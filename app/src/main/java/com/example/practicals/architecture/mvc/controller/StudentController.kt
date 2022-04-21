package com.example.practicals.architecture.mvc.controller

import com.example.practicals.architecture.mvc.view.StudentDetailsActivity
import com.example.practicals.architecture.mvc.model.StudentData

class StudentController(var model: StudentData, var view: StudentDetailsActivity) {

    private fun getRollNO(): String? {
        return model.rollNo
    }

    private fun getName(): String? {
        return model.name
    }

    fun setName(name: String) {
        model.name = name
    }

    fun setRollNo(roll: String) {
        model.rollNo = roll
    }

    fun updateView() {
        view.printDetails(getName(), getRollNO())
    }
}