package com.example.demo.Model;

import java.util.Iterator;

public interface MyList<T> extends Iterator {


    int size();

    void add(T element);

    T get(int index);

    T set(int index, Object object);

    T remove(int index);

    String toString();
}
