package com.example.aplikasimeddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        moveToMainLoginActivity()
    }

    private fun moveToMainLoginActivity(){
        val btnDaftar = findViewById<Button>(R.id.btn_daftar)
        btnDaftar.setOnClickListener{
            val move = Intent(this, LoginActivity::class.java)
            startActivity(move)
        }
    }
}