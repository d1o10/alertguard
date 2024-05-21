package com.delcastillo.alertguardappregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.delcastillo.appregister.R

class FireDetected : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fire_detected)


        val location2: Button = findViewById(R.id.locationIcon)
        location2.setOnClickListener {
            val intent = Intent(this, Location::class.java)
            startActivity(intent)
        }

        val dashboard: Button = findViewById(R.id.homeIcon)
        dashboard.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        val womanImageView: ImageView = findViewById(R.id.WomanFireDect)
        womanImageView.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}



