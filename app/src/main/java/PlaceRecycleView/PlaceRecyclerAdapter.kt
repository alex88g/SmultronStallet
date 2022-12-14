package PlaceRecycleView

import Maps.MapsPlace
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R

class PlaceRecyclerAdapter(val context: Context, val places: MutableList<MapsPlace>):
    RecyclerView.Adapter<PlaceRecyclerAdapter.ViewHolder>() {


    val layoutInflater = LayoutInflater.from(context)
    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.card_layout, parent, false)
        Log.d("!!!Adapter", "oncreateViewholder")

        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("!!!Adapter", "onbindviewholder")

        // när en list_view ska visas så tar vi rätt person från vår lista
        val place = places[position]

        // sätt in den personens uppgifter i vår view
        holder.nameTextView.text = place.name
        holder.reviewTextView.text = place.review.toString()

    }

    override fun getItemCount(): Int {
        return places.size
    }

    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        // när en viewholder skapas letar vi reda på två textvews som finns inne i vår itemview
        // (vår itemview är skapad utifrån vår list_item layout
        var nameTextView = itemView.findViewById<TextView>(R.id.itemTitle)
        var reviewTextView = itemView.findViewById<TextView>(R.id.itemDetail)
        var placeImage = itemView.findViewById<ImageView>(R.id.itemImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)

            }
        }
    }
}

