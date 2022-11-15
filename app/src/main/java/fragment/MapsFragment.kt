package fragment

import Maps.MapsPlace
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
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import java.util.*


//This class allows you to interact with the map by adding markers, styling its appearance and
// displaying the user's location.

class MapsFragment : Fragment() {
    val db = Firebase.firestore
    val list = ArrayList<MapsPlace>()
    lateinit var mMap: GoogleMap





    @SuppressLint("MissingPermission")
    val callback = OnMapReadyCallback { mMap: GoogleMap ->


        mMap.isMyLocationEnabled = true
        mMap.uiSettings.isZoomControlsEnabled = true

//These coordinates represent the lattitude and longitude of the It-Högskolan

        val stockholm = LatLng(59.31102, 18.02979)
        val zoomLevel = 15f

        mMap.addMarker(
            MarkerOptions().position(stockholm).title("IT-Högskolan Stockholm")
                .snippet("En bland de högst rekommenderade skolor")
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(stockholm, zoomLevel))

        getList {
            //Toast.makeText(context, "intent docID : $docID", Toast.LENGTH_SHORT).show()
            for (document in it) {
                val lat = document.latitude!!
                val long = document.longitude!!
                val location2 = LatLng(lat, long)
                mMap.addMarker(
                    MarkerOptions().position(location2).title(document.name)
                        .snippet(document.review)
                )

            }
        }
        setMapLongClick(mMap)
        setPoiClick(mMap)

    }

    fun getList(myCallback: (MutableList<MapsPlace>) -> Unit) {
        val args = this.arguments
        val inputData = args?.get("data")
        if (inputData != null) {
            db.collection("users")
                .document("$inputData")
                .get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val userName = it.result["name"].toString()


                        //  val user = snapshot.toObject<User>()
                        Toast.makeText(
                            context,
                            "inputData: $inputData name : $userName",
                            Toast.LENGTH_SHORT
                        )
                            .show()

                    }
                }

            db.collection("users").document("$inputData")
                .collection("smultrons")
                .get()
                .addOnCompleteListener {
                    if (it.isSuccessful) {

                        for (document in it.result) {
                            val place = document.toObject<MapsPlace>()


                            list.add(place)
                        }
                        myCallback(list)

                    }
                }
        } else if(inputData == null) {
             db.collection("places")
                 .get()
                 .addOnCompleteListener {
                     if (it.isSuccessful) {

                         for (document in it.result) {
                             val place = document.toObject<MapsPlace>()


                             list.add(place)
                         }
                         myCallback(list)

                     }
                 }
        }
    }

    // Called when user makes a long press gesture on the map.
    private fun setMapLongClick(map: GoogleMap) {
        map.setOnMapLongClickListener {
            val snippet = String.format(
                Locale.getDefault(),
                "Lat: %1.5f, Lng: %2$.5f",
                it.latitude,
                it.longitude
            )
            map.addMarker(
                MarkerOptions().position(it).title(getString(R.string.dropped_pin)).snippet(snippet)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
            )


            val database =
                Firebase.database("https://smultronstalletdatabase-default-rtdb.firebaseio.com")
            val reference = database.reference
            val data = reference.push().child("loacation").setValue(it)


        }
    }

    // Places a marker on the map and displays an info window that contains POI name.
    private fun setPoiClick(map: GoogleMap) {
        map.setOnPoiClickListener { point ->
            val poiMarker = map.addMarker(MarkerOptions().position(point.latLng).title(point.name))
            poiMarker!!.showInfoWindow()
        }

    }

    //     Initializes contents of Activity's standard options menu. Only called the first time options
//     menu is displayed.

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.map_options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
//             Change the map type based on the user's selection.

            R.id.normal_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                true
            }
            R.id.hybrid_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                true
            }
            R.id.satellite_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
                true
            }
            R.id.terrain_map -> {
                mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
                true
            }
            else -> super.onOptionsItemSelected(item)
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


        //Toast.makeText(context, "intent docID : $docID", Toast.LENGTH_SHORT).show()
    }
}

