package com.example.practicals

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_registration_form.*


class RegistrationForm : AppCompatActivity() {
    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_form)
        submitDetails()
        usernamevalidate()
        toast()
    }
    private fun toast() {
        toastTaskButton.setOnClickListener {
            intent = Intent(applicationContext, com.example.practicals.Toast::class.java)
            startActivity(intent)
        }
    }
    private fun usernamevalidate() {
        userNameEditText.doOnTextChanged { text, start, before, count ->
            if(text!!.isEmpty()) {
                usernameTextInput.error = "required"
            }
            else if (userNameEditText.text.toString().matches(emailPattern.toRegex()) == false) {
                usernameTextInput.error = "Enter valid email"
            }
            else {
                usernameTextInput.error = null
            }
        }
        passwordEditText.doOnTextChanged { text, start, before, count ->
            if (text!!.isEmpty()) {
                passwordTextInput.error = "required"
            }
            else if (text!!.length < 8) {
                passwordTextInput.error = "password is too short"
            } else {
                passwordTextInput.error = null
            }
        }
    }

    private fun submitDetails() {
        var valid = false
        submitButton.setOnClickListener {
            if(valid == false) {
                 if (userNameEditText.text.isEmpty() ) {
                    usernameTextInput.error = "Required"
                    valid = false
                 }
                if (passwordEditText.text.isEmpty() ) {
                    passwordTextInput.error = "Required"
                    valid = false
                }
                else if (passwordEditText.text.length < 8) {
                    passwordTextInput.error = "Password is too short"
                    valid = false
                }
                else {
                    valid = true
                }
            }
            if (valid == true) {
                if (detailsSwitch.isChecked && userNameEditText.text.isEmpty() == false) {
                    showDetailsTextView.text = "username:" + userNameEditText.text
                }
                else {
                    showDetailsTextView.text = " "
                    Toast.makeText(this, "Details submitted", Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}

