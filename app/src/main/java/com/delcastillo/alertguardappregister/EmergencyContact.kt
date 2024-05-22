package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R

class EmergencyContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_contact)

        val back: Button = findViewById(R.id.backbtn)
        back.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }

        val emergencybtn: Button = findViewById(R.id.newContactbtn)
        emergencybtn.setOnClickListener {
            val intent = Intent(this, AddContacts::class.java)
            startActivity(intent)
        }
    }
}