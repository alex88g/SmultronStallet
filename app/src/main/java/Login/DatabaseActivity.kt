package Login

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

class DatabaseActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        getList {
            var recyclerView = findViewById<RecyclerView>(R.id.userRecyclerView)
            recyclerView.layoutManager = LinearLayoutManager(this)

            val adapter = UserRecyclerAdapter(this,it)
            recyclerView.adapter = adapter
            adapter.setOnItemClickListener(object : UserRecyclerAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {
                    val intent = Intent(this@DatabaseActivity, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this@DatabaseActivity, "you Clicked on iten no. $position",Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
    fun getList(myCallback :(MutableList<User>) -> Unit) {
        db.collection("users")
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    val list = mutableListOf<User>()
                    for (document in it.result){
                        val name = document.data["name"].toString()
                        val phone = document.data["phone"].toString()

                        val email = document.data["email"].toString()
                        val item = User(name = name, email = email,phone = phone)

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