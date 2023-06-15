package com.example.aplikasimeddy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.ui.adapter.ObatHasilCariAdapter
import com.example.aplikasimeddy.databinding.FragmentObatHasilCariBinding
import com.example.aplikasimeddy.data.model.ObatHasilCari

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ObatHasilCariFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ObatHasilCariFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentObatHasilCariBinding
    private lateinit var rvObat: RecyclerView
    private lateinit var adapter: ObatHasilCariAdapter
    private var obatArrayList = ArrayList<ObatHasilCari>()

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
        binding = FragmentObatHasilCariBinding.inflate(layoutInflater)

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ObatHasilCariFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ObatHasilCariFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()

        val layoutManager = GridLayoutManager(context, 2)

        rvObat = binding.rvHasilCariObat
        rvObat.layoutManager = layoutManager
        rvObat.setHasFixedSize(true)
        adapter = ObatHasilCariAdapter(obatArrayList)
        rvObat.adapter = adapter
    }

    private fun dataInitialize(): ArrayList<ObatHasilCari>{
        val imageObat = resources.obtainTypedArray(R.array.image_obat)
        val namaObat = resources.getStringArray(R.array.nama_obat)
        for (i in namaObat.indices){
            val obatHasilCari = ObatHasilCari(
                imageObat.getResourceId(
                    i, -1),
                namaObat[i]
            )
            obatArrayList.add(obatHasilCari)
        }
        return obatArrayList
    }
}