package com.elmsofttest.controller;

import com.elmsofttest.service.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Main controller.
 */
@Controller
public class MainController {
    /**
     * Service for controller.
     */
    @Autowired
    private EquationService equationService;

    /**
     * First get.
     *
     * @return index page.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * The method obtains the coefficients of a quadratic equation.
     *
     * @return solution.
     * @param map results map.
     * @param request get params from request.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView payment(Map<String, Object> map,
                                HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("solution");
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        return modelAndView;
    }
}
