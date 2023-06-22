package com.example.aplikasimeddy.views.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.views.adapter.CariApotekTerdekatAdapter
import com.example.aplikasimeddy.models.ApotekTerdekatCari

class CariFragment : Fragment() {

    private lateinit var adapter: CariApotekTerdekatAdapter
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<ApotekTerdekatCari>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cari, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        getData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_card_cari_apotek_terdekat)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CariApotekTerdekatAdapter(list){
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = InfoApotekFragment()
            fragmentManager.beginTransaction().replace(R.id.frame_layout, destination)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter

        //move to lihat semua apotek
        val btnLihatApotek: ImageView = view.findViewById(R.id.iv_btn_lihat_apotek)
        btnLihatApotek.setOnClickListener{
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = HasilCariContainerFragment()
            fragmentManager.beginTransaction().replace(R.id.frame_layout, destination)
                .commit()
        }
    }
    private fun getData(): ArrayList<ApotekTerdekatCari>{
        val namaApotek = resources.getStringArray(R.array.nama_apotek)
        val alamatApotek = resources.getStringArray(R.array.alamat_apotek)
        for (i in namaApotek.indices) {
            val listApotek = ApotekTerdekatCari(
                namaApotek[i],
                alamatApotek[i]
            )
            list.add(listApotek)
        }
        return list
    }
}