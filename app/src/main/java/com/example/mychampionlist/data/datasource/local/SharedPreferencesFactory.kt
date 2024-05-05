package com.example.mychampionlist.data.datasource.local

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesFactory {

    companion object {
        const val SHARED_PREFERENCES_NAME = "app shared preferences"
        const val TOKEN = "token"
        const val EMAIL = "email"
    }

    fun createSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}