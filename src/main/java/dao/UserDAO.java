package dao;

import components.Order;
import components.User;

/**
 * Created by nazar on 11.04.17.
 */
public interface UserDAO {
    User get(int id);
    int insert(User user);
    void delete(User user );
    void update( User user );


}