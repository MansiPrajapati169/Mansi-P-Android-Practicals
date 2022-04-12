package com.example.practicals.architecture.mvc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicals.R
import com.example.practicals.architecture.mvc.controller.StudentController
import com.example.practicals.architecture.mvc.model.StudentData
import com.example.practicals.databinding.ActivityStudentDetailsBinding
import kotlinx.android.synthetic.main.activity_student_details.*

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var controller : StudentController
    private var model = StudentData()
    private lateinit var binding: ActivityStudentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {
        controller = StudentController(model,this)

        btnSubmit.setOnClickListener {
            controller.setName(etStudentName.text.toString())
            controller.setRollNo(etRollNo.text.toString())
            controller.updateView()
        }
    }

    fun printDetails(name: String?, rollNo: String?) {
        Toast.makeText(this, getString(R.string.txt_student_alert,name,rollNo), Toast.LENGTH_SHORT).show()
    }
}