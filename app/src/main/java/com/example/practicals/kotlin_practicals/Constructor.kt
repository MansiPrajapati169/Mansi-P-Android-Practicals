package com.example.practicals.kotlin_practicals

class Constructor(var finalstr : String) {
    constructor(str1: String, str2: String) : this(str1) {
        this.finalstr += str2
        print(finalstr)
    }
    init {
        finalstr += "B"
        print(finalstr)
    }
}

fun main() {
    Constructor("M","S")
    println()
    Constructor("M","D")
}