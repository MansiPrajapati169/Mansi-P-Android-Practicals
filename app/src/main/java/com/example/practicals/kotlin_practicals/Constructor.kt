package com.example.practicals.kotlin_practicals

class Constructor(var s : String) {
    constructor(t: String, u: String) : this(t) {
        this.s += u
        print(s)
    }
    init {
        s += "B"
        print(s)
    }
}
fun main()
{
    Constructor("M","S")
    println()
    Constructor("M","D")
}