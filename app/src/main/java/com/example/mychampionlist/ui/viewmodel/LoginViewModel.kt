package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mychampionlist.data.datasource.local.room.UserEntity
import com.example.mychampionlist.data.domain.UserRepository

class LoginViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun login(userList: List<UserEntity>, email: String, password: String) {
        try {
            _loading.value = true
            if (isUserValid(userList, email, password)) {
                _loading.value = false
                _success.value = true
            } else {
                _loading.value = false
                _success.value = false
            }
        } catch (throwable: Throwable) {
            _loading.value = false
            _error.value = throwable
        }
    }

    fun getAllUsers() = userRepository.getAllUsers()

    private fun isUserValid(userList: List<UserEntity>, email: String, password: String): Boolean {
        userList.forEach {
            if (it.email == email && it.password == password) {
                return true
            }
        }
        return false
    }
}