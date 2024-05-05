package com.example.mychampionlist.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mychampionlist.data.dataclass.User
import com.example.mychampionlist.data.datasource.local.room.UserEntity
import com.example.mychampionlist.data.domain.UserRepository
import kotlinx.coroutines.launch

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _isUsernameExist = MutableLiveData<Boolean>()
    val isUsernameExist: LiveData<Boolean> = _isUsernameExist

    private val _isEmailExist = MutableLiveData<Boolean>()
    val isEmailExist: LiveData<Boolean> = _isEmailExist

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun registerUser(user: User) {
        viewModelScope.launch {
            try {
                _loading.value = true
                userRepository.insertUser(
                    UserEntity(
                        user.username,
                        user.email,
                        user.password
                    )
                )
                _loading.value = false
                _success.value = true
            } catch (throwable: Throwable) {
                _loading.value = false
                _error.value = throwable
            }
        }
    }

    fun getAllUsers() = userRepository.getAllUsers()

    fun isUsernameExist(userList: List<UserEntity>, username: String): Boolean {
        userList.forEach {
            if (it.username == username) {
                return true
            }
        }
        return false
    }

    fun isEmailExist(userList: List<UserEntity>, email: String): Boolean {
        userList.forEach {
            if (it.email == email) {
                return true
            }
        }
        return false
    }
}