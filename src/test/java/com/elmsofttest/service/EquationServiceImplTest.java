package com.elmsofttest.service;

import com.elmsofttest.dao.EquationDAO;
import com.elmsofttest.model.Equation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
/**
 * Equation service test class.
 */
@RunWith(MockitoJUnitRunner.class)
public class EquationServiceImplTest {
    /**
     * Equation service.
     */
    @InjectMocks
    private EquationServiceImpl service;
    /**
     * Mock equation DAO.
     */
    @Mock
    private EquationDAO equationDAO;

    /**
     * Test call DAO add.
     */
    @Test
    public void whenServiceAddEquationThenDAOAddEquation() {
        service.addEquation(new Equation());
        verify(equationDAO, times(1)).addEquation(any(Equation.class));
    }

    /**
     * Validate coefficient test.
     */
    @Test
    public void validateCoefficient() {
        Equation equation = new Equation();
        equation.setCoefficientA(0.0);
        equation.setCoefficientB(2.0);
        equation.setCoefficientC(1.0);
        Assert.assertFalse(service.validateCoefficients(equation));

        equation.setCoefficientA(3.0);
        Assert.assertFalse(service.validateCoefficients(equation));

        equation.setCoefficientA(2.0);
        equation.setCoefficientB(5.0);
        equation.setCoefficientC(1.0);
        Assert.assertTrue(service.validateCoefficients(equation));
    }

    /**
     * Test calculate equation.
     */
    @Test
    public void calculateQuadraticEqulation() {
        Equation equation = new Equation();
        equation.setCoefficientA(2.0);
        equation.setCoefficientB(5.0);
        equation.setCoefficientC(1.0);
        Assert.assertNull(equation.getDiscriminant());
        Assert.assertNull(equation.getRootFirst());
        Assert.assertNull(equation.getRootSecond());

        equation = service.solutionEquation(equation);

        Assert.assertNotNull(equation.getDiscriminant());
        Assert.assertNotNull(equation.getRootFirst());
        Assert.assertNotNull(equation.getRootSecond());
    }

    /**
     * Test calculate equation where discriminant 0.
     */
    @Test
    public void calculateQuadraticEqulationWhereDiscriminantZero() {
        Equation equation = new Equation();
        equation.setCoefficientA(1.0);
        equation.setCoefficientB(2.0);
        equation.setCoefficientC(1.0);
        Assert.assertNull(equation.getDiscriminant());
        Assert.assertNull(equation.getRootFirst());
        Assert.assertNull(equation.getRootSecond());

        equation = service.solutionEquation(equation);

        Assert.assertNotNull(equation.getDiscriminant());
        Assert.assertNotNull(equation.getRootFirst());
        Assert.assertNotNull(equation.getRootSecond());
        Assert.assertThat(equation.getRootFirst(), is(-1.0));
        Assert.assertThat(equation.getRootSecond(), is(-1.0));
    }
    /**
     * Test calculate equation where discriminant not 0.
     */
    @Test
    public void calculateQuadraticEqulationWhereDiscriminantNotZero() {
        Equation equation = new Equation();
        equation.setCoefficientA(-4.25);
        equation.setCoefficientB(-7.0);
        equation.setCoefficientC(2.0);

        equation = service.solutionEquation(equation);
        Assert.assertThat(equation.getDiscriminant(), is(83.0));
        Assert.assertThat(equation.getRootSecond(), is(0.24828630342874108));
        Assert.assertThat(equation.getRootFirst(), is(-1.895345126958153));
    }
}