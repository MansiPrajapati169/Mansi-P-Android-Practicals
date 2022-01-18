package com.example.practicals.kotlin_practicals

class IfForWhile {
}
fun main() {
    var num:Int = 10
    var j:Int = 1
    print("even ")
    for (i in 1..num)
        if(i%2==0)print("$i ")
    println()

    print("odd ")
    var i:Int = 1
    while(i<num) {
        if(i%2!=0)print("$i ")
        i++
    }
}