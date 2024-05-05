package com.example.mychampionlist.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mychampionlist.MainActivity
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory.Companion.EMAIL
import com.example.mychampionlist.data.datasource.local.SharedPreferencesFactory.Companion.TOKEN
import com.example.mychampionlist.databinding.ActivityLoginBinding
import com.example.mychampionlist.ui.viewmodel.LoginViewModel
import com.example.mychampionlist.ui.viewmodel.LoginViewModelFactory

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private val viewModel: LoginViewModel by viewModels { LoginViewModelFactory.getInstance(this) }
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        sharedPreferences = SharedPreferencesFactory().createSharedPreferences(this)

        binding.btnTextBuatAkun.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnSignin.setOnClickListener {
            if (binding.edtEmail.text.isNullOrEmpty()) {
                binding.ilEmail.error = "email tidak boleh kosong"
            } else if (binding.edtPassword.text.isNullOrEmpty()) {
                binding.ilPassword.error = "password tidak boleh kosong"
            } else {
                viewModel.getAllUsers().observe(this){ listUserEntity ->
                    binding.ilEmail.error = null
                    binding.ilPassword.error = null
                    viewModel.login(
                        listUserEntity,
                        binding.edtEmail.text.toString(),
                        binding.edtPassword.text.toString()
                    )
                }
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            if (isLoading) {
                binding.flipperBtnLogin.displayedChild = 1
            } else {
                binding.flipperBtnLogin.displayedChild = 0
            }
        }

        viewModel.success.observe(this) { isSuccess ->
            if (isSuccess) {
                sharedPreferences.edit().putString(TOKEN, generateToken()).apply()
                sharedPreferences.edit().putString(EMAIL, binding.edtEmail.text.toString()).apply()

                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            } else {
                Toast.makeText(this, "Akun Tidak Ditemukan!", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.error.observe(this) { throwable ->
            Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateToken(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..20).map { allowedChars.random() }.joinToString("")
    }
}