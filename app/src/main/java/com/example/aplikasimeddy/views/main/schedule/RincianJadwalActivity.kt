package com.example.aplikasimeddy.views.main.schedule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.room.model.Jadwal

class RincianJadwalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rincian_jadwal)

        //Btn Back
        val btnBack: ImageView = findViewById(R.id.iv_btn_back_rincian)
        btnBack.setOnClickListener {
            finish()
        }

        val jadwal = intent.getParcelableExtra<Jadwal>("jadwal")
        if (jadwal != null){
            val date : TextView = findViewById(R.id.tv_date_rincian)
            val month : TextView = findViewById(R.id.tv_month_rincian)
            val year : TextView = findViewById(R.id.tv_year_rincian)
            val waktu : TextView = findViewById(R.id.tv_waktu_rincian)
            val waktuMinum : TextView = findViewById(R.id.tv_waktu_minum_rincian)
            val tablet : TextView = findViewById(R.id.tv_jumlah_tablet_rincian)
            val anjuran : TextView = findViewById(R.id.tv_jumlah_anjuran_rincian)

            date.text = jadwal.date.toString()
            month.text = jadwal.month
            year.text = jadwal.year.toString()
            waktu.text = jadwal.waktu
            waktuMinum.text = jadwal.waktu_minum
            tablet.text = "${jadwal.sisa_tablet} tablet tersisa"
            anjuran.text = "${jadwal.anjuran_tablet} tablet/dosis"
        }
    }
}