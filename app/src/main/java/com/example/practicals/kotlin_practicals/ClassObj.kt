package com.example.practicals.kotlin_practicals

class ClassObj {
    var name: String = "Mansi"
    fun printName() {
        print("Name : " + name)
    }
}

fun main() {
    val obj = ClassObj()
    obj.printName()
}