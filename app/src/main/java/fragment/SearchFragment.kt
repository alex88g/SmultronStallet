package fragment

import Login.UserRecyclerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import Maps.MyAdapter
import Maps.News
import Maps.Place
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.smultronstallet.MainActivity
import com.example.smultronstallet.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import io.grpc.internal.JsonUtil.getList

class SearchFragment : Fragment() {
    val db = Firebase.firestore
    lateinit var adapter : MyAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    val list = ArrayList<Place>()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(container!!.context,list)
        recyclerView.adapter = adapter

        Toast.makeText(context, "Välkommen att Söka!", Toast.LENGTH_SHORT).show()

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    fun dataInitialize(){

        db.collection("places")
            .get()
            .addOnCompleteListener {
                if(it.isSuccessful){

                    for (document in it.result){
                        val place = document.toObject<Place>()
                       // val name = document.data["name"].toString()
                       //// val lat = document.data["latitude"].toString().toDouble()
                       //// val long = document.data["latitude"].toString().toDouble()
                       //// val review = document.data["review"].toString()
                       //// val imgUrl = document.data["imageURL"].toString()
                       // val item = Place(name = name, latitude = lat,longitude = long, review = review,imageURL = imgUrl)

                        list.add(place)
                    }

                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
    }

}