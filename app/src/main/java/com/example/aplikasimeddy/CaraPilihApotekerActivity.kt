package com.example.aplikasimeddy

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.example.aplikasimeddy.databinding.ActivityCaraPilihApotekerBinding

class CaraPilihApotekerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCaraPilihApotekerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaraPilihApotekerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBtnPilihApotek.setOnClickListener{
////            val fragment = CariApotekFragment()
//            supportFragmentManager.beginTransaction().replace(
//                R.id.frame_layout, fragment)
//                .commit()
        }
    }
}