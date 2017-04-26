package application.controllers;

import application.components.Consultant;
import application.components.User;
import application.pojo.AjaxResponseBody;
import application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by nazar on 26.04.17.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/create",method= RequestMethod.GET)
    public ModelAndView createUser() {
        ModelAndView modelAndView= new ModelAndView("consultantEdit");
       // modelAndView.addObject("departments",departmentService.getAll());
      //  modelAndView.addObject("firstEdit",true);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doCreateUser(@RequestBody User user){
        //TO-DO: backend validation
        System.out.print(user);
        userService.insert(user);
        return new AjaxResponseBody("200", "OK");
    }
}
