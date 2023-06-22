package com.example.aplikasimeddy.views.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.views.adapter.ApotekHasilCariAdapter
import com.example.aplikasimeddy.databinding.FragmentApotekHasilCariBinding
import com.example.aplikasimeddy.models.ApotekHasilCari

class ApotekHasilCariFragment : Fragment() {
    private lateinit var binding: FragmentApotekHasilCariBinding
    private lateinit var rvApotek: RecyclerView
    private lateinit var adapter: ApotekHasilCariAdapter
    private var apotekArrayList = ArrayList<ApotekHasilCari>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentApotekHasilCariBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)

        rvApotek = binding.rvHasilCariApotek
        rvApotek.layoutManager = layoutManager
        rvApotek.setHasFixedSize(true)
        adapter = ApotekHasilCariAdapter(apotekArrayList){
            //move to detail apotek
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = InfoApotekFragment()
            fragmentManager.beginTransaction().replace(R.id.frame_layout, destination)
                .addToBackStack(null)
                .commit()
        }
        rvApotek.adapter = adapter
    }
    private fun dataInitialize(): ArrayList<ApotekHasilCari>{
        val namaApotek = resources.getStringArray(R.array.nama_apotek)
        val alamatApotek = resources.getStringArray(R.array.alamat_apotek)
        val imgApotek = resources.obtainTypedArray(R.array.img_apotek)
        for (i in namaApotek.indices){
            val apotekHasilCari = ApotekHasilCari(
                namaApotek[i],
                alamatApotek[i],
                imgApotek.getResourceId(i, -1)
            )
            apotekArrayList.add(apotekHasilCari)
        }
        return apotekArrayList
    }
}