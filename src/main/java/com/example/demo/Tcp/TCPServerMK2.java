package com.example.demo.Tcp;

import java.io.IOException;
import java.util.ArrayList;


public class TCPServerMK2 {
    public static void main(String[] args) throws IOException {
        ServerPartMK2 server= new ServerPartMK2();
        server.Connection();
    }
}