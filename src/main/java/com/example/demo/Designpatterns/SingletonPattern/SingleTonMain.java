package com.example.demo.Designpatterns.SingletonPattern;

import java.util.ArrayList;

public class SingleTonMain {


    public static void main(String[] args) {
        SingletonClass stc=SingletonClass.getInstance();
        System.out.println(stc);

    }
}
