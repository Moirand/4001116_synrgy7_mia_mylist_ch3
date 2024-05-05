package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mychampionlist.data.domain.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val userRepository: UserRepository): ViewModel() {
    private val _columnCount = MutableLiveData<Int>()
    val columnCount: LiveData<Int> = _columnCount

    fun setColumnLayout(columnCount: Int = 1){
        _columnCount.value = columnCount
    }

    fun deleteUser(email: String?){
        viewModelScope.launch {
            if (email != null) {
                userRepository.deleteUser(email)
            }
        }
    }
}