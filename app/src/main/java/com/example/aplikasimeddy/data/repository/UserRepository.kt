package com.example.aplikasimeddy.data.repository

import androidx.lifecycle.LiveData
import com.example.aplikasimeddy.data.room.dao.UserDao
import com.example.aplikasimeddy.data.room.database.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}