package com.example.demo.Tcp;


import java.net.Socket;

public class ClientHandler {

    public Socket s;
    public String username;


    public ClientHandler(Socket s, String username) {
        this.s = s;
        this.username = username;
    }

    public Socket getSocket() {
        return s;
    }

    public void setSocket(Socket s) {
        this.s = s;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
