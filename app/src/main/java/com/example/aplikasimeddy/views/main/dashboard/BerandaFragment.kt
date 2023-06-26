package com.example.aplikasimeddy.views.main.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.views.main.search.InfoApotekFragment
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.FragmentBerandaBinding
import com.example.aplikasimeddy.models.ApotekTerdekat
import com.example.aplikasimeddy.repositories.Repository
import com.example.aplikasimeddy.view_models.ArtikelViewModel
import com.example.aplikasimeddy.view_models.MainViewModelFactory
import com.example.aplikasimeddy.views.adapter.ArtikelAdapter
import com.example.aplikasimeddy.views.main.profile.ProfilFragment
import de.hdodenhof.circleimageview.CircleImageView

class BerandaFragment : Fragment() {

    private lateinit var binding: FragmentBerandaBinding
    private lateinit var recyclerView: RecyclerView
    private val artikelAdapter by lazy { ArtikelAdapter() }
    private lateinit var viewModel: ArtikelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBerandaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        //move to profile
        val moveProfile: CircleImageView = binding.civFotoProfil
        moveProfile.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = ProfilFragment()
            fragmentManager.beginTransaction().replace(
                R.id.main_container, destination)
                .addToBackStack(null)
                .commit()
        }

        //search view
        val searchView: SearchView = binding.searchViewBeranda
        searchView.queryHint = "Cari nama obat, apotek"

        //artikel
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ArtikelViewModel::class.java)
        viewModel.getArtikel()
        viewModel.artikelResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful){
                response.body()?.let { artikelAdapter.setData(it) }
            } else {
                Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerView(){
        recyclerView = binding.rvArtikel
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = artikelAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

}