package com.example.aplikasimeddy.api.interfaces

import com.example.aplikasimeddy.model_responses.ArtikelResponse
import retrofit2.Response
import retrofit2.http.GET

interface ArtikelApiService {
    @GET("/api/beritas")
    suspend fun getArtikel() : Response<List<ArtikelResponse>>
}