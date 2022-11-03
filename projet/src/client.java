package src;

import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;

/**
 * client
 */
public class client {
    public static void main(String[] args) {

        String host = "127.0.0.1";
        int port = 8003;

        try (Socket socket = new Socket(host, port)) {
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Entrez votre nom : ");
            Scanner sc = new Scanner(System.in);
            String line = null;

            line = sc.nextLine();
            pw.println(line);
            pw.flush();
            System.out.println("Serveur:" + br.readLine());
            // sc.close();

            String line2 = null;
            System.out.println("entrez un message : ");
            line2 = sc.nextLine();
            pw.println(line2);
            pw.flush();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
