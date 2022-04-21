package com.example.practicals.architecture.mvp.presenter

interface ILoginPresenter {
    fun onLogin(email: String, password: String)
}