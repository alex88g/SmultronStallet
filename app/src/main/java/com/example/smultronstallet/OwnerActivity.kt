
package com.example.smultronstallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class OwnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner)

        val logOutBtn = findViewById<Button>(R.id.logOutBtn)
        logOutBtn.setOnClickListener{
            val intent = Intent(this, Login.SignInActivity::class.java)
            startActivity(intent)
        }

        val sendofferBtn = findViewById<Button>(R.id.sendOfferBtn)
        sendofferBtn.setOnClickListener{
            val intent = Intent(this, OwnerSendOfferActivity::class.java)
            startActivity(intent)
        }

        val showReviewsBtn = findViewById<Button>(R.id.showReviewsBtn)
        showReviewsBtn.setOnClickListener{
            val intent = Intent(this, OwnerReviewsActivity::class.java)
            startActivity(intent)
        }

    }
}
