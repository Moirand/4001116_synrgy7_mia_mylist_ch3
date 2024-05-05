package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.ViewModel

class ApplicationViewModel: ViewModel() {
    fun checkLogin(token: String?): Boolean{
        return token.isNullOrEmpty()
    }
}