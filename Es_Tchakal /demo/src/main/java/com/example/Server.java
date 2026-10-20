package com.example;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("SERVER AVVIATO");

        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        System.out.println("Client connesso!");

        GestoreLogica gestore = new GestoreLogica(s);
        gestore.esegui(); 
        
        ss.close();
    }
}
