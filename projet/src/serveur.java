package src;

// import java.io.InputStream;
import java.io.OutputStream;
// import java.net.ServerSocket;
import java.net.Socket;

/**
 * serveur
 */
public class serveur {

    public static void main(String[] args) {
        serveur serveur1 = new serveur();
        serveur1.print();
        serveur1.listen();
    }

    // attributs serveur
    private String Name;
    private String IP;
    private int port;
    private String protocole;

    // constructeur serveur
    public serveur() {

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

    // methodes
    public void print() {
        System.out.println("Name: " + this.Name);
        System.out.println("IP: " + this.IP);
        System.out.println("Port: " + this.port);
        System.out.println("Protocole: " + this.protocole);
    }

    // methode pour ecouter le client
    public void listen() {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Client connecté sur le port" + this.port);
            OutputStream os = socket.getOutputStream();
            os.write("Hello".getBytes());
            os.close();
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}