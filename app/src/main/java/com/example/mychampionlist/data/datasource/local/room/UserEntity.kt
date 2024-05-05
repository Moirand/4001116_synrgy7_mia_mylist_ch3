package com.example.mychampionlist.data.datasource.local.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
class UserEntity (
    @ColumnInfo(name = "username")
    @PrimaryKey(autoGenerate = false)
    val username: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "password")
    val password: String
) : Serializable