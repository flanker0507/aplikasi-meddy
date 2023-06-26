package com.example.aplikasimeddy.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.aplikasimeddy.repositories.JadwalUserRepository
import com.example.aplikasimeddy.room.database.JadwalUserDatabase
import com.example.aplikasimeddy.room.model.Jadwal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JadwalUserViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Jadwal>>
    private val repository: JadwalUserRepository

    init {
        val jadwalUserDao = JadwalUserDatabase.getDatabase(application).jadwalUserDao()
        repository = JadwalUserRepository(jadwalUserDao)
        readAllData = repository.readAllData
    }

    fun addJadwalUser(jadwal: Jadwal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addJadwalUser(jadwal)
        }
    }
    fun updateJadwalUser(jadwal: Jadwal){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateJadwalUser(jadwal)
        }
    }
}