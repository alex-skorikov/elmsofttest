package com.elmsofttest.controller;

import com.elmsofttest.model.Equation;
import com.elmsofttest.service.EquationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Main controller test class.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

    /**
     * Inject controller.
     */
    @InjectMocks
    private MainController controller;

    /**
     * Mock Http request.
     */
    @Mock
    private HttpServletRequest request;

    /**
     * Mock equation service.
     */
    @Mock
    private EquationService service;

    /**
     * Test method GET.
     */
    @Test
    public void main() {
        ModelAndView mav = controller.main();
        Assert.assertEquals("index", mav.getViewName());
    }

    /**
     * Test method POST.
     */
    @Test
    public void whenSolutionThenViewSolution() {
        when(request.getParameter("a")).thenReturn(String.valueOf(2.0));
        when(request.getParameter("b")).thenReturn(String.valueOf(3.0));
        when(request.getParameter("c")).thenReturn(String.valueOf(4.0));
        when(service.validateCoefficients(any(Equation.class))).thenReturn(Boolean.TRUE);
        when(service.solutionEquation(any(Equation.class))).thenReturn(new Equation());

        ModelAndView mav = controller.solution(new HashMap<String, Object>(), this.request);
        verify(service, times(1)).addEquation(any(Equation.class));
        Assert.assertEquals("solution", mav.getViewName());

    }

    /**
     * Test method POST.
     */
    @Test
    public void whenNotSolutionThenViewError() {
        when(request.getParameter("a")).thenReturn(String.valueOf(2.0));
        when(request.getParameter("b")).thenReturn(String.valueOf(3.0));
        when(request.getParameter("c")).thenReturn(String.valueOf(4.0));

        when(service.validateCoefficients(any(Equation.class))).thenReturn(Boolean.FALSE);
        ModelAndView mav = controller.solution(new HashMap<String, Object>(), this.request);
        verify(service, times(0)).addEquation(any(Equation.class));
        Assert.assertEquals("error", mav.getViewName());

    }
}