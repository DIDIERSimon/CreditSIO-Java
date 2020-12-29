package CreditSIO.metier;

/**
 * Classe CompteCourant.
 * Hérite de la classe abstraite Compte.
 * Modélise un compte épargne.
 * @author : B. CHATAING.
 * created on  08/12/2020
 * modified on 18/12/2020
 */

public class CompteEpargne extends Compte{
    /**
     * Attribut privé.
     * taux d'intérêt appliqué. Calcul des intérêts en fin d'année.
     */
    private double tauxInteret;

    /**
     * Constructeur.
     * @param numero : id du compte. De type String.
     * @param titulaire : le titulaire du compte. De type Client.
     * @see Client
     * @param solde : de type double.
     * @param tauxInteret : de type double.
     */

    public CompteEpargne(String numero, Client titulaire, double solde, double tauxInteret) {
        super(numero, titulaire, solde);
        this.tauxInteret = tauxInteret;
    }


    /**
     * Acces au numero de compte : attribut de la classe mère.
     * @return le numéro de compte.
     */
    public String getNumero() {
        return super.getNumero();
    }

    /**
     * Acces au solde du compte : attribut de la classe mère.
     * @return le solde du compte.
     */
    public double getSolde() {
        return super.getSolde();
    }
    /**
     * Accesseurs en lecture et en écriture.
     *
     */


    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    /**
     * Redéfinition de la méthode abstraite.
     * Rend l'objet sous forme textuelle.
     * @return : le compte épargne sous forme textuelle.
     */
    public String toString() {
        String strEpargne;
        strEpargne = numero + "\n" + titulaire.toString() + "\n" + tauxInteret;
        return strEpargne;
    }

    @Override
    public Client getClient() {
        return titulaire;
    }

}
