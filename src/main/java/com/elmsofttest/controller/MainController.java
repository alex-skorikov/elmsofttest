package com.elmsofttest.controller;

import com.elmsofttest.model.Equation;
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
     * @param map     results map.
     * @param request get params from request.
     * @return solution.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView solution(Map<String, Object> map,
                                 HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        double a = Double.parseDouble(request.getParameter("a"));
        double b = Double.parseDouble(request.getParameter("b"));
        double c = Double.parseDouble(request.getParameter("c"));
        Equation equation = new Equation();
        equation.setCoefficientA(a);
        equation.setCoefficientB(b);
        equation.setCoefficientC(c);
        if (equationService.validateCoefficients(equation)) {
            equationService.solutionEquation(equation);
            equationService.addEquation(equation);
            map.put("coefficientA", equation.getCoefficientA());
            map.put("coefficientB", equation.getCoefficientB());
            map.put("coefficientC", equation.getCoefficientC());
            map.put("discriminant", equation.getDiscriminant());
            map.put("rootFirst", equation.getRootFirst());
            map.put("rootSecond", equation.getRootSecond());
            modelAndView.setViewName("solution");
        } else {
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}