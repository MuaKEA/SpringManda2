package com.example.demo.Model;
public interface MyList<T> {


    int size();
    void add(T element);
    T get(int index);
    T set(int index,Object object);
    T remove(int index);
    String toString();
}
