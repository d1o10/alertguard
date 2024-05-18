package com.delcastillo.appregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)


        val back2: Button = findViewById(R.id.backbtn2)
        back2.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        }
    }
