package com.example.smultronstallet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class RecyclerAdapter():RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
        private lateinit var mListener:onItemClicklisterner
        interface onItemClicklisterner{
            fun onItemClick(position: Int)
        }
    fun setOnItemClickListener(listener: onItemClicklisterner){
        mListener = listener
    }

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

        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v,mListener)

    }

    //räknar hur stor listan är och returnerar storleken
    override fun getItemCount(): Int {
        if (counter == 0) {
            addToLists()
            counter++
        }
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(image[position])


    }


    inner class ViewHolder(itemView: View,listener: onItemClicklisterner) : RecyclerView.ViewHolder(itemView) {
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





