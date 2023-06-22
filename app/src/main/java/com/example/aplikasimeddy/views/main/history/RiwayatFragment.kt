package com.example.aplikasimeddy.views.main.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.FragmentHasilCariContainerBinding
import com.example.aplikasimeddy.databinding.FragmentRiwayatBinding
import com.example.aplikasimeddy.views.main.search.HasilCariContainerFragment

class RiwayatFragment : Fragment() {
    private lateinit var binding: FragmentRiwayatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moveBtn = binding.ivBtnPilihApotek
        moveBtn.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = HasilCariContainerFragment()
            fragmentManager.beginTransaction().replace(
                R.id.frame_layout,
                destination
            ).commit()
        }
    }
}