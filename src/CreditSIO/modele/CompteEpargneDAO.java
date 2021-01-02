package CreditSIO.modele;

import CreditSIO.metier.Client;
import CreditSIO.metier.CompteCourant;
import CreditSIO.metier.CompteEpargne;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe CompteEpargneDAO.
 * Classe d'accès aux données de la table compteepargne.
 * Transforme ces données en objets métiers.
 * Implémentation des méthodes du CRUD pour la table compteepargne dans la db.
 * Implémente l'interface IDao.
 * @author B. Chataing.
 * created on 15/12/2020.
 * modified on 18/12/2020.
 * @see CreditSIO.metier.CompteEpargne
 */

public class CompteEpargneDAO implements IDao{
    private Connection myConnection;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<CompteEpargne> epargnes = null;

    /**
     * Constructeur.
     * Connecte l'application à la db.
     * Selectionne tous les clients de la table, les stocke dans la collection.
     */

    public CompteEpargneDAO() {
        myConnection = Connexion.getMyConnection();
        read("select * from compteepargne cc " +
                "join compte c on cc.numcompte=c.numcompte " +
                "join client ct on c.clientnum=ct.clientnum");
    }

    /**
     * Effectue un insert into client.
     * @param req : la requete SQL (insert into).
     * @return : le nombre de lignes affectées dans la table.
     */

    @Override
    public int create(String req) {
        return 0;
    }

    /**
     * Selectionne tous les comptes epargnes, les ajoute dans la collection.
     * Coupe ensuite la connexion à la base.
     * @param req : la requete (select *).
     */
    @Override
    public void read(String req) {
        try {
            epargnes = new ArrayList<>();
            stmt = myConnection.createStatement();
            rs = stmt.executeQuery(req);
            while(rs.next()){
                Client client = new Client(rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),
                        rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13));
                epargnes.add(new CompteEpargne(rs.getString(1),client,rs.getDouble(4),rs.getDouble(2)));
                myConnection.close();
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
    public void delete(String req) {

    }

    /**
     * @return la collection de comptes courants.
     */
    public ArrayList<CompteEpargne> findAll(){
        return epargnes;
    }

    /**
     *
     * @param index indice du compte dans la collection.
     * @return le compte courant ayant l'indice index dans la collection.
     */
    public CompteEpargne findByIndex(int index) {
        return epargnes.get(index);
    }
}
