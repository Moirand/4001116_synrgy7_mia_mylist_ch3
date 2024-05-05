package com.example.mychampionlist

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory.Companion.TOKEN
import com.example.mychampionlist.ui.LoginActivity
import com.example.mychampionlist.ui.viewmodel.ApplicationViewModel
import com.example.mychampionlist.ui.viewmodel.ApplicationViewModelFactory

class ApplicationActivity : AppCompatActivity() {
    private val viewModel by viewModels<ApplicationViewModel> { ApplicationViewModelFactory() }
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = SharedPreferencesFactory().createSharedPreferences(this)

        if (viewModel.checkLogin(sharedPreferences.getString(TOKEN, null))) {
            startActivity(Intent(this, LoginActivity::class.java))
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }
        finishAffinity()
    }
}