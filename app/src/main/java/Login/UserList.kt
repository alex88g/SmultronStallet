package Login

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class UserList() {
    val db = Firebase.firestore

    var users = mutableListOf<User>()


    init {
        createUsers()
    }

    fun createUsers() {
        for(i in 1..20){
            var randomNr = (1000000..9999999).random()
            users.add(User("user$i","user${i}@user${i}mail.se","+4673$randomNr"))


        }
        for(user in users){
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")




                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }


        }


    }
}