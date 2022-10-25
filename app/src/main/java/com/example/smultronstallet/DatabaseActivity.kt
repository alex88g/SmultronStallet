package com.example.smultronstallet

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DatabaseActivity : AppCompatActivity() {

   //private var layoutManager: RecyclerView.LayoutManager?= null
   //private var adapter: RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>?=null
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        getList {
            var recyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            // skapade vi en adapter från vår adapter-klass och skickar med vår lista av personer
            val adapter = UserRecyclerAdapter(this,it)

            // koppla ihop vår adapter med recyclerviewn
            recyclerView.adapter = adapter


            // skapa adapter
            // koppla data (users) till adapter
            // Koppla adapter till rcycleview
        }

    }
    fun getList(myCallback :(MutableList<User>) -> Unit) {
        db.collection("user")
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val list = mutableListOf<User>()
                    for (document in it.result){
                        val name = document.data["name"].toString()
                        val age = document.data["age"].toString().toInt()
                        val item = User(name = name, age = age)
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