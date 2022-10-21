package com.example.smultronstallet


import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.ContentValues.TAG
import android.content.Intent
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    lateinit var button : Button

   private var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonMap)
        button.setOnClickListener {

            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)


    fun openNextActivity(view: View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

}

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        recyclerView.adapter =RecyclerAdapter()

       }


}