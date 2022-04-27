package com.example.practicals.web_services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import com.example.practicals.utils.Constants
import com.example.practicals.utils.Constants.GET_METHOD
import com.example.practicals.utils.Constants.URL_ID
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_display_user.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class DisplayUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_user)

        setData()
    }

    private fun setData() {
        val intent = intent
        val id = intent.getIntExtra("id", 0)

        Thread {
            displayUser(id)
        }.start()
    }

    private fun displayUser(id: Int) {
        val mURL = URL(URL_ID + id)
        val response: String
        val jsonObject: JSONObject
        val obj: JSONObject

        with(mURL.openConnection() as HttpURLConnection) {
            requestMethod = GET_METHOD

            setRequestProperty(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
            response = inputStream.bufferedReader().use {
                it.readText()
            }
            jsonObject = JSONObject(response)
            obj = JSONObject(jsonObject.getString("data"))

            runOnUiThread {
                tvFirstName.text = obj.getString("first_name")
                tvLastName.text = obj.getString("last_name")
                tvEmail.text = obj.getString("email")
                tvId.text = obj.getString("id")
                Picasso.get().load(obj.getString("avatar")).into(rvImage)
            }
        }
    }
}