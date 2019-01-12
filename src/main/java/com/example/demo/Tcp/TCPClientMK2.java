package com.example.demo.Tcp;

import java.io.IOException;

import static com.example.demo.Tcp.ClientPartMK2.*;


public class TCPClientMK2 {

    public static void main(String[] args) throws IOException {
       ClientStartop();
       sendmessageTOserver();
       resivemessage();
    }
}