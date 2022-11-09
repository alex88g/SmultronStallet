package Login


import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smultronstallet.MainActivity
import com.example.smultronstallet.R
import com.example.smultronstallet.databinding.ActivitySignInBinding
import com.example.smultronstallet.OwnerActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.emailEt
import kotlinx.android.synthetic.main.activity_sign_in.passET

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    lateinit var auth: FirebaseAuth
    lateinit var emailView: EditText
    lateinit var passwordView: EditText
    var businessSignin = false
    val db = Firebase.firestore

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


        binding.OwnerSignin.setOnClickListener {

            textView.setEnabled(false)
            textView.setHint("")
            textView.setText(null)
            BusinessTextView.setEnabled(false)
            BusinessTextView.setHint("")
            BusinessTextView.setText(null)
            buttonSignin.setText("Business Logga in")
            wellcomeView.setText("Business Login")
            emailEt.setHint("Business mail")
            passET.setHint("Password")
            OwnerSignin.setBackgroundResource(android.R.color.transparent)
            OwnerSignin.setText(null)
            signin.setBackgroundResource(R.drawable.ownersignup)

        }
        binding.textForgot.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
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
                val ownerCheck = db.collection("owners").whereEqualTo("email", email)
                ownerCheck
                    .get()
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                            Log.d("!!!","ownerCheck")
                            Toast.makeText(applicationContext,"Exists",Toast.LENGTH_SHORT).show()
                              //val document = it.result

                                for(document in it.result) {
                                    val emailcheck = document.data["email"].toString()
                                    if(email == emailcheck) {
                                        businessSignin = true
                                    }
                                }



                            Log.d("!!!","businessSignin = $businessSignin")
                        }
                    }
                    .addOnFailureListener { exception ->
                        Log.d(ContentValues.TAG, "Kontot matchar inte!", exception)
                    }
                if (email.isNotEmpty() && password.isNotEmpty()) {


                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            if(businessSignin) {
                                val intent = Intent(this, OwnerActivity::class.java)
                                startActivity(intent)
                            } else if(!businessSignin){
                                Toast.makeText(this, "Välkommen Till SmultronStället!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            }
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Tomma fält är inte tillåtna!!", Toast.LENGTH_SHORT).show()

                }
            }
    }
}