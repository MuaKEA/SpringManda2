package com.example.demo.Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class ServerPartMK2  {

    final int PORT_LISTEN = 5656;
    String clientIp;
    byte[] dataIn;
    byte[] dataToSend;
    boolean usergodkend;
    Socket s;
    OutputStream output;
    InputStream input;
    public void Connection() throws IOException {
        usergodkend = false;
        System.out.println("=============SERVER==============");

        ServerSocket server = new ServerSocket(PORT_LISTEN);


             s = server.accept();


            System.out.println("New client request received : " + s);
            System.out.println("Client connected");
            clientIp = s.getInetAddress().getHostAddress();
            System.out.println("IP: " + clientIp);
            System.out.println("PORT: " + s.getPort());
            resivemessage();
            sendmessageToclient();

        }



    public  void resivemessage() {

         new Thread(() -> {
            InputStream input;
            while (true) {
                try {
                    input = s.getInputStream();
                    dataIn = new byte[1024];
                    input.read(dataIn);
                    String msgIn = new String(dataIn);
                    msgIn = msgIn.trim();
                    System.out.println(msgIn);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


        public void sendmessageToclient() {
            Thread T1= new Thread(()->{
              Scanner scan= new Scanner(System.in);
                OutputStream output;
                while(true) {

                 try {
                     System.out.println("type message");
                     String msgIn=scan.nextLine();
                     output = s.getOutputStream();
                     String msgToSend = "SERVER: [sender:" + clientIp + " ]: " + msgIn;
                     dataToSend = msgToSend.getBytes();
                     output.write(dataToSend);


                 } catch (IOException e) {
                     e.printStackTrace();
                 }



            }
            });
            T1.start();
            }




}
















