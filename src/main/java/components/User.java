package components;

/**
 * Created by nazar on 10.04.17.
 */

public class User {
    private int id;

    public void setLogin(String login) {
        this.login = login;
    }

    private String login ;
    private String password;
    private String role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
