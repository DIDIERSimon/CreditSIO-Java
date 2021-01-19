package CreditSIO.modele;

import CreditSIO.metier.Client;
import java.sql.*;
import java.util.ArrayList;


/**
 * Classe ClientDAO.
 * Classe d'accès aux données de la table client.
 * Transforme ces données en objets métiers.
 * Implémentation des méthodes du CRUD pour la table client dans la db.
 * Implémente l'interface IDao.
 * @author B. Chataing.
 * created on 15/12/2020.
 * modified on 18/12/2020.
 * @see CreditSIO.metier.Client
 */

public class ClientDAO implements IDao<Client> {
    private Connection myConnection;
    private Statement stmt = null;
    private CallableStatement cStmt = null;
    private PreparedStatement pStmt = null;
    private ResultSet rs = null;
    private ArrayList<Client> clients = null;

    /**
     * Constructeur.
     * Connecte l'application à la db.
     * Selectionne tous les clients de la table, les stocke dans la collection.
     */
    public ClientDAO() {
        myConnection = Connexion.getMyConnection();
        read("select * from client");
    }

    @Override
    public int create(Client client) {
        try{
            pStmt = myConnection.prepareStatement("INSERT INTO CLIENT VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            pStmt.setString(1, client.getNumeroCLI());
            pStmt.setString(2, client.getNom());
            pStmt.setString(3, client.getPrenom());
            pStmt.setString(4, client.getRue());
            pStmt.setString(5, client.getCp());
            pStmt.setString(6, client.getVille());
            pStmt.setString(7, client.getMobile());
            pStmt.setString(8, client.getEmail());
            pStmt.execute();
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * Selectionne tous les clients, les ajoute dans la collection.
     * Coupe ensuite la connexion à la base.
     * @param req : la requete (select * from client).
     */
    @Override
    public void read(String req) {
        try {
            clients = new ArrayList<>();
            stmt = myConnection.createStatement();
            rs = stmt.executeQuery(req);
            while(rs.next()){
                clients.add(new Client(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(String req) {
        return 0;
    }

    @Override
    public void delete(String numeroClient) {
        try{
            cStmt = myConnection.prepareCall("{call supprimerClient(?)}");
            cStmt.setString(1, numeroClient);
            cStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * @return la collection de clients.
     */
    public ArrayList<Client> findAll(){
        return clients;
    }

    /**
     *
     * @param index indice du client dans la collection.
     * @return le client ayant l'indice index dans la collection.
     */
    public Client findByIndex(int index) {
        return clients.get(index);
    }
}
