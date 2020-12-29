package CreditSIO;

import CreditSIO.metier.Users;
import CreditSIO.modele.UsersDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            final URL url = getClass().getResource("vue/Connexion.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final AnchorPane root = (AnchorPane) fxmlLoader.load();
            final Scene scene = new Scene(root, 300, 350);
            primaryStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Connexion CreditSIO");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
