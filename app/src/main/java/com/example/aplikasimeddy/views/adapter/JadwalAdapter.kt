package com.example.aplikasimeddy.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.databinding.ItemCardJadwalBinding
import com.example.aplikasimeddy.room.model.Jadwal

class JadwalAdapter: RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder>() {
    private var list = emptyList<Jadwal>()
    var onItemClick: ((Jadwal) -> Unit)? = null

    class JadwalViewHolder(val binding: ItemCardJadwalBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JadwalViewHolder {
        return JadwalViewHolder(ItemCardJadwalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: JadwalViewHolder, position: Int) {
        holder.binding.apply {
            tvDate.text = list[position].date.toString()
            tvMonth.text = list[position].month.toString()
            tvYear.text = list[position].year.toString()
            tvNamaObat.text = list[position].nama_obat.toString()
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])
        }
     }

    fun setData(list: List<Jadwal>){
        this.list = list
        notifyDataSetChanged()
    }

}