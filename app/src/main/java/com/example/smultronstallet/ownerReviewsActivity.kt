package com.example.smultronstallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class ownerReviewsActivity : AppCompatActivity() {

    var reviews = mutableListOf<Reviews>(
        Reviews("Anna","Det här var skitgott!!!!!"),
        Reviews("Ernesto", "Väldigt smakrikt och en bra upplevelse. Otrevlig personal med konstiga skor!"),
        Reviews("Fredde", "Jag trivs så bra i denna skog, jag sitter alltid här och tänker på när jag var liten och allt var så himla roligt t.ex. att plocka kottar. Tack!"),
        Reviews("Olivia", "Så kul att få vara tillbaka här! Jag är här varje år och trivs så himla bra. Guuuud vad gott det var med frälst potatis."))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_reviews)

        var recyclerView = findViewById<RecyclerView>(R.id.reviewsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // skapade vi en adapter från vår adapter-klass och skickar med vår lista av personer
        val adapter = ReviewsRecycleAdapter(this, reviews)

        // koppla ihop vår adapter med recyclerviewn
        recyclerView.adapter = adapter

    }
}