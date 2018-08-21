/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softtrons.genericentities.entities.jpa.enums;

/**
 *
 * @author danny
 */
public enum State {

    /**
     * Usuario activo
     */
    A("A", "Activo"),
    /**
     * Usuario inactivo
     */
    I("I", "Inactivo"),
    /**
     * Usuario bloqueado
     */
    B("B", "Bloqueado");

    private State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    private final String code;
    private final String name;

    /**
     * @return Code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

}
