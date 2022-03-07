package com.example.practicals.ui_widget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_toast.*

class Toast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        simpleToast()
        customToast()
    }

    private fun customToast() {
        val layout = layoutInflater.inflate(R.layout.custom_toast, findViewById(R.id.linear_layout))

        customToastButton.setOnClickListener {
            val myToast = Toast(applicationContext)
            myToast.duration = Toast.LENGTH_LONG
            myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            myToast.view = layout
            myToast.show()
        }
    }

    private fun simpleToast() {
        toastButton.setOnClickListener {
            Toast.makeText(this,getString(R.string.toast_message), Toast.LENGTH_LONG).show()
        }
    }
}