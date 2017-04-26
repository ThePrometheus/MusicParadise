package application.services.impl;

import application.components.Client;
import application.dao.ClientDAO;
import application.dao.UserDAO;
import application.services.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nazar on 11.04.17.
 */
@Service
public class ClientServiceImpl  implements ClientService {
    @Autowired
    private ClientDAO clientDao;

    @Autowired
    private UserDAO userDAO;



    private static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class.getSimpleName());

    public Client get(String login) {
       logger.info("Gettting client by id");
       return clientDao.get(login );
    }



    public int insert(Client client) {
        logger.info("Insert client");

        return clientDao.insert(client);
    }

    public void update(Client client) {
        logger.info("update clinet");
        clientDao.update(client);

    }

    public void remove(Client client) {
        logger.info("Client is removed");
        clientDao.delete(client);

    }
}
