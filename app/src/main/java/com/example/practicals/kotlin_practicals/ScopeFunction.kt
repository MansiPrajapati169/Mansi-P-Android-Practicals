package com.example.practicals.kotlin_practicals

class ScopeFunction {
    var name : String = ""
    var id : Int = 0
}

fun main() {
    val student = ScopeFunction().apply {
        name = "mansi"
        id = 123
    }

    val result : Int = with(student) {
        println(name)
        id
    }

    println(result)
    student?.run{
        println(name)
    }

    ScopeFunction().also {
        it.name = "bansi"
        println("${it.name}")
    }

    val name: String? = "stuti"
    val results = name?.let { str ->
        str.uppercase()
    }
    println("$results")
}