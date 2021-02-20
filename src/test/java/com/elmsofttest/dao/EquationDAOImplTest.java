package com.elmsofttest.dao;

import com.elmsofttest.model.Equation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Equation DAO class test.
 */
@RunWith(MockitoJUnitRunner.class)
public class EquationDAOImplTest {
    /**
     * Equation DAO.
     */
    @InjectMocks
    private EquationDAOImpl equationDAO;
    /**
     * Session factory mock.
     */
    @Mock
    private SessionFactory sessionFactory;
    /**
     * Session mock.
     */
    @Mock
    private Session session;

    /**
     * Add equation test.
     */
    @Test
    public void whenAddEquationThenCallSessionMethodSaveTimesOne() {
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        Equation equation = new Equation();
        equation.setCoefficientA(2.5);
        equation.setCoefficientB(-2.5);
        equation.setCoefficientC(0.5);
        equation.setDiscriminant(5.5);
        equation.setId(1L);
        equation.setRootFirst(0.5);
        equation.setRootSecond(0.5);
        equationDAO.addEquation(equation);
        verify(session, times(1)).save(equation);
    }
}