package com.test.projetDemo.beans;

import jakarta.persistence.*;

@Entity
public class Animal {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String nom;
    private String espece;
    private int age;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Territoire territoire;

    // Getters & Setters
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEspece() {
        return espece;
    }
    public void setEspece(String espece) {
        this.espece = espece;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Territoire getTerritoire() {
        return territoire;
    }
    public void setTerritoire(Territoire territoire) {
        this.territoire = territoire;
    }

    // Constructeurs
    public Animal() {
    }
    public Animal(String nom, String espece, int age) {
        this.nom = nom;
        this.espece = espece;
        this.age = age;
    }
    public Animal(int ID, String nom, String espece, int age) {
        this.ID = ID;
        this.nom = nom;
        this.espece = espece;
        this.age = age;
    }
    public Animal(Territoire territoire, int age, String espece, String nom) {
        this.territoire = territoire;
        this.age = age;
        this.espece = espece;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", age=" + age +
                ", territoire=" + territoire +
                '}';
    }
}
