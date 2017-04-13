package dao;

import components.Client;
import components.Consultant;
import components.Order;
import pojo.ClientOrder;

import java.util.List;

/**
 * Created by nazar on 10.04.17.
 */
public interface OrderDAO {
    Order get(int id);
    int insert(Order order);
    void delete(Order order );
    void update( Order order);
    List<Order> getAllForClient(Client client);
     void executeOrder(Order order);
     List<Order> getAllOrdersForConsultant(Consultant consultant);
       ClientOrder getClientOrderById(int id);



}
