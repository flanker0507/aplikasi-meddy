package com.example.aplikasimeddy.views.main.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.aplikasimeddy.R

class JadwalFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moveButton: ImageView = view.findViewById(R.id.iv_btn_atur_sekarang)
        moveButton.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = InputJadwalFragment()

            fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, destination)
                .addToBackStack(null)
                .commit()
        }
    }
}