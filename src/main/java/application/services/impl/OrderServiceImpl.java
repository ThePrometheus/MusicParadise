package application.services.impl;

import application.components.Client;
import application.components.Consultant;
import application.components.Order;
import application.dao.OrderDAO;
import application.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import application.pojo.ClientOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;
    private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class.getSimpleName());


    public Order get(int id) {
        logger.info("Gettting order by id");
        return orderDAO.get(id);
    }

  public   List<Order> getAllForConsultant(Consultant consultant){
        return orderDAO.getAllOrdersForConsultant(consultant);
    }

    public int insert(Order order) {
        logger.info("Inserting instrument by id");
        return orderDAO.insert(order);
    }

    public void update(Order order) {
        logger.info("Update instrument");
        orderDAO.insert(order);

    }

    public void remove(Order order) {
        logger.info("Instrument is removed");
        orderDAO.delete(order);

    }

    public List<Order> getAllForClient(Client client) {
        logger.info("Get all orders of that client");
        return  orderDAO.getAllForClient(client);
    }

    public ClientOrder getClientOrderById(int id) {
     return    orderDAO.getClientOrderById(id);
    }


}
