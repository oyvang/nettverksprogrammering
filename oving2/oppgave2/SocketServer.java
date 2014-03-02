package oving2.oppgave2;

/**
 * Created by GeirMorten on 02.03.14.
 */
import java.io.*;
import java.net.*;

class SocketServer {
    public static void main(String[] args) throws IOException {
        final int PORTNR = 1250;

        ServerSocket tjener = new ServerSocket(PORTNR);
        System.out.println("Logg for tjenersiden. Nå venter vi...");

        while (true) {
            Socket forbindelse = tjener.accept();  // venter inntil noen tar kontakt
            Thread trad = new ThreadClientController(forbindelse);
            trad.start();
        }
    }
}
