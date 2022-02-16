package com.example.practicals.activity_intent_fragment_practicals.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_android_dtasks.*

class AndroidDTasks : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_dtasks)

        androidDTasks()
    }

    private fun androidDTasks() {
        fragmentNavTask.setOnClickListener {
            intent = Intent(applicationContext, FragmentContainerActivity::class.java)
            startActivity(intent)
        }

        jetpackNavTask.setOnClickListener {
            intent = Intent(applicationContext, JetpackNavActivity::class.java)
            startActivity(intent)
        }
    }
}