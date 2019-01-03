package com.example.demo.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client {
    public byte[] data1;
    public byte[] data;
    public DatagramSocket receivingSocket;
    public DatagramSocket sendingSocket;
   public BufferedReader inFromUser;
    public InetAddress IPAddress;
    public String sentence;
    public int length;

    public void clientconnetion() throws SocketException, UnknownHostException {

        inFromUser = new BufferedReader(new InputStreamReader(System.in));
        receivingSocket = new DatagramSocket(6701);
        sendingSocket = new DatagramSocket();
        IPAddress = InetAddress.getByName("127.0.0.1");
        data = new byte[1024];


    }

    public void sendmessage()   {
         Thread T3 = new Thread(()->{
        while(true) {

            try {
                data1= new byte[1024];
                System.out.println("Please type you message: ");
                sentence = inFromUser.readLine();

                length = sentence.length();
                data1 = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(data1, length, IPAddress, 6710);
                sendingSocket.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        });
    T3.start();
    }

    public void resivemessage()   {

Thread T4= new Thread(()->{
while(true) {

    try {
        data= new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(data ,data.length);
        receivingSocket.receive(receivePacket);
        sentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + sentence.trim());
    } catch (IOException e) {
        e.printStackTrace();
    }
      data=new byte[0];

}
});
T4.start();
}

}
