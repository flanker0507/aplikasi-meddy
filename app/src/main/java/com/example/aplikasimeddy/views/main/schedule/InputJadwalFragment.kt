package com.example.aplikasimeddy.views.main.schedule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.FragmentInputJadwalBinding

class InputJadwalFragment : Fragment() {
    private lateinit var binding: FragmentInputJadwalBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputJadwalBinding.inflate(inflater, container, false)
//        val view = inflater.inflate(R.layout.fragment_input_jadwal, container, false)
        val btnBack: ImageView = binding.ivBtnBackWhite
        btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        SelectedCard()

        val fragmentManager = requireActivity().supportFragmentManager
        val destination = RincianFragment()

        val simpan: ImageView = binding.ivBtnSimpan
        simpan.setOnClickListener {
            fragmentManager.beginTransaction().replace(
                R.id.frame_layout,
                destination
            )
                .addToBackStack(null)
                .commit()
        }
    }

    private fun primary(): Int {
        return ContextCompat.getColor(requireContext(), R.color.primary)
    }

    private fun white(): Int {
        return ContextCompat.getColor(requireContext(), R.color.white)
    }

    private fun SelectedCard() {
        val cardPagi = binding.cvPagi
        val cardSiang = binding.cvSiang
        val cardSore = binding.cvSore

        cardOnClick(cardPagi)
        cardOnClick(cardSiang)
        cardOnClick(cardSore)
    }

    private fun cardOnClick(cardView: CardView) {
        var isCardSelected = false
        cardView.setOnClickListener {
            if (isCardSelected){
                cardView.setCardBackgroundColor(white())
            } else {
                cardView.setCardBackgroundColor(primary())
            }
            isCardSelected = !isCardSelected
        }
    }
//    private fun CardPagi(){
//        var isCardSelected = false
//        val cardOnClick: CardView = view.findViewById(R.id.cv_pagi)
//        cardOnClick.setOnClickListener{
//            if (isCardSelected){
//                cardOnClick.setCardBackgroundColor(white())
//            } else {
//                cardOnClick.setCardBackgroundColor(primary())
//            }
//            isCardSelected = !isCardSelected
//        }
//    }


}