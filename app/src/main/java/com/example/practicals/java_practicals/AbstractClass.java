package com.example.practicals.java_practicals;

abstract class Car {
    public abstract void carCompany();
    public void carColor() {
        System.out.println("black");
    }
}

class CarDetails extends Car {
    public void carCompany() {
        System.out.println("Hyundai");
    }
}

public class AbstractClass{
    public static void main(String[] args) {
        CarDetails c1 = new CarDetails();
        c1.carCompany();
        c1.carColor();
    }
}
