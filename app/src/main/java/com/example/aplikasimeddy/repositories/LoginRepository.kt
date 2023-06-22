package com.example.aplikasimeddy.repositories

import com.example.aplikasimeddy.api.interfaces.UserApiService

class LoginRepository(private val userApiService: UserApiService) {
//    suspend fun loginUser(email: String, password: String): Response<UserLoginResponse> {
////        val request = UserLoginRequest(email, password)
////        val response = userApiService.loginUser(request)
////        if (response.isSuccessful){
////            val body = response.body()
////            if (body != null){
////                return Response.success(body)
////            }
////        }
//        return null
//    }
}