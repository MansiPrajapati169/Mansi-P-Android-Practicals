package com.example.practicals.kotlin_practicals

class EnumTest {
}
enum class Color{
    RED, MEDIUM, LARGE
}
fun main() {
    val myFav = Color.RED
    println("My fav color is $myFav")
}