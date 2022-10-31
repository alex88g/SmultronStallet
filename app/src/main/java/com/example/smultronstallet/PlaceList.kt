package com.example.smultronstallet

import android.content.ContentValues
import android.content.Intent
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class PlaceList {
    var placeList = mutableListOf<Place>()
    val db = Firebase.firestore

    fun createPlaces() {

        placeList.add(Place("Brödernas", 59.30696, 18.03324,4.0,""))
        placeList.add(Place("MGL Sushi", 59.30722, 18.02694,4.3,""))
        placeList.add(Place("Sjöviks pizzeria", 59.30707, 18.02926,4.0,""))
        placeList.add(Place("Wong Kee Restaurang", 59.30695, 18.02892,3.9,""))
        placeList.add(Place("BankOmat Seaside", 59.30771, 18.0306,3.9,""))
        placeList.add(Place("Mama Ye's", 59.30756, 18.03011,3.9,""))
        placeList.add(Place("NiDa Catering", 59.31012, 18.03034,3.4,""))
        placeList.add(Place("Rhino Food & Drinks", 59.30964, 18.02801,4.2,""))
        placeList.add(Place("Roots & Soil Marievik", 59.30973, 18.02811,4.6,""))
        placeList.add(Place("Prepp", 59.31054, 18.02958,3.5,""))
        placeList.add(Place("Wang Asia", 59.30821, 18.02705,3.8,""))
        placeList.add(Place("Brot", 59.30775, 18.02834,4.0,""))
        placeList.add(Place("Primo Ciao Ciao", 59.30829, 18.02954,3.3,""))
        placeList.add(Place("KATO liljeholmskajen", 59.30811, 18.02917,4.1,""))
        placeList.add(Place("Café Bravo", 59.31012, 18.02318,3.5,""))
        placeList.add(Place("RIICO", 59.30979, 18.02294,4.0,""))
        placeList.add(Place("Bastard Burgers", 59.30964, 18.0225,4.0,""))
        placeList.add(Place("Oh Poké", 59.30954, 18.02247,3.6,""))
        placeList.add(Place("Brödernas", 59.30954, 18.02225,3.3,""))
        placeList.add(Place("Gateau", 59.30956, 18.02367,3.6,""))
        placeList.add(Place("Sushi Kawa Liljeholmen", 59.30927, 18.02276,3.8,""))
        placeList.add(Place("Sushi Yama", 59.30931, 18.02232,3.2,""))
        placeList.add(Place("Thai Rung Restaurang", 59.31046, 18.02226,3.9,""))
        placeList.add(Place("Café Trekantsparken", 59.31041, 18.02164,5.0,""))
        placeList.add(Place("Naked Juicebar", 59.30947, 18.02193,3.0,"R.drawable.chilenskmat"))
        placeList.add(Place("Espresso House", 59.30964, 18.02174,3.7,""))
        placeList.add(Place("Brillo Pizza", 59.30999, 18.02184,3.8,""))
        placeList.add(Place("Pizzeria Di Metro", 59.31014, 18.02205,3.0,""))
        placeList.add(Place("Boulebar", 59.31282, 18.027,4.2,""))
        placeList.add(Place("Café Rosteriet", 59.31198, 18.02396,4.0,""))
        placeList.add(Place("Chong Qing", 59.31294, 18.02849,4.2,"https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/bild_2022-10-25_221227351.png?alt=media&token=848af126-5c22-4f52-bacf-7a8e8a16c41a"))

    }
}