package services;

import components.Order;

/**
 * Created by nazar on 11.04.17.
 */
public interface OrderService {
    Order get(int id);
    int insert(Order order);
    void update(Order order);
    void remove(Order order );
}
