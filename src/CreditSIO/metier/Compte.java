package CreditSIO.metier;

/**
 * Classe Compte.
 * permet de créer un compte et de le gérer :
 * déposer ou retirer de l'argent du compte.
 * @author : B. CHATAING.
 * created on  08/12/2020.
 * modified on 13/12/2020.
 */
public abstract class Compte {
    /**
     * Attributs privés.
     * numero : le numéro du compte. Type String car varchar dans la db.
     * titulaire : le titulaire du compte. De type Client.
     * @see Client
     * solde : Type double. Le solde du compte.
     */
    protected String numero;
    protected Client titulaire;
    protected double solde;

    /**
     * Constructeur : portée protected : utilisé uniquement par les classes filles.
     * @param numero : id du compte.
     * @param titulaire : de type Client.
     * @see Client
     * @param solde : de type double.
     */
    protected Compte(String numero, Client titulaire, double solde) {
        this.numero = numero;
        this.titulaire = titulaire;
        this.solde = solde;
    }

    /**
     * Accesseurs en lecture (get) et en écriture (set)
     * Portée protected : accessibles uniquement par les classes filles.
     */

    protected String getNumero() {
        return numero;
    }

    protected void setNumero(String numero) {
        this.numero = numero;
    }

    protected Client getTitulaire() {
        return titulaire;
    }

    protected void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    protected double getSolde() {
        return solde;
    }

    protected void setSolde(double solde) {
        this.solde = solde;
    }

    /**
     * Rend l'objet sous forme textuelle.
     * @return : String
     */

    public abstract String toString();

    /**
     * Permet un dépot d'argent sur le compte.
     * @param montant : type double. Le montant à déposer sur le compte.
     */
    public void deposer (double montant) {
        if(montant > 0)
            solde += montant;
    }

    /**
     * Permet un retrait d'argent sur le compte.
     * Le retrait n'est possible que si le découvert autorisé n'est pas dépassé.
     * Le contrôle est implémentée dans la DB.
     * @param montant : type double. Le montant à retirer sur le compte.
     */

    public void retirer (double montant) {
        if(montant > 0) {
            solde -= montant;
        }
    }

    public abstract Client getClient();
}
