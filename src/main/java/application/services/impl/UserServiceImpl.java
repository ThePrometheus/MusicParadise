package application.services.impl;

import application.components.User;
import application.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import application.services.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by nazar on 11.04.17.
 */
@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UserDAO userDAO;
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getSimpleName());
    public User get(String login) {
        logger.info("Gettting user by id");
        return userDAO.get(login);
    }

    public int insert(User user) {
        logger.info("Inserting user by id");
        return userDAO.insert(user);
    }

    public void update(User user) {
        logger.info("Update user");
        userDAO.insert(user);

    }

    public void remove(User user) {
        logger.info("User is removed");
        userDAO.delete(user);

    }

    public boolean ifExists(User user) {
        return true;
    }
}
