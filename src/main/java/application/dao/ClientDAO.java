package application.dao;


import application.components.Client;

/**
 * Created by nazar on 10.04.17.
 */
public interface ClientDAO {

    Client get(String login );
    int insert(Client client);
    void update(Client client);
    void delete(Client client);


}
