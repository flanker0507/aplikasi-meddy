package com.example.aplikasimeddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.ui.adapter.CariApotekTerdekatAdapter
import com.example.aplikasimeddy.data.model.ApotekTerdekatCari


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CariFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CariFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: CariApotekTerdekatAdapter
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<ApotekTerdekatCari>()


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
        return inflater.inflate(R.layout.fragment_cari, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CariFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CariFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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