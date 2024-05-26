package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.delcastillo.appregister.R

class RespondersDashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_responders_dashboard)



        val responderprof: Button = findViewById(R.id.profileIcon)
        responderprof.setOnClickListener {
            val intent = Intent(this, RespondersProfile::class.java)
            startActivity(intent)
        }

    }


}