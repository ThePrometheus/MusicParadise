package application.services.impl;

import application.components.Consultant;
import application.dao.ConsultantDAO;
import application.services.ConsultantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nazar on 11.04.17.
 */
@Service
public class ConsultantServiceImpl implements ConsultantService {
    @Autowired
    private ConsultantDAO consultantDAO;
    private static Logger logger = LoggerFactory.getLogger(ConsultantServiceImpl.class.getSimpleName());

    public Consultant get(String login) {
        logger.info("Gettting consultant by login");
        return consultantDAO.get(login);
    }

    public int insert(Consultant client) {
        logger.info("Insert consultant");
        return consultantDAO.insert(client);
    }

    public void update(Consultant consultant) {
        logger.info("update consultant");
        consultantDAO.update(consultant);

    }
    public Consultant getById(int id){
     return    consultantDAO.getById(id);

    }

    public void remove(Consultant consultant) {
        logger.info("Consultant is removed");
        consultantDAO.delete(consultant);

    }
  public   Consultant getByOrderId(int id){
   return consultantDAO.getConsultantByOrderId(id);
    }
}
