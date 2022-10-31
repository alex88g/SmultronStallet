package com.example.smultronstallet


import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smultronstallet.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView: EditText
    lateinit var passwordView: EditText
    var showPass = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }

        binding.buttonSignin.setOnClickListener {
            val email = binding.emailEt.toString()
            val password = binding.passET.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, SignInActivity::class.java)
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
                    startActivity(Intent(this, SignInActivity::class.java))
                    finish()

                }

            }
            if (auth.currentUser != null) {
                auth.currentUser?.let {
                    binding.textCheckLog.text = it.email
                }
            }
                checkIfUserIsLogged()
            }

            showHidePass.setOnClickListener() {
                showPass = !showPass
                showPassword(showPass)
            }

            showPassword(showPass)
        }

        fun showPassword(isShow: Boolean) {
            if (isShow) {
                //this show the password
                passET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showHidePass.setImageResource(R.drawable.ic_visibility_off)
            } else {
                //to hide the password
                passET.transformationMethod = HideReturnsTransformationMethod.getInstance()
                showHidePass.setImageResource(R.drawable.ic_visibility)
            }
            //this line of code to put the pointer att the end of the password string
            passET.setSelection(passET.text.toString().length)
        }
    }
