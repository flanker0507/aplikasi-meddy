package com.example.aplikasimeddy.data.room.database

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama_depan: String,
    val email: Email,
    val no_handphone: Int,
    val password: String,
    val lokasi: String
)