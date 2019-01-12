package com.example.demo.Tcp;

import org.hibernate.mapping.Join;

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
    byte[] dataIn;
    Socket s;
    OutputStream output;
 ArrayList<ClientHandler> clients=new ArrayList<>();




    public void Connection() throws IOException {
        System.out.println("=============SERVER STARTED==============");
        ServerSocket server = new ServerSocket(PORT_LISTEN);

        while (true) {
            s = server.accept();
            output=s.getOutputStream();

            InputStream input = s.getInputStream();
            dataIn = new byte[1024];
            input.read(dataIn);
            String msgIn = new String(dataIn);
            msgIn = msgIn.trim();
            String Joinmsgin = msgIn.substring(0,4);
            String[] temp = msgIn.split("[., ]");
            String username=temp[1];


            System.out.println("Client trying to connect  <<" + username +">> " + s.getInetAddress().getHostAddress() + ":" + s.getPort());

            if (!doblicateusername(username) && !Joinmsgin.equals("JOIN ")){
                System.out.println("Client connection terminated, due duplicate username<<" + username +">> " + s.getInetAddress().getHostAddress() + ":" + s.getPort());

                String fail="Error:J_EOR JOIN not found OR username already exist, restart program and try again!!";
                byte[] send = fail.getBytes();
                output.write(send);

            }else {
                ClientHandler client = new ClientHandler(s, username);
                System.out.println("Client connected  <<" + username + ">> " + s.getInetAddress().getHostAddress() + ":" + s.getPort());
                clients.add(client);
                SendAndRecieve sendAndRecieve = new SendAndRecieve(client);
                sendAndRecieve.resivemessage(clients);
            }
            }

        }

            public boolean doblicateusername(String username){
              boolean b=true;
                for (int i = 0; i <clients.size() ; i++) {

                    if(username.equals(clients.get(i).getUsername())){
                        b=false;
                    }
                }

         return b;
    }

//     public void command() {
//         System.out.println("welcome admin!!");
//         Scanner scan = new Scanner(System.in);
//         Thread commandthread = new Thread(() -> {
//             while (true) {
//
//
//                 String serverCommands = scan.next();
//
//                 switch (serverCommands) {
//
//                     case "list":
//                         for (int i = 0; i < clients.size(); i++) {
//                             System.out.println(clients.get(i).getUsername());
//                         }
//                         break;
//
//                     case "kick":
//
//                         String closecommand="QUITCOMMAND";
//
//                         try {
//
//                             byte[] datatosend=closecommand.getBytes();
//                             output.write(datatosend);
//
//
//
//
//                         } catch (IOException e) {
//                             e.printStackTrace();
//                         }
//
//                         break;
//                         }
//
//
//                 }
//
//         });
//       commandthread.start();
//
//     }
     }






















