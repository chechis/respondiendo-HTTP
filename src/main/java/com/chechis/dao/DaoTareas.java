/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.dao;

import com.chechis.Conexion;
import com.chechis.IDAO;
import com.chechis.model.ModeloAsignatura;
import com.chechis.model.ModeloTarea;
import com.chechis.rest.Tarea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Alvarez
 */
public class DaoTareas implements IDAO<ModeloTarea> {
    
    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    @Override
    public void insertar(ModeloTarea entidad) throws SQLException {
        String query = "INSERT INTO tareas (nombre_tarea, nota) VALUES (?, ?)";
        
        if(insertar == null){
           insertar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        insertar.setString(1, entidad.getTarea());
        insertar.setString(2, entidad.getNota());
        
        insertar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String query = "DELETE FROM tareas WHERE id = ?";
        
        if (eliminar == null){
            eliminar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<ModeloTarea> listar() throws SQLException {
        String query = "SELECT * FROM tareas";
        
        if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        ResultSet set = listar.executeQuery();
        ArrayList<ModeloTarea> result = new ArrayList<>();
        while(set.next()){
            result.add(cargar(set));
        }
        
        return result;
    }

    @Override
    public ModeloTarea buscar(Integer id) throws SQLException {
        String query = "SELECT * FROM tareas WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(ModeloTarea entidad) throws SQLException {
        String query = "UPDATE tareas SET nombre_tarea=?, nota=? WHERE id = ?";
        
        if (actualizar == null){
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getTarea());
        actualizar.setString(2, entidad.getNota());
        actualizar.setInt(3, entidad.getId());
        actualizar.executeUpdate();
    }
    
    public ModeloTarea cargar(ResultSet set) throws SQLException{
        
        ModeloTarea tarea = new ModeloTarea();
        
        tarea.setId(set.getInt("id"));
        tarea.setTarea(set.getString("nombre_tarea"));
        tarea.setNota(set.getString("nota"));
        
        return tarea;
    }
    
}
