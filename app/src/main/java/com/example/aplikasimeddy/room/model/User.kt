package com.example.aplikasimeddy.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama_depan: String,
    val email: String,
    val no_handphone: String,
    val password: String,
    val lokasi: String
)