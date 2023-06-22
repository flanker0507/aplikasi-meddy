package com.example.aplikasimeddy.views.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.aplikasimeddy.views.intro.OnboardingActivity
import com.example.aplikasimeddy.R

@SuppressLint("CustomSplashScreen")
class SplashscreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Splashscreen2Activity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}