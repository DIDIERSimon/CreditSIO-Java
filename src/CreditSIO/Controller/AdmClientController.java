package CreditSIO.Controller;

import CreditSIO.metier.Client;
import CreditSIO.modele.ClientDAO;
import CreditSIO.modele.UsersDAO;
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

public class AdmClientController implements Initializable {

    @FXML public TextField clientNum;
    @FXML public TextField clientNom;
    @FXML public TextField clientPrenom;
    @FXML public TextField clientRue;
    @FXML public TextField clientCP;
    @FXML public TextField clientVille;
    @FXML public TextField clientTel;
    @FXML public TextField clientMail;
    @FXML public TableView<Client> vueClient;
    @FXML public TableColumn<Client, String> client;
    @FXML public TableColumn<Client, String> prenomClient;


    public ObservableList<Client> getList(){

        ObservableList<Client> TableVue = FXCollections.observableArrayList();
        ClientDAO clientDAO = new ClientDAO();
        ArrayList<Client> clients = clientDAO.findAll();

        for(Client client : clients){
            String ClientNum = client.getNumeroCLI();
            String ClientPrenom = client.getPrenom();
            String ClientNom = client.getNom();
            String ClientRue = client.getRue();
            String ClientCP = client.getCp();
            String ClientVille = client.getVille();
            String ClientMobile = client.getMobile();
            String ClientMail = client.getEmail();
            TableVue.add(new Client(ClientNum, ClientNom, ClientPrenom, ClientRue, ClientCP, ClientVille, ClientMobile, ClientMail));
        }

        return TableVue;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        client.setCellValueFactory(new PropertyValueFactory<Client, String>("numeroCLI"));
        prenomClient.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));

        vueClient.setItems(getList());

    }

    public void deleteClient(ActionEvent actionEvent) {
        ClientDAO cliDAO = new ClientDAO();
        cliDAO.delete(clientNum.getText());
    }

    public void addClient(ActionEvent actionEvent) {
        Client client = new Client(clientNum.getText(), clientNom.getText(), clientPrenom.getText(), clientRue.getText(),
                clientCP.getText(), clientVille.getText(), clientTel.getText(), clientMail.getText());
        ClientDAO cliDAO = new ClientDAO();
        cliDAO.create(client);
    }
}
