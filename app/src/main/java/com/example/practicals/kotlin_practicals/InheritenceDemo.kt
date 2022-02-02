package com.example.practicals.kotlin_practicals

open class parent {
    val name = "mansi"
}

class InheritenceDemo : parent() {
    fun printName() {
        println("name :" + name)
    }
}

fun main() {
    val inherit = InheritenceDemo()
    inherit.printName()
}