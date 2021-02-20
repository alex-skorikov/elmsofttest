package com.elmsofttest.service;

import com.elmsofttest.model.Equation;

/**
 * Equation service.
 */
public interface EquationService {
    /**
     * Add equation, for save to DB..
     * @param equation equation.
     */
    void addEquation(Equation equation);

    /**
     * Validate Equation coefficients.
     * @param equation equation.
     * @return is valid.
     */
    boolean validateCoefficients(Equation equation);

    /**
     * Solution.
     * @param equation equation.
     * @return equation.
     */
    Equation solutionEquation(Equation equation);
}
