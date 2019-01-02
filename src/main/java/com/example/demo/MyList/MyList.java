package com.example.demo.MyList;

public interface MyList<T> {

    /**
         * Returns the size of the list (how many elements are in the list)
         * @return
         */
        int size();
        void add(T el);
        T get(int index);
        T remove(int index);
        String toString();
    }