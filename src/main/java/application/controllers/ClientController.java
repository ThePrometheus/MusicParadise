package application.controllers;

import application.components.Client;
import application.services.ClientService;
import application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import application.services.OrderService;

import javax.transaction.Transactional;
import java.security.Principal;

/**
 * Created by nazar on 11.04.17.
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    private static final String CLIENT_ROLE = "CLIENT";
    @Autowired
    private OrderService orderService;


    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Transactional
    public ModelAndView registerClient( @RequestParam  String login,
                                       @RequestParam String  surname, @RequestParam String  firstname,
                                       @RequestParam String middlename,
                                       @RequestParam String tel_number,@RequestParam String address,
                                       @RequestParam  String email,
    @RequestParam  String pass,@RequestParam String  password){
        ModelAndView modelAndView = new ModelAndView("login");
       if(pass.compareTo(password)==0) throw new IllegalArgumentException("password don't match");
        Client client = new Client(login,surname,firstname,middlename,tel_number,address,email);
        client.setRole(CLIENT_ROLE);
        client.setPassword(password);
        if (clientService.insert(client) > 0)
            modelAndView.addObject("registered", true);
        else
            modelAndView.addObject("registered", false);

return modelAndView;

    }


    @RequestMapping(value = "/all_orders", method = RequestMethod.GET)
    public ModelAndView allOrders(Principal principal){

        ModelAndView modelAndView = new ModelAndView("clientOrders");
        modelAndView.addObject("orders", orderService.getAllForClient(new Client(principal.getName())));

        return modelAndView;
    }



}
