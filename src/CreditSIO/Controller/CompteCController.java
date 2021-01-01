package CreditSIO.Controller;

import CreditSIO.metier.*;
import CreditSIO.modele.CompteCourantDAO;
import CreditSIO.modele.UsersDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CompteCController implements Initializable {

    @FXML private TableView<CompteCourant> tableCompte;
    @FXML private TableColumn<CompteCourant, String> compte;
    @FXML private TableColumn<CompteCourant, Double> solde;
    @FXML private TableColumn<CompteCourant, Double> decouvMax;
    @FXML private TableColumn<CompteCourant, Client> titulaire;



    public ObservableList<CompteCourant> getList() {

        ObservableList<CompteCourant> tableView = FXCollections.observableArrayList();
        UsersDAO usersDAO = new UsersDAO();
        ArrayList<Users> users = usersDAO.findAll();
        CompteCourantDAO compteCourantDAO = new CompteCourantDAO();
        ArrayList<CompteCourant> courants = compteCourantDAO.findAll();

        for(Users user : users){
            String login = infoForm.userLogin;
            if(user.getLogin().equals(login)){
                String numAcc = user.getClientNum();
                if(user.getLogin().equals(login) && user.getType().equalsIgnoreCase("client")) {
                    courants.removeIf(crt -> !crt.getNumeroClient().equals(numAcc));
                }
                for(CompteCourant courant : courants){
                        String current = courant.getNumero();
                        Client titulaire = courant.getClient();
                        double solde = courant.getSolde();
                        double decouvMax = courant.getDecouvertAutorise();
                        tableView.add(new CompteCourant(current, titulaire, solde, decouvMax));
                }
            }
        }

        return tableView;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        compte.setCellValueFactory(new PropertyValueFactory<CompteCourant, String>("numero"));
        solde.setCellValueFactory(new PropertyValueFactory<CompteCourant, Double>("solde"));
        decouvMax.setCellValueFactory(new PropertyValueFactory<CompteCourant, Double>("decouvertAutorise"));
        titulaire.setCellValueFactory(new PropertyValueFactory<CompteCourant, Client>("numeroClient"));

        tableCompte.setItems(getList());
    }
}
