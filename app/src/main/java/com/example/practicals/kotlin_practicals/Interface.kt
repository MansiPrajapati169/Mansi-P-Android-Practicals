package com.example.practicals.kotlin_practicals

interface Interface {
    fun printGreet()
}

class Greet : Interface {
    override fun printGreet() {
        println("Good morning")
    }
}

fun main() {
    val obj = Greet()
    obj.printGreet()
}