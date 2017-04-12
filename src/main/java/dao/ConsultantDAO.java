package dao;

import components.Client;
import components.Consultant;
import components.Order;

import java.util.List;

/**
 * Created by nazar on 10.04.17.
 */
public interface ConsultantDAO {

    Consultant get(String login );
    int insert(Consultant consultant);
    void update(Consultant consultant);
    void delete(Consultant consultant);
}
