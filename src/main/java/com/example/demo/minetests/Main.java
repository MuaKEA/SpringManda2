package com.example.demo.minetests;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
       int j=0;
       int k =1;
       double n=10;
       int m=7;
        for (int i = 0; i<2 ; i++) {
            System.out.println(i);
            j+=2;
            k*=10;
            n/=2;
            m-=2;
        }
        System.out.println("plus= " +  j + " minus= " + m + " gange ="+ k + " dividere= " + n  );

    }

}


