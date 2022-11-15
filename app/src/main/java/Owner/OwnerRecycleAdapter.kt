package Owner

import android.content.Context
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.reviews_item, parent, false)
        Log.d("!!!Adapter", "oncreateViewholder")

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("!!!Adapter", "onbindviewholder $position")

        // när en list_view ska visas så tar vi rätt person från vår lista
        val review = reviews[position]

        // sätt in den personens uppgifter i vår view

        holder.nameTextView.text = review.userName
        holder.reviewTextView.text = review.userReview
        holder.emailTextView.text = review.userEmail

    }


    override fun getItemCount(): Int {
        return reviews.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    
        var nameTextView = itemView.findViewById<TextView>(R.id.userNameTextView)
        var reviewTextView = itemView.findViewById<TextView>(R.id.reviewTextView)
        var emailTextView = itemView.findViewById<TextView>(R.id.userEmailTextView)


    }
}