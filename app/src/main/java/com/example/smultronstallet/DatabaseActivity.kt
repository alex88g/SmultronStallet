package com.example.smultronstallet

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DatabaseActivity : AppCompatActivity() {

    val userList = UserList()
    val placeList = PlaceList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        val db = Firebase.firestore

        // Create a new user with a first and last name
        for (user in userList.users) {

            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
                }


        }
        for(place in placeList.placeList) {

            db.collection("places")
                .add(place)
                .addOnSuccessListener { documentReference ->
                    Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ContentValues.TAG, "Error adding document", e)
                }

        }


// Add a new document with a generated ID
//
//       // Create a new user with a first, middle, and last name
//       val user = hashMapOf(
//           "first" to "Alan",
//           "middle" to "Mathison",
//           "last" to "Turing",
//           "born" to 1912
//       )

/// Add a new document with a generated ID
//       db.collection("users")
//           .add(user)
//           .addOnSuccessListener { documentReference ->
//               Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//           }
//           .addOnFailureListener { e ->
//               Log.w(ContentValues.TAG, "Error adding document", e)
//           }
//       db.collection("users")
//           .get()
//           .addOnSuccessListener { result ->
//               for (document in result) {
//                   Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
//               }
//           }
//           .addOnFailureListener { exception ->
//               Log.w(ContentValues.TAG, "Error getting documents.", exception)
//           }
    }
}