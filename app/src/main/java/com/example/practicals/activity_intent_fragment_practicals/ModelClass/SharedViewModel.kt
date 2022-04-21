package com.example.practicals.activity_intent_fragment_practicals.ModelClass

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val message = MutableLiveData<String>()

    fun sendMessage(text: Editable?) {
        message.value = text.toString()
    }
}