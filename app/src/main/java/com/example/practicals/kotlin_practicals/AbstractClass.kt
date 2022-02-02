package com.example.practicals.kotlin_practicals

abstract class AbstractClass {
    abstract fun run()
}

class Hello: AbstractClass() {
    override fun run() {
        println("hello")
    }
}

fun main() {
    val obj = Hello()
    obj.run();
}