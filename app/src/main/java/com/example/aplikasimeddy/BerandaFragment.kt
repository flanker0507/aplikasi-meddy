package com.example.aplikasimeddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BerandaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BerandaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: ApotekTerdekatAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var apotekArrayList: ArrayList<ApotekTerdekat>

    lateinit var namaApotek : Array<String>
    lateinit var alamatApotek : Array<String>
    lateinit var imgApotek : Array<Int>
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
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BerandaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BerandaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_card_apotek_terdekat)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ApotekTerdekatAdapter(apotekArrayList)
        recyclerView.adapter = adapter

    }

    private fun dataInitialize(){
        apotekArrayList = arrayListOf<ApotekTerdekat>()

        namaApotek = arrayOf(
            getString(R.string.agatha_farma),
            getString(R.string.kimia_farma_455),
            getString(R.string.kimia_farma_bintan),
            getString(R.string.mitra_husada)
        )

        alamatApotek = arrayOf(
            getString(R.string.alamat_agatha_farma),
            getString(R.string.alamat_kimia_farma_455),
            getString(R.string.kimia_farma_bintan),
            getString(R.string.alamat_mitra_husada)
        )

        imgApotek = arrayOf(
            R.drawable.apotek_agatha_farma,
            R.drawable.apotek_kimia_farma_455,
            R.drawable.apotek_kimia_farma_bintan,
            R.drawable.apotek_kimia_farma_bintan,
        )

        for (i in namaApotek.indices){
            val apotekTerdekat = ApotekTerdekat(namaApotek[i],alamatApotek[i],imgApotek[i])
            apotekArrayList.add(apotekTerdekat)
        }
    }
}