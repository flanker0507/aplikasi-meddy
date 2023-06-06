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
//        loadFragmentLogin(LoginFragment())
        moveToMainActivity()
        moveToRegisterActivity()
    }
//    private fun loadFragmentLogin(fragment: Fragment){
//
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame_layout_login, fragment)
//        fragmentTransaction.disallowAddToBackStack()
//        fragmentTransaction.commit()
//    }

    private fun moveToMainActivity(){
        val btnLogin = findViewById<Button>(R.id.button_login)
        btnLogin.setOnClickListener{
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }

    private fun moveToRegisterActivity(){
        val txtListener = findViewById<TextView>(R.id.tv_buat_sekarang)
        txtListener.setOnClickListener{
            val move = Intent(this, RegisterActivity::class.java)
            startActivity(move)
        }
    }
}