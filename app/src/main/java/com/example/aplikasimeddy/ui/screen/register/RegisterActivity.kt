package com.example.aplikasimeddy.ui.screen.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.ui.screen.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        moveToMainLoginActivity()
    }

    private fun moveToMainLoginActivity(){
        val btnDaftar = findViewById<Button>(R.id.btn_register)
        btnDaftar.setOnClickListener{
            val move = Intent(this, LoginActivity::class.java)
            startActivity(move)
        }
    }
}