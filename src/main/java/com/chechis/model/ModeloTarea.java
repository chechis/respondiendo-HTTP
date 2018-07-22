/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chechis
 */
@XmlRootElement
public class ModeloTarea {
    
    private int id;
    private String tarea;
    private String nota;

    public ModeloTarea() {
    }
    
    public ModeloTarea(int id, String tarea, String nota) {
        this.id = id;
        this.tarea = tarea;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
    
    
}
