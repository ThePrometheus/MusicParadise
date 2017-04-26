package application.services;

import application.components.Client;

/**
 * Created by nazar on 11.04.17.
 */
public  interface ClientService {
    Client get(String login);
    int insert(Client client);
    void update(Client client );
    void remove(Client client );


}
