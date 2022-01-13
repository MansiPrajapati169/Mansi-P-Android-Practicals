package com.example.practicals.kotlin_practicals;

public class Operators {
}
fun main() {
    var a=10;
    var b=2;

    println("Arithmetic")
    println("a+b : "+(a+b))
    println("a-b : "+(a-b))
    println("a*b : "+(a*b))
    println("a/b : "+(a/b))
    println("a%b : "+(a%b))
    println()

    println("Relational")
    println("a>b : "+(a>b))
    println("a<b : "+(a<b))
    println("a>=b : "+(a>=b))
    println("a<=b : "+(a<=b))
    println("a==b : "+(a==b))
    println("a!=b : "+(!(a.equals(b))))
    println()

    println("Unary")
    println("+a :"+ ++a)
    println("-b :"+ b--)
    println("++a :"+ ++a)
    println("--b :"+ --b)
    println()

    println("Logical")
    println((a > 5) && (b > 1))
    println((a > 5) || (b > 3))
    println(!(a == b))
    println()

    println("Assignment")
    a=10
    b=2
    a+=b
    println("a+=b : "+a)
    a-=b
    println("a-=b : "+a)
    a*=b
    println("a*=b : "+a)
    a/=b
    println("a/=b :"+a)
    a%=b
    println("a%=b :"+a)
    println()

    println("Bitwise")
    println("a.and(b): "+a.and(b))
    println("a.or(b): "+a.or(b))
    println("a.xor(b): "+a.xor(b))
    println("a.inv(): "+a.inv())
    println("a.shl(b): "+a.shl(b))
    println("a.shr(b): "+a.shr(b))
}
