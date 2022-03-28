package com.example.practicals.web_services

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.practicals.R
import com.example.practicals.web_services.Interface.UserInterface
import kotlinx.android.synthetic.main.activity_create_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)

        addUser()
    }

    private fun showDialog(message: String) {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage(message)
            .setCancelable(false)
            .setPositiveButton(R.string.proceed_alert_btn, DialogInterface.OnClickListener {
                    dialog, id -> finish()
            })
            .setNegativeButton(R.string.cancel_alert_btn, DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle(R.string.alert_title)
        alert.show()
    }

    private fun addUser() {

        btAddUser.setOnClickListener {
            val retrofitData =
            UserInterface.retrofitObject().create(UserInterface::class.java).addUserData(etName.text.toString(),etJob.text.toString())

            retrofitData.enqueue(object : Callback<AddUserData> {

                override fun onResponse(call: Call<AddUserData>, response: Response<AddUserData>) {
                    val response = response.body()

                    if (response != null) {
                        val message = getString(R.string.alert_text,response.name,response.job,response.id,response.createdAt)
                        showDialog(message)
                    }
                }

                override fun onFailure(call: Call<AddUserData>, t: Throwable) {
                    Toast.makeText(this@CreateUserActivity,R.string.empty_response,Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}