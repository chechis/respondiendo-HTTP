/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.sevicios;

import com.chechis.model.ModeloAsignatura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chechis
 */
public class ServicioAsignatura {
    
    private final List<ModeloAsignatura> asignaturas;
    
    private static final ServicioAsignatura INSTANCE = new ServicioAsignatura();
    
    public static ServicioAsignatura getInstance (){
        return INSTANCE;
    }
    
    private ServicioAsignatura() {
        asignaturas = new ArrayList<>();
        asignaturas.add(new ModeloAsignatura (1, "Puentes"));
        asignaturas.add(new ModeloAsignatura (2, "Costos, presupuestos y avaluos"));
        asignaturas.add(new ModeloAsignatura (3, "Estructuras de concreto"));
        asignaturas.add(new ModeloAsignatura (4, "Analisis estructural"));
    }
    
    public List<ModeloAsignatura> getAsignaturas (){
        return asignaturas;
    }
    
    public ModeloAsignatura getAsignatura(int id) {
        return asignaturas.get(id - 1);
    }
    
    public ModeloAsignatura addAsignatura(ModeloAsignatura curso) {
        curso.setId(asignaturas.size() + 1);
        asignaturas.add(curso);
        return curso;
    }
    
    public ModeloAsignatura updateAsignatura(int id, ModeloAsignatura modeloAsignatura) {
        modeloAsignatura.setId(id);
        asignaturas.set(id - 1, modeloAsignatura);
        return modeloAsignatura;
    }
    
    public ModeloAsignatura deleteAsignatura(int id) {
        return asignaturas.remove(id - 1);
    }
    
}
