package fragment
import Maps.Place
import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.example.smultronstallet.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*


class MapsFragment : Fragment() {
    val db = Firebase.firestore
    val list = ArrayList<Place>()

    @SuppressLint("MissingPermission")
    val callback = OnMapReadyCallback { mMap: GoogleMap ->
        mMap.isMyLocationEnabled = true



        val stockholm = LatLng(59.3110, 18.0300)
        val zoomLevel = 15f

        mMap.addMarker(
            MarkerOptions().position(stockholm).title("IT-Högskolan Stockholm")
                .snippet("En bland de högst rekommenderade skolor")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stockholm, zoomLevel))

        getList {
            for (document in it){
                val lat = document.latitude!!
                val long = document.longitude!!
                val location2 = LatLng(lat,long)
                mMap.addMarker(MarkerOptions().position(location2).title(document.name).snippet(document.review)
                )

            }
        }



        setMapLongClick(mMap)
        setPoiClick(mMap)

    }

    fun getList(myCallback :(MutableList<Place>) -> Unit){

        db.collection("places")
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){

                    for (document in it.result){
                        val place = document.toObject<Place>()


                        list.add(place)
                    }
    myCallback(list)

                }
            }
    }

    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener {
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1.5f, Lng: %2$.5f",
                it.latitude,
                it.longitude
            )
            map.addMarker(MarkerOptions().position(it).title("Marker here").snippet(snippet))

            val database =
                Firebase.database("https://smultronstalletdatabase-default-rtdb.firebaseio.com")
            val reference = database.reference
            val data = reference.push().child("loacation").setValue(it)


        }
    }

    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { point ->
            val poiMarker = map.addMarker(MarkerOptions().position(point.latLng).title(point.name))
            poiMarker!!.showInfoWindow()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


        Toast.makeText(context, "Välkommen till Kartan", Toast.LENGTH_SHORT).show()
    }
}

