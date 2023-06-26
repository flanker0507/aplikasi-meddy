package com.example.aplikasimeddy.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aplikasimeddy.room.dao.JadwalUserDao
import com.example.aplikasimeddy.room.model.Jadwal

@Database(entities = [Jadwal::class], version = 1, exportSchema = false)
abstract class JadwalUserDatabase : RoomDatabase() {
    abstract fun jadwalUserDao(): JadwalUserDao

    companion object {
        @Volatile
        private var INSTANCE: JadwalUserDatabase? = null

        fun getDatabase(context: Context): JadwalUserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JadwalUserDatabase::class.java,
                    "jadwal_user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}