package edu.pidev3a32.entities;

public class AbonnementService {
    private int id;
    private int abonnementId;
    private int serviceId;

    public AbonnementService() {}

    public AbonnementService(int id, int abonnementId, int serviceId) {
        this.id = id;
        this.abonnementId = abonnementId;
        this.serviceId = serviceId;
    }

    public AbonnementService(int abonnementId, int serviceId) {
        this.abonnementId = abonnementId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(int abonnementId) {
        this.abonnementId = abonnementId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "AbonnementService{" +
                "id=" + id +
                ", abonnementId=" + abonnementId +
                ", serviceId=" + serviceId +
                '}';
    }



}
