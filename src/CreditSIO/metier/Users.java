package CreditSIO.metier;

public class Users {

    private int id;
    private String login;
    private String type;
    private String password;
    private String clientNum;

    public Users(int id, String login, String type, String password, String clientNum){
        this.id = id;
        this.login = login;
        this.type = type;
        this.password = password;
        this.clientNum = clientNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getPassword(){ return password; }

    public void setPassword(String password){
        this.password = password;
    }

    public String getClientNum(){
        return clientNum;
    }

    public void setClientNum(String clientNum){
        this.clientNum = clientNum;
    }


    public String toString(){
        String strUsers;
        strUsers = id + "\n" + login + "\n" + type + "\n" + password + "\n" + clientNum;
        return strUsers;
    }
}
