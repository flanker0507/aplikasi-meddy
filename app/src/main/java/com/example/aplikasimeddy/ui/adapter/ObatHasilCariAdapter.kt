package com.example.aplikasimeddy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.data.model.ObatHasilCari
import com.example.aplikasimeddy.R

class ObatHasilCariAdapter (private val obatHasilCari: ArrayList<ObatHasilCari>):
    RecyclerView.Adapter<ObatHasilCariAdapter.ObatHasilCariViewHolder>(){

        class ObatHasilCariViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val imgObat: ImageView = itemView.findViewById(R.id.iv_obat_hasil_cari)
            val namaObat: TextView = itemView.findViewById(R.id.tv_obat_hasil_cari)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatHasilCariViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hasil_cari_obat, parent, false)
        return ObatHasilCariViewHolder(view)
    }

    override fun getItemCount(): Int {
        return obatHasilCari.size
    }

    override fun onBindViewHolder(holder: ObatHasilCariViewHolder, position: Int) {
        val (imgObat, nmObat) = obatHasilCari[position]
        holder.imgObat.setImageResource(imgObat)
        holder.namaObat.text = nmObat
    }
}