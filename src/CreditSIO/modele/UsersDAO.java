package CreditSIO.modele;

import CreditSIO.metier.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDAO implements IDao{

    private Connection myConnection;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ArrayList<Users> users = null;

    public UsersDAO(){
        myConnection = Connexion.getMyConnection();
        read("select * from users");
    }

    @Override
    public int create(String req) {
        return 0;
    }

    @Override
    public void read(String req) {
        try{
            users = new ArrayList<>();
            stmt = myConnection.createStatement();
            rs = stmt.executeQuery(req);
            while(rs.next()){
                users.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));
            }
        }catch (SQLException e){
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

    public ArrayList<Users> findAll(){ return users; }
    public Users findByIndex(int index){ return users.get(index); }
}
