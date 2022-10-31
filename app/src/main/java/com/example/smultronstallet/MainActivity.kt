package com.example.smultronstallet



import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import fragment.HomeFragment
import fragment.MapsFragment
import fragment.ReviewFragment
import fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val mapsFragment = MapsFragment()
    private val reviewFragment = ReviewFragment()
    lateinit var button : Button

    val db = Firebase.firestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFragment)



//        getList {
//
//            var recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//
//            recyclerView.adapter = RecyclerAdapter(this,it)
//        }

        button = findViewById<Button>(R.id.buttonLog)

        button.setOnClickListener {

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)




        }
        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_search -> replaceFragment(searchFragment)
                R.id.ic_map -> replaceFragment(mapsFragment)
                R.id.ic_rate_review -> replaceFragment(reviewFragment)

            }

            true
        }

    }

//    fun getList(myCallback :(MutableList<Place>) -> Unit) {
//        db.collection("places")
//            .get()
//            .addOnCompleteListener {
//                if(it.isSuccessful){
//                    val list = mutableListOf<Place>()
//                    for (document in it.result){
//                        val name = document.data["name"].toString()
//                        val review = document.data["review"].toString().toDouble()
//                        val item = Place(name = name,review = review)
//                        list.add(item)
//                    }
//                    myCallback(list)
//                }
//
//            }
//            .addOnFailureListener { exception ->
//                Log.d(ContentValues.TAG, "error gettingdocuments: ", exception)
//            }
//    }

    fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)

            transaction.commit()
        }
    }
}
