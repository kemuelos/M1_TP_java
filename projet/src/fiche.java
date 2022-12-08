package src;

import java.io.Serializable;

public class fiche implements Serializable {
    // attributes
    public String marque;
    public String modele;
    public String couleur;
    public String immatriculation;

    // constructor
    public fiche(String marque, String modele, String couleur, String immatriculation) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
    }


    // getters and setters
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    

    public void afficher(){
        System.out.println("Marque : " + this.marque);
        System.out.println("Modele : " + this.modele);
        System.out.println("Couleur : " + this.couleur);
        System.out.println("Immatriculation : " + this.immatriculation);
    }


    public String toString(){
        return "Marque : " + this.marque + ", Modele : " + this.modele + ", Couleur : " + this.couleur + ", Immatriculation : " + this.immatriculation;
    }
}
