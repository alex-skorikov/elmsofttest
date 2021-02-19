package com.elmsofttest.dao;

import com.elmsofttest.model.Equation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EquationDAOImpl implements EquationDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public EquationDAOImpl() {
    }

    @Override
    public void addEquation(Equation equation) {
        getCurrentSession().save(equation);
    }
}
