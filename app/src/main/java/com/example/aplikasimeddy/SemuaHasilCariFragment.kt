package com.example.aplikasimeddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.aplikasimeddy.ui.adapter.ApotekHasilCariAdapter
import com.example.aplikasimeddy.ui.adapter.ObatHasilCariAdapter
import com.example.aplikasimeddy.databinding.FragmentSemuaHasilCariBinding
import com.example.aplikasimeddy.data.model.ApotekHasilCari
import com.example.aplikasimeddy.data.model.ObatHasilCari

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SemuaHasilCariFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SemuaHasilCariFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentSemuaHasilCariBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var rvObat: RecyclerView
    private lateinit var rvApotek: RecyclerView
    private var obatList = ArrayList<ObatHasilCari>()
    private var apotekList = ArrayList<ApotekHasilCari>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SemuaHasilCariFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SemuaHasilCariFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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

        // hasil cari obat
        val layoutManager = GridLayoutManager(context, 2)
        rvObat = binding.rvHasilCariObat2
        rvObat.layoutManager = layoutManager
        rvObat.setHasFixedSize(true)
        val adapter = ObatHasilCariAdapter (obatList)
        rvObat.adapter = adapter



        // hasil cari apotek
        val layoutManager2 = LinearLayoutManager(context)
        rvApotek = binding.rvHasilCariApotek2
        rvApotek.layoutManager = layoutManager2
        rvApotek.setHasFixedSize(true)
        val adapterApotek = ApotekHasilCariAdapter(apotekList){
            val fragmentManager =requireActivity().supportFragmentManager
            val destination = InfoApotekFragment()
            fragmentManager.beginTransaction().replace(R.id.frame_layout, destination)
                .addToBackStack(null)
                .commit()
        }
        rvApotek.adapter = adapterApotek


    }

    private fun dataInitializeObat(): ArrayList<ObatHasilCari> {
        val imageObat = resources.obtainTypedArray(R.array.image_obat)
        val namaObat = resources.getStringArray(R.array.nama_obat)
        for (i in namaObat.indices) {
            if (i < 4 ) {
                val obatHasilCari = ObatHasilCari(
                    imageObat.getResourceId(i, -1),
                    namaObat[i]
                )
                obatList.add(obatHasilCari)
            }
        }
        return obatList
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