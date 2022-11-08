package fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import Maps.MyAdapter
import Maps.News
import com.example.smultronstallet.R

class SearchFragment : Fragment() {

    lateinit var adapter : MyAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(newsArrayList)
        recyclerView.adapter = adapter

        Toast.makeText(context, "Välkommen att Söka!", Toast.LENGTH_SHORT).show()
    }


    fun dataInitialize(){

        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(
            R.drawable.a_chileansk,
            R.drawable.b_indisk,
            R.drawable.c_vietnamesisk,
            R.drawable.d_chinesisk,
            R.drawable.e_japansk,
            R.drawable.f_balkan,
            R.drawable.g_libanesisk,
            R.drawable.h_rysk,
            R.drawable.i_italiensk,
            R.drawable.j_thai
        )

        heading = arrayOf(
            getString(R.string.head_a),
            getString(R.string.head_b),
            getString(R.string.head_c),
            getString(R.string.head_d),
            getString(R.string.head_e),
            getString(R.string.head_f),
            getString(R.string.head_g),
            getString(R.string.head_h),
            getString(R.string.head_i),
            getString(R.string.head_j),
        )

        news = arrayOf(
            getString(R.string.news_1),
            getString(R.string.news_2),
            getString(R.string.news_3),
            getString(R.string.news_4),
            getString(R.string.news_5),
            getString(R.string.news_6),
            getString(R.string.news_7),
            getString(R.string.news_8),
            getString(R.string.news_9),
            getString(R.string.news_10),
        )

        for (i in imageId.indices){

            val news = News(imageId[i],heading[i])
            newsArrayList.add(news)
        }
    }
}