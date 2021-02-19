package com.elmsofttest.service;

import com.elmsofttest.dao.EquationDAO;
import com.elmsofttest.model.Equation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquationServiceImpl implements EquationService {
    @Autowired
    private EquationDAO equationDAO;
    @Override
    public void addEquation(Equation equation) {
        equationDAO.addEquation(equation);
    }

    public EquationServiceImpl() {
    }
}
