package services.impl;

import components.Consultant;
import components.Instrument;
import components.Order;
import dao.OrderInstrumentDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.OrderInstrument;
import services.OrderInstrumentService;

import java.util.List;

/**
 * Created by nazar on 12.04.17.
 */
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
