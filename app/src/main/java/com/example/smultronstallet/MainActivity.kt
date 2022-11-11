package com.example.smultronstallet




import Login.SignInActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_review.*


class MainActivity : AppCompatActivity() {

    private val contactsFragment = ContactsFragment()
    private val homeFragment = HomeFragment()
    private val placesFragment = PlacesFragment()
    private val mapsFragment = MapsFragment()
    private val reviewFragment = ReviewFragment()

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)

        //PlaceList()

        cameraButton1.setOnClickListener{
            val intentCamerar = Intent(this, CameraActivity::class.java)
            startActivity(intentCamerar)
        }

        button = findViewById(R.id.buttonLog)

        button.setOnClickListener {

            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_contacts -> replaceFragment(contactsFragment)
                R.id.ic_places -> replaceFragment(placesFragment)
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