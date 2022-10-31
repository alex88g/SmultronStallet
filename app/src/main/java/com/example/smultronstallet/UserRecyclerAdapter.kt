package com.example.smultronstallet

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerAdapter (private val context: Context, private val users: MutableList<User>) :
                    RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.userlist_item, parent, false)
        Log.d("!!!Adapter", "oncreateViewholder")
//add
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("!!!Adapter", "onbindviewholder")

        // när en list_view ska visas så tar vi rätt person från vår lista
        val user = users[position]

        // sätt in den personens uppgifter i vår view
        holder.nameTextView.text = user.name
        holder.ageTextView.text = user.age.toString()
        holder.emailTextView.text = user.email
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
        return users.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        // när en viewholder skapas letar vi reda på två textvews som finns inne i vår itemview
        // (vår itemview är skapad utifrån vår list_item layout
        var nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        var ageTextView = itemView.findViewById<TextView>(R.id.ageTextView)
        var emailTextView = itemView.findViewById<TextView>(R.id.emailTextView)

    }
}
