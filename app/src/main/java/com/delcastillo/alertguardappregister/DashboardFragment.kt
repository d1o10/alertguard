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

        womanImageView.setOnClickListener {
            val mainScreenActivity = requireActivity() as? MainScreenActivity
            mainScreenActivity?.replaceFragment(ProfileFragment(), R.id.flFragment)
        }
    }

}
