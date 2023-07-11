package com.example.aplikasimeddy.views.main.schedule

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.databinding.FragmentInputJadwalBinding
import com.example.aplikasimeddy.room.model.Jadwal
import com.example.aplikasimeddy.view_models.JadwalUserViewModel
import java.util.*

class InputJadwalFragment : Fragment() {

    //TODO card Pagi, Siang, Sore OnClick bug

    private lateinit var binding: FragmentInputJadwalBinding
    private lateinit var jadwalViewModel: JadwalUserViewModel
    private var waktuMakan:String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputJadwalBinding.inflate(inflater, container, false)
//        val view = inflater.inflate(R.layout.fragment_input_jadwal, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jadwalViewModel = ViewModelProvider(this).get(JadwalUserViewModel::class.java)

        // back to previous page
        val btnBack: ImageView = binding.ivBtnBackWhite
        btnBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        //implementation function
        selectedCard()
        showTimePicker()
        jmlObat()
        anjuranObat()
        radioButtonOnClick()

        // button Simpan onClick, save date and move to next page
        val fragmentManager = requireActivity().supportFragmentManager
        val destination = JadwalFragment()
//        val text = view.findViewById<TextView>(R.id.tv_belum_ada_jadwal)

        val simpan: ImageView = binding.ivBtnSimpan
        simpan.setOnClickListener {
            // insert jadwal to database
            insertDataToDatabase()
//            text.visibility = View.GONE
            fragmentManager.beginTransaction().replace(
                R.id.frame_layout,
                destination
            )
                .addToBackStack(null)
                .commit()
        }
    }

    private fun radioButtonOnClick(){
        //radio button
        val radioButtonBefore = binding.rdSblm
        val radioButtonAfter = binding.rdSsdh
        val radioButtonWhen = binding.rdKtk

        binding.radioButtonContainer.setOnCheckedChangeListener { radioGroup, id ->
            waktuMakan = when (requireView().findViewById<RadioButton>(id)) {
                radioButtonBefore -> "Sebelum makan"
                radioButtonAfter -> "Sesudah makan"
                radioButtonWhen -> "Ketika makan"
                else -> "Null"
//                    Log.d("TAG", "tidak ada! ")
            }
            Log.d("waktuMakan", waktuMakan)

        }
    }
    private fun getDataRadioButton(data: String): String{
        return data
    }

    private fun primary(): Int {
        return ContextCompat.getColor(requireContext(), R.color.primary)
    }

    private fun white(): Int {
        return ContextCompat.getColor(requireContext(), R.color.white)
    }

    private fun selectedCard() {
        val cardPagi = binding.cvPagi
        val cardSiang = binding.cvSiang
        val cardSore = binding.cvSore

        cardOnClick(cardPagi)
        cardOnClick(cardSiang)
        cardOnClick(cardSore)
    }

    private fun cardOnClick(cardView: CardView) {
        var isCardSelected = false
        val cardExtend = binding.cvTimePicker

        cardExtend.visibility = View.GONE

        cardView.setOnClickListener {
            if (isCardSelected) {
                cardView.setCardBackgroundColor(white())
                cardExtend.visibility = View.GONE

            } else {
                cardView.setCardBackgroundColor(primary())
                cardExtend.visibility = View.VISIBLE
            }
            isCardSelected = !isCardSelected
        }
    }

    //TODO this is Card who still bug
    private fun cardClick() {
        val cardPagi = binding.cvPagi
        val cardSiang = binding.cvSiang
        val cardSore = binding.cvSore
        val cardExtend = binding.cvTimePicker

        cardExtend.visibility = View.GONE

        if (cardPagi.isSelected) {
            cardPagi.setCardBackgroundColor(primary())
            cardExtend.visibility = View.VISIBLE
        } else {
            cardPagi.setCardBackgroundColor(white())
            cardExtend.visibility = View.GONE
        }

        val clickListener = requireView().setOnClickListener { view ->
            cardPagi.isSelected = false
            cardSiang.isSelected = false
            cardSore.isSelected = false

            view.isSelected = true

            when (view.id) {
                R.id.cv_pagi -> {
                    Log.d("TAG", "cardClick : Card View Pagi")
                }
                R.id.cv_siang -> {
                    Log.d("TAG", "cardCLick : Card View Siang ")

                }
                R.id.cv_sore -> {
                    Log.d("TAG", "cardClick : Card View Sore")
                }
            }
        }
        cardPagi.setOnClickListener { clickListener }
        cardSiang.setOnClickListener { clickListener }
        cardSore.setOnClickListener { clickListener }
    }

    private fun jmlObat() {
        val plus = binding.ivBtnPlus
        val minus = binding.ivBtnMinus
        val jmlObat = binding.jmlSatuanObat

        var number = 0
        plus.setOnClickListener {
            number++
            jmlObat.text = number.toString()
        }
        minus.setOnClickListener {
            number--
            if (number <= 0) {
                number = 0
            }
            jmlObat.text = number.toString()
        }
    }

    private fun anjuranObat() {
        val plus = binding.ivBtnPlus2
        val minus = binding.ivBtnMinus2
        val anjuran = binding.jmlAnjuran

        var number = 0
        plus.setOnClickListener {
            number++
            anjuran.text = number.toString()
        }
        minus.setOnClickListener {
            number--
            if (number <= 0) {
                number = 0
            }
            anjuran.text = number.toString()
        }
    }

    private fun showTimePicker() {
        val tvMinute = binding.tvMinute
        val tvHour = binding.tvHour
        val onClikTimePicker = binding.clBgTimePicker
        onClikTimePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _: TimePicker?, _hour: Int, _minute: Int ->
                    tvHour.setText("$_hour")
                    tvMinute.setText("$_minute")
                },
                hour,
                minute,
                true
            )
            timePickerDialog.show()
        }
    }

    private fun datePicker() {
        val datePicker = binding.dpInputJadwal

        val date = datePicker.dayOfMonth
        val month = datePicker.month + 1
        val year = datePicker.year

        Log.d("TAG", "datePicker: day = $date")
        Log.d("TAG", "datePicker: month = $month")
        Log.d("TAG", "datePicker: year = $year")
    }

    private fun insertDataToDatabase() {
        val datePicker = binding.dpInputJadwal
        val getHour = binding.tvHour.text.toString()
        val getMinute = binding.tvMinute.text.toString()

        val date = datePicker.dayOfMonth
        val month = datePicker.month + 1
        val year = datePicker.year
        val namaObat = "Amoxicillin"
        val gambar = "amoxicillin.png"
        val waktu = "$getHour:$getMinute"
        val waktuMinum = waktuMakan
        val sisaTablet = binding.jmlSatuanObat.text.toString()
        val anjuranTablet = binding.jmlAnjuran.text.toString()

        // parse number of month to string
        val _month: String = when (month){
            1 -> "Januari"
            2 -> "Februari"
            3 -> "Maret"
            4 -> "April"
            5 -> "Mei"
            6 -> "Juni"
            7 -> "Juli"
            8 -> "Agustus"
            9 -> "September"
            10 -> "Oktober"
            11 -> "November"
            else -> "Desember"
        }

        if (inputCheck(
                date,
                _month,
                year,
                namaObat,
                gambar,
                waktu,
                waktuMinum,
                sisaTablet,
                anjuranTablet
            )
        ) {
            // create jadwal Object
            val jadwal = Jadwal(
                1,
                date,
                _month,
                year,
                namaObat,
                gambar,
                waktu,
                waktuMinum,
                Integer.parseInt(sisaTablet),
                Integer.parseInt(anjuranTablet)
            )

            //add Data to Database
                jadwalViewModel.addJadwalUser(jadwal)
            Toast.makeText(requireContext(), "Jadwal berhasil disimpan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        date: Int,
        _month: String,
        year: Int,
        nama_obat: String,
        gambar: String,
        waktu: String,
        waktu_minum: String,
        sisa_tablet: String ,
        anjuran_tablet: String
    ): Boolean {
        return !(TextUtils.isEmpty(date.toString()) && TextUtils.isEmpty(_month)
                && TextUtils.isEmpty(year.toString()) && TextUtils.isEmpty(nama_obat)
                && TextUtils.isEmpty(gambar) && TextUtils.isEmpty(waktu)
                && TextUtils.isEmpty(waktu_minum) && TextUtils.isEmpty(sisa_tablet)
                && TextUtils.isEmpty(anjuran_tablet))
    }
}