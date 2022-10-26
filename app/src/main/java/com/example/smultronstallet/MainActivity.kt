package com.example.smultronstallet



import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentValues.TAG
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore
    
    lateinit var button: Button
    //lateinit var smultronList: SmultronList
    //lateinit var userReviewDetails: List<SmultronList>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.setBackgroundColor(Color.BLACK)
        button = findViewById(R.id.buttonMap)


            getList {

                var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)

                recyclerView.adapter = RecyclerAdapter(this,it)
            }
        //button listner till kartan
        button.setOnClickListener {

            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)


            fun openNextActivity(view: View) {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }


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


        //var list = SmultronList().listSmultronPerson[5]


        //var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //recyclerView.layoutManager = LinearLayoutManager(this)



       //var adapter =RecyclerAdapter()
       //recyclerView.adapter =adapter
       //adapter.setOnItemClickListener(object: RecyclerAdapter.onItemClicklisterner {
       //    override fun onItemClick(position: Int) {
       //        //  Toast.makeText(this@MainActivity,"you clicked on item ${position}", Toast.LENGTH_LONG).show()

       //        val intent= Intent(this@MainActivity,userNewActivity::class.java)

       //        startActivity(intent)


       //    }

       //})



    }



