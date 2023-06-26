package com.example.aplikasimeddy.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplikasimeddy.repositories.Repository

class MainViewModelFactory(private val repository: Repository)
    : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(ObatViewModel::class.java) -> ObatViewModel(repository) as T
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> RegisterViewModel(repository) as T
            modelClass.isAssignableFrom(ArtikelViewModel::class.java) -> ArtikelViewModel(repository) as T
//            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(repository) as T
            else -> throw java.lang.IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
        }
    }
}