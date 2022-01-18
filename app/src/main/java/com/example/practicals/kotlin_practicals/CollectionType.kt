package com.example.practicals.kotlin_practicals

class CollectionType {

}
fun main() {
    var list1 = listOf<String>("Mansi", "Bansi", "Stuti")
    for(item in list1) {
        println(item)
    }

    val myMap = mapOf<Int,String>(1 to "Mansi", 2 to "bansi", 3 to "stuti")
    for(key in myMap.keys) {
        println(myMap[key])
    }

    val set1 = setOf("Mansi" , "bansi", "stuti")
    val set2 = setOf( 1 ,2 , 3 , 4 )
    for(item in set1)
        println( item )
    for(item in set2)
        println( item )
}