package com.example.aplikasimeddy.views.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.aplikasimeddy.databinding.FragmentHasilCariContainerBinding
import com.example.aplikasimeddy.views.adapter.ViewPagerHasilCariAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HasilCariContainerFragment: Fragment() {

    private lateinit var binding: FragmentHasilCariContainerBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHasilCariContainerBinding.inflate(layoutInflater)

        tabLayout = binding.tlFilterCariContainer
        viewPager = binding.vpHasilCariContainer

        setupTabLayoutViewPager()

        return binding.root
    }


    private fun setupTabLayoutViewPager(){
        val adapter = ViewPagerHasilCariAdapter(requireActivity())
        adapter.addFragment(SemuaFragment(), "Semua")
        adapter.addFragment(ObatFragment(), "Obat")
        adapter.addFragment(ApotekHasilCariFragment(), "Apotek")
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }
}