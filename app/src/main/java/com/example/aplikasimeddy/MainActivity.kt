package com.example.aplikasimeddy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.aplikasimeddy.databinding.ActivityMainBinding
import com.example.aplikasimeddy.views.main.dashboard.BerandaFragment
import com.example.aplikasimeddy.views.main.history.RiwayatChatFragment
import com.example.aplikasimeddy.views.main.schedule.JadwalFragment
import com.example.aplikasimeddy.views.main.search.CariFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(BerandaFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.beranda -> replaceFragment(BerandaFragment())
                R.id.cari -> replaceFragment(CariFragment())
                R.id.jadwal -> replaceFragment(JadwalFragment())
                R.id.riwayat -> replaceFragment(RiwayatChatFragment())
            }
            true
        }

    }


    //create a function to replace frame layout on main activity with fragment
    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}