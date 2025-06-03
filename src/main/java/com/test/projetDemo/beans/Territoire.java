package com.test.projetDemo.beans;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Territoire {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private int superficie;
    private String typeTerrain;


    // Constructeur
    public Territoire() {
    }
    public Territoire(String typeTerrain, int superficie ){
        this.typeTerrain = typeTerrain;
        this.superficie = superficie;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getSuperficie() {
        return superficie;
    }
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    public String getTypeTerrain() {
        return typeTerrain;
    }
    public void setTypeTerrain(String typeTerrain) {
        this.typeTerrain = typeTerrain;
    }



}
