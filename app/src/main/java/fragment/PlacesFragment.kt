package fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import Maps.MapsAdapter
import Maps.MapsPlace
import com.example.smultronstallet.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class PlacesFragment : Fragment() {
    val db = Firebase.firestore
    lateinit var adapter: MapsAdapter
    lateinit var recyclerView: RecyclerView


    val list = ArrayList<MapsPlace>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_places, container, false)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MapsAdapter(container!!.context, list)
        recyclerView.adapter = adapter

        //Toast.makeText(context, "Välkommen att Söka!", Toast.LENGTH_SHORT).show()

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    fun dataInitialize() {

        db.collection("places")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {

                    for (document in it.result) {
                        val place = document.toObject<MapsPlace>()


                        list.add(place)
                    }

                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
    }

}