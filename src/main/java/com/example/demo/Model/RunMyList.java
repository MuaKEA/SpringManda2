package com.example.demo.Model;

public class RunMyList {

    public static void main(String[] args) {

        myArrayList<?> letters = new myArrayList<>();

        System.out.println("Size of the list is: " + letters.size());

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
//          letters.add("F");
//          letters.add("G");

        System.out.println("Size of the list is: " + letters.size());

        int indexToGet = 3;
        System.out.println("The element on index " + indexToGet + " is " + letters.get(indexToGet));

        int indexToRemove = 2;
        System.out.println("The element " + letters.remove(indexToRemove) + " from index " + indexToRemove);
        System.out.println("Size of the list is: " + letters.size());

        System.out.println(letters);

    }

}
