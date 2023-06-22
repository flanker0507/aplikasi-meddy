package com.example.aplikasimeddy.views.register

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasimeddy.R
import com.example.aplikasimeddy.view_models.RegisterViewModel
import com.example.aplikasimeddy.databinding.ActivityRegisterBinding
import com.example.aplikasimeddy.views.login.LoginActivity

class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener,
    View.OnKeyListener {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var mUserViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tietRegisterName.onFocusChangeListener = this
        binding.tietRegisterEmail.onFocusChangeListener = this
        binding.tietRegisterPassword.onFocusChangeListener = this
        binding.tietConfirmPassword.onFocusChangeListener = this

        mUserViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.btnRegister.setOnClickListener {
//            insertDataToDatabase()
        }
    }

    private fun validateName(): Boolean{
        var errorMessage: String? = null
        val value = binding.tietRegisterName.text.toString()
        if (value.isEmpty()){
            errorMessage = "Isi nama anda"
        }
        if (errorMessage != null){
            binding.tilRegisterNama.apply{
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return  errorMessage == null
    }

    private fun validateEmail(): Boolean{
        var errorMessage: String? = null
        val value = binding.tietRegisterEmail.text.toString()
        if(value.isEmpty()){
            errorMessage = "Isi email anda"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMessage = "Email tidak valid"
        }
        if (errorMessage != null){
            binding.tilRegisterEmail.apply{
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePassword(): Boolean{
        var errorMessage: String? = null
        val value = binding.tietRegisterPassword.text.toString()
        if(value.isEmpty()){
            errorMessage = "Isi kata sandi anda"
        } else if (value.length <= 8){
            errorMessage = "Kata sandi minimal 8 karakter"
        }
        if (errorMessage != null){
            binding.tilRegisterPassword.apply{
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }
    private fun validateConfirmPassword(): Boolean{
        var errorMessage: String? = null
        val value = binding.tietConfirmPassword.text.toString()
        if(value.isEmpty()){
            errorMessage = "Konfirmasi kata sandi anda"
        } else if (value.length <= 8){
            errorMessage = "konfirmasi kata sandi minimal 8 karakter"
        }
        if (errorMessage != null){
            binding.tilConfirmPassword.apply{
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    private fun validatePwordAndCfPword(): Boolean{
        var errorMessage: String? = null
        val pword = binding.tietRegisterPassword.text.toString()
        val cfpword = binding.tietConfirmPassword.text.toString()
        if (pword != cfpword){
            errorMessage = "Konfirmasi kata sandi tidak sama!"
        }
        if (errorMessage != null){
            binding.tilConfirmPassword.apply{
                isErrorEnabled = true
                error = errorMessage
            }
        }
        return errorMessage == null
    }

    override fun onClick(view: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null){
            when(view.id){
                R.id.tiet_register_name -> {
                    if (hasFocus){
                        if (binding.tilRegisterNama.isErrorEnabled){
                            binding.tilRegisterNama.isErrorEnabled = false
                        }
                    }else{
                        validateName()
                    }
                }
                R.id.tiet_register_email -> {
                    if (hasFocus){
                        if (binding.tilRegisterEmail.isErrorEnabled){
                            binding.tilRegisterEmail.isErrorEnabled = false
                        }
                    }else{
                        validateEmail()
                    }
                }
                R.id.tiet_register_password -> {
                    if (hasFocus){
                        if (binding.tilRegisterPassword.isErrorEnabled){
                            binding.tilRegisterPassword.isErrorEnabled = false
                        }
                    }else{
                        if (validatePassword() && binding.tietConfirmPassword.text!!.isEmpty()
                            && validateConfirmPassword() && validatePwordAndCfPword()){
                            if (binding.tilConfirmPassword.isErrorEnabled){
                                binding.tilConfirmPassword.isErrorEnabled = false
                            }
                            binding.tilConfirmPassword.apply {
                                setStartIconDrawable(R.drawable.round_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
                R.id.tiet_confirm_password -> {
                    if (hasFocus){
                        if (binding.tilConfirmPassword.isErrorEnabled){
                            binding.tilConfirmPassword.isErrorEnabled = false
                        }
                    }else{
                        if (validateConfirmPassword() && validatePassword() && validatePwordAndCfPword()){
                            if (binding.tilRegisterPassword.isErrorEnabled){
                                binding.tilRegisterPassword.isErrorEnabled = false
                            }
                            binding.tilConfirmPassword.apply {
                                setStartIconDrawable(R.drawable.round_check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }

//    private fun insertDataToDatabase() {
//        val firstName = binding.etRegisterFirstName.text.toString()
//        val email = binding.etRegisterEmail.text.toString()
//        val phone = binding.etRegisterNomorHandphone.text.toString()
//        val password = binding.etRegisterPassword.text.toString()
//        val location = binding.etRegisterSelectRegion.text.toString()
//        val checkBox = binding.cbRegister
//
//        fun isChecked(): Boolean{
//            val check = checkBox.isChecked
//            if (!check){
//                Toast.makeText(this, "Belum Menyetujui Syarat dan Ketentuan",Toast.LENGTH_SHORT).show()
//            }
//            return check
//        }
//
//        if (inputCheck(firstName, email, phone, password, location) && isChecked()){
//            //Create User Object
//            val user = User(0, firstName, email, phone, password, location)
//            //Add Data to Database
//            mUserViewModel.addUser(user)
//            Toast.makeText(this, "Berhasil Daftar!", Toast.LENGTH_SHORT).show()
//            //move activity
//            moveToLoginActivity()
//        } else {
//            Toast.makeText(this, "Mohon lengkapi data anda.", Toast.LENGTH_SHORT).show()
//        }
//
//    }
//
//    private fun inputCheck(
//        firstName: String,
//        email: String,
//        phone: String,
//        password: String,
//        location: String
//    ): Boolean {
//        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(email)
//                && (TextUtils.isEmpty(phone)) && TextUtils.isEmpty(password) && TextUtils.isEmpty(location))
//    }

    private fun moveToLoginActivity() {
        val move = Intent(this, LoginActivity::class.java)
        startActivity(move)
    }


}