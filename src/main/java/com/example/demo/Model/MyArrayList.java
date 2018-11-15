package com.example.demo.Model;
import java.lang.reflect.Type;
import java.util.*;

public class MyArrayList<T> implements MyList {
    private int size = 0;
    public  Object[] myArraylist = new Object[5];

    @Override
    public int size() {


        return size;
    }

    @Override
    public void add(Object object) {

        if (myArraylist.length == size) {
            myArraylist = Arrays.copyOf(myArraylist, size * 2);
        }
        myArraylist[size] = object;
        size++;


    }


    @Override
    public Object get(int index) {

        return myArraylist[index];
    }

    @Override
    public Object remove(int index) {//skal uddybes
        myArraylist[index] = null;
        size--;

        for (int i = 0; i < myArraylist.length; i++) {
            if (myArraylist[i] == null) {
                for (int k = i + 1; k < myArraylist.length; k++) {//rykker pladserne for at få i det næste index
                    myArraylist[k - 1] = myArraylist[k];//
                }
                myArraylist[myArraylist.length - 1] = null;//det sidste index i arrayet er = null
                break;
            }
        }
        return myArraylist;
    }

    @Override
    public Object set(int index, Object object) {
        if (myArraylist[index] == null) {
            myArraylist[index] = object;
        }else {
            for(int i = 0; i < myArraylist.length; i++){

            }
        }


        return myArraylist;

    }

    @Override
    public String toString() {
        String result = "[";
        for(int i = 0; i < size(); i++) {
            result += myArraylist[i];
            if(i != size-1){//skal uddybes
                result += ", ";
            }
        }


        return result + "]";
    }


}
