package Login

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.smultronstallet.R
import com.example.smultronstallet.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView: EditText
    lateinit var passwordView: EditText
    lateinit var username: EditText
    lateinit var phonenr: EditText
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailView = findViewById(R.id.emailEt)
        passwordView = findViewById(R.id.passET)
        username = findViewById(R.id.userName)
        phonenr = findViewById(R.id.phonenrTextView)

        //business Login!
        val businessAcount = intent.getBooleanExtra("business", false)
        if(businessAcount){
            userName.hint = "Business Name"
            emailEt.hint = "Business eMail"

            textView3.text = "Register to business account"

            phonenrTextView.hint = "Business phone"

            signup.setBackgroundResource(R.drawable.ownersignup)

        }

        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()


        binding.textView2.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)

            startActivity(intent)
        }
        binding.buttonSignup.setOnClickListener {
            val username = userName.text.toString()
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()
            val phoneNR = phonenr.text.toString()

            // add to Database
            if(businessAcount){
                val item = User(name = username, email = email, phone = phoneNR)
                db.collection("owners")
                    .add(item)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
            }else if(!businessAcount){
                val item = User(name = username, email = email, phone = phoneNR)
                db.collection("users")
                    .add(item)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }

            }



            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        } else {

                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Incorrect password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}