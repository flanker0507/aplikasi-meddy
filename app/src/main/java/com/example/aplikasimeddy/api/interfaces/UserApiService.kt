package com.example.aplikasimeddy.api.interfaces

import com.example.aplikasimeddy.model_responses.UserLoginRequest
import com.example.aplikasimeddy.model_responses.UserLoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiService {
    @POST("login")
    suspend fun loginUser(
        @Body userLoginRequest: UserLoginRequest
    ): Response<UserLoginResponse>
}