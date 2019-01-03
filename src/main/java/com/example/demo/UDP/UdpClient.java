package com.example.demo.UDP;

public class UdpClient {
    public static void main(String args[]) throws Exception {
      Client client= new Client();
      client.clientconnetion();
      client.sendmessage();
      client.resivemessage();

    }
}