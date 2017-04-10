package components;

/**
 * Created by nazar on 10.04.17.
 */
public class Order {
    private int id;

    public Order(int id, boolean shipped, String ship_date, String comment) {
        this.id = id;
        this.shipped = shipped;
        this.ship_date = ship_date;
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (shipped != order.shipped) return false;
        if (ship_date != null ? !ship_date.equals(order.ship_date) : order.ship_date != null) return false;
        return comment != null ? comment.equals(order.comment) : order.comment == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shipped ? 1 : 0);
        result = 31 * result + (ship_date != null ? ship_date.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    private boolean shipped;
    private String ship_date;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }

    public String getShip_date() {
        return ship_date;
    }

    public void setShip_date(String ship_date) {
        this.ship_date = ship_date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", shipped=" + shipped +
                ", ship_date='" + ship_date + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
