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
    }
}