package Maps


import Login.User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.smultronstallet.R

class MyAdapter( val context: Context,val list : ArrayList<Place>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.infoReview.text = currentItem.review
        holder.titleName.text = currentItem.name

        // Här lägger vi imageURL
        var imageUrl = currentItem.imageURL
        val radius = 30
        val margin = 10
        Glide.with(context)
            .load(imageUrl)
            .error(R.drawable.ic_launcher_background)
            .centerCrop()
            .transform(RoundedCorners(radius))
            .into(holder.placeImage)
    }



    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val titleName : TextView = itemView.findViewById(R.id.itemTitle)
        val infoReview : TextView = itemView.findViewById(R.id.itemDetail)
        var placeImage = itemView.findViewById<ImageView>(R.id.itemImage)
    }
}
