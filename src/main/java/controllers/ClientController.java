package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by nazar on 11.04.17.
 */
@Controller
@RequestMapping("/client")
public class ClientController {





    @RequestMapping(value = "/all_orders", method = RequestMethod.GET)
    public ModelAndView allOrders(Principal principal){
        ModelAndView mv = new ModelAndView("clientOrders");
        mv.addObject("orders", orderService.getAllForClient(new Client(principal.getId())));
        return mv;
    }



}
