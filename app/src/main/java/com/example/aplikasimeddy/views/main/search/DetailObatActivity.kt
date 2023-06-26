package com.example.aplikasimeddy.views.main.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.model_responses.ObatResponse

class DetailObatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_obat)

        val obat = intent.getParcelableExtra<ObatResponse>("obat")
        if (obat != null){
            val nama : TextView = findViewById(R.id.tv_nama_obat_detail)
            val deskripsi : TextView = findViewById(R.id.tv_deskripsi_obat)
            val jenis : TextView = findViewById(R.id.tv_jenis_obat)
            val komposisi : TextView = findViewById(R.id.tv_komposisi_obat)
            val kegunaan : TextView = findViewById(R.id.tv_kegunaan_obat)
            val efek : TextView = findViewById(R.id.tv_efek_samping_obat)

            nama.text = obat.name
            deskripsi.text = obat.deskripsi
            jenis.text = obat.jenis
            komposisi.text = obat.komposisi
            kegunaan.text = obat.kegunaan
            efek.text = obat.efek
        }

        val btnBack: ImageView = findViewById(R.id.iv_btn_back_detail_obat)
        btnBack.setOnClickListener {
            finish()
        }
    }
}