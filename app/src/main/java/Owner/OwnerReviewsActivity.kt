package Owner


import PlaceRecycleView.PlaceRecyclerAdapter
import UserRecycleView.User
import android.annotation.SuppressLint
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
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class OwnerReviewsActivity : AppCompatActivity() {


    val db = Firebase.firestore
    var userList = mutableListOf<User>()
    var reviews = mutableListOf<OwnerReviews>()
    lateinit var recyclerView: RecyclerView
    var emailString : String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_reviews)

        dataInitialize()

        recyclerView = findViewById(R.id.reviewsRecyclerView)

        var recyclerView = findViewById<RecyclerView>(R.id.reviewsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = OwnerRecycleAdapter(this, reviews)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : OwnerRecycleAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                for(user in reviews){
                    val userEmails = "${emailString},${user.userEmail}"
                    emailString = userEmails

                    Log.d("!!!","usermails: $userEmails")
                }
                Log.d("!!!","emailString : $emailString ")
                val businessNameBack = intent.getStringExtra("businessName")
                val intent = Intent(this@OwnerReviewsActivity, OwnerActivity::class.java)
                intent.putExtra("emails", emailString)
                intent.putExtra("businessnameexist",true)
                intent.putExtra("businessname",businessNameBack)
                startActivity(intent)
                Toast.makeText(this@OwnerReviewsActivity, "Vill du skicka erbjudande?",
                    Toast.LENGTH_SHORT).show()
            }
        })


        for(user in reviews){
            val userEmails = "${emailString},${user.userEmail}"
            emailString = userEmails

            Log.d("!!!","usermails: $userEmails")
        }
        Log.d("!!!","emailString : $emailString ")


    }
    fun dataInitialize() {
        // testa ladda ner hela user databasen!!!

        val businessName = intent.getStringExtra("businessName")
        Log.d("!!!","$businessName")

        db.collection("users")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                        for (document in it.result) {
                            val user = document.toObject<User>()
                            //Log.d("!!!", "${user.docId}")
                            userList.add(user)
                            db.collection("users")
                                .document(user.docId!!)
                                .collection("smultrons")
                                .get()
                                .addOnCompleteListener {
                                    for(smultrons in it.result){
                                        //Log.d("!!!","buss $businessName")
                                        val smultronNamn = smultrons.data["name"].toString()
                                        //Log.d("!!!", "smul  $smultronNamn")
                                        if(businessName == smultronNamn){
                                            val review = smultrons.data["review"].toString()
                                            reviews.add(OwnerReviews(
                                                userName = document.data["name"].toString(),
                                                userReview = review,
                                                userEmail = document.data["email"].toString()
                                            ))

                                        }


                                    }
                                    recyclerView.adapter?.notifyDataSetChanged()


                                }

                        }


                }
            }



    }



//        OwnerReviews("Anna", "Det här var skitgott!!!!!", "annas.kossa@hotmail.com"),
//        OwnerReviews(
//            "Ernesto",
//            "Väldigt smakrikt och en bra upplevelse. Otrevlig personal med konstiga skor!",
//            "cykel@traktos.se"
//        ),
//        OwnerReviews(
//            "Fredde",
//            "Jag trivs så bra i denna skog, jag sitter alltid här och tänker på när jag var liten och allt var så himla roligt t.ex. att plocka kottar. Tack!",
//            "freddearcool@gmail.com"
//        ),
//        OwnerReviews(
//            "Olivia",
//            "Så kul att få vara tillbaka här! Jag är här varje år och trivs så himla bra. Guuuud vad gott det var med frälst potatis.",
//            "solveig.karlsson@hotmail.com"
//        )
//    )





}
