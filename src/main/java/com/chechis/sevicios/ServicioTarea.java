/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.sevicios;

import com.chechis.model.ModeloTarea;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chechis
 */
public class ServicioTarea {
    
    private final List<ModeloTarea> tareas;
    
    private static final ServicioTarea INSTANCE = new ServicioTarea();
    
    public static ServicioTarea getInstance (){
        return INSTANCE;
    }
    
    private ServicioTarea() {
        tareas = new ArrayList<>();
        tareas.add(new ModeloTarea (1, "Investigar", "70" ));
    }
    
    public List<ModeloTarea> getAsignaturas (){
        return tareas;
    }
    
    public ModeloTarea getAsignatura(int id) {
        return tareas.get(id - 1);
    }
    
    public ModeloTarea addAsignatura(ModeloTarea tarea) {
        tarea.setId(tareas.size() + 1);
        tareas.add(tarea);
        return tarea;
    }
    
    public ModeloTarea updateAsignatura(int id, ModeloTarea tarea) {
        tarea.setId(id);
        tareas.set(id - 1, tarea);
        return tarea;
    }
    
    public ModeloTarea deleteAsignatura(int id) {
        return tareas.remove(id - 1);
    }
    
}
