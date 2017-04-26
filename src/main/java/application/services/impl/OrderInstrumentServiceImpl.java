package application.services.impl;

import application.components.Consultant;
import application.components.Instrument;
import application.components.Order;
import application.dao.OrderInstrumentDAO;
import application.services.OrderInstrumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import application.pojo.OrderInstrument;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nazar on 12.04.17.
 */
@Service
public class OrderInstrumentServiceImpl implements OrderInstrumentService {
@Autowired
private OrderInstrumentDAO orderInstrumentDAO;
    private static Logger logger = LoggerFactory.getLogger(OrderInstrumentServiceImpl.class.getSimpleName());

    public int createOrderInstrument(Order order, Instrument instrument, Consultant consultant) throws Exception {
        return orderInstrumentDAO.createOrderInstrument(order,instrument,consultant);
    }

    public int removeOrderInstrument(Order order, Instrument instrument, Consultant consultant) throws Exception {
        return orderInstrumentDAO.removeOrderInstrument(order,instrument,consultant);
    }

    public List<OrderInstrument> getWaitingForAccept(Consultant consultant) {
        return orderInstrumentDAO.getWaitingForAccept(consultant);
    }

    public OrderInstrument getByInstrumentId(int id) {
        return orderInstrumentDAO.getByInstrumentId(id);
    }

    public List<OrderInstrument> getByOrderId(int id) {
        return orderInstrumentDAO.getByOrderId(id);
    }

    public List<OrderInstrument> getByConsultant(Consultant consultant) {
        return orderInstrumentDAO.getByConsultant(consultant);
    }
   public  int enable(OrderInstrument orderInstrument,Consultant consultant){
        return orderInstrumentDAO.enable(orderInstrument,consultant);
   }
    public  int decline(OrderInstrument orderInstrument,Consultant consultant){
        return orderInstrumentDAO.decline(orderInstrument,consultant);
    }

}
