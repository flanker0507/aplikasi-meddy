package com.example.aplikasimeddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.aplikasimeddy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moveToMainActivity()
        moveToRegisterActivity()
    }
    private fun moveToMainActivity(){
        val btnLogin = findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener{
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }

    private fun moveToRegisterActivity(){
        val txtListener = findViewById<TextView>(R.id.tv_login_buatSkrg)
        txtListener.setOnClickListener{
            val move = Intent(this, RegisterActivity::class.java)
            startActivity(move)
        }
    }
}