package com.example.smultronstallet

import Maps.Place
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import fragment.ReviewFragment
import kotlinx.android.synthetic.main.fragment_review.*


private const val REQUEST_CODE = 42
@Suppress("DEPRECATION")
class CameraActivity : AppCompatActivity() {
    lateinit var smultronPlats:EditText
    lateinit var recenssion:EditText
    lateinit var  locationGps1:EditText
    lateinit var bTagg :EditText
    lateinit var buttonSave:Button
     var newListOfSmultron = mutableListOf<Place>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_review)



        smultronPlats = smultronPlace1
        recenssion = ReviewS
        locationGps1 = locationGps
        bTagg = bussnestagg
        buttonSave = buttonSmultronSave
        val db = Firebase.firestore
        buttonSave.setOnClickListener {


        }

        val takePicturesIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePicturesIntent.resolveActivity(this.packageManager)!=null){
            startActivityForResult(takePicturesIntent, REQUEST_CODE)

        }else{ Toast.makeText(this,"Unable to open camera", Toast.LENGTH_SHORT).show()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode== REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val takenImage =  data?.extras?.get("data") as Bitmap

            imageView.setImageBitmap(takenImage)
        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}
