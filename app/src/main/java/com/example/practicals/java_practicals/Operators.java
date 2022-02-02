package com.example.practicals.java_practicals;

import java.io.*;
import java.util.Scanner;
public class Operators {
    public static void main(String[] args) {
        int a = 10, b = 2;
        System.out.print("1.arithmetic"+"\n"+"2.relational"+"\n"+"3.bitwise"+"\n"+"4.logical"+"\n"+"5.assignment"+"\n"+"6.misc"+"\n");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        switch (str) {
            case "1" :  System.out.println("a + b = "+ (a + b));
                System.out.println("a - b = " + (a - b));
                System.out.println("a * b = " + (a * b));
                System.out.println("a / b = " + (a / b));
                System.out.println("a % b = " + (a % b));

            case "2" :  System.out.println(a == b);
                System.out.println(a != b);
                System.out.println(a > b);
                System.out.println(a < b);
                System.out.println(a >= b);
                System.out.println(a <= b);

            case "3" :  System.out.println("a&b = " + (a & b));
                System.out.println("a|b = " + (a | b));
                System.out.println("a^b = " + (a ^ b));
                System.out.println("~a = " + ~a);

            case "4" :
                System.out.println((a > 5) && (b > 1));
                System.out.println((a > 5) || (b > 3));
                System.out.println(!(a == b));

            case "5" :
                int var = a;
                System.out.println("var using =: " + var);
                var += a;
                System.out.println("var using +=: " + var);
                var *= a;
                System.out.println("var using *=: " + var);

            case "6" :
                System.out.println( "grater number is: " +  ((a > b) ? a : b ) );
        }
    }
}
