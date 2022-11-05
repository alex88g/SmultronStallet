package fragment
import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.smultronstallet.R
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*


class MapsFragment : Fragment() {


    @SuppressLint("MissingPermission")
    val callback = OnMapReadyCallback { googleMap ->

        googleMap.isMyLocationEnabled = true


        val location1 = LatLng(59.3110, 18.0300)
        googleMap.addMarker(MarkerOptions().position(location1).title("IT-Högskolan Stockholm")
            .snippet("En bland de högst rekommenderade skolor"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 15f))

        val location2 = LatLng(59.306596, 18.033461)
        googleMap.addMarker(MarkerOptions().position(location2).title("Brödernas")
            .snippet("Liljeholmskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location2, 15f))

        val location3 = LatLng(59.307664, 18.030499)
        googleMap.addMarker(MarkerOptions().position(location3).title("BankOmat Seaside")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location3, 15f))

        val location4 = LatLng(59.307486, 18.030159)
        googleMap.addMarker(MarkerOptions().position(location4).title("Mama Ye's")
            .snippet("Asian Kitchen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location4, 15f))

        val location5 = LatLng(59.306470, 18.032284)
        googleMap.addMarker(MarkerOptions().position(location5).title("Wokeriet")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location5, 15f))

        val location6 = LatLng(59.307013, 18.029231)
        googleMap.addMarker(MarkerOptions().position(location6).title("Sjöviks pizza & kebab")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location6, 15f))

        val location7 = LatLng(59.306959, 18.029017)
        googleMap.addMarker(MarkerOptions().position(location7).title("Wong ke")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location7, 15f))

        val location8 = LatLng(59.308280, 18.029633)
        googleMap.addMarker(MarkerOptions().position(location8).title("Primo cao cao")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location8, 15f))

        val location9 = LatLng(59.307214, 18.026848)
        googleMap.addMarker(MarkerOptions().position(location9).title("MGL Sushi")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location9, 15f))

        val location10 = LatLng(59.305986, 18.032400)
        googleMap.addMarker(MarkerOptions().position(location10).title("Pepe Nero")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location10, 15f))

        val location11 = LatLng(59.306051, 18.035433)
        googleMap.addMarker(MarkerOptions().position(location11).title("Braserie Deck")
            .snippet("Liljeholmenskajen"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location11, 15f))


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


    }
}


