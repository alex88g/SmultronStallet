package Maps


import Login.User
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.smultronstallet.R
import com.google.android.material.imageview.ShapeableImageView
import fragment.SearchFragment

class MyAdapter(val newsList : ArrayList<News>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.infoHeading.text = currentItem.heading

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
        return newsList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val infoHeading : TextView = itemView.findViewById(R.id.infoHeading)

    }
}
