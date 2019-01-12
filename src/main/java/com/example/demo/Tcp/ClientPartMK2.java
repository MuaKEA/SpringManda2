package com.example.demo.Tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientPartMK2 {
   private static Scanner sc = new Scanner(System.in);
   private static InputStream input;
   private static OutputStream output;
   private static Socket socket;
   private static byte[] dataToSend;
   private static boolean closeapplication;

   public static void ClientStartop() throws IOException {
       System.out.println("=============CLIENT==============");
       closeapplication=false;
       sc = new Scanner(System.in);
       System.out.print("enter username ");
       String username = sc.next();
       System.out.print("What is the IP for the server (type 0 for localhost): ");
       String IP = sc.next();
       if (IP.equals("0")) {
           IP = "127.0.0.1";
       }else
           if(IP.equals("1")){
               System.out.println("enter the ip of the Server");
              IP=sc.next();
       }
           System.out.print("What is the PORT for the server: ");
       int PORT_SERVER = sc.nextInt();
       socket = new Socket(IP, PORT_SERVER);
       input = socket.getInputStream();
       output = socket.getOutputStream();
       String JOIN="JOIN " +  username + "," + IP + ": " + PORT_SERVER;
       dataToSend = JOIN.getBytes();
       output.write(dataToSend);
   }

        public static void sendmessageTOserver(){
       Thread T1= new Thread(()->{

           outerloop:
while (true) {



    sc = new Scanner(System.in);
    System.out.println("Type message");
    String msgToSend = sc.nextLine();

    try {
        if (msgToSend.equals("QUIT")) {
            System.out.println("yes or no");
            String Answer=sc.next();

               if(Answer.equals("yes")) {
                   dataToSend=msgToSend.getBytes();
                   output.write(dataToSend);
                   closeapplication=true;
                   break outerloop;
               }
        }
            dataToSend = msgToSend.getBytes();
        output.write(dataToSend);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

         });
        T1.start();


   }

        public static void resivemessage()  {


            Thread T1= new Thread(()->{
      outerloop:
       while(true) {

               try {
                   byte[] dataIn = new byte[1024];
                   input.read(dataIn);
                   String msgIn = new String(dataIn);
                   msgIn = msgIn.trim();
                   System.out.println(msgIn);

                   if(msgIn.contains("Error:J_EOR") || closeapplication){
                       closeapplication=true;
                      break outerloop;
                   }

               } catch (IOException e) {
                   e.printStackTrace();
               }

       }
            });
            T1.start();
        }





    }




