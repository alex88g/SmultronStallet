package Owner

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.smultronstallet.R


class OwnerSendOfferActivity : AppCompatActivity() {

    //lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val sendOfferBtn = findViewById<Button>(R.id.sendButton)
        val emails = intent.getStringExtra("emails")
        val intent = Intent(Intent.ACTION_SENDTO) // it's not ACTION_SEND
        
        intent.putExtra(Intent.EXTRA_SUBJECT, "Erbjudande!")
        intent.putExtra(Intent.EXTRA_TEXT, "Vi ser att du gillar vårt ställe klicka på länken för erbjudande!")
        intent.data = Uri.parse("mailto:$emails") // or just "mailto:" for blank
            Log.d("!!!","$emails")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // this will make such that when user returns to your app, your app is displayed, instead of the email app.

        startActivity(intent)
    }
}