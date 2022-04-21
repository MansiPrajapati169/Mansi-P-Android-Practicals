package com.example.practicals.web_services


import com.google.gson.annotations.SerializedName

data class AddUser(
    @SerializedName("job")
    val job: String,
    @SerializedName("name")
    val name: String
)

data class AddUserData(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("job")
    val job: String,
    @SerializedName("name")
    val name: String
)