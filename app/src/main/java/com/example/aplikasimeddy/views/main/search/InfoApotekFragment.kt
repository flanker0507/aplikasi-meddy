package com.example.aplikasimeddy.views.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.FragmentInfoApotekBinding

class InfoApotekFragment : Fragment() {
    private lateinit var binding: FragmentInfoApotekBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoApotekBinding.inflate(inflater, container, false)

        val btnKonsultasi = binding.ivBtnKonseling
        btnKonsultasi.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = KonsultasiFragment()
            fragmentManager.beginTransaction().replace(
                R.id.frame_layout,
                destination)
                .addToBackStack(null)
                .commit()
        }

        val btnBack = binding.ivBtnBack
        btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        return binding.root

    }

}