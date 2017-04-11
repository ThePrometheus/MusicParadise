package services;

import components.User;

/**
 * Created by nazar on 11.04.17.
 */
public interface UserService {
    User get(int id);
    int insert(User user);
    void update(User user);
    void remove(User user);
    boolean ifExists(User user);
}
