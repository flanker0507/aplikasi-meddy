package com.example.aplikasimeddy.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.ItemListArtikelBinding
import com.example.aplikasimeddy.model_responses.ArtikelResponse

class ArtikelAdapter : RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>(){

    private var list = emptyList<ArtikelResponse>()
    var onItemClick: ((ArtikelResponse) -> Unit)? = null
    inner class ArtikelViewHolder(val binding: ItemListArtikelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        return ArtikelViewHolder(ItemListArtikelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        holder.binding.apply {
            tvJudul.text = list[position].judul.toString()
            Glide.with(holder.itemView)
                .load(list[position].gambar.toString())
                .centerCrop()
                .placeholder(R.drawable.ibuprofen)
                .into(holder.binding.ivArtikel)
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])
        }
    }

    fun setData(newList: List<ArtikelResponse>){
        list = newList
        notifyDataSetChanged()
    }


}