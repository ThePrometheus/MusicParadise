package application.pojo;

import application.components.Order;
import application.components.Client;

/**
 * Created by nazar on 12.04.17.
 */
public class ClientOrder {



        private application.components.Client client;
        private Order order;

    public ClientOrder(Client client, Order order) {
        this.client = client;
        this.order = order;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ClientOrder{" +
                "client=" + client +
                ", order=" + order +
                '}';
    }
}
