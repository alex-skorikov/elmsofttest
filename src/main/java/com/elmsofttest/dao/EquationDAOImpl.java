package com.elmsofttest.dao;

import com.elmsofttest.model.Equation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Equation repository.
 */
@Repository
public class EquationDAOImpl implements EquationDAO {
    /**
     * Session factory.
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Current session.
     * @return session.
     */
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Add equation to DB.
     * @param equation equation.
     */
    @Override
    public void addEquation(Equation equation) {
        getCurrentSession().save(equation);
    }
}
