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

}
