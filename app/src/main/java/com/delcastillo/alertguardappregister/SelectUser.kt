package com.delcastillo.alertguardappregister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.delcastillo.appregister.R

class SelectUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_user)

        val selectUserBtn: Button = findViewById(R.id.selectuserbtn)
        selectUserBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("USER_TYPE", "USER")
            startActivity(intent)
        }

        val selectResponderBtn: Button = findViewById(R.id.selectresponderbtn)
        selectResponderBtn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("USER_TYPE", "RESPONDER")
            startActivity(intent)
        }
    }
}
