package com.example.practicals.java_practicals;

interface A
{
    public void func1();
}
public class Interface1 implements A
{
    public void func1() {
        System.out.println("func1 is executed");
    }

    public static void main (String args[])
    {
        Interface1 obj = new Interface1();
        obj.func1();
    }
}
