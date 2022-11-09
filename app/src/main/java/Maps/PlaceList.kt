package Maps


import Login.PlaceRecycleActivity
import Login.User
import Login.UserRecyclerAdapter
import android.content.ContentValues
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PlaceList {
    var placeList = mutableListOf<Place>()
    lateinit var auth: FirebaseAuth
    val db = Firebase.firestore
init {
    auth = Firebase.auth
    getList {

    }

    //createPlaces()
    //for(place in placeList){
    //    db.collection("places")
    //        .add(place)
    //        .addOnSuccessListener { documentReference ->
    //            Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
    //        }
    //        .addOnFailureListener { e ->
    //            Log.w(ContentValues.TAG, "Error adding document", e)
    //        }
    //}
}

    fun createPlaces() {


        placeList.add(Place("","Brödernas", 59.30696, 18.03324,"4.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/bro%CC%88dernas.jpeg?alt=media&token=b5f34195-0f0d-4ef9-8d55-002a05dd4f80"))
        placeList.add(Place("","MGL Sushi", 59.30722, 18.02694,"4.3","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/mgl_sushi.jpeg?alt=media&token=68b72718-6f1e-40f0-ab0f-485c6ba5f0de"))
        placeList.add(Place("","Sjöviks pizzeria", 59.30707, 18.02926,"4.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/sjo%CC%88viks_pizzeria.png?alt=media&token=5e00caa2-e51a-4d28-a7b2-b847c0875101"))
        placeList.add(Place("","Wong Kee Restaurang", 59.30695, 18.02892,"3.9","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/wong_kee.jpeg?alt=media&token=9c03e649-2c71-419e-8e3d-b476f00aeb58"))
        placeList.add(Place("","BankOmat Seaside", 59.30771, 18.0306,"3.9","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/bankomat_seaside.jpeg?alt=media&token=2178668c-b2ef-4976-a189-df77cc091d45"))
        placeList.add(Place("","Mama Ye's", 59.30756, 18.03011,"3.9","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/mama_yes.jpeg?alt=media&token=c3afa962-61e0-46df-8bfb-9db6282340dc"))
        placeList.add(Place("","NiDa Catering", 59.31012, 18.03034,"3.4","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/nida_catering.jpeg?alt=media&token=f3d65bbe-ca3a-4a23-b3a0-c7b2133ef7e6"))
        placeList.add(Place("","Rhino Food & Drinks", 59.30964, 18.02801,"4.2","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/primo_cao_cao.jpeg?alt=media&token=5533c64a-39a3-4cba-8528-ce2fb0af8f8c"))
        placeList.add(Place("","Roots & Soil Marievik", 59.30973, 18.02811,"4.6","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/roots_and_soil.png?alt=media&token=6e5d3974-9927-4453-8a31-e76f76bf4208"))
        placeList.add(Place("","Prepp", 59.31054, 18.02958,"3.5","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/prepp.webp?alt=media&token=3d5518d6-aca7-4ce4-b217-9c8b35dd20a3"))
        placeList.add(Place("","Wang Asia", 59.30821, 18.02705,"3.8","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/wang_asia.jpeg?alt=media&token=7f9eb817-b212-4b4c-80f7-43c86ea8e5ff"))
        placeList.add(Place("","Brot", 59.30775, 18.02834,"4.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/brot.jpeg?alt=media&token=ce3df334-258a-46fa-b08d-c8342ad67f02"))
        placeList.add(Place("","Primo Ciao Ciao", 59.30829, 18.02954,"3.3","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/primo_cao_cao.jpeg?alt=media&token=5533c64a-39a3-4cba-8528-ce2fb0af8f8c"))
        placeList.add(Place("","KATO liljeholmskajen", 59.30811, 18.02917,"4.1","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/KATO.jpeg?alt=media&token=a0c7865b-9ca5-4ae3-81de-c605c5ab32bc"))
        placeList.add(Place("","Café Bravo", 59.31012, 18.02318,"3.5","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/cafe_bravo.jpeg?alt=media&token=04b64ab1-c61f-4187-ae5c-fb9ec556424d"))
        placeList.add(Place("","RIICO", 59.30979, 18.02294,"4.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/riico.png?alt=media&token=5508308b-9c15-494c-96b9-51a3664203e6"))
        placeList.add(Place("","Bastard Burgers", 59.30964, 18.0225,"4.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/bastard_burgers.jpeg?alt=media&token=ccb351be-7448-4999-b1c5-0ff8bbe50efd"))
        placeList.add(Place("","Oh Poké", 59.30954, 18.02247,"3.6","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/nida_catering.jpeg?alt=media&token=f3d65bbe-ca3a-4a23-b3a0-c7b2133ef7e6"))
        placeList.add(Place("","Brödernas", 59.30954, 18.02225,"3.3","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/bro%CC%88dernas.jpeg?alt=media&token=b5f34195-0f0d-4ef9-8d55-002a05dd4f80"))
        placeList.add(Place("","Gateau", 59.30956, 18.02367,"3.6","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/gateau.jpeg?alt=media&token=3b3b0b7e-a6a0-4a34-b2a8-775c1119ceb7"))
        placeList.add(Place("","Sushi Kawa Liljeholmen", 59.30927, 18.02276,"3.8","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/sushi_kawa.jpeg?alt=media&token=8f129cdb-104e-428c-8e3e-d569407f7f16"))
        placeList.add(Place("","Sushi Yama", 59.30931, 18.02232,"3.2","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/sushi_kawa.jpeg?alt=media&token=8f129cdb-104e-428c-8e3e-d569407f7f16"))
        placeList.add(Place("","Thai Rung Restaurang", 59.31046, 18.02226,"3.9","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/thai_rung.png?alt=media&token=e165c87d-f052-454b-a6e7-710b4ffb5afb"))
        placeList.add(Place("","Café Trekantsparken", 59.31041, 18.02164,"5.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/cafe_trekantsparken.png?alt=media&token=bac7c6bd-973a-4055-bfb9-6430fc1201fe"))
        placeList.add(Place("","Naked Juicebar", 59.30947, 18.02193,"3.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/nacked_juicebar.png?alt=media&token=cc2563a5-d59b-4b14-bc25-c178d881eedb"))
        placeList.add(Place("","Espresso House", 59.30964, 18.02174,"3.7","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/esspreso_house.jpeg?alt=media&token=0844deb7-b90a-4b3c-ab57-e08b3e8481ca"))
        placeList.add(Place("","Brillo Pizza", 59.30999, 18.02184,"3.8","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/brillo_pizza.jpeg?alt=media&token=59cd39db-e9f0-4b28-966c-ab222bd2118d"))
        placeList.add(Place("","Pizzeria Di Metro", 59.31014, 18.02205,"3.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/pizzeria_di_metro.jpeg?alt=media&token=27a0ba9c-c098-4830-a451-b2bbe549cdb9"))
        placeList.add(Place("","Boulebar", 59.31282, 18.027,"4.2","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/boulebar.jpeg?alt=media&token=abb606f7-29c4-44cd-a6d0-098e6ce8949d"))
        placeList.add(Place("","Café Rosteriet", 59.31198, 18.02396,"4.0","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/cafe_rosteriet.jpeg?alt=media&token=53df5245-60b0-4181-a371-68dc59930daf"))
        placeList.add(Place("","Chong Qing", 59.31294, 18.02849,"4.2","https://firebasestorage.googleapis.com/v0/b/smultronstalletdatabase.appspot.com/o/chong_qing.jpeg?alt=media&token=3c00f2b2-ddcb-4e1e-942d-0286e2c7e780"))


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
                        val documentId = document.data["docId"].toString()

                        val email = document.data["email"].toString()
                        val item = User(docId = documentId, name = name, email = email,phone = phone)

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
