package com.example.practicals.java_practicals;

import java.io.*;

public class ExceptionTest {
    public static void main(String args[]) {
        try {
            int array[] = new int[5];
            System.out.println("Access element on index 6 :" + array[6]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
        }
        System.out.println("finish");
    }
}
