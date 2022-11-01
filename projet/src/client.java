package src;

import java.io.OutputStream;
import java.net.Socket;


public class client {

    public static void main(String[] args){
        client client1 = new client("syo", "192.168.1.9", 5000, "HTTP");  
        client1.print();
        client1.send();

    }

    // attributs client
    private String Name;
    private String IP;
    private int port;
    private String protocole;

    // constructeur client
    public client(String Name, String IP, int port, String protocole) {
        this.Name = Name;
        this.IP = IP;
        this.port = port;
        this.protocole = protocole;
    }


    // getters et setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String iP) {
        this.IP = iP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocole() {
        return protocole;
    }

    public void setProtocole(String protocole) {
        this.protocole = protocole;
    }



    // methode print
    public void print() {
        System.out.println("Name: " + Name);
        System.out.println("IP: " + IP);
        System.out.println("port: " + port);
        System.out.println("protocole: " + protocole);
    }

    // methode send
    public void send(){
        try {
            Socket socket = new Socket(IP, port);
            OutputStream os = socket.getOutputStream();
            os.write("Hello".getBytes());
            os.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Erreur: " );
        }
    }
    
}


