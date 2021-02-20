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
        boolean isValid = false;
        if (equation.getCoefficientA() != 0 && calculateDiscriminant(equation) >= 0) {
            isValid = true;
        }
        return isValid;
    }

    @Override
    public Equation solutionEquation(Equation equation) {
        double discriminant = calculateDiscriminant(equation);
        double rootFirst;
        double rootSecond;
        equation.setDiscriminant(discriminant);
        if (discriminant == 0) {
            rootFirst = (-1 * equation.getCoefficientB() + Math.sqrt(discriminant))
                    / (2 * equation.getCoefficientA());
            rootSecond = (-1 * equation.getCoefficientB() - Math.sqrt(discriminant))
                    / (2 * equation.getCoefficientA());
        } else {
            rootFirst = ((-1 * equation.getCoefficientB()) / 2) * equation.getCoefficientA();
            rootSecond = ((-1 * equation.getCoefficientB()) / 2) * equation.getCoefficientA();
        }
        equation.setRootFirst(rootFirst);
        equation.setRootSecond(rootSecond);
        return equation;
    }

    /**
     * Calculate discriminant.
     *
     * @param equation equation.
     * @return discriminant.
     */
    private double calculateDiscriminant(Equation equation) {
        return equation.getCoefficientB() * equation.getCoefficientB()
                - 4 * equation.getCoefficientA() * equation.getCoefficientC();
    }
}
