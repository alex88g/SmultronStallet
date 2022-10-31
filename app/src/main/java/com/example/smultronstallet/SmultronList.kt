package com.example.smultronstallet

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class SmultronList () {
    var listSmultronPerson = mutableListOf<SmultronPlats>()
    val db = Firebase.firestore

    init {


//        listSmultronPerson.add(SmultronPlats("maria", "grym", R.drawable.a_chileansk))
//        listSmultronPerson.add(SmultronPlats("Görgen", "grym", R.drawable.b_indisk))
//        listSmultronPerson.add(SmultronPlats("Elias", "grym", R.drawable.c_vietnamesisk))
//        listSmultronPerson.add(SmultronPlats("cachito", "grym", R.drawable.d_chinesisk))
//        listSmultronPerson.add(SmultronPlats("Lea", "grym", R.drawable.e_japansk))
//        listSmultronPerson.add(SmultronPlats("Ernesto", "grym", R.drawable.f_balkan))
//        listSmultronPerson.add(SmultronPlats("Maria", "grym", R.drawable.g_libanesisk))
//        listSmultronPerson.add(SmultronPlats("Maria", "grym", R.drawable.h_rysk))
//        listSmultronPerson.add(SmultronPlats("Maria", "grym", R.drawable.i_italiensk))
//        listSmultronPerson.add(SmultronPlats("Maria", "grym", R.drawable.j_thai))


        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val user = document.toObject<Place>()
                    Log.d("!!!","${user.name}")






                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }



    }


}

