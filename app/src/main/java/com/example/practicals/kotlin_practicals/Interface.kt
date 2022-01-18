package com.example.practicals.kotlin_practicals

interface Interface {
    fun printG()
}

class B : Interface {
    override fun printG() {
        println("Good morning")
    }
}
fun main() {
    val obj = B()
    obj.printG()
}