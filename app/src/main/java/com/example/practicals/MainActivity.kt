package com.example.practicals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.architecture.ArchitectureTasksActivity
import com.example.practicals.activity_intent_fragment_practicals.Activities.AndroidDTasks
import com.example.practicals.android_permission_model.PermissionActivity
import com.example.practicals.layout_practicals.Layouts
import com.example.practicals.recycler_list_practicals.Activities.ListRecyclerViewPager
import com.example.practicals.ui_widget.RegistrationForm
import com.example.practicals.web_services.LoginActivity
import com.example.practicals.views.ScrollView
import com.example.practicals.views.ViewTasksActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        androidTasks()
    }

    private fun androidTasks() {
        uiWidget.setOnClickListener {
            intent = Intent(applicationContext, RegistrationForm::class.java)
            startActivity(intent)
        }

        uiLayouts.setOnClickListener {
            intent = Intent(applicationContext, Layouts::class.java)
            startActivity(intent)
        }

        recyclerViewAdapters.setOnClickListener {
            intent = Intent(applicationContext, ListRecyclerViewPager::class.java)
            startActivity(intent)
        }

        views.setOnClickListener {
            intent = Intent(applicationContext, ViewTasksActivity::class.java)
            startActivity(intent)
        }

        recyclerViewAdapters.setOnClickListener {
            intent = Intent(applicationContext, ListRecyclerViewPager::class.java)
            startActivity(intent)
        }

        activityFragment.setOnClickListener {
            intent = Intent(applicationContext, AndroidDTasks::class.java)
            startActivity(intent)
        }

        webService.setOnClickListener {
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

        btnArchitecture.setOnClickListener {
            intent = Intent(applicationContext, ArchitectureTasksActivity::class.java)
            startActivity(intent)
        }

        btnPermissionModel.setOnClickListener {
            intent = Intent(applicationContext, PermissionActivity::class.java)
            startActivity(intent)
        }
    }
}