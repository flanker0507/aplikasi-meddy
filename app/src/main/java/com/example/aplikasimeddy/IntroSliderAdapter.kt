package com.example.aplikasimeddy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IntroSliderAdapter(private val introSlides: List<IntroSlide>):
    RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_onboarding_container,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        val (imgOnboard, descOnboard) = introSlides[position]
        holder.imageOnboard.setImageResource(imgOnboard)
        holder.textOnboard.text = descOnboard
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageOnboard = view.findViewById<ImageView>(R.id.onboard_image)
        val textOnboard = view.findViewById<TextView>(R.id.onboard_desc)

//        fun bind(introSlide: IntroSlide) {
//            imageOnboard.setImageResource(IntroSlide.imgOnboard)
//            textOnboard.text = IntroSlide.descOnboard
//        }
    }
}