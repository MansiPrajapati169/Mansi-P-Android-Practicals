package com.example.practicals.java_practicals;

public class IfForWhile {
    public static void main(String args[]) {
        int num = 10, i;
        System.out.print("List of even numbers from 1 to 10 " + "\n");
        for (i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.print("\n"+"List of odd numbers from 1 to 10 " + "\n");
        i = 0;
        while(i <= num) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
            i++;
        }
    }
}