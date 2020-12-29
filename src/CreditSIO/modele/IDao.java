package CreditSIO.modele;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Gestion du CRUD.
 * implémentée par ClientDAO, CompteCourantDAO, CompteEpargneDAO.
 */
public interface IDao {
    /**
     * Create : C du crud.
     * Insère une ligne dans la table.
     */

    int create(String req);

    /**
     * Read : R du crud.
     * Selectionne toutes les lignes de la table.
     */
    void read(String req);

    /**
     * Update : modifie une ligne dans la table.
     * U du crud.
     */

    int update(String req);

    /**
     * Delete : supprime une ligne dans la table.
     * D du crud.
     */

    int delete(String req);
}
