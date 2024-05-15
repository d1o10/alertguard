package com.delcastillo.appregister

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginbtn = findViewById<Button>(R.id.loginAcc)
        loginbtn.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
            val signupbtn = findViewById<Button>(R.id.Signup)
            signupbtn.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)

        }
    }
}