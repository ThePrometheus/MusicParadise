package services.impl;

import components.Client;
import dao.ClientDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import services.ClientService;

/**
 * Created by nazar on 11.04.17.
 */
public class ClientServiceImpl  implements ClientService{
    @Autowired
    private ClientDAO clientDao;
    private static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class.getSimpleName());

    public Client get(int id) {
       logger.info("Gettting client by id");
       return clientDao.get(id);
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
