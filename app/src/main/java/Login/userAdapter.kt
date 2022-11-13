package Login


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R

class userAdapter(private val context: Context, val userList : ArrayList<User>) : RecyclerView.Adapter<userAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position : Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.userlist_item,
            parent,false)
        return MyViewHolder(itemView,mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]

        // sätt in den personens uppgifter i vår view
        holder.nameTextView.text = user.name
        holder.phoneTextView.text = user.phone.toString()
        holder.emailTextView.text = user.email
    }
    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){

        var nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        var phoneTextView = itemView.findViewById<TextView>(R.id.phoneTextView)
        var emailTextView = itemView.findViewById<TextView>(R.id.emailTextView)

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }
    }
}