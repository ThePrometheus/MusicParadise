package controllers;

import components.Consultant;
import components.Instrument;
import components.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.AjaxResponseBody;
import pojo.OrderInstrument;
import services.ConsultantService;
import services.InstrumentService;
import services.OrderInstrumentService;
import services.OrderService;

import java.security.Principal;

@Controller
@RequestMapping("/consultant")
public class  ConsultantController {
    @Autowired
    OrderService orderService;
    @Autowired
    InstrumentService instrumentService;
    @Autowired
    OrderInstrumentService orderInstrumentService;
    @Autowired
    ConsultantService consultantService;

    @RequestMapping(value = "/order_instruments", method = RequestMethod.GET)
    public ModelAndView getCarDrivers(Principal principal) {
        ModelAndView mv = new ModelAndView("orderInstrument");
        Consultant self = consultantService.get(principal.getName());
        mv.addObject("order_instruments", orderInstrumentService.getByConsultant(self));
        try {
            //mv.addObject("instruments", instrumentService.getFreeCarsByDispatcher(self));
            mv.addObject("orders", orderService.getAllForConsultant(self));
        } catch (Exception e) {
            return new ModelAndView("403");
        }
        return mv;
    }

    @RequestMapping(value = "/cancel_order_instrument", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody cancelOrderInstrument(@RequestBody OrderInstrument orderInstrument, Principal principal) {
        Order order = orderService.get(orderInstrument.getOrder().getId());
        Instrument instrument = instrumentService.get(orderInstrument.getInstrument().getId());
        try {
            if (orderInstrumentService.removeOrderInstrument(order, instrument, consultantService.get(principal.getName())) > 0)
                return new AjaxResponseBody("200", "Cancelled");
            else
                return new AjaxResponseBody("555", "FAIL");
        } catch (Exception ex) {
            return new AjaxResponseBody("403", ex.getMessage());
        }
    }

    @RequestMapping(value = "/create_order_instrument", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody createOrderInstrument(@RequestBody OrderInstrument orderInstrument, Principal principal) {
        Order order = orderService.get(orderInstrument.getOrder().getId());
        Instrument instrument = instrumentService.get(orderInstrument.getInstrument().getId());
        try {
            if (orderInstrumentService.createOrderInstrument(order, instrument, consultantService.get(principal.getName())) > 0)
                return new AjaxResponseBody("200", "Cancelled");
            else
                return new AjaxResponseBody("555", "FAIL");
        } catch (Exception ex) {
            return new AjaxResponseBody("403", ex.getMessage());
        }
    }

    @RequestMapping(value = "/orders_awaiting", method = RequestMethod.GET)
    public ModelAndView getOrdersAwaiting(Principal principal) {
        ModelAndView mv = new ModelAndView("awaitinOrders");
        Consultant self = consultantService.get(principal.getName());
        mv.addObject("order_instruments", orderInstrumentService.getWaitingForAccept(self));
        //mv.addObject("instruments",  instrumentService.get(););
        return mv;
    }

    @RequestMapping(value = "/orders_awaiting/accepted", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody acceptOrder(@RequestBody OrderInstrument orderInstrument, Principal principal){
        try {
            Consultant self = consultantService.get(principal.getName());
            orderInstrumentService.enable(orderInstrument,  self);
        }catch (Exception e) {
            return new AjaxResponseBody("500", e.getMessage());
        }
        return new AjaxResponseBody("200", "OK");
    }

    @RequestMapping(value = "/orders_awaiting/declined", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody declineOrder(@RequestBody OrderInstrument orderInstrument, Principal principal){
        try {
            Consultant self = consultantService.get(principal.getName());
            orderInstrumentService.decline(orderInstrument,  self);
        }catch (Exception e) {
            return new AjaxResponseBody("500", e.getMessage());
        }
        return new AjaxResponseBody("200", "OK");
    }
    @RequestMapping(value = "/all_orders", method = RequestMethod.GET)
    public ModelAndView allOrders(Principal principal){
        ModelAndView mv = new ModelAndView("clientOrders");
        mv.addObject("orders", orderService.getAllForConsultant(new Consultant(principal.getName())));
        return mv;
    }














}
