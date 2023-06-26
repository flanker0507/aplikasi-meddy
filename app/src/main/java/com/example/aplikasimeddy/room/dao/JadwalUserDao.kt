package com.example.aplikasimeddy.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.aplikasimeddy.room.model.Jadwal

@Dao
interface JadwalUserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJadwalUser(jadwalUser: Jadwal)

    @Update
    suspend fun updateJadwalUser(jadwalUser: Jadwal)

    @Query("SELECT * FROM jadwal_user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Jadwal>>
}