package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R

class Profile : AppCompatActivity() {
    private lateinit var profileImageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var genderTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileImageView = findViewById(R.id.profile_image)
        nameTextView = findViewById(R.id.textview_name)
        phoneTextView = findViewById(R.id.textview_phone)
        genderTextView = findViewById(R.id.textview_gender)


        val profilesett: Button = findViewById(R.id.settingsprof)
        profilesett.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }


        val profilemerge: Button = findViewById(R.id.emergency_contacts)
        profilemerge.setOnClickListener {
            val intent = Intent(this, EmergencyContact::class.java)
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






