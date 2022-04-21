package com.example.practicals.architecture.mvp.model

import android.text.TextUtils
import android.util.Patterns

class UserData(override  val email: String, override val password: String) : User {
    override val isDataValid: Boolean

    get() = (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6)
}