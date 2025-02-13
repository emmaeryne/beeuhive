package edu.pidev3a32.entities;

public class Service {
    private int id;
    private String nom;
    private String description;
    private double tarif;

    public Service() {}

    public Service(int id, String nom, String description, double tarif) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.tarif = tarif;
    }

    public Service(String nom, String description, double tarif) {
        this.nom = nom;
        this.description = description;
        this.tarif = tarif;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", tarif=" + tarif +
                '}';
    }
}
