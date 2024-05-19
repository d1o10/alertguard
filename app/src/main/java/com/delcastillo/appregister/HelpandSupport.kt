package com.delcastillo.appregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HelpandSupport : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_helpand_support)


        val backhelp = findViewById<Button>(R.id.backbtnhelp)
        backhelp.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)

            }

    }
}