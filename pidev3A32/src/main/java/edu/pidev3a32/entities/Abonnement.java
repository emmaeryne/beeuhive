package edu.pidev3a32.entities;

public class Abonnement {
    private int id;
    private String nom;
    private double prix;
    private String duree;

    public Abonnement() {}

    public Abonnement(int id, String nom, double prix, String duree) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.duree = duree;
    }

    public Abonnement(String nom, double prix, String duree) {
        this.nom = nom;
        this.prix = prix;
        this.duree = duree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", duree='" + duree + '\'' +
                '}';
    }
}
