package com.example.mychampionlist.data.repository

import androidx.lifecycle.LiveData
import com.example.mychampionlist.data.datasource.local.room.UserDao
import com.example.mychampionlist.data.datasource.local.room.UserEntity
import com.example.mychampionlist.data.domain.UserRepository

class UserRepositoryImpl(
    private val userDao: UserDao
) : UserRepository {
    override fun getAllUsers(): LiveData<List<UserEntity>> {
        return userDao.getAllUsers()
    }

    override fun getUserByUsername(username: String): LiveData<UserEntity?> {
        return userDao.getUserByUsername(username)
    }

    override fun getUserByEmail(email: String): LiveData<UserEntity?> {
        return userDao.getUserByEmail(email)
    }

    override suspend fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
    }

    override suspend fun deleteUser(userame: String) {
        userDao.deleteUser(userame)
    }
}