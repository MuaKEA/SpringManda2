package com.example.demo.threads;

import java.util.Date;

public class Run implements Runnable{


    private static Thread t = new Thread(new Run());

    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println(new Date());
            try {
                t.sleep(1000);
            }catch(InterruptedException IE) {
                IE.printStackTrace();
            }
        }


    }

    public static void main(String []args) {
        t.start();
    }




}