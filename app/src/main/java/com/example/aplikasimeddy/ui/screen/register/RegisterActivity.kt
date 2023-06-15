package com.example.aplikasimeddy.ui.screen.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.DisplayPhoto
import android.text.Editable
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.data.room.database.User
import com.example.aplikasimeddy.data.viewmodel.UserViewModel
import com.example.aplikasimeddy.databinding.ActivityRegisterBinding
import com.example.aplikasimeddy.ui.screen.login.LoginActivity
import java.net.UnknownServiceException

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var mUserViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnRegister.setOnClickListener {
            insertDataToDatabase()
        }

    }

    private fun insertDataToDatabase() {
        val firstName = binding.etRegisterFirstName.text.toString()
        val email = binding.etRegisterEmail.text.toString()
        val phone = binding.etRegisterNomorHandphone.text.toString()
        val password = binding.etRegisterPassword.text.toString()
        val location = binding.etRegisterSelectRegion.text.toString()
        val checkBox = binding.cbRegister

        fun isChecked(): Boolean{
            val check = checkBox.isChecked
            if (!check){
                Toast.makeText(this, "Belum Menyetujui Syarat dan Ketentuan",Toast.LENGTH_SHORT).show()
            }
            return check
        }

        if (inputCheck(firstName, email, phone, password, location) && isChecked()){
            //Create User Object
            val user = User(0, firstName, email, phone, password, location)
            //Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(this, "Berhasil Daftar!", Toast.LENGTH_SHORT).show()
            //move activity
            moveToLoginActivity()
        } else {
            Toast.makeText(this, "Mohon lengkapi data anda.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun inputCheck(
        firstName: String,
        email: String,
        phone: String,
        password: String,
        location: String
    ): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(email)
                && (TextUtils.isEmpty(phone)) && TextUtils.isEmpty(password) && TextUtils.isEmpty(location))
    }

    private fun moveToLoginActivity() {
        val move = Intent(this, LoginActivity::class.java)
        startActivity(move)
    }
}