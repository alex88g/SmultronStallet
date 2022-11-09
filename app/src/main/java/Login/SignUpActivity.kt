package Login


import android.content.ContentValues.TAG
import android.content.Intent
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
            userName.hint = "Användarnamn"
            emailEt.hint = "E-post"

            wellcomeView.text = "Registrera dig till Smultronstället företag!"

            phonenrTextView.hint = "Mobilnummer"

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
                    Toast.makeText(this, "Fel lösenord", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Tomma fält är inte tillåtna!!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}