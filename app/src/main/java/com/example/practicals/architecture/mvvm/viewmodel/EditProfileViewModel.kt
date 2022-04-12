package com.example.practicals.architecture.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicals.architecture.mvvm.model.EditProfileData

class EditProfileViewModel : ViewModel() {

    val editProfileModel = MutableLiveData<EditProfileData>()
    val email = MutableLiveData("mansi@gmail.com")
    val name = MutableLiveData("mansi")
    val message = MutableLiveData("Hello World")

    fun setEditProfileModel() {
        editProfileModel.value = EditProfileData(email.value, name.value, message.value)
    }
}