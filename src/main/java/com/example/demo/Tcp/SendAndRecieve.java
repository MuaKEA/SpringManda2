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
                    clientHandler.getUsername();
                    byte[] dataIn = new byte[1024];
                    input.read(dataIn);
                    String msgIn = new String(dataIn);
                    msgIn = msgIn.trim();

                    if(msgIn.equals("QUIT") || !clientHandler.getSocket().getInetAddress().isReachable(1000)){
                        for (int i = 0; i <clients.size() ; i++) {
                            if (clients.get(i).getUsername().equals(clientHandler.getUsername())){
                                System.out.println( clientHandler.getUsername() +"has been kicked out due to not client socket not responding ");

                                clients.remove(i);
                                clientHandler.getSocket().close();
                                System.out.println("socket has been closed true if yes:> " + clientHandler.getSocket().isClosed());

                                break;
                            }
                        }
                        break;
                    }else {


                        String msgToSend = "message From-->" + clientHandler.getUsername() + "--> " + msgIn + "<--" + " " + clientHandler.getSocket().getPort();


                        for (int i = 0; i < clients.size(); i++) {

                            if (!clientHandler.getUsername().equals(clients.get(i).getUsername())) {
                                byte[] dataToSend = msgToSend.getBytes();
                                clients.get(i).getSocket().getOutputStream().write(dataToSend);

                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }





}
