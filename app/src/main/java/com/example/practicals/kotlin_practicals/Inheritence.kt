package com.example.practicals.kotlin_practicals

open class parent {
    val name = "mansi"
}
class Inheritence : parent() {
    fun printN() {
        println("name :" + name)
    }
}
fun main() {
    val c1 = Inheritence()
    c1.printN()
}