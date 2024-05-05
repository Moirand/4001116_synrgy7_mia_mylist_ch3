package com.example.mychampionlist.di

import android.content.Context
import com.example.mychampionlist.data.datasource.local.room.UserDatabase
import com.example.mychampionlist.data.domain.UserRepository

object Injection {
    fun provideUserRepository(context: Context): UserRepository {
        val database = UserDatabase.getInstance(context)
        val dao = database.userDao()
        return UserRepository.getInstance(dao)
    }
}