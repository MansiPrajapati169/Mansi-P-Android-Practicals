package com.example.practicals.kotlin_practicals

open class parent {
    val name = "mansi"
}

class Inheritence : parent() {
    fun printName() {
        println("name :" + name)
    }
}

fun main() {
    val c1 = Inheritence()
    c1.printName()
}