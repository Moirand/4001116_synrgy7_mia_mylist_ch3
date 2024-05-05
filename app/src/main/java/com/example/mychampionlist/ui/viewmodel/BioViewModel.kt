package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BioViewModel : ViewModel() {
    private val _bio = MutableLiveData<Int?>()
    val bio: LiveData<Int?> = _bio

    fun getArgs(bio: Int?) {
        _bio.value = bio
    }
}