package src;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * serveur
 */
public class serveur {
    private static ArrayList<Object> slist = new ArrayList<>();
    private static ArrayList<Object> rlist = new ArrayList<>();

    public static void main(String[] args) {
        serveur s = new serveur();
        s.ecouter();
    }

    public void ecouter() {
        ServerSocket socket;

        for (int i = 0; i < 10; i++) {
            slist.add(new fiche("marque" + i, "modele" + i, "couleur" + i, "immatriculation" + i));
        }

        try {
            socket = new ServerSocket(8003);
            System.out.println("Serveur en attente de connexion");

            while (true) {
                Socket socketClient = socket.accept();
                System.out.println("Connexion acceptee");

                Thread t = new monthread(socketClient, slist, rlist);
                System.out.println("Thread lance");
                t.start();
            }

        } catch (IOException e) {
            System.out.println("Erreur de connexion au serveur ");
        }
    }

}