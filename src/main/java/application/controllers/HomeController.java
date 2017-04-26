package application.controllers;

import application.services.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by nazar on 11.04.17.
 */
@Controller
@RequestMapping(value = "/", headers = "Accept=*/*")
public class HomeController {
    @Autowired
    ConsultantService consultantService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView setOnline(Principal principal) {
        ModelAndView mv = new ModelAndView("home");
     //   logger.info(ROOT_CTL_TAG, "RootController handles GET request");
       consultantService.get("NAZAR");
        return mv;
    }

    @RequestMapping("/pre_logout")
    public String setOffline(Principal principal) {
        if (principal != null){}
           return new String("redirect: /logout") ;

    }

}
