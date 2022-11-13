package Owner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R

class OwnerReviewsActivity : AppCompatActivity() {

    var reviews = mutableListOf<OwnerReviews>(
        OwnerReviews("Anna", "Det här var skitgott!!!!!", "annas.kossa@hotmail.com"),
        OwnerReviews(
            "Ernesto",
            "Väldigt smakrikt och en bra upplevelse. Otrevlig personal med konstiga skor!",
            "cykel@traktos.se"
        ),
        OwnerReviews(
            "Fredde",
            "Jag trivs så bra i denna skog, jag sitter alltid här och tänker på när jag var liten och allt var så himla roligt t.ex. att plocka kottar. Tack!",
            "freddearcool@gmail.com"
        ),
        OwnerReviews(
            "Olivia",
            "Så kul att få vara tillbaka här! Jag är här varje år och trivs så himla bra. Guuuud vad gott det var med frälst potatis.",
            "solveig.karlsson@hotmail.com"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_reviews)

        var recyclerView = findViewById<RecyclerView>(R.id.reviewsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // skapade vi en adapter från vår adapter-klass och skickar med vår lista av personer
        val adapter = OwnerRecycleAdapter(this, reviews)

        // koppla ihop vår adapter med recyclerviewn
        recyclerView.adapter = adapter

    }
}
