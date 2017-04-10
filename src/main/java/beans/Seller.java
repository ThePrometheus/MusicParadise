package beans;

import org.springframework.stereotype.Component;

/**
 * Created by nazar on 10.04.17.
 */
@Component
public class Seller {
    private int id;

    private String encrypted_password;
    private String surname;
    private String firstname;
    private String middlename;
    private String position;
    private String birth_date;
    private String tel_number;
    private double salary;

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", encrypted_password='" + encrypted_password + '\'' +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", position='" + position + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", tel_number='" + tel_number + '\'' +
                ", salary=" + salary +
                '}';
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seller seller = (Seller) o;

        if (id != seller.id) return false;
        if (Double.compare(seller.salary, salary) != 0) return false;
        if (encrypted_password != null ? !encrypted_password.equals(seller.encrypted_password) : seller.encrypted_password != null)
            return false;
        if (surname != null ? !surname.equals(seller.surname) : seller.surname != null) return false;
        if (firstname != null ? !firstname.equals(seller.firstname) : seller.firstname != null) return false;
        if (middlename != null ? !middlename.equals(seller.middlename) : seller.middlename != null) return false;
        if (position != null ? !position.equals(seller.position) : seller.position != null) return false;
        if (birth_date != null ? !birth_date.equals(seller.birth_date) : seller.birth_date != null) return false;
        return tel_number != null ? tel_number.equals(seller.tel_number) : seller.tel_number == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (encrypted_password != null ? encrypted_password.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (birth_date != null ? birth_date.hashCode() : 0);
        result = 31 * result + (tel_number != null ? tel_number.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }



    public int getId() {
        return id;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getPosition() {
        return position;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getTel_number() {
        return tel_number;
    }


}
