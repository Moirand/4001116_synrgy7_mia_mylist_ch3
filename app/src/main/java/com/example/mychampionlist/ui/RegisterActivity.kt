package com.example.mychampionlist.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mychampionlist.data.dataclass.User
import com.example.mychampionlist.databinding.ActivityRegisterBinding
import com.example.mychampionlist.ui.viewmodel.RegisterViewModel
import com.example.mychampionlist.ui.viewmodel.RegisterViewModelFactory

class RegisterActivity : AppCompatActivity() {
    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(
            layoutInflater
        )
    }
    private val viewModel by viewModels<RegisterViewModel> {
        RegisterViewModelFactory.getInstance(
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            viewModel.getAllUsers().observe(this) { listUserEntity ->
                // Check apakah username sudah terdaftar
                if (viewModel.isUsernameExist(listUserEntity, binding.edtUsername.text.toString())) {
                    binding.ilUsername.error = "Username sudah ada!"
                // Check apakah email sudah terdaftar
                } else if (viewModel.isEmailExist(listUserEntity, binding.edtEmail.text.toString())) {
                    binding.ilEmail.error = "Email sudah ada!"
                // Check apakah confirmasi password sudah benar
                } else if (!binding.edtConfirmPassword.text.toString().isEqual(binding.edtPassword.text.toString())) {
                    binding.ilConfirmPassword.error = "Confirmasi password harus selaras"
                } else {
                    binding.ilUsername.error = null
                    binding.ilEmail.error = null
                    binding.ilConfirmPassword.error = null

                    viewModel.registerUser(
                        User(
                            username = binding.edtUsername.text.toString(),
                            email = binding.edtEmail.text.toString(),
                            password = binding.edtPassword.text.toString()
                        )
                    )
                }
            }
        }

        viewModel.loading.observe(this) { isLoading ->
            if (isLoading) {
                binding.flipperBtnRegister.displayedChild = 1
            } else {
                binding.flipperBtnRegister.displayedChild = 0
            }
        }

        viewModel.success.observe(this) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(this, "Akun Berhasil Dibuat!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finishAffinity()
            }
        }

        viewModel.error.observe(this) { throwable ->
            Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun String.isEqual(password: String): Boolean {
        return this == password
    }
}