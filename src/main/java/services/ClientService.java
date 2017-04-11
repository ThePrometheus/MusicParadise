package services;

import components.Client;

/**
 * Created by nazar on 11.04.17.
 */
public  interface ClientService {
    Client get(int id);
    int insert(Client client);
    void update(Client client );
    void remove(Client client );


}
