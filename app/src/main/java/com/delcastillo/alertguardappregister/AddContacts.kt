package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.delcastillo.appregister.R

class AddContacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_contacts)



        val backemergency: Button = findViewById(R.id.backbtnemergency)
        backemergency.setOnClickListener {
            val intent = Intent(this, EmergencyContact::class.java)
            startActivity(intent)
        }
    }
}