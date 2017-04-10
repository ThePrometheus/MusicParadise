package components;

/**
 * Created by nazar on 10.04.17.
 */
public class Client implements User {
    public Client(int id, String surname, String firstname, String middlename, String login, String password, String tel_number, String address, String email) {
        this.id = id;
        this.surname = surname;
        this.firstname = firstname;
        this.middlename = middlename;
        this.login = login;
        this.password = password;
        this.tel_number = tel_number;
        this.address = address;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    private int id;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    private String surname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    private String firstname;

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLogin() {
        return login;
    }

    private String middlename;

    public void setLogin(String login) {
        this.login = login;
    }

    private String login;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    private String tel_number;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", tel_number='" + tel_number + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        if (firstname != null ? !firstname.equals(client.firstname) : client.firstname != null) return false;
        if (middlename != null ? !middlename.equals(client.middlename) : client.middlename != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        if (password != null ? !password.equals(client.password) : client.password != null) return false;
        if (tel_number != null ? !tel_number.equals(client.tel_number) : client.tel_number != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        return email != null ? email.equals(client.email) : client.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (tel_number != null ? tel_number.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
