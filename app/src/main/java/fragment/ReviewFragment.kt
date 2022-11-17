package fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.smultronstallet.CameraActivity
import com.example.smultronstallet.R
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.fragment_review.*
import java.text.SimpleDateFormat
import java.util.*


class ReviewFragment : Fragment() {
    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {

                val imageUri: Uri? = result.data?.data
                val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
                val now = Date()
                val fileName = formatter.format(now)

                val storage = FirebaseStorage.getInstance()
                val storageRef = storage.reference
                val newImageRef = storageRef.child("images/$fileName")

                if (imageUri != null) {
                    val uploadTask = newImageRef.putFile(imageUri)
                    uploadTask.continueWithTask { task ->
                        if (!task.isSuccessful) {
                            task.exception?.let {
                                throw it
                            }
                        }

                        newImageRef.downloadUrl
                    }
                        .addOnCompleteListener { task->
                            if(task.isSuccessful){
                       // progressBar.visibility = View.GONE
                       // uploadingTextView.visibility = View.GONE
                       // editItemImage.visibility = View.VISIBLE
                        val newImage = task.result.toString()
                            imageView.setImageURI(imageUri)
                        Toast.makeText(context,"Image Uploaded",Toast.LENGTH_SHORT).show()
                        Log.d("!!!","url : $newImage")
                    }
                    }
                }
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cameraButtonSmultron.setOnClickListener {
            val intentCamerar = Intent(activity, CameraActivity::class.java)
            startActivity(intentCamerar)
        }
        imageView.setOnClickListener {
            //startar telefonens "image/galleri" och startar en result launcher som inväntar en bild
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            resultLauncher.launch(intent)

        }


        //Toast.makeText(context, "Vällkommen till Recesion!", Toast.LENGTH_SHORT).show()
    }

}


