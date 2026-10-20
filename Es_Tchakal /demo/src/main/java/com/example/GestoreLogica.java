package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestoreLogica {
    private Socket s;

    public GestoreLogica(Socket s) {
        this.s = s;
    }

    public void esegui() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        while (true) {
            String n1 = in.readLine();
            String n2 = in.readLine();
            String segno = in.readLine();
            
            if (n1 == null || n2 == null || segno == null || 
                n1.equalsIgnoreCase("exit") || n2.equalsIgnoreCase("exit") || segno.equalsIgnoreCase("exit")) {
                System.out.println("Chiusura connessione...");
                break;
            }

            System.out.println("Ricevuto: " + n1 + " " + segno + " " + n2);

            double N1 = Double.parseDouble(n1);
            double N2 = Double.parseDouble(n2);

            if (segno.equals("+")) {
                out.println(N1 + N2);
            } else if (segno.equals("-")) {
                out.println(N1 - N2);
            } else if (segno.equals("*")) {
                out.println(N1 * N2);
            } else if (segno.equals("/")) {
                if (N2 == 0) {
                    out.println("ERR-0:divided_by_zero");
                } else {
                    out.println(N1 / N2);
                }
            } else {
                out.println("Operatore non valido");
            }
        }
        
        s.close(); 
    }
}
