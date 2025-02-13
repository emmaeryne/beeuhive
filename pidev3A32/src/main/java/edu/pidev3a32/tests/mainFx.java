package edu.pidev3a32.tests;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ajouterservice.fxml"));
        try {
            Parent parent =loader.load();
            Scene scene = new Scene(parent);
            primaryStage.setTitle("Ajouter service");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        }

    }

