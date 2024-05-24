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

        loadContacts()
    }

    private fun loadContacts() {
        val sharedPreferences = getSharedPreferences("Contacts", MODE_PRIVATE)
        val allContacts = sharedPreferences.all

        val contactContainer = findViewById<LinearLayout>(R.id.contactContainer)
        contactContainer.removeAllViews() // Clear existing views

        allContacts.keys.sorted().forEach { key ->
            if (key.startsWith("FIRST_NAME_")) {
                val id = key.removePrefix("FIRST_NAME_")
                val firstName = allContacts[key] as String
                val lastName = allContacts["LAST_NAME_$id"] as String
                val phone = allContacts["PHONE_$id"] as String

                val contactView = layoutInflater.inflate(R.layout.activity_contact_item, contactContainer, false)
                val contactDetails = contactView.findViewById<TextView>(R.id.contactDetails)
                val deleteButton = contactView.findViewById<Button>(R.id.deleteButton)

                contactDetails.text = "$firstName $lastName\n$phone"

                deleteButton.setOnClickListener {
                    val editor = sharedPreferences.edit()
                    editor.remove("FIRST_NAME_$id")
                    editor.remove("LAST_NAME_$id")
                    editor.remove("PHONE_$id")
                    editor.apply()

                    // Remove the contact view from the container
                    contactContainer.removeView(contactView)
                }

                contactContainer.addView(contactView)
            }
        }
    }
}