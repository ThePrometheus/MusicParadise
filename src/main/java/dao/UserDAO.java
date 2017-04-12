package dao;


import components.User;

/**
 * Created by nazar on 11.04.17.
 */
public interface UserDAO {
    User get(String login );
    int insert(User user);
    void delete(User user );
    void update( User user );


}