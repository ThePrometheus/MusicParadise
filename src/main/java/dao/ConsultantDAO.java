package dao;

import components.Client;
import components.Consultant;

/**
 * Created by nazar on 10.04.17.
 */
public interface ConsultantDAO {

    Consultant get(int id);
    int insert(Consultant consultant);
    void update(Consultant consultant);
    void delete(Consultant consultant);
}
