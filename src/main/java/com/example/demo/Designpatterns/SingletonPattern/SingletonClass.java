package com.example.demo.Designpatterns.SingletonPattern;

public class SingletonClass {
    private String name;
    private int age;

    private static SingletonClass ourInstance = new SingletonClass("sigurt",24);


    private SingletonClass(String name, int age) {
    this.age=age;
    this.name=name;
    }

    public static SingletonClass getInstance() {
        return ourInstance;
    }

    public String toString() {
        return "SingletonClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
