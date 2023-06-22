package com.example.aplikasimeddy.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.models.ApotekTerdekatCari
import com.example.aplikasimeddy.R

class CariApotekTerdekatAdapter (private val list: ArrayList<ApotekTerdekatCari>, private val move: () -> Unit):
    RecyclerView.Adapter<CariApotekTerdekatAdapter.CariApotekTerdekatViewHolder>(){

        class CariApotekTerdekatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val namaApotek: TextView = itemView.findViewById(R.id.tv_item_nama_apotek)
            val alamatApotek: TextView = itemView.findViewById(R.id.tv_item_alamat_apotek)
            val ivBtnBuka: ImageView = itemView.findViewById(R.id.iv_btn_buka_2)
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CariApotekTerdekatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_card_cari_apotek_terdekat,
            parent, false)
        return CariApotekTerdekatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CariApotekTerdekatViewHolder, position: Int) {
        val (namaApotek, alamatApotek) = list[position]
        holder.namaApotek.text = namaApotek
        holder.alamatApotek.text = alamatApotek
        holder.ivBtnBuka.setOnClickListener{
            move()
        }
    }


}