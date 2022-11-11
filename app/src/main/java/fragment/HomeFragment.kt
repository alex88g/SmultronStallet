package fragment


import Login.User
import Login.userAdapter
import Maps.Place
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {

    val db = Firebase.firestore
    lateinit var adapter : userAdapter
    lateinit var recyclerView : RecyclerView
    val userList = ArrayList<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = userAdapter(container!!.context,userList)
        recyclerView.adapter = adapter

        //Toast.makeText(context, "Välkommen Hem!",Toast.LENGTH_SHORT).show()

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

fun dataInitialize(){

    db.collection("users")
//        .get()
//        .addOnCompleteListener {
        .addSnapshotListener { snapshot, e ->

            if (snapshot != null) {
                for (document in snapshot.documents) {
                    val user = document.toObject<User>()
                    if (user != null) {
                        userList.add(user)
                    }
                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
//            if(it.isSuccessful){
//
//                for (document in it.result){
//                    val user = document.toObject<User>()
//
//
//                    userList.add(user)
//                }
//
//                recyclerView.adapter?.notifyDataSetChanged()
//            }
        }
 }
}