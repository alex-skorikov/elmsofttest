package com.elmsofttest.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


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
    private Double coefficientA;
    /**
     * Coefficient B.
     */
    private Double coefficientB;
    /**
     * Coefficient C.
     */
    private Double coefficientC;
    /**
     * Discriminamt.
     */
    private Double discriminant;
    /**
     * First root quadratic equation.
     */
    private Double rootFirst;
    /**
     * Second root quadratic equation.
     */
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
     * @param id ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get equation id.
     *
     * @return ID.
     */
    public Long getId() {
        return id;
    }
}
