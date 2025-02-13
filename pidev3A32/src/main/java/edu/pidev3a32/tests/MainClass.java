package edu.pidev3a32.tests;

import edu.pidev3a32.tools.MyConnection;

import java.sql.*;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = MyConnection.getInstance().getCnx(); // Obtenir la connexion via le singleton

        if (conn == null) {
            System.out.println("Échec de la connexion à la base de données !");
            return;
        }

        while (true) {
            // Affichage du menu principal
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Ajouter un service");
            System.out.println("2. Ajouter un abonnement");
            System.out.println("3. Associer service à un abonnement");
            System.out.println("4. Afficher tous les abonnements et services associés");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    ajouterService(scanner, conn);
                    break;
                case 2:
                    ajouterAbonnement(scanner, conn);
                    break;
                case 3:
                    associerServiceAbonnement(scanner, conn);
                    break;
                case 4:
                    afficherAbonnementsAvecServices(conn);
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    try {
                        if (conn != null && !conn.isClosed()) {
                            conn.close();  // Fermer la connexion à la fin
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    // Méthode pour ajouter un service
    private static void ajouterService(Scanner scanner, Connection conn) {
        System.out.println("\n=== Ajouter un Service ===");
        System.out.print("Nom du service : ");
        String nomService = scanner.nextLine();
        System.out.print("Description du service : ");
        String descriptionService = scanner.nextLine();
        System.out.print("Tarif du service : ");
        double tarifService = scanner.nextDouble();
        scanner.nextLine();  // Consommer le retour à la ligne

        String query = "INSERT INTO service (nom, description, tarif) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nomService);
            stmt.setString(2, descriptionService);
            stmt.setDouble(3, tarifService);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Service ajouté avec succès !");
            } else {
                System.out.println("Échec de l'ajout du service.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour ajouter un abonnement
    private static void ajouterAbonnement(Scanner scanner, Connection conn) {
        System.out.println("\n=== Ajouter un Abonnement ===");
        System.out.print("Nom de l'abonnement : ");
        String nomAbonnement = scanner.nextLine();
        System.out.print("Prix de l'abonnement : ");
        double prixAbonnement = scanner.nextDouble();
        System.out.print("Durée de l'abonnement : ");
        String dureeAbonnement = scanner.nextLine(); // Consommer le retour à la ligne après nextDouble
        dureeAbonnement = scanner.nextLine();

        String query = "INSERT INTO abonnement (nom, prix, duree) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nomAbonnement);
            stmt.setDouble(2, prixAbonnement);
            stmt.setString(3, dureeAbonnement);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Abonnement ajouté avec succès !");
            } else {
                System.out.println("Échec de l'ajout de l'abonnement.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour associer un service à un abonnement
    private static void associerServiceAbonnement(Scanner scanner, Connection conn) {
        System.out.println("\n=== Associer Service à Abonnement ===");
        System.out.print("ID du service : ");
        int serviceId = scanner.nextInt();
        System.out.print("ID de l'abonnement : ");
        int abonnementId = scanner.nextInt();

        String query = "INSERT INTO abonnement_service (abonnement_id, service_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, abonnementId);
            stmt.setInt(2, serviceId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Service associé à l'abonnement avec succès !");
            } else {
                System.out.println("Échec de l'association du service à l'abonnement.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour afficher tous les abonnements et services associés
    private static void afficherAbonnementsAvecServices(Connection conn) {
        String query = "SELECT a.nom AS abonnement, s.nom AS service " +
                "FROM abonnement a " +
                "JOIN abonnement_service asb ON a.id = asb.abonnement_id " +
                "JOIN service s ON asb.service_id = s.id";

        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n=== Abonnements et Services Associés ===");
            while (rs.next()) {
                String abonnement = rs.getString("abonnement");
                String service = rs.getString("service");
                System.out.println("Abonnement: " + abonnement + " | Service: " + service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
