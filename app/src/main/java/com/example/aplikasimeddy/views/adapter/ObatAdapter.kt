package com.example.aplikasimeddy.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.model_responses.ObatResponse
import com.example.aplikasimeddy.databinding.ItemHasilCariObatBinding

class ObatAdapter : RecyclerView.Adapter<ObatAdapter.ObatHasilCariViewHolder>(){

    private var myList = emptyList<ObatResponse>()
    var onItemClick : ((ObatResponse) -> Unit)? = null
    inner class ObatHasilCariViewHolder(val binding: ItemHasilCariObatBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatHasilCariViewHolder {
        return ObatHasilCariViewHolder(ItemHasilCariObatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ObatHasilCariViewHolder, position: Int) {
        holder.binding.apply {
            tvObatHasilCari.text = myList[position].name.toString()
            Glide.with(holder.itemView)
                .load(myList[position].gambar)
                .centerCrop()
                .placeholder(R.drawable.img_amox_yusimox)
                .into(holder.binding.ivObatHasilCari)
//            Log.d("TAG", "imageObat: ${myList[position].gambar}")
        }
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(myList[position])
        }
    }

    fun setData(newList: List<ObatResponse>){
        myList = newList
        notifyDataSetChanged()
    }

}
