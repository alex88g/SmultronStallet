package com.example.smultronstallet


import android.content.ContentValues
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PlaceList {
    var placeList = mutableListOf<Place>()
    val db = Firebase.firestore
init {
    createPlaces()
    for(place in placeList){
        db.collection("places")
            .add(place)
            .addOnSuccessListener { documentReference ->
                Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
}
    fun createPlaces() {

        placeList.add(Place("Brödernas", 59.30696, 18.03324,4.0,"brödernas.jpeg"))
        placeList.add(Place("MGL Sushi", 59.30722, 18.02694,4.3,"mgl_sushi.jpeg"))
        placeList.add(Place("Sjöviks pizzeria", 59.30707, 18.02926,4.0,"sjöviks_pizzeria"))
        placeList.add(Place("Wong Kee Restaurang", 59.30695, 18.02892,3.9,"wong_kee.jpeg"))
        placeList.add(Place("BankOmat Seaside", 59.30771, 18.0306,3.9,"bankomat_seaside.jpeg"))
        placeList.add(Place("Mama Ye's", 59.30756, 18.03011,3.9,"mama_yes.jpeg"))
        placeList.add(Place("NiDa Catering", 59.31012, 18.03034,3.4,"nida_catering.jpeg"))
        placeList.add(Place("Rhino Food & Drinks", 59.30964, 18.02801,4.2,"rhino_food_and_drinks.jpeg"))
        placeList.add(Place("Roots & Soil Marievik", 59.30973, 18.02811,4.6,"roots_and_soil"))
        placeList.add(Place("Prepp", 59.31054, 18.02958,3.5,"prepp.webp"))
        placeList.add(Place("Wang Asia", 59.30821, 18.02705,3.8,"wang_asia"))
        placeList.add(Place("Brot", 59.30775, 18.02834,4.0,"brot.jpeg"))
        placeList.add(Place("Primo Ciao Ciao", 59.30829, 18.02954,3.3,"primo_cao_cao.jpeg"))
        placeList.add(Place("KATO liljeholmskajen", 59.30811, 18.02917,4.1,"KATO.jpeg"))
        placeList.add(Place("Café Bravo", 59.31012, 18.02318,3.5,"cafe_bravo.jpeg"))
        placeList.add(Place("RIICO", 59.30979, 18.02294,4.0,"riico.png"))
        placeList.add(Place("Bastard Burgers", 59.30964, 18.0225,4.0,"bastard_burgers.jpeg"))
        placeList.add(Place("Oh Poké", 59.30954, 18.02247,3.6,"oh_poke.jpeg"))
        placeList.add(Place("Brödernas", 59.30954, 18.02225,3.3,""))
        placeList.add(Place("Gateau", 59.30956, 18.02367,3.6,"gateau.jpeg"))
        placeList.add(Place("Sushi Kawa Liljeholmen", 59.30927, 18.02276,3.8,"sushi_kawa.jpeg"))
        placeList.add(Place("Sushi Yama", 59.30931, 18.02232,3.2,""))
        placeList.add(Place("Thai Rung Restaurang", 59.31046, 18.02226,3.9,"thai_rung"))
        placeList.add(Place("Café Trekantsparken", 59.31041, 18.02164,5.0,"cafe_trekantsparken"))
        placeList.add(Place("Naked Juicebar", 59.30947, 18.02193,3.0,"nacked_juicebar"))
        placeList.add(Place("Espresso House", 59.30964, 18.02174,3.7,"esspreso_house_jpeg"))
        placeList.add(Place("Brillo Pizza", 59.30999, 18.02184,3.8,"brillo_pizza.jpeg"))
        placeList.add(Place("Pizzeria Di Metro", 59.31014, 18.02205,3.0,"pizzeria_di_metro.jpeg"))
        placeList.add(Place("Boulebar", 59.31282, 18.027,4.2,"boulebar.jpeg"))
        placeList.add(Place("Café Rosteriet", 59.31198, 18.02396,4.0,"cafe_rosteriet.jpeg"))
        placeList.add(Place("Chong Qing", 59.31294, 18.02849,4.2,"chong_qing"))

    }
}
