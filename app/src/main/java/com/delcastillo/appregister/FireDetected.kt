package com.delcastillo.appregister

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat

class FireDetected : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_detected)

        val location2: Button = findViewById(R.id.locationIcon)
        location2.setOnClickListener {
            val intent = Intent(this, Location::class.java)
            ContextCompat.startActivity(this, intent, null)
        }

        val dashboard: Button = findViewById(R.id.homeIcon)
        dashboard.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            ContextCompat.startActivity(this, intent, null)
        }

        val womanImageView: ImageView = findViewById(R.id.WomanFireDect)
        womanImageView.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            ContextCompat.startActivity(this, intent, null)
        }
    }
}
