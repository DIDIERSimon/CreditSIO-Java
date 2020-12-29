package CreditSIO.modele;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Classe Connexion.
 * Gère la connexion et la déconnexion à la db.
 * @author B. Chataing.
 * created on 15/12/2020.
 * modified on 20/12/2020.
 */
public class Connexion {
    /*Les paramètres de connexion sont stockés dans un fichier de configuration (config.properties)
    * Ce fichier est lu par la méthode privée "read".
    * Elle initialise les membres driverName, dbUrl, user et pass*/
    private static String driverName;
    private static String dbUrl;
    private static String user;
    private static String pass;
    private static Connection myConnection = null;

    /**
     * getConnexion.
     * Charge le pilote et se connecte à la db.
     * Methode statique.
     */
    public static Connection getMyConnection(){
        readProperties();
        try {
            Class.forName(driverName);
            myConnection = DriverManager.getConnection(dbUrl, "root", "");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return myConnection;
    }

    /**
     * Deconnexion de la db.
     * Méthode statique.
     */
    public void Deconnexion(){
        if(myConnection != null){
            try {
                myConnection.close();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }

    /**
     * Lecture des données de connexion à la db.
     * Ces données sont stockées dans un fichier de config (config.properties).
     */
    private static void readProperties(){
        final Properties properties = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            properties.load(input);
            // get the property value
            driverName = properties.getProperty("db.drivername");
            dbUrl = properties.getProperty("db.url");
            user = properties.getProperty("db.username");
            pass = properties.getProperty("db.password");

        } catch (final IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
