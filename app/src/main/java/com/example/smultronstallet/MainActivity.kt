package com.example.smultronstallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

 lateinit var list:MapList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // lista till map

       Log.d("!!!", "${list.latitude}")


       }
}