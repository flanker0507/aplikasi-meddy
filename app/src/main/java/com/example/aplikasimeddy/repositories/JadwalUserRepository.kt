package com.example.aplikasimeddy.repositories

import androidx.lifecycle.LiveData
import com.example.aplikasimeddy.room.dao.JadwalUserDao
import com.example.aplikasimeddy.room.model.Jadwal

class JadwalUserRepository(private val jadwalUserDao: JadwalUserDao) {

    val readAllData: LiveData<List<Jadwal>> = jadwalUserDao.readAllData()

    suspend fun addJadwalUser(jadwal: Jadwal){
        jadwalUserDao.addJadwalUser(jadwal)
    }
    suspend fun updateJadwalUser(jadwal: Jadwal){
        jadwalUserDao.updateJadwalUser(jadwal)
    }
}