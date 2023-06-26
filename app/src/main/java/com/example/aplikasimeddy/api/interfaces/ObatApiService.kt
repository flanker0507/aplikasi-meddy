package com.example.aplikasimeddy.api.interfaces

import com.example.aplikasimeddy.api.RequestState
import com.example.aplikasimeddy.model_responses.ObatResponse
import com.example.aplikasimeddy.model_responses.TestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ObatApiService {

    @GET("/api/obats")
    suspend fun getObat() : Response<List<ObatResponse>>

    @GET ("posts")
    suspend fun getCustomTest() : Response<List<TestResponse>>

    @GET("/api/obats")
    suspend fun searchObat(@Query("query") query: String): Response<List<ObatResponse>>

}