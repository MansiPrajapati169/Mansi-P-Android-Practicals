package com.example.practicals.web_services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practicals.R
import com.example.practicals.web_services.Adapters.DelayedResponseAdapter
import com.example.practicals.web_services.Interface.UserInterface
import kotlinx.android.synthetic.main.activity_delayed_response.*
import retrofit2.Call
import retrofit2.Response

class DelayedResponseActivity : AppCompatActivity() {
    private var adapter: DelayedResponseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delayed_response)

        getUserData()
    }

    private fun getUserData() {
        val retrofitData = UserInterface.retrofitObject().create(UserInterface::class.java).getData()

        retrofitData.enqueue(object : retrofit2.Callback<DataClass> {
            override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                val responseData = response.body()
                if (responseData != null) {
                    progressBar.visibility = View.INVISIBLE
                    adapter = DelayedResponseAdapter(responseData.data)
                    rvItem.adapter = adapter
                }
            }

            override fun onFailure(call: Call<DataClass>, t: Throwable) {
                progressBar.visibility = View.INVISIBLE
            }
        })

        btFabAdd.setOnClickListener {
            intent = Intent(applicationContext, CreateUserActivity::class.java)
            startActivity(intent)
        }
    }
}