package com.delcastillo.appregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        val fireDetected: Button = findViewById(R.id.notificationIcon)
        fireDetected.setOnClickListener {
            val intent = Intent(this, FireDetected::class.java)
            startActivity(intent)
        }

        val location: Button = findViewById(R.id.locationIcon)
        location.setOnClickListener {
            val intent = Intent(this, Location::class.java)
            startActivity(intent)
        }

        val womanImageView: ImageView = findViewById(R.id.Woman)
        womanImageView.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }

    fun onTextViewClicked(view: View) {
        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
    }
}
