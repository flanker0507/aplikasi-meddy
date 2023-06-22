package com.example.aplikasimeddy.views.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aplikasimeddy.R

class OnboardingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nextBtn: ImageView = view.findViewById(R.id.iv_btn_next)
        nextBtn.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = Onboarding2Fragment()
            fragmentManager.beginTransaction().replace(R.id.onboarding_container, destination)
                .commit()
        }


    }
}