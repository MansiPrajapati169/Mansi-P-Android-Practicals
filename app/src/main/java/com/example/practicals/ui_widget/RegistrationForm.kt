package com.example.practicals.ui_widget

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_registration_form.*

class RegistrationForm : AppCompatActivity() {

    private var emailPattern : String? = null
    private var required : String? = null
    private var invalidEnail : String? = null
    private var submitDetails : String? = null
    private var passwordShort : String? = null

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

        emailPattern = getString(R.string.email_pattern)
        required = getString(R.string.required_text)
        invalidEnail = getString(R.string.invalid_email)
        submitDetails = getString(R.string.submit_toast)
        passwordShort = getString(R.string.password_short_text)

        userNameEditText.doOnTextChanged { text, start, before, count ->
            when (true) {
                text!!.isEmpty() -> usernameTextInput.error = required
                userNameEditText.text.toString().matches(emailPattern!!.toRegex()) == false -> usernameTextInput.error = invalidEnail
                else -> usernameTextInput.error = null
            }
        }

        passwordEditText.doOnTextChanged { text, start, before, count ->
            when (true) {
                text!!.isEmpty() -> passwordTextInput.error = required
                text!!.length < 8 -> passwordTextInput.error = passwordShort
                else -> passwordTextInput.error = null
            }
        }
    }

    private fun submitDetails() {
        submitButton.setOnClickListener {
            when(valid == false) {
                userNameEditText.text!!.isEmpty() && passwordEditText.text!!.isEmpty() -> {
                    usernameTextInput.error = required
                    passwordTextInput.error = required
                }
                passwordEditText.text!!.length < 8 -> passwordTextInput.error = passwordShort
                else -> {
                    passwordTextInput.error = null
                    usernameTextInput.error = null
                    valid = true
                }
            }

            when (valid == true) {
                detailsSwitch.isChecked && userNameEditText.text!!.isEmpty() == false -> {
                    showDetailsTextView.text = userNameEditText.text
                }
                else -> {
                    showDetailsTextView.text = " "
                    Toast.makeText(this, submitDetails, Toast.LENGTH_LONG).show()
                }
            }

        }
    }
}

