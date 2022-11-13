package fragment


import UserRecycleView.User
import UserRecycleView.UserAdapter
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


class ContactsFragment : Fragment() {

    val db = Firebase.firestore
    lateinit var adapter: UserAdapter
    lateinit var recyclerView: RecyclerView
    val userList = ArrayList<User>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contacts, container, false)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.userRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = UserAdapter(container!!.context, userList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : UserAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(context, "You clicked on user $position",Toast.LENGTH_SHORT).show()
            }
        })

        //Toast.makeText(context, "Välkommen till Kontakter!",Toast.LENGTH_SHORT).show()

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun dataInitialize() {

        db.collection("users")
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {

                    for (document in it.result) {
                        val user = document.toObject<User>()


                        userList.add(user)
                    }

                    recyclerView.adapter?.notifyDataSetChanged()
                }
            }
    }
}