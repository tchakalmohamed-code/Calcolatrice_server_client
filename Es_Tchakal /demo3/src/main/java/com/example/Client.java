package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Tentativo di connessione al server...");
        
        Socket s = new Socket("localhost", 3000);
        System.out.println("Connesso al server!");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\n 'exit' per uscire)");
            
            System.out.print("Inserisci il primo numero: ");
            String n1 = tastiera.readLine();
            out.println(n1);
            if(n1.equalsIgnoreCase("exit")) break;

            System.out.print("Inserisci il secondo numero: ");
            String n2 = tastiera.readLine();
            out.println(n2);
            if(n2.equalsIgnoreCase("exit")) break;

            System.out.print("Inserisci l'operatore (+, -, *, /): ");
            String segno = tastiera.readLine();
            out.println(segno);
            if(segno.equalsIgnoreCase("exit")) break;

            String risultato = in.readLine();
            System.out.println("RISULTATO DAL SERVER: " + risultato);
        }

        System.out.println("Chiusura client.");
        s.close();
    }
}