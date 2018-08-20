/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chechis
 */

@XmlRootElement
public class ModeloAsignatura {
    
    private int id;
    
    private String asignatura;

    public ModeloAsignatura() {
    }

    public ModeloAsignatura(int id, String asignatura) {
        this.id = id;
        this.asignatura = asignatura;
    }
    
    
    public ModeloAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @XmlElement
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
   
}
