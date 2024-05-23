package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R

class AddContacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contacts)

        val backemergency: Button = findViewById(R.id.backbtnemergency)
        backemergency.setOnClickListener {
            val intent = Intent(this, EmergencyContact::class.java)
            startActivity(intent)
        }

        val saveContact: Button = findViewById(R.id.newContactbtn)
        saveContact.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.fnameContact).text.toString()
            val lastName = findViewById<EditText>(R.id.lnameContact).text.toString()
            val phone = findViewById<EditText>(R.id.phoneContact).text.toString()

            val sharedPreferences = getSharedPreferences("Contacts", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val contactID = System.currentTimeMillis().toString()
            editor.putString("FIRST_NAME_$contactID", firstName)
            editor.putString("LAST_NAME_$contactID", lastName)
            editor.putString("PHONE_$contactID", phone)
            editor.apply()

            val intent = Intent(this, EmergencyContact::class.java)
            startActivity(intent)
        }
    }
}