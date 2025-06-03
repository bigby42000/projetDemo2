package com.test.projetDemo.beans;

public class Contact2 {

    // Attributs
    private String nom;
    private String prenom;
    private String numeroTelephone;
    private String adresseMail;

    // Constructeurs
    public Contact2() {
    }

    // Getter & Setter
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNumeroTelephone() {
        return numeroTelephone;
    }
    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
    public String getAdresseMail() {
        return adresseMail;
    }
    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    // Methode

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                ", adresseMail='" + adresseMail + '\'' +
                '}';
    }
}
