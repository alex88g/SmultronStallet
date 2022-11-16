package Owner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.smultronstallet.R
import kotlinx.android.synthetic.main.activity_owner.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class OwnerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner)
        var nameText : String?

        val businessName = findViewById<EditText>(R.id.businessNameEditText)
        val businessNameButton = findViewById<Button>(R.id.businessNameBtn)
        businessNameButton.setOnClickListener {
            businessNameButton.setEnabled(false)
            businessNameButton.setHint("")
            businessNameButton.setText(null)
            businessNameButton.setBackgroundResource(android.R.color.transparent)


            businessName.setOnEditorActionListener(TextView.OnEditorActionListener { v, id, event ->
                if (id == EditorInfo.IME_ACTION_DONE) {
                    nameText = businessName.text.toString()
                    val intent = Intent(this, OwnerReviewsActivity::class.java)
                    intent.putExtra("businessName", nameText)
                    startActivity(intent)
                    businessName.setEnabled(false)


                    true
                } else false
            })
        }


        val logOutBtn = findViewById<Button>(R.id.logOutBtn)
        logOutBtn.setOnClickListener {
            val intent = Intent(this, Login.SignInActivity::class.java)
            startActivity(intent)
        }
        val emails = intent.getStringExtra("emails")

        val sendofferBtn = findViewById<Button>(R.id.sendOfferBtn)
        sendofferBtn.setOnClickListener {
            val intent = Intent(this, OwnerSendOfferActivity::class.java)
            intent.putExtra("emails",emails)
            startActivity(intent)
        }

        val showReviewsBtn = findViewById<Button>(R.id.showReviewsBtn)
        showReviewsBtn.setOnClickListener {
            nameText = businessName.text.toString()
            val intent = Intent(this, OwnerReviewsActivity::class.java)
            intent.putExtra("businessName", nameText)
            startActivity(intent)
        }

    }
}
