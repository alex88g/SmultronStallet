package Owner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smultronstallet.R

class OwnerReviewsActivity : AppCompatActivity() {

    var reviews = mutableListOf<OwnerReviews>(
        OwnerReviews("Alex", "Jättegod pasta med tryffelsalami och björnbär. Rekommenderar absolut.", "alex.kossa@hotmail.com"),
        OwnerReviews(
            "Ernesto",
            "Väldigt smakrikt och en bra upplevelse. Otrevlig personal med konstiga skor!",
            "cykel@traktos.se"
        ),
        OwnerReviews(
            "Fredde",
            "Jag gillar denna resturang massor, jag sitter alltid här och fantiserara att jag är i skogen och äter kottar. Rekommenderar till alla.",
            "freddearcool@gmail.com"
        ),
        OwnerReviews(
            "Olivia",
            "Så kul att få vara tillbaka här! Jag och min familj äter julbord här varje påsk. Så himlans gott måste jag säga. Min 4-åring gillade potatisen.",
            "solveig.karlsson@hotmail.com"
        ),
        OwnerReviews(
            "Hugo",
            "Jag rekommenderar alla att gå hit innan klockan 11 för att ta del av deras fina brunchbuffé. Fräscht och gott! Bra med barnförbudet innan 12.",
            "hugopugolugo@hotmail.com"
        ),
        OwnerReviews(
            "Anna",
            "Gott och nyttigt. Synd att proteinshaken var slut, men gott med en kladdkaka istället.",
            "annapannoooooo.larsson@hotmail.com"
        ),
        OwnerReviews(
            "Zilola",
            "Fantastiskt fin plats med stora fönsterpartier som gör det lätt att njuta av utsikten och sin kaffe! Tack. Spenderar mycket tid här och läser om blommor.",
            "ziloololi@hotmail.com")
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
