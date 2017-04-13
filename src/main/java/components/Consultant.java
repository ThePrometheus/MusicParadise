package components;

/**
 * Created by nazar on 10.04.17.
 */
public class Consultant  {
    public Consultant(){}
    public Consultant(String login) {
        this.login = login;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    private int payment;
    private int id;
    private String surname;

    private String firstname;
    private String middlename;

    private String birth_date;
    private String telephone_number;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    private String login ;




    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", surname='" + surname + '\'' +

                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", department_id=" + department_id +

                ", salary=" + salary +
                '}';
    }

    public int getDepartment_id() {
        return department_id;
    }



    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    private int department_id;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }



    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }


    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getTelephone_number() {
        return telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private double salary;


}