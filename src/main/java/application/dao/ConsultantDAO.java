package application.dao;

import application.components.Consultant;

/**
 * Created by nazar on 10.04.17.
 */
public interface ConsultantDAO {

    Consultant get(String login );
    int insert(Consultant consultant);
    void update(Consultant consultant);
    void delete(Consultant consultant);
    Consultant getById(int id);
    Consultant getConsultantByOrderId(int id);
}
