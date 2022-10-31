package com.example.smultronstallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.widget.EditText
import android.widget.Toast
import com.example.smultronstallet.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView: EditText
    lateinit var passwordView: EditText
    var showPass = false

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
        showHidePass2.setOnClickListener() {
        showPass = !showPass
        showPassword(showPass)
    }

    showPassword(showPass)
}

fun showPassword(isShow: Boolean) {
    if (isShow) {
        //this show the password
        passET.transformationMethod = HideReturnsTransformationMethod.getInstance()
        showHidePass2.setImageResource(R.drawable.ic_visibility_off)
        showHidePass3.setImageResource(R.drawable.ic_visibility_off)
    } else {
        //to hide the password
        passET.transformationMethod = HideReturnsTransformationMethod.getInstance()
        showHidePass3.setImageResource(R.drawable.ic_visibility)
        showHidePass2.setImageResource(R.drawable.ic_visibility)
    }
    //this line of code to put the pointer att the end of the password string
    passET.setSelection(passET.text.toString().length)
}
}