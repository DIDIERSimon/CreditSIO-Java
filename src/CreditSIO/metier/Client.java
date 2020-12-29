package CreditSIO.metier;

/**
 * Classe Client.
 * Modélise un client de la banque.
 * @author : B. CHATAING.
 * created on  08/12/2020.
 * modified on 13/12/2020.
 */
public class Client {
    /**
     * Attributs privés.
     * Attributs identiques aux champs de la table client de la DB.
     */
    private String numeroCLI;
    private String nom;
    private String prenom;
    private String rue;
    private String cp;
    private String ville;
    private String mobile;
    private String email;

    /**
     * Constructeur.
     * @param numero : type String.
     * @param nom : type String.
     * @param prenom : type String.
     * @param rue : type String.
     * @param cp : type String.
     * @param ville : type String.
     * @param mobile : type String.
     * @param email : type String.
     */
    public Client(String numero, String nom, String prenom, String rue, String cp, String ville, String mobile, String email) {
        this.numeroCLI = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.rue = rue;
        this.cp = cp;
        this.ville = ville;
        this.mobile = mobile;
        this.email = email;
    }

    /**
     * Accesseurs en lecture (get) et en écriture (set)
     * @param acc
     */
    public String getNumero(String acc) {
        return numeroCLI;
    }

    public void setNumero(String numero) {
        this.numeroCLI = numero;
    }

    public String getNumeroCLI() {
        return numeroCLI;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Rend l'objet client sous forme textuelle;
     * @return String
     */
    public String toString() {
        String strClient;
        strClient = numeroCLI + "\n" + nom + "\n" + prenom + "\n" + rue + "\n" + cp + "\n" + ville + "\n" + mobile + "\n" + email;
        return strClient;
    }

}
