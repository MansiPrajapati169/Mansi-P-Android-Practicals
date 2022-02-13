package com.example.practicals.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_tasks.*

class ViewTasksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_tasks)

        androidETasks()
    }

    private fun androidETasks() {
        scrollViewTask.setOnClickListener {
            intent = Intent(applicationContext, ScrollView::class.java)
            startActivity(intent)
        }

        searchViewTask.setOnClickListener {
            intent = Intent(applicationContext, NestedScrollView::class.java)
            startActivity(intent)
        }

        webViewTask.setOnClickListener {
            intent = Intent(applicationContext, WebView::class.java)
            startActivity(intent)
        }

        animateTask.setOnClickListener {
            intent = Intent(applicationContext, WebView::class.java)
            startActivity(intent)
        }
    }
}