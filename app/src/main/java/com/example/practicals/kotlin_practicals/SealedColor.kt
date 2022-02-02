package com.example.practicals.kotlin_practicals

sealed class SealedColor {
    class Red : SealedColor()
    class Green : SealedColor()
    class Blue : SealedColor()
}

fun eval(c: SealedColor) =
    when (c) {
        is SealedColor.Red -> println("red")
        is SealedColor.Green -> println("green")
        is SealedColor.Blue -> println("blue")
    }

fun main() {
    val obj = SealedColor.Red()
    eval(obj)
}