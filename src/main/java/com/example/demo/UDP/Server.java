package com.example.demo.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Server {
public byte[] data;
public byte[] data1;
public BufferedReader inFromUser;
public DatagramSocket receivingSocket;
public DatagramSocket sendingSocket;
public InetAddress IPAddress;
public String sentence;
public int length;

public void Connetion() throws UnknownHostException, SocketException {


     inFromUser = new BufferedReader(new InputStreamReader(System.in));
     receivingSocket = new DatagramSocket(6710);
     sendingSocket = new DatagramSocket();
     IPAddress = InetAddress.getByName("127.0.0.1");
}

public void sendmessage() {
    Thread T1=new Thread(()->{
    while(true) {

        try {

            System.out.println("Please type you message: ");
            sentence = inFromUser.readLine();
            length = sentence.length();
            data = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(data, length, IPAddress, 6701);
            sendingSocket.send(sendPacket);
            data=null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    });
    T1.start();
}

public void receivigmessage()
{

    Thread T2 = new Thread(() -> {

        while (true)
        {

            try
            {
                data1=new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(data1,data1.length);
                receivingSocket.receive(receivePacket);
                sentence = new String(receivePacket.getData());
                System.out.println("FROM Client:" + sentence.trim());
              data1=new byte[0];
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    });
    T2.start();
}

}
