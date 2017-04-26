package application.services;

import application.components.Consultant;
import application.components.Instrument;
import application.components.Order;
import application.pojo.OrderInstrument;

import java.util.List;

/**
 * Created by nazar on 12.04.17.
 */
public interface  OrderInstrumentService {
    int createOrderInstrument(Order order, Instrument instrument, Consultant consultant) throws Exception ;
    int removeOrderInstrument(Order order, Instrument instrument, Consultant consultant) throws Exception;
    List<OrderInstrument> getWaitingForAccept(Consultant consultant);
    OrderInstrument getByInstrumentId(int id);
    List<OrderInstrument>getByOrderId(int id);
    List<OrderInstrument> getByConsultant(Consultant consultant);
    int enable(OrderInstrument orderInstrument,Consultant consultant);
    int decline(OrderInstrument orderInstrument,Consultant consultant);
}
