package com.example.practicals.java_practicals;

enum Color {
    RED,BLUE,BLACK
}

class PickColor {

    Color myfav;
    public PickColor(Color myfav) {
        this.myfav = myfav;
    }

    public void printColor() {
        switch(myfav) {
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case BLACK:
                System.out.println("black");
                break;
            default:
                System.out.println("white");
                break;
        }
    }
}

public class EnumTest {
    
    public static void main(String[] args) {
        PickColor c1 = new PickColor(Color.BLACK);
        c1.printColor();
    }
}

