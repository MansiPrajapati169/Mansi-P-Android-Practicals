package com.example.practicals.kotlin_practicals

class HigherOrder {

}

fun printN(name: String) {
    println("$name")
}

fun hOF(fun1: (name: String)-> Unit, name: String) {
    println("In higher order function")
}

fun main() {
    hOF(::printN, "Mansi")
}