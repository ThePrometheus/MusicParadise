package application.services;

import application.components.User;

/**
 * Created by nazar on 11.04.17.
 */
public interface UserService {
    User get(String login );
    int insert(User user);
    void update(User user);
    void remove(User user);
    boolean ifExists(User user);
}
