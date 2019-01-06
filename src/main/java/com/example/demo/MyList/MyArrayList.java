package com.example.demo.MyList;


public class MyArrayList<T> implements MyList<T> {

    private T[] data = (T[]) new Object[5];
    private int size;

    @Override
    public int size() {
        return size;

    }

    @Override
    public void add(T element) {
        indexsizechecker();
        data[size++] = element;

    }

    public void set(int index, T element) {
        data[index]=null;
        data[index]=element;

    }

    private void indexsizechecker() {
        if (size == data.length) {
            T[] temp = data;
            data = (T[]) new Object[size + 5];
            for (int i = 0; i < size; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("" + index);
        }
        return data[index];
    }

    @Override
    public T remove(int index) {
        T temp = data[index];
        for (int j = index + 1; j < size; j++) {
            data[j - 1] = data[j];
        }
        size--;
        data[size] = null;
        return temp;
    }

    @Override
    public String toString() {
        String result = "[" + data[0];
        for (int i = 1; i < size; i++) {
            result += ", " + data[i].toString();
        }
        return result + "]";
    }

    public void clear(){

        for (int i = size; i ==0 ; i--) {
              data[i]=null;

        }
        data = (T[]) new Object[5];
        size=0;

    }

}

