package com.example.aplikasimeddy.views.main.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.views.main.search.InfoApotekFragment
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.models.ApotekTerdekat
import com.example.aplikasimeddy.views.adapter.ApotekTerdekatAdapter
import com.example.aplikasimeddy.views.main.profile.ProfilFragment
import de.hdodenhof.circleimageview.CircleImageView

class BerandaFragment : Fragment() {
    private lateinit var adapter: ApotekTerdekatAdapter
    private lateinit var recyclerView: RecyclerView
    private var apotekArrayList = ArrayList<ApotekTerdekat>()

//    lateinit var namaApotek : Array<String>
//    lateinit var alamatApotek : Array<String>
//    lateinit var imgApotek : Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()

        val moveProfile: CircleImageView = view.findViewById(R.id.civ_foto_profil)
        moveProfile.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = ProfilFragment()
            fragmentManager.beginTransaction().replace(
                R.id.main_container, destination)
                .addToBackStack(null)
                .commit()
        }

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_card_apotek_terdekat)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ApotekTerdekatAdapter(apotekArrayList) {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = InfoApotekFragment()
            fragmentManager.beginTransaction().replace(
                R.id.frame_layout, destination
            )
                .addToBackStack(null)
                .commit()
        }
        recyclerView.adapter = adapter

    }

    private fun dataInitialize(): ArrayList<ApotekTerdekat> {
        val namaApotek = resources.getStringArray(R.array.nama_apotek)
        val alamatApotek = resources.getStringArray(R.array.alamat_apotek)
        val imgApotek = resources.obtainTypedArray(R.array.img_apotek)
        for (i in namaApotek.indices){
            val apotekTerdekat = ApotekTerdekat(
                namaApotek[i],
                alamatApotek[i],
                imgApotek.getResourceId(i, -1)
            )
            apotekArrayList.add(apotekTerdekat)
        }
        return apotekArrayList
    }
}