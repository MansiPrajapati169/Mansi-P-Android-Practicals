package com.example.practicals.kotlin_practicals

fun main() {
    try {
        val data = 5 / 0
    }
    catch (e: ArithmeticException) {
        println(e)
    }
    println("End")
}