package com.example.practicals.ui_widget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_task_buttons.*

class TaskButtons : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_buttons)

        registrationForm()
    }

    private fun registrationForm() {
        taskButton.setOnClickListener {
            intent = Intent(applicationContext, RegistrationForm::class.java)
            startActivity(intent)
        }
    }


}