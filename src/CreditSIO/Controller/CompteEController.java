package CreditSIO.Controller;

import CreditSIO.metier.*;
import CreditSIO.modele.CompteCourantDAO;
import CreditSIO.modele.CompteEpargneDAO;
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

public class CompteEController implements Initializable {

    @FXML private TableView<CompteEpargne> tableCompteE;
    @FXML private TableColumn<CompteEpargne, String> compteE;
    @FXML private TableColumn<CompteEpargne, Double> soldeE;
    @FXML private TableColumn<CompteEpargne, Double> taux;
    @FXML private TableColumn<CompteEpargne, Client> titulaireE;



    public ObservableList<CompteEpargne> getList() {

        ObservableList<CompteEpargne> tableViewEpargne = FXCollections.observableArrayList();
        UsersDAO usersDAO = new UsersDAO();
        ArrayList<Users> users = usersDAO.findAll();
        CompteEpargneDAO compteEpargneDAO = new CompteEpargneDAO();
        ArrayList<CompteEpargne> epargnes = compteEpargneDAO.findAll();

        for(Users user : users){
            String login = infoForm.userLogin;
            if(user.getLogin().equals(login)){
                String numAcc = user.getClientNum();
                if(user.getLogin().equals(login) && user.getType().equalsIgnoreCase("client")) {
                    epargnes.removeIf(crt -> !crt.getNumeroClient().equals(numAcc));
                }
                for(CompteEpargne epargne  : epargnes){
                    String current = epargne.getNumero();
                    Client titulaire = epargne.getClient();
                    double solde = epargne.getSolde();
                    double tauxInteret = epargne.getTauxInteret();
                    tableViewEpargne.add(new CompteEpargne(current, titulaire, solde, tauxInteret));
                }

            }
        }

        return tableViewEpargne;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        compteE.setCellValueFactory(new PropertyValueFactory<CompteEpargne, String>("numero"));
        soldeE.setCellValueFactory(new PropertyValueFactory<CompteEpargne, Double>("solde"));
        taux.setCellValueFactory(new PropertyValueFactory<CompteEpargne, Double>("tauxInteret"));
        titulaireE.setCellValueFactory(new PropertyValueFactory<CompteEpargne, Client>("numeroClient"));

        tableCompteE.setItems(getList());
    }
}
