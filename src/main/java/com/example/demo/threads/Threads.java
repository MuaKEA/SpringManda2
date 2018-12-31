package com.example.demo.threads;

public class Threads  {
 static String thread1;
 static String thread2;


public static void main(String [] args) {



       Thread t = new Thread(()->{

           for (int i = 0; i <200 ; i++) {


               print(thread1);
           }
    });
    t.setName("t");
    thread1=t.getName();



    Thread t2 = new Thread(()->{
        for (int i = 0; i <200 ; i++) {


            print(thread2);
        }
    });
    t2.setName("t2");
    thread2=t2.getName();
    t2.start();
    t.start();
    }


public  static void print(String name){

    System.out.println("hallo world " + name );
}

}
