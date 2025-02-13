package edu.pidev3a32.services;

import edu.pidev3a32.entities.AbonnementService;
import edu.pidev3a32.tools.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonnementServiceService {

    public void addAbonnementService(AbonnementService abonnementService) {
        String query = "INSERT INTO Abonnement_Service(abonnement_id, service_id) VALUES (?, ?)";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setInt(1, abonnementService.getAbonnementId());
            pst.setInt(2, abonnementService.getServiceId());
            pst.executeUpdate();
            System.out.println("Relation Abonnement-Service ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAbonnementService(int id) {
        String query = "DELETE FROM Abonnement_Service WHERE id = ?";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Relation supprimée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<AbonnementService> getAllAbonnementServices() {
        List<AbonnementService> abonnementServices = new ArrayList<>();
        String query = "SELECT * FROM Abonnement_Service";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                AbonnementService abonnementService = new AbonnementService(
                        rs.getInt("id"),
                        rs.getInt("abonnement_id"),
                        rs.getInt("service_id")
                );
                abonnementServices.add(abonnementService);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return abonnementServices;
    }
}
