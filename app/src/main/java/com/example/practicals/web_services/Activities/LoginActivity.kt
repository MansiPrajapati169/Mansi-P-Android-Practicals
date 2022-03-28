package com.example.practicals.web_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.practicals.R
import com.example.practicals.utils.Constants
import com.example.practicals.utils.Constants.LOGIN_URL
import com.example.practicals.utils.Constants.POST_METHOD
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {
    private var emailPattern: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginClick()
    }

    private fun loginClick() {
        emailPattern = getString(R.string.email_pattern)
        val required = getString(R.string.required_text)
        val invalidEmail = getString(R.string.invalid_email)

        btnLogin.setOnClickListener {
            when (true) {
                etUserName.text!!.isEmpty() -> {
                    tilUserName.error = required
                }

                else -> {
                    tilUserName.error = null
                    intent = Intent(applicationContext, DelayedResponseActivity::class.java)
                    startActivity(intent)

                    Thread {
                        sendPostRequest()
                    }.start()
                }
            }
        }

        etUserName.doOnTextChanged { text, _, _, _ ->
            when (true) {
                text?.isEmpty() -> tilUserName.error = required
                emailPattern?.toRegex()?.let { etUserName.text.toString().matches(it) } == false, -> tilUserName.error = invalidEmail
                else -> tilUserName.error = null
            }
        }
    }

    private fun sendPostRequest() {

        val mURL = URL(LOGIN_URL)
        val data = JSONObject()
        val writer: OutputStreamWriter
        val response: String

        data.put("email", etUserName.text)
        data.put("password", etPassword.text)

        with(mURL.openConnection() as HttpURLConnection) {

            requestMethod = POST_METHOD
            setRequestProperty(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)

            writer = OutputStreamWriter(outputStream)
            writer.write(data.toString())
            writer.flush()

            response = inputStream.bufferedReader().use {
                it.readText()
            }
            println(response)

            runOnUiThread {
                if (responseCode == 200) {
                    Toast.makeText(applicationContext,
                        R.string.successful_toast,
                        Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(applicationContext,
                        R.string.unsuccessful_toast,
                        Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}