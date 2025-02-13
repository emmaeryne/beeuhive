package edu.pidev3a32.services;

import edu.pidev3a32.entities.Abonnement;
import edu.pidev3a32.tools.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonnementService {

    // Méthode pour ajouter un abonnement
    public void addAbonnement(Abonnement abonnement) {
        String query = "INSERT INTO Abonnement(nom, prix, duree) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setString(1, abonnement.getNom());
            pst.setDouble(2, abonnement.getPrix());
            pst.setString(3, abonnement.getDuree());
            pst.executeUpdate();
            System.out.println("Abonnement ajouté !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Méthode pour supprimer un abonnement
    public void deleteAbonnement(int id) {
        String query = "DELETE FROM Abonnement WHERE id = ?";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Abonnement supprimé !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Méthode pour mettre à jour un abonnement
    public void updateAbonnement(Abonnement abonnement) {
        String query = "UPDATE Abonnement SET nom=?, prix=?, duree=? WHERE id=?";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setString(1, abonnement.getNom());
            pst.setDouble(2, abonnement.getPrix());
            pst.setString(3, abonnement.getDuree());
            pst.setInt(4, abonnement.getId());
            pst.executeUpdate();
            System.out.println("Abonnement mis à jour !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Méthode pour récupérer tous les abonnements
    public List<Abonnement> getAllAbonnements() {
        List<Abonnement> abonnements = new ArrayList<>();
        String query = "SELECT * FROM Abonnement";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Abonnement abonnement = new Abonnement(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix"),
                        rs.getString("duree")
                );
                abonnements.add(abonnement);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return abonnements;
    }
}
