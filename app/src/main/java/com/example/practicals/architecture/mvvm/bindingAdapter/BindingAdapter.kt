package com.example.practicals.architecture

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.example.practicals.R

@BindingAdapter("customText")
fun TextView.setCustomText(item: String) {
    this.text = context.getString(R.string.txt_custom_message,item)
}

@InverseBindingAdapter(attribute = "customText")
fun TextView.getCustomText(): String {
    return this.text.toString()
}