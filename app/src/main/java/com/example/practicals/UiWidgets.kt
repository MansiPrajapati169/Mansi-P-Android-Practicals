package com.example.practicals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ui_widgets.*

class UiWidgets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_widgets)

        registrationForm()
    }

    private fun registrationForm() {
        registrationTaskButton.setOnClickListener {
            intent = Intent(applicationContext, RegistrationForm::class.java)
            startActivity(intent)
        }
    }


}