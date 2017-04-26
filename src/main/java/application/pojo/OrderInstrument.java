package application.pojo;

import application.components.Instrument;
import application.components.Order;

/**
 * Created by nazar on 12.04.17.
 */
public class OrderInstrument {
    private Order order;
    private Instrument instrument;

    public OrderInstrument(Order order, Instrument instrument) {
        this.order = order;
        this.instrument = instrument;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "OrderInstrument{" +
                "order=" + order +
                ", instrument=" + instrument +
                '}';
    }
}
