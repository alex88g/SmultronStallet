package com.example.smultronstallet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.smultronstallet.databinding.ActivitySignInBinding


class ownerSendOfferActivity : AppCompatActivity() {

    //lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_send_offer)
        //val sendOfferBtn = findViewById<Button>(R.id.sendButton)

        val intent = Intent(Intent.ACTION_SENDTO) // it's not ACTION_SEND

        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email")
        intent.putExtra(Intent.EXTRA_TEXT, "Body of email")
        intent.data = Uri.parse("mailto:default@example.com") // or just "mailto:" for blank

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // this will make such that when user returns to your app, your app is displayed, instead of the email app.

        startActivity(intent)
    }
}