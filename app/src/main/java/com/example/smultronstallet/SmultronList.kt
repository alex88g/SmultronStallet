package com.example.smultronstallet

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

//class SmultronList () {
//    var listSmultronPerson = mutableListOf<SmultronPlats>()
//    val db = Firebase.firestore
//    init {
//
//
//        listSmultronPerson.add(SmultronPlats("maria", "haninge", R.drawable.chilenskmat))
//        listSmultronPerson.add(SmultronPlats("Görgen", "grym", R.drawable.indisk))
//        listSmultronPerson.add(SmultronPlats("Elias", "grym", R.drawable.indisk))
//        listSmultronPerson.add(SmultronPlats("cachito", "grym", R.drawable.indisk))
//        listSmultronPerson.add(SmultronPlats("Lea", "grym", R.drawable.indisk))
//        listSmultronPerson.add(SmultronPlats("Ernesto", "grym", R.drawable.indisk))
//        listSmultronPerson.add(SmultronPlats("Maria", "grym", R.drawable.indisk))
//
//
//        db.collection("users")
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    val user = document.toObject<Place>()
//                    Log.d("!!!","${user.name}")
//
//
//
//
//                    Log.d(TAG, "${document.id} => ${document.data}")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents.", exception)
//            }
//
//
//
//    }
//
//
//}