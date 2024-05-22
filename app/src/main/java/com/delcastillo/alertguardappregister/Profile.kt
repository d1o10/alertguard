package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val profilebtn = findViewById<Button>(R.id.emergency_contacts)
        profilebtn.setOnClickListener {
            val intent = Intent(this, EmergencyContact::class.java)
            startActivity(intent)
        }

        val settingsbtn = findViewById<Button>(R.id.settingsprof)
        settingsbtn.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }

        val profback: Button = findViewById(R.id.backbtnprof)
        profback.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        // Log out button functionality
        val logoutBtn = findViewById<Button>(R.id.logout)
        logoutBtn.setOnClickListener {
            // Clear any saved user data if necessary
            // For example, clear SharedPreferences or any logged-in session data

            // Redirect to login activity
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}