package beans;

import org.springframework.stereotype.Component;

/**
 * Created by nazar on 10.04.17.
 */
@Component
public class Department {
    private int id;
    private String address;

    public int getId() {
        return id;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
