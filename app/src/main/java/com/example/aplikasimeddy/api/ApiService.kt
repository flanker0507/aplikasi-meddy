package com.example.aplikasimeddy.api


import com.example.aplikasimeddy.api.interfaces.ObatApiService
import com.example.aplikasimeddy.api.interfaces.UserApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiService {

//    private val
//
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//    val obat: ObatApiService by lazy {
//        retrofit.create(ObatApiService::class.java)
//    }
//    val test: ObatApiService by lazy {
//        retrofit.create(ObatApiService::class.java)
//    }
//
//    private val getService by lazy {
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    val login: UserApiService by lazy {
//        getService.create(UserApiService::class.java)
//    }

//
//    fun getServiceUser(): UserApiService {
//
////        val client: OkHttpClient = OkHttpClient.Builder()
////            .connectTimeout(60, TimeUnit.SECONDS)
////            .readTimeout(60, TimeUnit.SECONDS)
////            .writeTimeout(60, TimeUnit.SECONDS)
////            .build()
////
////        val builder: Retrofit.Builder = Retrofit.Builder()
////            .baseUrl(BASE_URL)
////            .client(client)
////            .addConverterFactory(GsonConverterFactory.create())
////
////        val build: Retrofit = builder.build()
////        return build.create(UserApiService::class.java)
//    }

}