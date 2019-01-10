package com.example.demo.Tcp;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SendAndRecieve {

public ClientHandler clientHandler;

    public SendAndRecieve(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public void resivemessage(ArrayList<ClientHandler> clients) {

        new Thread(() -> {
            InputStream input;
            while (true) {
                try {
                    input = clientHandler.getSocket().getInputStream();
                    byte[] dataIn = new byte[1024];
                    input.read(dataIn);
                    String msgIn = new String(dataIn);
                    msgIn = msgIn.trim();

                    if(msgIn.equals("QUIT")){

                        for (int i = 0; i <clients.size() ; i++) {
                            if (clients.get(i).getUsername().equals(clientHandler.getUsername())){
                                clients.get(i).getSocket().close();
                                clients.remove(i);

                                break;
                            }
                        }

                    }


                    String msgToSend="message From-->" + clientHandler.getUsername() + "--> " + msgIn + "<--";
                   System.out.println(msgToSend);



                    for (int i = 0; i < clients.size(); i++) {

                       if(!clientHandler.getUsername().equals(clients.get(i).getUsername())) {
                           System.out.println(clients.get(i).getUsername() + " inside if statement");
                           System.out.println(clients.get(i).getUsername() + " " + i);
                           byte[] dataToSend = msgToSend.getBytes();
                           clients.get(i).getSocket().getOutputStream().write(dataToSend);
                       }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }





}
