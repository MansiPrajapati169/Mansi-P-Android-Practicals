package com.example.practicals.java_practicals;

class Student {
    String name;
    public void baseFun() {
        System.out.println("parent function");
    }
}

class Batch extends Student {
    public void show() {
        System.out.println("name : " + name);
    }
}

public class Inheritence {
    public static void main(String[] args) {
        Batch batch = new Batch();
        batch.name = "mansi";
        batch.show();
        batch.baseFun();

    }
}
