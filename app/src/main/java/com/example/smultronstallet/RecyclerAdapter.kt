package com.example.smultronstallet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var titles = arrayOf("Maria", "Hugo ", "Anna", "Alexander", "Leandro", "Christian","Christian","Christian","Maria", "Hugo ", "Anna", "Alexander", "Leandro", "Christian","Christian","Christian")
    private var details = arrayOf("ojjjjj vad sjuklikt gott","empanadas är den nya smakatombomben","Item three detail","Item five detail", "item six detail","item six detail","ojjjjj vad sjuklikt gott","empanadas är den nya smakatombomben","Item three detail","Item five detail", "item six detail","item six detail")
    private var image = intArrayOf(R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat,R.drawable.chilenskmat)
    var smultronlist = mutableListOf<SmultronList>()
// här ska skapas en finktion som gör att recyclerView inte slutar forsätter till sixe of
   /* for(i in 0 to size){
        smultronlist.add(SmultronList("hej",))
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {

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