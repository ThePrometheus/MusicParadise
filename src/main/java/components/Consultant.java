package components;

/**
 * Created by nazar on 10.04.17.
 */
public class Consultant implements User {
    private int id;
    private String surname;
    private String password;
    private String firstname;
    private String middlename;
    private String job;
    private String birth_date;
    private String telephone_number;
    private String login;

    public Consultant(int id, String surname, String password, String firstname, String middlename, String job, String birth_date, String telephone_number, String login, double salary) {
        this.id = id;
        this.surname = surname;
        this.password = password;
        this.firstname = firstname;
        this.middlename = middlename;
        this.job = job;
        this.birth_date = birth_date;
        this.telephone_number = telephone_number;
        this.login = login;
        this.salary = salary;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getLogin() {
        return login;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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


    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", job='" + job + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", telephone_number='" + telephone_number + '\'' +
                ", login='" + login + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consultant that = (Consultant) o;

        if (id != that.id) return false;
        if (Double.compare(that.salary, salary) != 0) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (job != null ? !job.equals(that.job) : that.job != null) return false;
        if (birth_date != null ? !birth_date.equals(that.birth_date) : that.birth_date != null) return false;
        if (telephone_number != null ? !telephone_number.equals(that.telephone_number) : that.telephone_number != null)
            return false;
        return login != null ? login.equals(that.login) : that.login == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (birth_date != null ? birth_date.hashCode() : 0);
        result = 31 * result + (telephone_number != null ? telephone_number.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}