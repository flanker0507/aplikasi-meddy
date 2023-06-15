package com.example.aplikasimeddy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.data.model.ApotekHasilCari
import com.example.aplikasimeddy.R

class ApotekHasilCariAdapter (private val apotekHasilCari: ArrayList<ApotekHasilCari>, private val move: ()-> Unit):
    RecyclerView.Adapter<ApotekHasilCariAdapter.ApotekHasilCariViewHolder>(){

        class ApotekHasilCariViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val namaApotek: TextView = itemView.findViewById(R.id.tv_nama_apotek_hasil_cari)
            val alamatApotek: TextView = itemView.findViewById(R.id.tv_alamat_apotek_hasil_cari)
            val imgApotek: ImageView = itemView.findViewById(R.id.iv_apotek_terdekat_hasil_cari)
            val move: ImageView = itemView.findViewById(R.id.iv_btn_buka_hasil_cari)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApotekHasilCariViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hasil_cari_apotek, parent, false)
        return ApotekHasilCariViewHolder(view)
    }

    override fun getItemCount(): Int {
        return apotekHasilCari.size
    }

    override fun onBindViewHolder(holder: ApotekHasilCariViewHolder, position: Int) {
        val (nmApotek, almApotek, imApotek) = apotekHasilCari[position]
        holder.namaApotek.text = nmApotek
        holder.alamatApotek.text = almApotek
        holder.imgApotek.setImageResource(imApotek)
        holder.move.setOnClickListener{
            move()
        }
    }

}