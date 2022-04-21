package com.example.practicals.architecture.mvp.presenter

import com.example.practicals.architecture.mvp.model.UserData

class LoginPresenter (private var iLoginView: ILoginView) : ILoginPresenter {

    override fun onLogin(email: String, password: String) {

        val user = UserData(email,password)
        val isLoginSuccess = user.isDataValid

        if(isLoginSuccess){
            iLoginView.onLoginResult("Login success")
        }
        else {
            iLoginView.onLoginResult("Login Fail")
        }
    }
}