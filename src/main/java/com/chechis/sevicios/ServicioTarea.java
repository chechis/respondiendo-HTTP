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
        tareas.add(new ModeloTarea (1, "Investigar", "80" ));
        tareas.add(new ModeloTarea (2, "Resolver matrices", "83" ));
        tareas.add(new ModeloTarea (3, "Predimensionar", "70" ));
        tareas.add(new ModeloTarea (4, "Deducir doble integral", "90" ));
        tareas.add(new ModeloTarea (5, "Coordenadas Polares", "75" ));
        tareas.add(new ModeloTarea (6, "Coordenadas Parametricas", "67" ));
    }
    
    public List<ModeloTarea> getTareas (){
        return tareas;
    }
    
    public ModeloTarea getTarea(int id) {
        return tareas.get(id - 1);
    }
    
    public ModeloTarea addTarea(ModeloTarea tarea) {
        tarea.setId(tareas.size() + 1);
        tareas.add(tarea);
        return tarea;
    }
    
    public ModeloTarea updateTarea(int id, ModeloTarea tarea) {
        tarea.setId(id);
        tareas.set(id - 1, tarea);
        return tarea;
    }
    
    public ModeloTarea deleteTarea(int id) {
        return tareas.remove(id - 1);
    }
    
}
