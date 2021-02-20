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
}
