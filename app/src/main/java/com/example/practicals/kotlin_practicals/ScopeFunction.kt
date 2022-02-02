package com.example.practicals.kotlin_practicals

class ScopeFunction {
    var name : String = ""
    var id : Int = 0
}

fun main() {
    val s1 = ScopeFunction().apply {
        name = "mansi"
        id = 123
    }

    val result : Int = with(s1) {
        println(name)
        id
    }

    println(result)
    s1?.run{
        println(name)
    }

    ScopeFunction().also {
        it.name = "bansi"
        println("${it.name}")
    }

    val name: String? = "stuti"
    val result1 = name?.let { str ->
        str.uppercase()
    }
    println("$result1")
}