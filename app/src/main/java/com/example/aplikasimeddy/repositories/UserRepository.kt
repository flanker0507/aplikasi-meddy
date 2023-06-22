package com.example.aplikasimeddy.repositories

import androidx.lifecycle.LiveData
import com.example.aplikasimeddy.room.dao.UserDao
import com.example.aplikasimeddy.room.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}