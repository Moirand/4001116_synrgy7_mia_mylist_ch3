package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mychampionlist.data.Champions
import com.example.mychampionlist.data.Regions
import com.example.mychampionlist.data.Roles

class DetailViewModel : ViewModel() {
    private val _champion = MutableLiveData<Champions?>()
    val champion: LiveData<Champions?> = _champion

    private val _region = MutableLiveData<Regions?>()
    val region: LiveData<Regions?> = _region

    private val _role = MutableLiveData<List<Roles>?>()
    val role: LiveData<List<Roles>?> = _role

    fun getArgs(championData: Champions?, regionData: Regions?, roleData: List<Roles>?) {
        _champion.value = championData
        _region.value = regionData
        _role.value = roleData
    }
}