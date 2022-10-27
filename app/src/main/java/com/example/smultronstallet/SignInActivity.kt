package com.example.smultronstallet


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.smultronstallet.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView : EditText
    lateinit var passwordView : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        emailView = findViewById(R.id.emailEt)
        passwordView = findViewById(R.id.passET)

        auth = Firebase.auth

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener {
            val intent = Intent(this, SignUpActivity:: class.java)
            startActivity(intent)
        }
        binding.buttonSignin.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (auth.currentUser == null) {
                Log.d("!!!", "${auth.currentUser?.email}")



                if (email.isNotEmpty() && pass.isNotEmpty()) {

                    auth.signInWithEmailAndPassword("alex@gmail.com", "12345678")
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {

                                // Sign in success, update UI with the signed-in user's information
                                Log.d("!!!", "createUserWithEmail:success")

                                val intent = Intent(this, Item::class.java)
                                startActivity(intent)
                            } else {

                                // If sign in fails, display a message to the user.
                                Log.w("!!!", "createUserWithEmail:failure ${task.exception}")

                                Toast.makeText(this, task.exception.toString(), Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show()
                }

            }
            fun goToAddActivity() {
                val intent = Intent(this, AddItemActivity::class.java)
                startActivity(intent)
            }
            goToAddActivity()
        }
    }
}