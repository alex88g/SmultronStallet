package PlaceRecycleView

import Maps.MapsPlace
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.MainActivity
import com.example.smultronstallet.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PlaceRecycleActivity : AppCompatActivity() {

    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_recycle)

        getList {
            var recyclerView = findViewById<RecyclerView>(R.id.placeRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            val adapter = PlaceRecyclerAdapter(this,it)
            recyclerView.adapter = adapter
            adapter.setOnItemClickListener(object : PlaceRecyclerAdapter.onItemClickListener {
                override fun onItemClick(position: Int) {
                    val intent = Intent(this@PlaceRecycleActivity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@PlaceRecycleActivity, "you Clicked on iten no. $position",
                        Toast.LENGTH_SHORT).show()
                }
            })
        }
    }


fun getList(myCallback :(MutableList<MapsPlace>) -> Unit) {
    db.collection("places")
        .get()
        .addOnCompleteListener {
            if(it.isSuccessful){
                val list = mutableListOf<MapsPlace>()
                for (document in it.result){
                    val name = document.data["name"].toString()
                    val lat = document.data["latitude"].toString().toDouble()
                    val long = document.data["latitude"].toString().toDouble()
                    val review = document.data["review"].toString()
                    val imgUrl = document.data["imageURL"].toString()
                    val item = MapsPlace(name = name, latitude = lat,longitude = long, review = review,imageURL = imgUrl)

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