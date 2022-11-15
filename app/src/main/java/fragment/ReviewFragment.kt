package fragment

import Maps.Place
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.smultronstallet.CameraActivity
import com.example.smultronstallet.R
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_review.*





    lateinit var botton: Button
    lateinit var cameraButton1: ImageButton

    class ReviewFragment : Fragment() {


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_review, container, false)


        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            var cameraButton1 = cameraButtonSmultron
            cameraButton1.setOnClickListener {
                val intentCamerar = Intent(activity, CameraActivity::class.java)
                startActivity(intentCamerar)
            }


            //Toast.makeText(context, "Vällkommen till Recesion!", Toast.LENGTH_SHORT).show()
        }

    }

