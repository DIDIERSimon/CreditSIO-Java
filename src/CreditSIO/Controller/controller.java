package CreditSIO.Controller;

import CreditSIO.metier.*;
import CreditSIO.modele.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class controller implements Initializable {

    @FXML private TextField userTextField;
    @FXML private PasswordField pwField;
    @FXML private Label EtatConnexion;


    @FXML
    public void login(ActionEvent actionEvent) throws IOException {
        if (!userTextField.getText().equals("") && !pwField.getText().equals("")) {
            infoForm.userLogin = userTextField.getText();
            infoForm.userPassword = pwField.getText();
            UsersDAO log_in = new UsersDAO();
            ArrayList<Users> users = log_in.findAll();

            for (Users user : users) {
                if (user.getLogin().equals(infoForm.userLogin) && user.getPassword().equals(infoForm.userPassword) && user.getType().equalsIgnoreCase("Client")) {
                    Parent root = FXMLLoader.load(getClass().getResource("../vue/vueClient.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle(userTextField.getText() + " Menu");
                    stage.show();
                } else if (user.getLogin().equals(infoForm.userLogin) && user.getPassword().equals(infoForm.userPassword) && user.getType().equalsIgnoreCase("conseiller")) {
                    Parent root = FXMLLoader.load(getClass().getResource("../vue/vueConseiller.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle(userTextField.getText() + " Menu");
                    stage.show();
                }
            }
        } else
            EtatConnexion.setText("Aucune information ");
    }

    @FXML
    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void comptesCourant(ActionEvent actionEvent) throws IOException {
        String login = infoForm.userLogin;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/vueComptesCourantByClient.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(login + " -  Liste comptes courants");
        stage.show();
    }

    public void comptesEpargne(ActionEvent actionEvent) throws IOException {
        String login = infoForm.userLogin;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/vueComptesEpargneByClient.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(login + " - Liste des comptes épargnes");
        stage.show();
    }

    @FXML
    public void showAdmClient(ActionEvent actionEvent) throws IOException {

        String login = infoForm.userLogin;
        Parent root = FXMLLoader.load(getClass().getResource("../vue/AdministrationClient.fxml"));

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(login + " Administration des clients");
        stage.show();

    }
}

