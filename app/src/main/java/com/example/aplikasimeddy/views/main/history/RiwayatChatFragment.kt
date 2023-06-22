package com.example.aplikasimeddy.views.main.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aplikasimeddy.R

class RiwayatChatFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newChat: ImageView = view.findViewById(R.id.iv_btn_new_chat)
        newChat.setOnClickListener {
//            val context = requireContext()
//            val intent = Intent(context, CaraPilihApotekerActivity::class.java)
//            startActivity(intent)
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = RiwayatFragment()
            fragmentManager.beginTransaction().replace(
                R.id.frame_layout,
            destination).commit()
        }
    }
}