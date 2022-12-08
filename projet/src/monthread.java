package src;

import java.io.*;
import java.net.*;
import java.util.ArrayList;


/**
 * monthread
 */
public class monthread extends Thread {
    public Socket socketClient;
    ArrayList<Object> slist;
    ArrayList<Object> rlist;


    public monthread(Socket socketClient, ArrayList<Object> slist, ArrayList<Object> rlist) {
        this.socketClient = socketClient;
        this.slist = slist;
        this.rlist = rlist;
    }
    
    public void run() {
        try {
            OutputStream out = socketClient.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            InputStream is = socketClient.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            synchronized(slist){
                if(slist.isEmpty()){
                    System.out.println("Liste vide");
                    socketClient.close();  
                    this.interrupt();                  
                }
                else{
                    Object o = slist.get(slist.size()-1);
                    slist.remove(slist.size()-1);
                    oos.writeObject(o);
                }
            }

            if(!this.isInterrupted()){
                synchronized(rlist){
                    Object o = ois.readObject();
                    System.out.println("Objet reçu");
                    rlist.add(o);
                    // afficher la fiche
                    System.out.println(o.toString());
                }
            }

            
            
        


            socketClient.close();

        } catch (IOException  | ClassNotFoundException e) {
            System.out.println("Erreur de connexion au serveur ");
        }   
    }
    
}