package com.example.aplikasimeddy.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasimeddy.api.RequestState
import com.example.aplikasimeddy.repositories.Repository
import com.example.aplikasimeddy.model_responses.ObatResponse
import com.example.aplikasimeddy.model_responses.UserRegisterRequest
import kotlinx.coroutines.launch
import retrofit2.Response

class ObatViewModel(private val repository: Repository): ViewModel(){
//    private var _obatResponse = MutableLiveData<RequestState<ObatResponse?>>()
//    var obatResponse: LiveData<RequestState<ObatResponse?>> = _obatResponse

    val obatResponse: MutableLiveData<Response<List<ObatResponse>>> = MutableLiveData()


    fun getObat(){
        viewModelScope.launch {
            val response = repository.getObat()
            obatResponse.value = response
        }
    }

}