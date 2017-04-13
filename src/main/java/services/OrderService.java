package services;

import components.Client;
import components.Consultant;
import components.Order;
import pojo.ClientOrder;

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
