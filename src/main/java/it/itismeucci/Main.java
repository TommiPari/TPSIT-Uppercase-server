package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Il server è partito!");
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        System.out.println("Qualcuno si è collegato!!");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaRicevuta;
        do {
            stringaRicevuta = in.readLine();
            if (stringaRicevuta.equals("0")) {
                System.out.println("Comunicazione terminata!");
            } else  {
                System.out.println("Stringa ricevuta: " + stringaRicevuta + "\n");
                out.writeBytes(stringaRicevuta.toUpperCase() + "\n");
            }
        } while (!stringaRicevuta.equals("0"));

        s.close();
        ss.close();
    }
}