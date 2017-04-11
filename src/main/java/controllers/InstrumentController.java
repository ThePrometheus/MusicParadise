package controllers;

import components.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.InstrumentService;
import services.OrderService;

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


    @RequestMapping(value="/all")
    public ModelAndView allInstruments(ModelAndView modelAndView) throws SQLException {
        List<Instrument> list  = instrumentService.getAll();
        modelAndView.addObject("instruments",list);
        modelAndView.addObject("titleWord", "All instruments");

        modelAndView.setViewName("viewAll");
        return modelAndView;
    }




}
