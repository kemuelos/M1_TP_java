package src;

import java.io.*;
import java.lang.reflect.Field;
import java.util.*;
import java.net.Socket;

/**
 * client
 */
public class client {

    public static void remplirFiche(Object o) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> type_primitif = new ArrayList<String>(
                Arrays.asList("int", "float", "double", "long", "boolean", "char", "byte", "short"));

        for (Field f : o.getClass().getDeclaredFields()) {
            System.out.println(
                    "Veuillez saisir la valeur de l'attribut " + f.getName() + " de type " + f.getType().getName());
            String value = sc.nextLine();
            if (type_primitif.contains(f.getType().getName())) {
                try {
                    f.set(o, value);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    f.set(o, value);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        sc.close();

    }

    public static void main(String[] args) {
        Socket sock = null;

        try {
            sock = new Socket("localhost", 8003);
            System.out.println("Connexion établie");

            OutputStream out = sock.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            InputStream is = sock.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            Object o = ois.readObject();
            // remplir la fiche
            remplirFiche(o);
            System.out.println("objet recu");
            oos.writeObject(o);
            System.out.println("objet envoyé");
        }

        catch (IOException e) {
            System.out.println("Erreur de connexion au serveur ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}