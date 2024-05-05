package com.example.mychampionlist.data.datasource.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM user WHERE username = :username")
    fun getUserByUsername(username: String): LiveData<UserEntity?>

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserByEmail(email: String): LiveData<UserEntity?>

    @Query("DELETE FROM user WHERE email = :email")
    suspend fun deleteUser(email: String)
}