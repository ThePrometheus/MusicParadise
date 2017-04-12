package components;

/**
 * Created by nazar on 10.04.17.
 */
public class Order {
    public Order(){}
    private int id;
    private String client;


    public int getConsultant_id() {
        return consultant_id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setConsultant_id(int consultant_id) {
        this.consultant_id = consultant_id;
    }

    private int  consultant_id;

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    private int  client_id;


    private String order_time;




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


    public String getComment() {
        return comment;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getShip_time() {
        return ship_time;
    }

    public void setShip_time(String ship_time) {
        this.ship_time = ship_time;
    }

    private String ship_time;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

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
