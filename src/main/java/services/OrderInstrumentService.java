package services;

import components.Consultant;
import components.Instrument;
import components.Order;
import pojo.OrderInstrument;

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
}
