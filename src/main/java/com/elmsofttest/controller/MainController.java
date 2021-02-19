package com.elmsofttest.controller;

import com.elmsofttest.service.EquationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main controller.
 */
@Controller
public class MainController {
    @Autowired
    EquationService equationService;

    /**
     * First get.
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
     * @return solution.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView raschet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("solution");
        return modelAndView;
    }
}
