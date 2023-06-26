package com.example.aplikasimeddy.views.main.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.databinding.FragmentObatHasilCariBinding
import com.example.aplikasimeddy.models.ObatHasilCari
import com.example.aplikasimeddy.repositories.Repository
import com.example.aplikasimeddy.view_models.MainViewModelFactory
import com.example.aplikasimeddy.view_models.ObatViewModel
import com.example.aplikasimeddy.views.adapter.ObatAdapter

class ObatFragment : Fragment() {

    private lateinit var binding: FragmentObatHasilCariBinding
    private lateinit var rvObat: RecyclerView
    private val obatAdapter by lazy { ObatAdapter() }
    private lateinit var viewModel: ObatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentObatHasilCariBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ObatViewModel::class.java)
        viewModel.getObat()
        viewModel.obatResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { obatAdapter.setData(it) }
            } else {
                Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })

        //searchview



        obatAdapter.onItemClick = {
            val intent = Intent(requireContext(), DetailObatActivity::class.java)
            intent.putExtra("obat", it)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        rvObat = binding.rvHasilCariObat
        rvObat.setHasFixedSize(true)
        rvObat.adapter = obatAdapter
        rvObat.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}