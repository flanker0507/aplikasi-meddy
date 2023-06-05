package com.example.aplikasimeddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApotekTerdekatAdapter (private val apotekTerdekat: ArrayList<ApotekTerdekat>) :
    RecyclerView.Adapter<ApotekTerdekatAdapter.ApotekTerdekatViewHolder>(){
    class ApotekTerdekatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNamaApotek: TextView = itemView.findViewById(R.id.tv_nama_apotek)
        val tvAlamatApotek: TextView = itemView.findViewById(R.id.tv_alamat_apotek)
        val ivApotek: ImageView = itemView.findViewById(R.id.iv_apotek_terdekat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApotekTerdekatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_apotek_terdekat, parent, false)
        return ApotekTerdekatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return apotekTerdekat.size
    }

    override fun onBindViewHolder(holder: ApotekTerdekatViewHolder, position: Int) {
        val (namaApotek, alamatApotek, imgApotek) = apotekTerdekat[position]
        holder.tvNamaApotek.text = namaApotek
        holder.tvAlamatApotek.text = alamatApotek
        holder.ivApotek.setImageResource(imgApotek)
    }


}