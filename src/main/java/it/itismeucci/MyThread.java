package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread extends Thread {
    private Socket s;
    
    public MyThread(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
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
        } catch (IOException e) {
            System.out.println("IOException!!");
        }
    }
}
