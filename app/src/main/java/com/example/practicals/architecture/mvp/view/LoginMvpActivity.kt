package com.example.practicals.architecture.mvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicals.architecture.mvp.presenter.ILoginView
import com.example.practicals.architecture.mvp.presenter.LoginPresenter
import com.example.practicals.databinding.ActivityLoginMvpBinding

class LoginMvpActivity : AppCompatActivity(), ILoginView {

    private lateinit var binding: ActivityLoginMvpBinding
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginData()
    }

    private fun loginData() {
        loginPresenter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {
            loginPresenter.onLogin(binding.etEmail.text.toString(),binding.etPassword.text.toString())
        }
    }

    override fun onLoginResult(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}