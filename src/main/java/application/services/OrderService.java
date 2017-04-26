package application.services;

import application.components.Client;
import application.components.Consultant;
import application.components.Order;
import application.pojo.ClientOrder;

import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
public interface OrderService {
    Order get(int id);
    int insert(Order order);
    void update(Order order);
    void remove(Order order );
    List<Order> getAllForClient(Client client );
    ClientOrder getClientOrderById(int id);
    //List<Client> getWaitingForConsultant(Consultant consultant);
    List<Order> getAllForConsultant(Consultant consultant);
}
