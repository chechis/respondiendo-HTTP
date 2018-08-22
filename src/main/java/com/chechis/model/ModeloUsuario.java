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
public class ModeloUsuario {
    
    private int id;
    private String nombre;
    private String contrasena;
    private String rol;

    public ModeloUsuario() {
    }

    public ModeloUsuario(String nombre, String contrasena, String rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    

    public ModeloUsuario(int id, String nombre, String contrasena, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @XmlElement
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "ModeloUsuario{" + "id=" + id + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol + '}';
    }
    
    
            
}
