package com.example.aplikasimeddy.views.intro

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.views.login.LoginActivity

class Onboarding4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn: ImageView = view.findViewById(R.id.iv_btn_next4)
        nextBtn.setOnClickListener{
            val context = requireContext()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}