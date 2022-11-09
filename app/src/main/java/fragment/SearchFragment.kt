package fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import Maps.MyAdapter
import Maps.Place
import com.example.smultronstallet.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class SearchFragment : Fragment() {
    val db = Firebase.firestore
    lateinit var adapter : MyAdapter
    lateinit var recyclerView : RecyclerView
<<<<<<< HEAD
    //lateinit var newsArrayList: ArrayList<News>
=======
>>>>>>> alexbranch21
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


                        list.add(place)
                    }

                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
    }

}