package com.example.practicals.layout_practicals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_layouts.*

class Layouts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layouts)

        layoutTasks()
    }

    private fun layoutTasks() {
        relativeLayout.setOnClickListener {
            intent = Intent(applicationContext, RelativeLayout::class.java)
            startActivity(intent)
        }

        linearLayout.setOnClickListener {
            intent = Intent(applicationContext, LinearLayout::class.java)
            startActivity(intent)
        }

        constraintLayout.setOnClickListener {
            intent = Intent(applicationContext, ConstraintLayout::class.java)
            startActivity(intent)
        }

        tableLayout.setOnClickListener {
            intent = Intent(applicationContext, TableLayout::class.java)
            startActivity(intent)
        }

        frameLayout.setOnClickListener {
            intent = Intent(applicationContext, FrameLayout::class.java)
            startActivity(intent)
        }
    }
}

