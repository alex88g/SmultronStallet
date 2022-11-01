package com.example.smultronstallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.smultronstallet.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView: EditText
    lateinit var passwordView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailView = findViewById(R.id.emailEt)
        passwordView = findViewById(R.id.passET)


        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()


        binding.textView2.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)

            startActivity(intent)
        }
        binding.buttonSignup.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()


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
