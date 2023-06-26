package com.example.aplikasimeddy.api

import androidx.viewbinding.BuildConfig
import com.example.aplikasimeddy.api.interfaces.ArtikelApiService
import com.example.aplikasimeddy.api.interfaces.ObatApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class ApiConfig {
    companion object {
        const val BASE_URL = "http://192.168.1.5:5000/"

        private val loggingInterceptor =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)

        private val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(30,TimeUnit.SECONDS)
            .build()

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client)
            .build()

        fun getObatApiService(): ObatApiService{
            return retrofit.create(ObatApiService::class.java)
        }

        fun getArtikelService(): ArtikelApiService{
            return  retrofit.create(ArtikelApiService::class.java)
        }


        const val test_URL = "https://jsonplaceholder.typicode.com/"
    }
}