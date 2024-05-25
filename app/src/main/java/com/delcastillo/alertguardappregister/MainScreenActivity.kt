package com.delcastillo.alertguardappregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.fragment.app.Fragment
import com.delcastillo.appregister.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainScreenActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        val dashboardFragment = DashboardFragment()
        val locationFragment = LocationFragment()
        val profileFragment = ProfileFragment()

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        setCurrentFragment(dashboardFragment)

        bottomNavigationView.setOnItemSelectedListener  {
            when (it.itemId) {
                R.id.homeIcon -> {
                    setCurrentFragment(dashboardFragment)
                    true
                }
                R.id.locationIcon -> {
                    setCurrentFragment(locationFragment)
                    true
                }
                R.id.notificationIcon -> {
                    setCurrentFragment(dashboardFragment)
                    true
                }
                R.id.profileIcon -> {
                    setCurrentFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }


    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
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
