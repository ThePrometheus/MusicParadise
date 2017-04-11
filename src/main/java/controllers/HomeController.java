package controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.ClientService;
import services.ConsultantService;
import services.UserService;

import java.security.Principal;

/**
 * Created by nazar on 11.04.17.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String home(){
        return "redirect:/instruments/all";
    }

}
