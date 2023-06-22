package com.example.aplikasimeddy.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasimeddy.repositories.Repository
import com.example.aplikasimeddy.model_responses.UserRegisterRequest

class RegisterViewModel(private val repository: Repository): ViewModel() {
    private val user: MutableLiveData<UserRegisterRequest> = MutableLiveData()

    fun postUser(): LiveData<UserRegisterRequest> = user
}