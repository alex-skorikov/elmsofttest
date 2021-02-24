package com.elmsofttest.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


/**
 * Class Equation.
 */
@Entity
@Table(name = "equation")
public class Equation {
    /**
     * Equations id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Coefficient A.
     */
    @Column(name = "coefficienta")
    private Double coefficientA;
    /**
     * Coefficient B.
     */
    @Column(name = "coefficientb")
    private Double coefficientB;
    /**
     * Coefficient C.
     */
    @Column(name = "coefficientc")
    private Double coefficientC;
    /**
     * Discriminamt.
     */
    @Column(name = "discriminant")
    private Double discriminant;
    /**
     * First root quadratic equation.
     */
    @Column(name = "rootfirst")
    private Double rootFirst;
    /**
     * Second root quadratic equation.
     */
    @Column(name = "rootsecond")
    private Double rootSecond;

    /**
     * Default constructor.
     */
    public Equation() {
    }

    /**
     * Get coefficient a.
     *
     * @return coefficient a.
     */
    public Double getCoefficientA() {
        return coefficientA;
    }

    /**
     * Set coefficient a.
     *
     * @param coefficientA coefficicient a.
     */
    public void setCoefficientA(Double coefficientA) {
        this.coefficientA = coefficientA;
    }

    /**
     * Get coefficient b.
     *
     * @return coefficient b.
     */
    public Double getCoefficientB() {
        return coefficientB;
    }

    /**
     * Set coefficient b.
     *
     * @param coefficientB coefficient b.
     */
    public void setCoefficientB(Double coefficientB) {
        this.coefficientB = coefficientB;
    }

    /**
     * Get coefficient c.
     *
     * @return coefficient c.
     */
    public Double getCoefficientC() {
        return coefficientC;
    }

    /**
     * Set coefficient c.
     *
     * @param coefficientC coefficient c.
     */
    public void setCoefficientC(Double coefficientC) {
        this.coefficientC = coefficientC;
    }

    /**
     * Get discriminamt.
     *
     * @return discriminant.
     */
    public Double getDiscriminant() {
        return discriminant;
    }

    /**
     * Set discriminant.
     *
     * @param discriminant discriminant.
     */
    public void setDiscriminant(Double discriminant) {
        this.discriminant = discriminant;
    }

    /**
     * Get first root.
     *
     * @return first root.
     */
    public Double getRootFirst() {
        return rootFirst;
    }

    /**
     * Set first root.
     *
     * @param rootFirst first root.
     */
    public void setRootFirst(Double rootFirst) {
        this.rootFirst = rootFirst;
    }

    /**
     * Get second root.
     *
     * @return second root.
     */
    public Double getRootSecond() {
        return rootSecond;
    }

    /**
     * Set second root.
     *
     * @param rootSecond second root.
     */
    public void setRootSecond(Double rootSecond) {
        this.rootSecond = rootSecond;
    }

    /**
     * Set eqution id.
     *
     * @param id id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get equation id.
     *
     * @return id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Is coefficients valid.
     * @return is valid.
     */
    public boolean isValid() {
        boolean isValid = false;
        if (this.getCoefficientA() != 0 && calculateDiscriminant() >= 0) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Solution euation.
     * @return equation solution.
     */
    public Equation solutionEquation() {
        double discriminant = calculateDiscriminant();
        double rootFirst;
        double rootSecond;
        this.setDiscriminant(discriminant);
        if (discriminant == 0) {
            rootFirst = (-1 * this.getCoefficientB())
                    / (2 * this.getCoefficientA());
            rootSecond = rootFirst;
        } else {
            rootFirst = (-1 * this.getCoefficientB() + Math.sqrt(discriminant)) / (2 * this.getCoefficientA());
            rootSecond = (-1 * this.getCoefficientB() - Math.sqrt(discriminant)) / (2 * this.getCoefficientA());
        }
        this.setRootFirst(rootFirst);
        this.setRootSecond(rootSecond);
        return this;
    }

    /**
     * Calculate discriminant.
     * @return discriminant.
     */
    private double calculateDiscriminant() {
        return this.getCoefficientB() * this.getCoefficientB()
                - 4 * this.getCoefficientA() * this.getCoefficientC();
    }
}