package com.example.practicals.ui_widget

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_registration_form.*

class RegistrationForm : AppCompatActivity() {
private var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
private var valid : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)

        submitDetails()
        userDataValidate()
        toast()
    }

    private fun toast() {
        toastTaskButton.setOnClickListener {
            intent = Intent(applicationContext, com.example.practicals.ui_widget.Toast::class.java)
            startActivity(intent)
        }
    }

    private fun userDataValidate() {
        userNameEditText.doOnTextChanged { text, start, before, count ->
            when (true) {
                text!!.isEmpty() -> usernameTextInput.error = "required"
                userNameEditText.text.toString().matches(emailPattern.toRegex()) == false -> usernameTextInput.error = "Enter valid email"
                else -> usernameTextInput.error = null
            }
        }

        passwordEditText.doOnTextChanged { text, start, before, count ->
            when (true) {
                text!!.isEmpty() -> passwordTextInput.error = "required"
                text!!.length < 8 -> passwordTextInput.error = "password is too short"
                else -> passwordTextInput.error = null
            }
        }
    }

    private fun submitDetails() {
        submitButton.setOnClickListener {
            when(valid == false) {
                userNameEditText.text!!.isEmpty() && passwordEditText.text!!.isEmpty() -> {
                    usernameTextInput.error = "Required"
                    passwordTextInput.error = "Required"
                }
                passwordEditText.text!!.length < 8 -> passwordTextInput.error = "password is too short"
                else -> {
                    passwordTextInput.error = null
                    usernameTextInput.error = null
                    valid = true
                }
            }

            when (valid == true) {
                detailsSwitch.isChecked && userNameEditText.text!!.isEmpty() == false -> {
                    showDetailsTextView.text = "username:" + userNameEditText.text
                }
                else -> {
                    showDetailsTextView.text = " "
                    Toast.makeText(this, "Details submitted", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}

