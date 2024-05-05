package com.example.mychampionlist.data.domain

import androidx.lifecycle.LiveData
import com.example.mychampionlist.data.datasource.local.room.UserDao
import com.example.mychampionlist.data.datasource.local.room.UserEntity
import com.example.mychampionlist.data.repository.UserRepositoryImpl

interface UserRepository {
    fun getAllUsers(): LiveData<List<UserEntity>>
    fun getUserByUsername(username: String): LiveData<UserEntity?>
    fun getUserByEmail(email: String): LiveData<UserEntity?>
    suspend fun insertUser(userEntity: UserEntity)
    suspend fun deleteUser(userame: String)

    companion object {
        @Volatile
        private var instance: UserRepositoryImpl? = null
        fun getInstance(
            userDao: UserDao
        ): UserRepositoryImpl =
            instance ?: synchronized(this) {
                instance ?: UserRepositoryImpl(userDao)
            }.also { instance = it }
    }
}