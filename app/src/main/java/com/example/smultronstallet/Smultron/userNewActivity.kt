package com.example.smultronstallet.Smultron

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.smultronstallet.R
import kotlinx.android.synthetic.main.activity_user_new.*


lateinit var image: ImageView
lateinit var textView: TextView
class userNewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_new)


        image = thai

        textView = textView2
        review1


    }
}