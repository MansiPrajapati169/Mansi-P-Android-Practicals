package com.example.practicals.java_practicals;


class Student{
    String name;
    public void fun1() {
        System.out.println("parent function");
    }
}
class Batch extends Student {
    public void show() {
        System.out.println("name : " + name);
    }
}

public class Inheritence{

    public static void main(String[] args) {
        Batch b = new Batch();
        b.name = "mansi";
        b.show();
        b.fun1();

    }
}
