package fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.smultronstallet.CameraActivity
import com.example.smultronstallet.R


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


//        var intentCamerar = Intent(activity, CameraActivity::class.java)
//        startActivity(intentCamerar)


            Toast.makeText(context, "Vällkommen till Recesion!", Toast.LENGTH_SHORT).show()

        }
    }
