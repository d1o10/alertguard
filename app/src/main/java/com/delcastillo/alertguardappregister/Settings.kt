package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

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

        val helpsup: Button = findViewById(R.id.helpSupport)
        helpsup.setOnClickListener {
            val intent = Intent(this, HelpandSupport::class.java)
            startActivity(intent)
        }


        val aboutbt: Button = findViewById(R.id.About)
        aboutbt.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    

        
        }
    }