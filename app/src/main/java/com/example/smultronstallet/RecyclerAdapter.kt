package com.example.smultronstallet

import android.content.ContentValues
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase


class RecyclerAdapter(private val context : Context, val places: MutableList<Place>) :

    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.card_layout,parent,false)
        return ViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int ){
        Log.d("!!!", "onBindViewHolder")
        val place = places[position]
        holder.itemTitle.text = place.name
        holder.itemDetail.text = place.review.toString()
        holder.itemImage.setImageResource(R.drawable.chilenskmat)
        // Här lägger vi imageURL
        //var imageUrl = currentItem.imageURL

        //val radius = 30
        //val margin = 10
        //Glide.with(context)
        //    .load(imageURL)
        //    .error(R.drawable.ic_launcher_background)
        //    .centerCrop()
        //    .transform(RoundedCorners(radius))
        //    .into(holder.menuImage)
    }
    override fun getItemCount(): Int {
        return places.size
    }

    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage = itemView.findViewById<ImageView>(R.id.item_image)
        var itemTitle = itemView.findViewById<TextView>(R.id.item_title)
        var itemDetail = itemView.findViewById<TextView>(R.id.item_detail)
    }

}

