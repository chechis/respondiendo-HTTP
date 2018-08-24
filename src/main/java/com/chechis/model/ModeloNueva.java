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
 * @author Julio Alvarez
 */
@XmlRootElement
public class ModeloNueva {
    
    private int id;
    private String nombreTarea;
    private String asignatura;
    private String estudiante;
    private String nota;

    public ModeloNueva() {
    }

    public ModeloNueva(int id, String nombreTarea, String asignatura, String estudiante, String nota) {
        this.id = id;
        this.nombreTarea = nombreTarea;
        this.asignatura = asignatura;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    public ModeloNueva(String nombreTarea, String asignatura, String estudiante, String nota) {
        this.nombreTarea = nombreTarea;
        this.asignatura = asignatura;
        this.estudiante = estudiante;
        this.nota = nota;
    }

    

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
    
    @XmlElement
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @XmlElement
    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    @XmlElement
    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

   
    @Override
    public String toString() {
        return "ModeloNueva{" + "id=" + id + ", nombreTarea=" + nombreTarea + ", asignatura=" + asignatura + ", estudiante=" + estudiante + ", nota=" + nota + '}';
    }

    
    
    
    
    
}
