package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
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

        // Retrieving the data from SharedPreferences
        val sharedPreferences = getSharedPreferences("Contacts", MODE_PRIVATE)
        val allContacts = sharedPreferences.all

        val contactContainer = findViewById<LinearLayout>(R.id.contactContainer)

        allContacts.keys.sorted().forEach { key ->
            if (key.startsWith("FIRST_NAME_")) {
                val id = key.removePrefix("FIRST_NAME_")
                val firstName = allContacts[key] as String
                val lastName = allContacts["LAST_NAME_$id"] as String
                val phone = allContacts["PHONE_$id"] as String

                val contactView = TextView(this).apply {
                    text = "$firstName $lastName\n$phone"
                    textSize = 16f
                    setPadding(0, 0, 0, 20)
                }
                contactContainer.addView(contactView)
            }
        }
    }
}