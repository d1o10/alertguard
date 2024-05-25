package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.delcastillo.appregister.R

class EmergencyContact : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_contact)

        db = FirebaseFirestore.getInstance()

        val back: Button = findViewById(R.id.backbtn)
        back.setOnClickListener {
            val intent = Intent(this, MainScreenActivity::class.java)
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
        val contactContainer = findViewById<LinearLayout>(R.id.contactContainer)
        contactContainer.removeAllViews() // Clear existing views

        db.collection("contacts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val firstName = document.getString("firstName") ?: ""
                    val lastName = document.getString("lastName") ?: ""
                    val phone = document.getString("phone") ?: ""

                    val contactView = layoutInflater.inflate(R.layout.activity_contact_item, contactContainer, false)
                    val contactDetails = contactView.findViewById<TextView>(R.id.contactDetails)
                    val deleteButton = contactView.findViewById<Button>(R.id.deleteButton)

                    contactDetails.text = "$firstName $lastName\n$phone"

                    deleteButton.setOnClickListener {
                        db.collection("contacts").document(document.id)
                            .delete()
                            .addOnSuccessListener {
                                Toast.makeText(this, "Contact deleted", Toast.LENGTH_SHORT).show()
                                contactContainer.removeView(contactView)
                            }
                            .addOnFailureListener { e ->
                                Toast.makeText(this, "Error deleting contact: ${e.message}", Toast.LENGTH_SHORT).show()
                            }
                    }

                    contactContainer.addView(contactView)
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error loading contacts: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
