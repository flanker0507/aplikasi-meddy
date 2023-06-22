package com.example.aplikasimeddy.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.model_responses.ObatResponse
import com.example.aplikasimeddy.databinding.ItemHasilCariObatBinding

class ObatAdapter : RecyclerView.Adapter<ObatAdapter.ObatHasilCariViewHolder>(){

    private var myList = emptyList<ObatResponse>()
    inner class ObatHasilCariViewHolder(val binding: ItemHasilCariObatBinding) : RecyclerView.ViewHolder(binding.root)

//    private val diffCallBack = object : DiffUtil.ItemCallback<ObatResponse>(){
//        override fun areItemsTheSame(oldItem: ObatResponse, newItem: ObatResponse): Boolean {
//            return oldItem.uuid == newItem.uuid
//        }
//
//        override fun areContentsTheSame(oldItem: ObatResponse, newItem: ObatResponse): Boolean {
//            return oldItem == newItem
//        }
//
//    }

//    private val differ = AsyncListDiffer(this, diffCallBack)
//    var obat: List<ObatResponse>
//    get() = differ.currentList
//    set(value) {differ.submitList(value)}

//        class ObatHasilCariViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//            val imgObat: ImageView = itemView.findViewById(R.id.iv_obat_hasil_cari)
//            val namaObat: TextView = itemView.findViewById(R.id.tv_obat_hasil_cari)
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatHasilCariViewHolder {
        return ObatHasilCariViewHolder(ItemHasilCariObatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hasil_cari_obat, parent, false)
//        return ObatHasilCariViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ObatHasilCariViewHolder, position: Int) {
        holder.binding.apply {
            tvObatHasilCari.text = myList[position].name.toString()
//            Picasso.get()
//                .load(myList[position].thumbnailUrl)
//                .into(ivObatHasilCari)
        }
//        val (imgObat, nmObat) = obatHasilCari[position]
//        holder.imgObat.setImageResource(imgObat)
//        holder.namaObat.text = nmObat
    }

    fun setData(newList: List<ObatResponse>){
        myList = newList
        notifyDataSetChanged()
    }
}

//(private val obatHasilCari: ArrayList<ObatHasilCari>)