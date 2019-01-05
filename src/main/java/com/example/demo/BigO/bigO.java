package com.example.demo.BigO;


import java.util.*;

public class bigO {
    static int array[] = new int[1000000];
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static LinkedList<Integer> linkedList = new LinkedList<>();
    static HashMap<Integer, Object> hasmap = new HashMap();
    static int numb;
    static Long startTime;

    public static void main(String[] args) {
        arrayfiller();
        menu();
    }


    public static void arrayfiller() {
        for (int i = 0; i < 1000000; i++) {
            array[i] = i;
            arrayList.add(i);
            linkedList.add(i);
            hasmap.put(i, i);


        }


    }





    public static void arraylistandlinkedlist(List T) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number 0-100000");
         numb = scan.nextInt();
         startTime = System.currentTimeMillis();
        for (int i = 0; i < T.size(); i++) {
            if (T.get(i).equals(numb)) {
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println(elapsedTime + " milliseconds");
            }
        }


    }


    public static void arraytimer(int[] a) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a number 0-100000");
        numb = scan.nextInt();
         startTime = System.currentTimeMillis();
        System.out.println(startTime);
        for (int i = 0; i < a.length; i++) {

            if (a[i] == numb) {
                long stopTime = System.currentTimeMillis();
                System.out.println(stopTime);
                long elapsedTime = stopTime - startTime;
                System.out.println(elapsedTime +" milliseconds");

            }

        }
    }

public static void hashmaptimer() {
    System.out.println("enter a number 0-100000");
    Scanner scan = new Scanner(System.in);
    numb = scan.nextInt();
    startTime = System.currentTimeMillis();
    for (int i = 0; i < hasmap.size(); i++) {

        if (hasmap.get(i).equals(numb)) {
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(elapsedTime + " milliseconds");
        }
    }
}


            public static void menu() {
        Scanner scan = new Scanner(System.in);
        int number;

        do {
            System.out.println("1. arraylist 2.Linkedlist 3.Hashmap 4. int array 5.run all at once");
            number = scan.nextInt();

            switch (number) {

                case 1:
                    arraylistandlinkedlist(arrayList);

                    break;

                case 2:
                    arraylistandlinkedlist(linkedList);
                    break;

                case 3:
                hashmaptimer();

                    break;


                case 4:
                    arraytimer(array);
                    break;

                case 5:
                    arraytimer(array);
                    arraylistandlinkedlist(arrayList);
                    arraylistandlinkedlist(linkedList);
                    hashmaptimer();
                    break;

            }


        }while(number!=-1);
    }
}

