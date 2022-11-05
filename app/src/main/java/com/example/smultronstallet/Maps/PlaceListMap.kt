package com.example.smultronstallet.Maps

import com.example.smultronstallet.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class PlaceListMap (val name: String, val info: String, val position: LatLng, val image: Int)



lateinit var mMap:GoogleMap

fun createPlaces() {

    val p1 = PlaceListMap("IT-Högskolan", "bra", LatLng(59.3110, 18.0300),
        R.drawable.ic_baseline_school_24
    )

    val p2 = PlaceListMap("Brödernas", "bra", LatLng(59.306596, 18.033461),
        R.drawable.ic_baseline_restaurant_24
    )

    val placeList = listOf<PlaceListMap>(p1,p2)

    for (place in placeList) {
        val mark = mMap.addMarker(MarkerOptions().position(place.position))
        mark?.tag = place
    }

}



