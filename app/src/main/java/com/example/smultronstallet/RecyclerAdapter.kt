package com.example.smultronstallet

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



/*
    var titles  = listOf("Thaistället","Indien","kebab stället","chilenar stället","Maria","Maria","Maria","Maria","Maria","Maria","Thaistället","Indien","kebab stället","chilenar stället","Maria","Maria","Maria","Maria","Maria","Maria")
    var details = listOf("jag säger bara rödcurrin !!","den bästa indiska!!","kebaben nästa nivår men service sämsta men värt","empanadas av rysninar!!","grymt!!","grymt!!","grymt!!","grymt!!","grymt!!","grymt!!","jag säger bara rödcurrin !!","den bästa indiska!!","kebaben nästa nivår men service sämsta men värt","empanadas av rysninar!!","grymt!!","grymt!!","grymt!!","grymt!!","grymt!!","grymt!!")
    var image = listOf(R.drawable.thai,R.drawable.indisk,R.drawable.hokis1,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat, R.drawable.thai,R.drawable.indisk,R.drawable.hokis1,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat)
    */
   private var titles = mutableListOf<String>()
    private var details = mutableListOf<String>()
    private var image = mutableListOf<Int>()
    private var counter = 0

    private fun addToLists() {

        val smultronList1 = SmultronList()
        Log.d("!!!", "hej jag var här")
        for (smultronplats in smultronList1.listSmultronPerson) {
            titles.add(smultronplats.name)
            details.add(smultronplats.review)
            image.add(smultronplats.image)
        }

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)

    }
   //räknar hur stor listan är och returnerar storleken
    override fun getItemCount(): Int {
       if (counter==0) {
           addToLists()
           counter++
       }
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ){
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(image[position])
    }



    inner class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {

            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
    }

}

}