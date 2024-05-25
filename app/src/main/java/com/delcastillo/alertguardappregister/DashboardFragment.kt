package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.delcastillo.appregister.R

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the ImageView
        val womanImageView: ImageView = view.findViewById(R.id.Woman)

        // Set the click listener
        womanImageView.setOnClickListener {
            // Create an intent to start the Profile activity
            val intent = Intent(activity, ProfileFragment::class.java)
            startActivity(intent)
        }
    }
//
//        setContentView(R.layout.fragment_dashboard)
//
//        val fireDetected: Button = findViewById(R.id.notificationIcon)
//        fireDetected.setOnClickListener {
//            val intent = Intent(this, FireDetected::class.java)
//            startActivity(intent)
//        }
//
//        val location: Button = findViewById(R.id.locationIcon)
//        location.setOnClickListener {
//            val intent = Intent(this, Location::class.java)
//            startActivity(intent)
//        }
//
//        val womanImageView: ImageView = findViewById(R.id.Woman)
//        womanImageView.setOnClickListener {
//            val intent = Intent(this, Profile::class.java)
//            startActivity(intent)
//        }
//
//        val profilebtn: Button = findViewById(R.id.profileIcon)
//        profilebtn.setOnClickListener {
//            val intent = Intent(this, Profile::class.java)
//            startActivity(intent)
//        }
//    }
//
//    fun onTextViewClicked(view: View) {
//        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
//    }
}
