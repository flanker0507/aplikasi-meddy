package com.example.aplikasimeddy.views.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasimeddy.MainActivity
import com.example.aplikasimeddy.model_responses.UserLoginRequest
import com.example.aplikasimeddy.view_models.LoginViewModel
import com.example.aplikasimeddy.views.register.RegisterActivity
import com.example.aplikasimeddy.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val repository = Repository(UserApiService.create())
//        val viewModelFactory = MainViewModelFactory(repository)
//        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
//
//        viewModel.myService.observe(this, { result ->
//            when (result){
//                is Result.Success ->{
//                    val uuid = result.data.uuid
//                }
//                is Result.Error -> {
//                    val errorMessage = result.error
//                }
//            }
//        })

        moveToMainActivity()
        moveToRegisterActivity()
    }

    private fun login(){
        val request = UserLoginRequest()
//        request.email = binding.etLoginEmail.text.toString().trim()
//        request.password = binding.etLoginPassword.text.toString().trim()
//        viewModel.loginUser()


    }
    private fun moveToMainActivity(){
        val btnLogin = binding.btnLogin
        btnLogin.setOnClickListener{
            val move = Intent(this, MainActivity::class.java)
            startActivity(move)
        }
    }

    private fun moveToRegisterActivity(){
        val txtListener = binding.tvLoginBuatSkrg
        txtListener.setOnClickListener{
            val move = Intent(this, RegisterActivity::class.java)
            startActivity(move)
        }
    }
}