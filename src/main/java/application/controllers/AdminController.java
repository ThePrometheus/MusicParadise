package application.controllers;


import application.components.Consultant;
import application.pojo.AjaxResponseBody;
import application.services.ConsultantService;
import application.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by nazar on 11.04.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private ConsultantService consultantService;


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createConsultant() {
        ModelAndView modelAndView = new ModelAndView("consultantEdit");

        modelAndView.addObject("departments", departmentService.getAll());
        modelAndView.addObject("firstEdit", true);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doCreateConsultant(@RequestBody Consultant consultant) {
        //TO-DO: backend validation
        System.out.print(consultant);
        if (consultantService.insert(consultant) < 1)
            return new AjaxResponseBody("500", "Could not create consultant");
        return new AjaxResponseBody("200", "OK");
    }

    @RequestMapping(value = "/edit/{login}", method = RequestMethod.GET)
    public ModelAndView editConsultant(@PathVariable String login) {
        ModelAndView mv = new ModelAndView("consultantEdit");

        Consultant consultant = consultantService.get(login);
        mv.addObject("consultant", consultant);
        mv.addObject("department", departmentService.get(consultant.getDepartment_id()));
        mv.addObject("firstEdit", false);

        return mv;


    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doEditConsultant(@RequestBody Consultant consultant) {
        consultantService.update(consultant);
        return new AjaxResponseBody("200", "OK");
    }
}

