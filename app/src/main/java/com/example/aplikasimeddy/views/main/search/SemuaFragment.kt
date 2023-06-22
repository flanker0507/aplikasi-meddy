package com.example.aplikasimeddy.views.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.FragmentSemuaHasilCariBinding
import com.example.aplikasimeddy.models.ApotekHasilCari
import com.example.aplikasimeddy.repositories.Repository
import com.example.aplikasimeddy.view_models.MainViewModelFactory
import com.example.aplikasimeddy.view_models.ObatViewModel
import com.example.aplikasimeddy.views.adapter.ApotekHasilCariAdapter
import com.example.aplikasimeddy.views.adapter.ObatAdapter

class SemuaFragment : Fragment() {


    private lateinit var binding: FragmentSemuaHasilCariBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var rvObat: RecyclerView
    private lateinit var rvApotek: RecyclerView
    private lateinit var vmObat: ObatViewModel
    private val obatAdapter by lazy { ObatAdapter() }
    private var apotekList = ArrayList<ApotekHasilCari>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSemuaHasilCariBinding.inflate(layoutInflater)

        //inisialisasi viewPager
//        viewPager = view.findViewById(R.id.vp_hasil_cari_container)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitializeObat()
        dataInitializeApotek()


        //lihat obat lainnya
        binding.tvLihatLainnya.setOnClickListener{
//            val lihatLainnya = viewPager.currentItem
//            val move = if (lihatLainnya == 0) 1 else 0
//            viewPager.setCurrentItem(move, true)
        }

        // lihat apotek lainnya
        binding.tvLihatLainnya2.setOnClickListener {
//            val lihatLainnya2 = viewPager.currentItem
//            val move = if (lihatLainnya2 == 0) 2 else 0
//            viewPager.setCurrentItem(move, true)
        }

//         hasil cari obat
        val layoutManager = GridLayoutManager(requireContext(), 2)
        rvObat = binding.rvHasilCariObat2
        rvObat.layoutManager = layoutManager
        rvObat.setHasFixedSize(true)
        rvObat.adapter = obatAdapter



        // hasil cari apotek
        val layoutManager2 = LinearLayoutManager(context)
        rvApotek = binding.rvHasilCariApotek2
        rvApotek.layoutManager = layoutManager2
        rvApotek.setHasFixedSize(true)
        val adapterApotek = ApotekHasilCariAdapter(apotekList) {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = InfoApotekFragment()
            fragmentManager.beginTransaction().replace(R.id.frame_layout, destination)
                .addToBackStack(null)
                .commit()
        }
        rvApotek.adapter = adapterApotek


    }

    private fun dataInitializeObat() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        vmObat = ViewModelProvider(this, viewModelFactory).get(ObatViewModel::class.java)
        vmObat.getObat()
        vmObat.obatResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let {obatAdapter.setData(it)}
            } else {
                Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun dataInitializeApotek(): ArrayList<ApotekHasilCari>{
        val namaApotek = resources.getStringArray(R.array.nama_apotek)
        val alamatApotek = resources.getStringArray(R.array.alamat_apotek)
        val imageApotek = resources.obtainTypedArray(R.array.img_apotek)
        for (i in namaApotek.indices){
            if ( i < 4){
                val apotekHasil = ApotekHasilCari(
                    namaApotek[i],
                    alamatApotek[i],
                    imageApotek.getResourceId(i, -1)
                )
                apotekList.add(apotekHasil)
            }
        }
        return apotekList
    }
}