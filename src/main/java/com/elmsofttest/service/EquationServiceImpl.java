package com.elmsofttest.service;

import com.elmsofttest.dao.EquationDAO;
import com.elmsofttest.model.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation eqution service.
 */
@Service
@Transactional
public class EquationServiceImpl implements EquationService {
    /**
     * Equation DAO.
     */
    @Autowired
    private EquationDAO equationDAO;

    /**
     * Add equation to DB.
     *
     * @param equation equation.
     */
    @Override
    public void addEquation(Equation equation) {
        equationDAO.addEquation(equation);
    }

    @Override
    public boolean validateCoefficients(Equation equation) {
        return equation.isValid();
    }

    @Override
    public Equation solutionEquation(Equation equation) {
        return equation.solutionEquation();
    }

}
