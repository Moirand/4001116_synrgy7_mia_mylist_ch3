package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mychampionlist.data.dataclass.Champion
import com.example.mychampionlist.ui.ListItemFragmentArgs

class ListItemViewModel(private val argumentsData: ListItemFragmentArgs) : ViewModel() {
    private val _championData = MutableLiveData<Champion>()
    val championData: LiveData<Champion> = _championData

    fun getArgs() {
        _championData.value = argumentsData.dataChampion
    }
}