/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.dao;

import com.chechis.Conexion;
import com.chechis.IDAO;
import com.chechis.model.ModeloNueva;
import com.chechis.model.ModeloTarea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Alvarez
 */
public class DaoNueva implements IDAO<ModeloNueva> {
    
    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;
    
    private static DaoNueva instancia;
    private DaoNueva (){
        
    }
    public static DaoNueva getInstance (){
        if(instancia==null){
            instancia=new DaoNueva();
        }
        return instancia;
              
    }
    

    @Override
    public void insertar(ModeloNueva entidad) throws SQLException {
        String query = "INSERT INTO nueva_tarea (nombre_tarea, asignatura, estudiante, nota) VALUES (?, ?, ?, ?)";
        
        if(insertar == null){
           insertar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        insertar.setString(1, entidad.getNombreTarea());
        insertar.setString(2, entidad.getAsignatura());
        insertar.setString(3, entidad.getEstudiante());
        insertar.setString(4, entidad.getNota());
        
        insertar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        String query = "DELETE FROM nueva_tarea WHERE id = ?";
        
        if (eliminar == null){
            eliminar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<ModeloNueva> listar() throws SQLException {
        String query = "SELECT * FROM nueva_tarea";
        
        if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        ResultSet set = listar.executeQuery();
        ArrayList<ModeloNueva> result = new ArrayList<>();
        while(set.next()){
            result.add(cargar(set));
        }
        
        return result;
    }

    @Override
    public ModeloNueva buscar(Integer id) throws SQLException {
        String query = "SELECT * FROM nueva_tarea WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(ModeloNueva entidad) throws SQLException {
        String query = "UPDATE nueva_tarea SET nombre_tarea=?, asignatura=?, estudiante=?, nota=? WHERE id = ?";
        
        if (actualizar == null){
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getNombreTarea());
        actualizar.setString(2, entidad.getAsignatura());
        actualizar.setString(3, entidad.getEstudiante());
        actualizar.setString(4, entidad.getNota());
        actualizar.setInt(5, entidad.getId());
        actualizar.executeUpdate();
    }
    
    
    public ModeloNueva cargar (ResultSet set) throws SQLException {
        
        ModeloNueva nueva = new ModeloNueva();
        
        nueva.setId(set.getInt("id"));
        nueva.setNombreTarea(set.getString("nombre_tarea"));
        nueva.setAsignatura(set.getString("asignatura"));
        nueva.setEstudiante(set.getString("estudiante"));
        nueva.setNota(set.getString("nota"));

        
        return nueva;
    }
    
}
