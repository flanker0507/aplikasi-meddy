package com.example.aplikasimeddy.views.main.schedule

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.view_models.JadwalUserViewModel
import com.example.aplikasimeddy.views.adapter.JadwalAdapter

class JadwalFragment : Fragment() {
    private lateinit var rvJadwal: RecyclerView
    private lateinit var mJadwalUserViewModel: JadwalUserViewModel
    private val adapter by lazy { JadwalAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler view
        rvJadwal = view.findViewById(R.id.rv_save_jadwal)
        rvJadwal.layoutManager = LinearLayoutManager(requireContext())
        rvJadwal.adapter = adapter

        //view model
        mJadwalUserViewModel = ViewModelProvider(this).get(JadwalUserViewModel::class.java)
        mJadwalUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { jadwal ->
            adapter.setData(jadwal)
        })

        val moveButton: ImageView = view.findViewById(R.id.iv_btn_atur_sekarang)
        moveButton.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val destination = InputJadwalFragment()

            fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, destination)
                .addToBackStack(null)
                .commit()
        }

        adapter.onItemClick = {
            val intent = Intent(requireContext(), RincianJadwalActivity::class.java)
            intent.putExtra("jadwal", it)
            startActivity(intent)
        }
    }
}