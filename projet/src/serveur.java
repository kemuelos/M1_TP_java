package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * serveur
 */
public class serveur {
    public static void main(String[] args) {
        ServerSocket serveur = null;

        try {
            serveur = new ServerSocket(8003);
            serveur.setReuseAddress(true);

            while (true) {
                System.out.println("En attente de connexion");
                Socket client = serveur.accept();
                System.out.println("Connexion etablie");

                ClientHandler clientSock = new ClientHandler(client);

                new Thread(clientSock).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serveur != null) {
                try {
                    serveur.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket = null;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            OutputStream os = clientSocket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Bonjour, vous etes connecte");
            pw.println(" vous êtes sur le port: " + clientSocket.getLocalPort());
            pw.flush();
            // os.close();

            // afficher message du client
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("Message du client: " + line);
                pw.flush();
                pw.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}