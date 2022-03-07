package com.example.practicals.layout_practicals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_linear_layout.*

class RelativeLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        spinnerClick(spinnerItems,this)
        buttonClick(sendFeedbackButton,this)
    }

}