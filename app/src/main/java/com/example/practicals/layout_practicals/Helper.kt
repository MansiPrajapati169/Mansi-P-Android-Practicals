package com.example.practicals.layout_practicals

import android.R
import android.app.Activity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

fun buttonClick(sendFeedback : Button,activity: Activity){
    sendFeedback.setOnClickListener {
        Toast.makeText(activity, "Details Submitted", Toast.LENGTH_LONG).show()
    }
}

fun spinnerClick(spinnerItems : Spinner,activity : Activity) {
    var feedbackTypes = arrayOf("Praise", "Complaint", "Improvement","Inquiry")
    val adapter = ArrayAdapter(activity, R.layout.simple_spinner_item, feedbackTypes)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerItems.adapter = adapter
}