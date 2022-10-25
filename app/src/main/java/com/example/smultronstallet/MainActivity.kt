package com.example.smultronstallet


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {
    lateinit var itemView: RecyclerAdapter
    lateinit var button: Button
    lateinit var smultronList: SmultronList
    lateinit var userReviewDetails: List<SmultronList>


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.setBackgroundColor(Color.BLACK)

        var list = SmultronList().listSmultronPerson[5]
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



        var adapter =RecyclerAdapter()
        recyclerView.adapter =adapter
        adapter.setOnItemClickListener(object: RecyclerAdapter.onItemClicklisterner {
            override fun onItemClick(position: Int) {
                //  Toast.makeText(this@MainActivity,"you clicked on item ${position}", Toast.LENGTH_LONG).show()

                val intent= Intent(this@MainActivity,userNewActivity::class.java)

                startActivity(intent)


            }

        })



    }


}





