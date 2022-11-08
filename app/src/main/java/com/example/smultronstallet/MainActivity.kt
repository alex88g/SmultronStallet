package com.example.smultronstallet



import Login.DatabaseActivity
import Login.SignInActivity
import Maps.PlaceList
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cameraButton1.setOnClickListener{
            var intentCamerar = Intent(this, CameraActivity::class.java)
            startActivity(intentCamerar)
        }
        replaceFragment(searchFragment)


        //PlaceList()

        button = findViewById(R.id.buttonLog)

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


    fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)

            transaction.commit()
        }

    }
}