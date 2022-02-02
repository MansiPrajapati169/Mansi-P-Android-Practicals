package com.example.practicals.kotlin_practicals

fun printN(name: String) {
    println("$name")
}

fun higherOrderFun(fun1: (name: String)-> Unit, name: String) {
    println("In higher order function")
}

fun main() {
    higherOrderFun(::printN, "Mansi")
}