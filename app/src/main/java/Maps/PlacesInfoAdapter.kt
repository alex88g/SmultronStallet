package Maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.smultronstallet.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import fragment.MapsFragment

class PlacesInfoAdapter(val context: Context) : GoogleMap.InfoWindowAdapter {

    val layoutInflater = LayoutInflater.from(context)

    override fun getInfoContents(p0: Marker): View? {
        return null
    }


    override fun getInfoWindow(marker: Marker): View? {
        val infoWindow = layoutInflater.inflate(R.layout.info_maps, null)

        val imageView = infoWindow.findViewById<ImageView>(R.id.imageView)
        val titleView = infoWindow.findViewById<TextView>(R.id.nameTextView)
        val infoView = infoWindow.findViewById<TextView>(R.id.infoTextView)

        //titleView.text = marker.title

//        val place = marker.tag as? MapsFragment.PlaceInfo
//
//        titleView.text = place?.name
//        infoView.text = place?.info
//        if (place != null) {
//            imageView.setImageResource(place.image)
//        }
//
        return infoWindow
    }


}