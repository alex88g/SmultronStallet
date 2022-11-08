package com.example.smultronstallet

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewsRecycleAdapter(val context: Context, val reviews: List<Reviews> ) :
    RecyclerView.Adapter<ReviewsRecycleAdapter.ViewHolder>(){


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
        holder.nameTextView.text = review.name
        holder.reviewTextView.text = review.review
    }


    override fun getItemCount(): Int {
        return reviews.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)   {
        var nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        var reviewTextView = itemView.findViewById<TextView>(R.id.reviewTextView)


    }
}