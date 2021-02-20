package com.elmsofttest.controller;

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
    public void payment() {

        when(request.getParameter("a")).thenReturn(String.valueOf(any(Double.class)));
        when(request.getParameter("b")).thenReturn(String.valueOf(any(Double.class)));
        when(request.getParameter("c")).thenReturn(String.valueOf(any(Double.class)));

        ModelAndView mav = controller.payment(new HashMap<String, Object>(), this.request);

        Assert.assertEquals("solution", mav.getViewName());

    }
}