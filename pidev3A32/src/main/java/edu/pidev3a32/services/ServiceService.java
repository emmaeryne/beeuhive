package edu.pidev3a32.services;

import edu.pidev3a32.entities.Service;
import edu.pidev3a32.tools.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceService {

    public void addService(Service service) {
        String query = "INSERT INTO Service(nom, description, tarif) VALUES (?, ?, ?)";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setString(1, service.getNom());
            pst.setString(2, service.getDescription());
            pst.setDouble(3, service.getTarif());
            pst.executeUpdate();
            System.out.println("Service ajouté !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteService(int id) {
        String query = "DELETE FROM Service WHERE id = ?";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            System.out.println("Service supprimé !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateService(Service service) {
        String query = "UPDATE Service SET nom=?, description=?, tarif=? WHERE id=?";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(query);
            pst.setString(1, service.getNom());
            pst.setString(2, service.getDescription());
            pst.setDouble(3, service.getTarif());
            pst.setInt(4, service.getId());
            pst.executeUpdate();
            System.out.println("Service mis à jour !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String query = "SELECT * FROM Service";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Service service = new Service(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("description"),
                        rs.getDouble("tarif")
                );
                services.add(service);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return services;
    }
}
