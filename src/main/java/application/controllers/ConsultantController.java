package application.controllers;


import application.components.*;
import application.pojo.AjaxResponseBody;
import application.pojo.OrderInstrument;
import application.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/consultant")
public class  ConsultantController {

    @Autowired
    OrderService orderService;
    @Autowired
    InstrumentService instrumentService;
    @Autowired
    OrderInstrumentService orderInstrumentService;
    @Autowired
    ConsultantService consultantService;
    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    private static final String ROLE = "CONSULTANT";

    @RequestMapping(value="/create",method= RequestMethod.GET)
    public ModelAndView createConsultant() {
        ModelAndView modelAndView= new ModelAndView("consultantEdit");
        modelAndView.addObject("departments",departmentService.getAll());
        modelAndView.addObject("firstEdit",true);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doCreateConsultant(@RequestBody Consultant consultant){
        //TO-DO: backend validation
        System.out.print(consultant);
        consultantService.insert(consultant);
        return new AjaxResponseBody("200", "OK");
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody doEditConsultant(@RequestBody Consultant consultant){
        consultantService.update(consultant);
        return new AjaxResponseBody("200", "OK");
    }

    @RequestMapping(value = "/edit/{login}", method = RequestMethod.GET)
    public ModelAndView editConsultant(@PathVariable String login){
        ModelAndView modelAndView = new ModelAndView("consultantEdit");

        Consultant consultant = consultantService.get(login);
        modelAndView.addObject("consultant", consultant);
        modelAndView.addObject("department", departmentService.get(consultant.getDepartment_id()));
        modelAndView.addObject("firstEdit", false);
        return modelAndView;
    }

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public ModelAndView allConsultants(ModelAndView modelAndView) throws SQLException {
        List<Consultant> list  = consultantService.getAll();
        for(Consultant i:list)
            System.out.println(i);
        modelAndView.addObject("consultants",list);
        //  modelAndView.addObject("titleWord", "All instruments");

        modelAndView.setViewName("consultantAll");
        return modelAndView;
    }

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
    @Transactional
    public ModelAndView registerConsultant( @RequestParam String login,
                                        @RequestParam String  surname, @RequestParam String  firstname,
                                        @RequestParam String middlename,
                                        @RequestParam String tel_number,@RequestParam double salary,
                                        @RequestParam String birth_date,@RequestParam int dept_id,

                                        @RequestParam  String pass,@RequestParam String  password) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (pass.compareTo(password) == 0) throw new IllegalArgumentException("password don't match");
        Consultant consultant = new Consultant(login, surname, firstname, middlename, birth_date, tel_number, salary, dept_id);
        User u = new User(login, password, ROLE,true);
        //consultant.setPassword(password);
        if (consultantService.insert(consultant) > 0)
            modelAndView.addObject("registered", true);
        else {
            modelAndView.addObject("registered", false);
            // User u = new User(0,login,pass,CLIENT_ROLE);
            if (userService.insert(u) > 0) {
                System.err.println("Multiple users");
            }
        }
        return modelAndView;
    }*/


        @RequestMapping(value = "/order_instruments", method = RequestMethod.GET)
    public ModelAndView getCarDrivers(Principal principal) {
        ModelAndView mv = new ModelAndView("orderInstrument");
        Consultant self = consultantService.get(principal.getName());
        mv.addObject("order_instruments", orderInstrumentService.getByConsultant(self));
        try {
            //mv.addObject("instruments", instrumentService.getFreeCarsByDispatcher(self));
            mv.addObject("orders", orderService.getAllForConsultant(self));
        } catch (Exception e) {
            return new ModelAndView("403");
        }
        return mv;
    }

    @RequestMapping(value = "/cancel_order_instrument", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody cancelOrderInstrument(@RequestBody OrderInstrument orderInstrument, Principal principal) {
        Order order = orderService.get(orderInstrument.getOrder().getId());
        Instrument instrument = instrumentService.get(orderInstrument.getInstrument().getId());
        try {
            if (orderInstrumentService.removeOrderInstrument(order, instrument, consultantService.get(principal.getName())) > 0)
                return new AjaxResponseBody("200", "Cancelled");
            else
                return new AjaxResponseBody("555", "FAIL");
        } catch (Exception ex) {
            return new AjaxResponseBody("403", ex.getMessage());
        }
    }

    @RequestMapping(value = "/create_order_instrument", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody createOrderInstrument(@RequestBody OrderInstrument orderInstrument, Principal principal) {
        Order order = orderService.get(orderInstrument.getOrder().getId());
        Instrument instrument = instrumentService.get(orderInstrument.getInstrument().getId());
        try {
            if (orderInstrumentService.createOrderInstrument(order, instrument, consultantService.get(principal.getName())) > 0)
                return new AjaxResponseBody("200", "Cancelled");
            else
                return new AjaxResponseBody("555", "FAIL");
        } catch (Exception ex) {
            return new AjaxResponseBody("403", ex.getMessage());
        }
    }

    @RequestMapping(value = "/orders_awaiting", method = RequestMethod.GET)
    public ModelAndView getOrdersAwaiting(Principal principal) {
        ModelAndView mv = new ModelAndView("awaitingOrders");
        Consultant self = consultantService.get(principal.getName());
        mv.addObject("order_instruments", orderInstrumentService.getWaitingForAccept(self));
        //mv.addObject("instruments",  instrumentService.get(););
        return mv;
    }

    @RequestMapping(value = "/orders_awaiting/accepted", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody acceptOrder(@RequestBody OrderInstrument orderInstrument, Principal principal){
        try {
            Consultant self = consultantService.get(principal.getName());
            orderInstrumentService.enable(orderInstrument,  self);
        }catch (Exception e) {
            return new AjaxResponseBody("500", e.getMessage());
        }
        return new AjaxResponseBody("200", "OK");
    }

    @RequestMapping(value = "/orders_awaiting/declined", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponseBody declineOrder(@RequestBody OrderInstrument orderInstrument, Principal principal){
        try {
            Consultant self = consultantService.get(principal.getName());
            orderInstrumentService.decline(orderInstrument,  self);
        }catch (Exception e) {
            return new AjaxResponseBody("500", e.getMessage());
        }
        return new AjaxResponseBody("200", "OK");
    }
    @RequestMapping(value = "/all_orders", method = RequestMethod.GET)
    public ModelAndView allOrders(Principal principal){
        ModelAndView mv = new ModelAndView("clientOrders");
        mv.addObject("orders", orderService.getAllForConsultant(new Consultant(principal.getName())));
        return mv;
    }














}

