package Owner

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R

class OwnerRecycleAdapter(val context: Context, val reviews: List<OwnerReviews>) :
    RecyclerView.Adapter<OwnerRecycleAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.reviews_item, parent, false)
        //Log.d("!!!Adapter", "oncreateViewholder")

        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val review = reviews[position]

        holder.nameTextView.text = review.userName
        holder.reviewTextView.text = review.userReview
        holder.emailTextView.text = review.userEmail
    }


    override fun getItemCount(): Int {
        return reviews.size
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
    
        var nameTextView = itemView.findViewById<TextView>(R.id.userNameTextView)
        var reviewTextView = itemView.findViewById<TextView>(R.id.reviewTextView)
        var emailTextView = itemView.findViewById<TextView>(R.id.userEmailTextView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }
        }
    }
}