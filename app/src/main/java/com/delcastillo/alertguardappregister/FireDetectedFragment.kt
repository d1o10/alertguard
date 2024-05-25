package com.delcastillo.alertguardappregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.delcastillo.appregister.R

class FireDetectedFragment : Fragment(R.layout.fragment_fire_detected) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Access the button from the fragment's layout
        val fireDetectemer: Button = view.findViewById(R.id.emergency)

        // Set OnClickListener for the button
        fireDetectemer.setOnClickListener {
            val intent = Intent(requireContext(), EmergencyContact::class.java)
            startActivity(intent)
        }

        // Find the ImageView
        val womanImageView: ImageView = view.findViewById(R.id.WomanFireDect)

        womanImageView.setOnClickListener {
            val mainScreenActivity = requireActivity() as? MainScreenActivity
            mainScreenActivity?.replaceFragment(ProfileFragment(), R.id.flFragment)
        }
    }
}



