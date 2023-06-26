package com.example.aplikasimeddy.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikasimeddy.model_responses.ArtikelResponse
import com.example.aplikasimeddy.repositories.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ArtikelViewModel(private val repository: Repository): ViewModel() {

    val artikelResponse: MutableLiveData<Response<List<ArtikelResponse>>> = MutableLiveData()

    fun getArtikel(){
        viewModelScope.launch {
            val response = repository.getArtikel()
            artikelResponse.value = response
        }
    }
}