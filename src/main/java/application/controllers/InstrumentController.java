package application.controllers;

import application.components.Instrument;
import application.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import application.pojo.AjaxResponseBody;
import application.services.DepartmentService;
import application.services.OrderService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by nazar on 11.04.17.
 */
@Controller
@RequestMapping(value = "/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;


    @Autowired
    private OrderService orderService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value="/create",method= RequestMethod.GET)
    public ModelAndView createInstrument() {
        ModelAndView modelAndView= new ModelAndView("instrumentEdit");
        modelAndView.addObject("departments",departmentService.getAll());
        modelAndView.addObject("firstEdit",true);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doCreateCar(@RequestBody Instrument instrument){
        //TO-DO: backend validation
        System.out.print(instrument);
        instrumentService.insert(instrument);
        return new AjaxResponseBody("200", "OK");
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doEditCar(@RequestBody Instrument instrument){
        instrumentService.update(instrument);
        return new AjaxResponseBody("200", "OK");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editCar(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("instrumentEdit");

        Instrument instrument = instrumentService.get(id);
        modelAndView.addObject("instrument", instrument);
        modelAndView.addObject("department", departmentService.get(instrument.getDepartment_id()));
        modelAndView.addObject("firstEdit", false);
        return modelAndView;
    }





    @RequestMapping(value="/all")
    public ModelAndView allInstruments(ModelAndView modelAndView) throws SQLException {
        List<Instrument> list  = instrumentService.getAll();
        modelAndView.addObject("instruments",list);
        modelAndView.addObject("titleWord", "All instruments");

        modelAndView.setViewName("viewAll");
        return modelAndView;
    }




}
