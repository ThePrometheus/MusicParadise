package application.controllers;

import application.components.Consultant;
import application.components.Order;
import application.services.ConsultantService;
import application.services.DepartmentService;
import application.services.OrderInstrumentService;
import application.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import application.pojo.AjaxResponseBody;
import application.pojo.ClientOrder;
import application.pojo.OrderInstrument;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */

@Controller
@RequestMapping("/order")
public class OrderController {
    private static final String ADMIN_ROLE = "ADMIN";

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ConsultantService consultantService;
    @Autowired
    private OrderInstrumentService orderInstrumentService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createOrder() {
        ModelAndView mv = new ModelAndView("orderEdit");

        mv.addObject("departments", departmentService.getAll());
        return mv;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doCreateOrder(Principal principal, @RequestBody Order order) {

        order.setClient(principal.getName());
        orderService.insert(order);
        return new AjaxResponseBody("200", "OK");


    }

    @RequestMapping(value = "/accept/{id}", method = RequestMethod.GET)
    public ModelAndView getReceipt(@PathVariable int id, Principal principal, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("clientOrder");

          ClientOrder clientOrder = orderService.getClientOrderById(id);
          List<OrderInstrument> orderInstruments= orderInstrumentService.getByOrderId(id);
        Consultant consultant= consultantService.getByOrderId(id);
        System.out.println(clientOrder);
        System.out.println(orderInstruments);
        System.out.println(consultant);
        if (!clientOrder.getClient().getLogin().equals(principal.getName())

                && !consultant.getLogin().equals(principal.getName())
                && !request.isUserInRole(ADMIN_ROLE))
            return new ModelAndView("403");
        mv.addObject("client_order", clientOrder);
        mv.addObject("order_instrument_list",orderInstruments);

        mv.addObject("consultant", consultant);
        return mv;
    }


}