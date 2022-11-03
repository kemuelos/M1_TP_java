package src;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        client client1 = new client("syo", "192.168.1.9", 5000, "HTTP");
        serveur serveur1 = new serveur();
        client1.print();
        client1.send();
        serveur1.listen();
    }

    // test envoi entre client et serveur
    

}
