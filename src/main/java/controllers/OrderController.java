package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.ClientService;
import services.UserService;

import javax.transaction.Transactional;

/**
 * Created by nazar on 11.04.17.
 */
@Controller

public class OrderController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class.getSimpleName());
    private static final String CLIENT_ROLE = "CLIENT";

    @Autowired
    private ClientService clientService;

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @Transactional
    public ModelAndView register(){

    }


}
