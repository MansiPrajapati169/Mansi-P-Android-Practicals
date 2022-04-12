package com.example.practicals.architecture.mvp.model

interface User {
    val email: String
    val password: String
    val isDataValid: Boolean
}