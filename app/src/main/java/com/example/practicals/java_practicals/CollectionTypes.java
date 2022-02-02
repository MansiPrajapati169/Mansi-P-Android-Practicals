package com.example.practicals.java_practicals;
import java.util.*;

public class CollectionTypes {
    public static void main(String[] args) {
        ArrayList<String> oop = new ArrayList<String>();
        oop.add("object");
        oop.add("class");
        oop.add("methods");
        oop.add("interface");
        System.out.println("after adding :" + oop);
        System.out.println("first item is :" + oop.get(0));
        oop.set(0, "instance");
        System.out.println("after setting :" + oop);
        System.out.println("\n");

        List<Integer> num = new ArrayList<>();
        num.add(10);
        num.add(20);
        num.add(30);
        System.out.println("element on pos 1: " + num.get(1));
        System.out.println("Removed Element: " + num.remove(2));
        System.out.println("\n");

        LinkedList<String> trainee = new LinkedList<String>();
        trainee.add("Mansi");
        trainee.addLast("Bansi");
        trainee.addFirst("Harshita");
        trainee.add(2, "Krupa");
        System.out.println(trainee);
        trainee.remove(3);
        trainee.removeFirst();
        trainee.removeLast();
        System.out.println(trainee);

        HashMap<String, Integer> people = new HashMap<String, Integer>();
        people.put("Mansi", 20);
        people.put("Bansi", 21);
        people.put("Stuti", 22);
        for (String i : people.keySet()) {
            System.out.println("key: " + i + " value: " + people.get(i));
        }
    }
}
