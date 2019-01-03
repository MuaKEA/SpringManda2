package com.example.demo.MyList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mylistmain {


    public static void main(String[] args) {
        MyArrayList<String> letters = new MyArrayList<>();

        System.out.println("Size of the list is: " + letters.size());

        letters.add("a");
        letters.add("b");
        letters.add("c");
        letters.add("d");
        letters.add("e");
        letters.add("f");
        letters.add("g");
        letters.add("h");

        System.out.println(letters);



        System.out.println("Size of the list is: " + letters.size());

        int indexToGet = 3;
        System.out.println("The element on index " + indexToGet + " is " + letters.get(indexToGet));

        int indexToRemove = 2;
        System.out.println("The element " + letters.remove(indexToRemove) + " from index " + indexToRemove);
        System.out.println("The element " + letters.remove(indexToRemove) + " from index " + indexToRemove);
       System.out.println("Size of the list is: " + letters.size());
        System.out.println(letters);

       letters.set(2,"ZZ");
       letters.set(3,"WW");
        System.out.println(letters);

    }





 }




