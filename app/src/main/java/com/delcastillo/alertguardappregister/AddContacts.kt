package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.delcastillo.appregister.R

class AddContacts : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contacts)

        db = FirebaseFirestore.getInstance()

        val backemergency: ImageButton = findViewById(R.id.backbtnemergency)
        backemergency.setOnClickListener {
            val intent = Intent(this, EmergencyContact::class.java)
            startActivity(intent)
        }

        val saveContact: Button = findViewById(R.id.newContactbtn)
        saveContact.setOnClickListener {
            val firstName = findViewById<EditText>(R.id.fnameContact).text.toString()
            val lastName = findViewById<EditText>(R.id.lnameContact).text.toString()
            val phone = findViewById<EditText>(R.id.phoneContact).text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val contact = hashMapOf(
                "firstName" to firstName,
                "lastName" to lastName,
                "phone" to phone
            )

            db.collection("contacts")
                .add(contact)
                .addOnSuccessListener {
                    Toast.makeText(this, "Contact saved successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, EmergencyContact::class.java)
                    startActivity(intent)
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error saving contact: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
