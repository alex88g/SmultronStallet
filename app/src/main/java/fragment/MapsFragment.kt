package fragment
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
import com.google.firebase.ktx.Firebase
import java.util.*


class MapsFragment : Fragment() {


    @SuppressLint("MissingPermission")
    val callback = OnMapReadyCallback { mMap: GoogleMap ->
        mMap.isMyLocationEnabled = true
        
        val stockholm = LatLng(59.3110, 18.0300)
        val zoomLevel = 15f

        mMap.addMarker(MarkerOptions().position(stockholm).title("IT-Högskolan Stockholm")
            .snippet("En bland de högst rekommenderade skolor"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stockholm, zoomLevel))

        val location2 = LatLng(59.306596, 18.033461)
        mMap.addMarker(MarkerOptions().position(location2).title("Brödernas")
            .snippet("Liljeholmskajen"))


        val location3 = LatLng(59.307664, 18.030499)
        mMap.addMarker(MarkerOptions().position(location3).title("BankOmat Seaside")
            .snippet("Liljeholmenskajen"))


        val location4 = LatLng(59.307486, 18.030159)
        mMap.addMarker(MarkerOptions().position(location4).title("Mama Ye's")
            .snippet("Asian Kitchen"))


        val location5 = LatLng(59.306470, 18.032284)
        mMap.addMarker(MarkerOptions().position(location5).title("Wokeriet")
            .snippet("Liljeholmenskajen"))


        val location6 = LatLng(59.307013, 18.029231)
        mMap.addMarker(MarkerOptions().position(location6).title("Sjöviks pizza & kebab")
            .snippet("Liljeholmenskajen"))


        val location7 = LatLng(59.306959, 18.029017)
        mMap.addMarker(MarkerOptions().position(location7).title("Wong ke")
            .snippet("Liljeholmenskajen"))


        val location8 = LatLng(59.308280, 18.029633)
        mMap.addMarker(MarkerOptions().position(location8).title("Primo cao cao")
            .snippet("Liljeholmenskajen"))


        val location9 = LatLng(59.307214, 18.026848)
        mMap.addMarker(MarkerOptions().position(location9).title("MGL Sushi")
            .snippet("Liljeholmenskajen"))


        val location10 = LatLng(59.305986, 18.032400)
        mMap.addMarker(MarkerOptions().position(location10).title("Pepe Nero")
            .snippet("Liljeholmenskajen"))


        val location11 = LatLng(59.306051, 18.035433)
        mMap.addMarker(MarkerOptions().position(location11).title("Braserie Deck")
            .snippet("Liljeholmenskajen"))

        setMapLongClick(mMap)
        setPoiClick(mMap)

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

