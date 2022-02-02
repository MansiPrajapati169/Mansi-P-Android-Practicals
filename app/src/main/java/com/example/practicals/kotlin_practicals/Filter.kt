package com.example.practicals.kotlin_practicals

fun main() {

    val list = listOf("Mansi","JM","bansi","taehyung","JK")
    println("${list.filter { it.length > 3 }}")

    println("${list.filterIndexed { index, s ->(index != 0) && (s.length < 4)}}")

    println("Any "+list.any { it.endsWith("i") })
    println("None "+list.none { it.startsWith("a") })
    println("All "+list.all { it.endsWith("i") })

    val (first, second) = list.partition { it.length > 3 }
    println(first)
    println(second)

    val list1 : MutableList<Int> = (1..10).toMutableList()
    println("${list1.filter{ it % 2 == 0 }}"  )
    println("${list1.filterNot { it % 2 == 0 }}"  )
}