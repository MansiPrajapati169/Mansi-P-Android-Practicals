package com.example.practicals.web_services.ViewModel

import com.example.practicals.web_services.Data
import com.example.practicals.web_services.Support
import com.google.gson.annotations.SerializedName

data class UserData (
    @SerializedName("data")
    val dataObject: Data,
    @SerializedName("support")
    val supportObject: Support
)