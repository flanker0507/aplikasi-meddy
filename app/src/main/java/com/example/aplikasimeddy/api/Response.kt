package com.example.aplikasimeddy.api

sealed class Response<out R> private constructor(){
    data class Success<out T>(val data: T): Response<T>()
    data class Error(val message: String): Response<Nothing>()
    object Loading: Response<Nothing>()
}
