package com.example.aplikasimeddy.repositories

import com.example.aplikasimeddy.api.ApiConfig
import com.example.aplikasimeddy.api.ApiService
import com.example.aplikasimeddy.model_responses.ObatResponse
import com.example.aplikasimeddy.model_responses.TestResponse
import retrofit2.Response

class Repository{
    private val getObat = ApiConfig.getObatApiService()

    suspend fun getObat() = getObat.getObat()

    private val getArtikel = ApiConfig.getArtikelService()

    suspend fun getArtikel() = getArtikel.getArtikel()

//    suspend fun getCustomTest(): Response<List<TestResponse>>{
//        return ApiService.test.getCustomTest()
//    }

}