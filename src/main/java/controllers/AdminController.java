package controllers;

import com.sun.org.apache.xerces.internal.util.HTTPInputSource;
import components.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import services.ConsultantService;
import services.InstrumentService;
import javax.*;
import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;

/**
 * Created by nazar on 11.04.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private InstrumentService instrumentService;

    @Autowired
    private ConsultantService consultantService;

    @RequestMapping(value = "/create_instrument")
    public ModelAndView createInstrument(ModelAndView modelAndView){
        modelAndView.setViewName("addInstrument");
        return modelAndView;
    }
    @RequestMapping(value = "/edit_instrument", method = RequestMethod.GET)
    public ModelAndView editInstrument(HttpServletRequest request) throws SQLException {
        ModelAndView mv = new ModelAndView("adminEditInstrument");
        int id = Integer.parseInt(request.getParameter("instrument_id"));
        mv.addObject("instrument", instrumentService.get(id));
        return mv;
    }

    @RequestMapping(value = "/do_edit", method = RequestMethod.POST)
    public @ResponseBody String doEdit(HttpServletRequest request) throws SQLException {
        String model= request.getParameter("model-input");
        String category = request.getParameter("category-input");
        String trademark = request.getParameter("trademark-input");
        int company_index= Integer.parseInt(request.getParameter("company_index-input"));
        String purchase_date = request.getParameter("purchase_date-input");
        String sell_date = request.getParameter("sell_date-input");
        boolean functioning = Boolean.parseBoolean(request.getParameter("fucntioning-input"));
        int department = Integer.parseInt(request.getParameter("department-input"));
        float price = Float.parseFloat(request.getParameter("price-input"));
        String description = request.getParameter("description-input");
        Instrument i = new Instrument();
        i.setModel(model);
        i.setCategory(category);
        i.setTrademark(trademark);
        i.setCompany_index(company_index);
        i.setPurchase_date(purchase_date);
        i.setSell_date(sell_date);
        i.setFunctioning(functioning);
        i.setDepartment_id(department);
        i.setPrice(price);
        i.setDescription(description);





        instrumentService.update(i);
        return "redirect:/instruments/all";
    }




}
