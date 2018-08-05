/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.sevicios;

import com.chechis.model.ModeloUsuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chechis
 */
public class ServicioUsuario {
    
    
    private final List<ModeloUsuario> usuarios;
    
    private static final ServicioUsuario INSTANCE = new ServicioUsuario();
    
    public static ServicioUsuario getInstance (){
        return INSTANCE;
    }
    
    private ServicioUsuario() {
        usuarios = new ArrayList<>();
        usuarios.add(new ModeloUsuario (1, "Dilma", "123456", "1" ));
        usuarios.add(new ModeloUsuario (2, "Mariano", "12", "1" ));
        usuarios.add(new ModeloUsuario (3, "Lucas", "150792", "1" ));
        usuarios.add(new ModeloUsuario (4, "Gustavo", "rochen", "estudiante" ));
        usuarios.add(new ModeloUsuario (5, "Adalberto", "69", "estudiante" ));
        
    }
    
    public List<ModeloUsuario> getUsuarios (){
        return usuarios;
    }
    
    public ModeloUsuario getUsuario(int id) {
        return usuarios.get(id - 1);
    }
    
    public ModeloUsuario addUsuario(ModeloUsuario profesor) {
        profesor.setId(usuarios.size() + 1);
        usuarios.add(profesor);
        return profesor;
    }
    
    public ModeloUsuario updateUsuario(int id, ModeloUsuario profesor) {
        profesor.setId(id);
        usuarios.set(id - 1, profesor);
        return profesor;
    }
    
    public ModeloUsuario deleteUsuario(int id) {
        return usuarios.remove(id - 1);
    }
    
}
