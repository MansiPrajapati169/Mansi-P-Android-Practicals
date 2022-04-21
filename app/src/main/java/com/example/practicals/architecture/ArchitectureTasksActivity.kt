package com.example.practicals.architecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import com.example.practicals.architecture.mvc.view.StudentDetailsActivity
import com.example.practicals.architecture.mvp.view.LoginMvpActivity
import com.example.practicals.architecture.mvvm.view.EditProfileActivity
import kotlinx.android.synthetic.main.activity_architecture_tasks.*

class ArchitectureTasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture_tasks)

        architectureTasks()
    }

    private fun architectureTasks() {

        btnMvp.setOnClickListener {
            intent = Intent(applicationContext, LoginMvpActivity::class.java)
            startActivity(intent)
        }

        btnMvc.setOnClickListener {
            intent = Intent(applicationContext, StudentDetailsActivity::class.java)
            startActivity(intent)
        }

        btnMvvm.setOnClickListener {
            intent = Intent(applicationContext, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }

}