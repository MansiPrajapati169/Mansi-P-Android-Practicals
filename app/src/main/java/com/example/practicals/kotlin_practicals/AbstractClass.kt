package com.example.practicals.kotlin_practicals

abstract class AbstractClass {
    abstract fun run()
}
class s: AbstractClass() {
    override fun run() {
        println("hello")
    }
}
fun main() {
    val obj = s()
    obj.run();
}