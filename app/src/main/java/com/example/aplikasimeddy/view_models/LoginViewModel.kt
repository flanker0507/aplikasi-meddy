package com.example.aplikasimeddy.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasimeddy.repositories.LoginRepository
import com.example.aplikasimeddy.model_responses.UserLoginResponse
import retrofit2.Response

class LoginViewModel(private val repository: LoginRepository): ViewModel() {
    private val _myService = MutableLiveData<Response<UserLoginResponse>>()
    val myService: LiveData<Response<UserLoginResponse>> = _myService

//    fun loginUser(email: String, password: String){
//        viewModelScope.launch {
//            val response = repository.loginUser(email, password)
//            _myService.value = response
//        }
//    }
}