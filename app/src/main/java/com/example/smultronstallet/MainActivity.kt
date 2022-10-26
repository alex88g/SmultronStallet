package com.example.smultronstallet


import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            getList {

                var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)

                recyclerView.adapter = RecyclerAdapter(this,it)
            }
    }

    fun getList(myCallback :(MutableList<Place>) -> Unit) {
        db.collection("places")
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val list = mutableListOf<Place>()
                    for (document in it.result){
                        val name = document.data["name"].toString()
                        val review = document.data["review"].toString().toDouble()
                        val item = Place(name = name,review = review)
                        list.add(item)
                    }
                myCallback(list)
            }

            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "error gettingdocuments: ", exception)
            }

    }
}