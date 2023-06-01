package com.example.aplikasimeddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class OnBoardIndicatorAdapter(private val pageSize: Int, private val movePageHandler: (Int) -> Unit) : RecyclerView.Adapter<OnBoardIndicatorAdapter.OnBoardIndicatorViewHolder>(){
    class OnBoardIndicatorViewHolder(private val view: View, private val movePageHandler: (Int) -> Unit) : RecyclerView.ViewHolder(view){
        fun movePage(position: Int){
            view.setOnClickListener{
                movePageHandler(position)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardIndicatorViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(
            R.layout.item_indicator,
            parent,
            false
        )
        return OnBoardIndicatorViewHolder(inflater, movePageHandler)
    }

    override fun onBindViewHolder(
        holder: OnBoardIndicatorViewHolder,
        position: Int
    ) {
        holder.movePage(position)
    }

    override fun getItemCount(): Int = pageSize
}