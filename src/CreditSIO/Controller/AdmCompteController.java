package CreditSIO.Controller;

import CreditSIO.metier.Client;
import CreditSIO.metier.Compte;
import CreditSIO.metier.CompteCourant;
import CreditSIO.metier.CompteEpargne;
import CreditSIO.modele.CompteCourantDAO;
import CreditSIO.modele.CompteEpargneDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AdmCompteController implements Initializable {

    @FXML public TableView<Compte> vueComptes;
    @FXML public TableColumn<Compte, String> CompteNum;
    @FXML public TableColumn<Compte, Double> CompteSolde;
    @FXML public TableColumn<Compte, Client> ClientNumero;
    @FXML public TextField NumAcc;
    @FXML public TextField SoldeAcc;
    @FXML public TextField ClientNum;
    @FXML public TextField ModifSolde;


    public ObservableList<Compte> getList(){

        ObservableList<Compte> TableCompte = FXCollections.observableArrayList();

        CompteCourantDAO compteCourantDAO = new CompteCourantDAO();
        CompteEpargneDAO compteEpargneDAO = new CompteEpargneDAO();

        ArrayList<CompteCourant> courants = compteCourantDAO.findAll();
        ArrayList<CompteEpargne> epargnes = compteEpargneDAO.findAll();

        for(CompteCourant courant : courants){
            String CompteNum = courant.getNumero();
            Client titulaire = courant.getClient();
            double solde = courant.getSolde();
            double decouvMax = courant.getDecouvertAutorise();
            TableCompte.add(new CompteCourant(CompteNum, titulaire, solde, decouvMax));
        }
        for(CompteEpargne epargne : epargnes){
            String CompteNum = epargne.getNumero();
            Client titulaire = epargne.getClient();
            double solde = epargne.getSolde();
            double taux = epargne.getTauxInteret();
            TableCompte.add(new CompteEpargne(CompteNum, titulaire, solde, taux));
        }


        return TableCompte;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        CompteNum.setCellValueFactory(new PropertyValueFactory<Compte, String>("numero"));
        CompteSolde.setCellValueFactory(new PropertyValueFactory<Compte, Double>("solde"));
        ClientNumero.setCellValueFactory(new PropertyValueFactory<Compte, Client>("numeroClient"));

        vueComptes.setItems(getList());

    }

    public void CreateAcc(ActionEvent actionEvent) {
    }

    public void DeleteAcc(ActionEvent actionEvent) {
    }

    public void AddSoldeAcc(ActionEvent actionEvent) {
    }

    public void RemoveSoldeAcc(ActionEvent actionEvent) {
    }
}
