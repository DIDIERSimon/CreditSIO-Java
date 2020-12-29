package CreditSIO.metier;

/**
 * Classe CompteCourant.
 * Hérite de la classe abstraite Compte.
 * Modélise un compte courant.
 * @author : B. CHATAING.
 * created on  08/12/2020.
 * modified on 18/12/2020.
 */
public class CompteCourant extends Compte{

    /**
     * Attribut privé.
     * Montant maximal du découvert autorisé.
     */
    private double decouvertAutorise;

    /**
     * Constructeur.
     * @param numero : id du compte. De type String.
     * @param titulaire : le titulaire du compte. De type Client.
     * @see Client
     * @param solde : de type double.
     * @param decouvertAutorise : de type double.
     */
    public CompteCourant(String numero, Client titulaire, double solde, double decouvertAutorise) {
        super(numero, titulaire, solde);
        this.decouvertAutorise = decouvertAutorise;
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
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }

    /**
     * Redéfinition de la méthode abstraite.
     * Rend l'objet sous forme textuelle.
     * @return : le compte courant sous forme textuelle.
     */
    public String toString() {
        String strCCourant;
        strCCourant = numero + "\n" + titulaire.toString() + "\n" + decouvertAutorise;
        return strCCourant;
    }

    @Override
    public Client getClient() {
        return titulaire;
    }

    public String getNumeroClient() { return titulaire.getNumeroCLI(); }
}
