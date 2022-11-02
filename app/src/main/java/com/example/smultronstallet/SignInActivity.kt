package com.example.smultronstallet


import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smultronstallet.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView: EditText
    lateinit var passwordView: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //UserList()
        //PlaceList()
        emailView = findViewById(R.id.emailEt)
        passwordView = findViewById(R.id.passET)



        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()



        binding.textForgot.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSignout.setOnClickListener {
            auth.signOut()
            startActivity(
                Intent(
                    this,
                    SignInActivity::class.java))
            startActivity(intent)
        }



        binding.textView.setOnClickListener {
            val business : Boolean = false
            val intent = Intent(this, SignUpActivity::class.java)
            intent.putExtra("business",business)
            startActivity(intent)

        }
        binding.BusinessTextView.setOnClickListener {
            val business : Boolean = true
            val intent = Intent(this, SignUpActivity::class.java)
            intent.putExtra("business",business)
            startActivity(intent)

        }

        binding.buttonSignin.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val password = binding.passET.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()

            }

            fun checkIfUserIsLogged() {
                if (auth.currentUser != null) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()

                }

            }
            if (auth.currentUser != null) {
                auth.currentUser?.let {
                    binding.textCheckLog.text = it.email
                }

                checkIfUserIsLogged()
            }
        }
    }
}