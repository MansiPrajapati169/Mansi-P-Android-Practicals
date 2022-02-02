package com.example.practicals.java_practicals;

interface InterfaceDemo {
    public void printFunction();
}

public class InterfaceExample implements InterfaceDemo {
    public void printFunction() {
        System.out.println("func is executed");
    }

    public static void main (String args[]) {
        InterfaceExample obj = new InterfaceExample();
        obj.printFunction();
    }
}
