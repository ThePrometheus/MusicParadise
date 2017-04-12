package controllers;

import components.Consultant;
import components.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.AjaxResponseBody;
import pojo.ClientOrder;
import services.ClientService;
import services.DepartmentService;
import services.OrderService;
import services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.security.Principal;

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
    private ClientService consultantService;

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
        ModelAndView mv = new ModelAndView("orderGeneralView");

          ClientOrder clientOrder = orderService.getClientOrderById(id);
        //  CarDriver carDriver = carDriverService.getByOrderId(id);
        Consultant consultant = consultantService.getById(id);
        System.out.println(clientOrder);
        System.out.println(carDriver);
        System.out.println(dispatcher);
        if (!clientOrder.getClient().getLogin().equals(principal.getName())
                && !carDriver.getDriver().getLogin().equals(principal.getName())
                && !dispatcher.getLogin().equals(principal.getName())
                && !request.isUserInRole(ADMIN_ROLE))
            return new ModelAndView("403");
        mv.addObject("client_order", clientOrder);
        mv.addObject("car_driver", carDriver);
        mv.addObject("dispatcher", dispatcher);
        return mv;
    }
}