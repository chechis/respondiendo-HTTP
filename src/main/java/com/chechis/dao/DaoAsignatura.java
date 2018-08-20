/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.dao;

import com.chechis.Conexion;
import com.chechis.IDAO;
import com.chechis.model.ModeloAsignatura;
import com.chechis.rest.Asignatura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chechis
 */
public class DaoAsignatura implements IDAO<ModeloAsignatura> {
    
    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;
    
    
    
    @Override
    public void insertar(ModeloAsignatura entidad) throws SQLException {
        //donde dice usuarios, es la tabla de workbench y nombre_usuario... son sus columnas
        String query = "INSERT INTO usuarios (nombre_usuario) VALUES (?)";
        
        if(insertar == null){
           insertar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        insertar.setString(1, entidad.getAsignatura());
        
        insertar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        
        String query = "DELETE FROM usuarios WHERE id = ?";
        
        if (eliminar == null){
            eliminar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<ModeloAsignatura> listar() throws SQLException {
        String query = "SELECT * FROM usuarios";
        
        if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        ResultSet set = listar.executeQuery();
        ArrayList<ModeloAsignatura> result = new ArrayList<>();
        while(set.next()){
            result.add(cargar(set));
        }
        
        return result;
       
    }

    @Override
    public ModeloAsignatura buscar(Integer id) throws SQLException {
        
        String query = "SELECT * FROM usuarios WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;
        
    }

    @Override
    public void actualizar(ModeloAsignatura entidad) throws SQLException {
        
        String query = "UPDATE usuarios SET nombre_usuario=? WHERE id = ?";
        
        if (actualizar == null){
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getAsignatura());
        actualizar.setInt(2, entidad.getId());
        actualizar.executeUpdate();
        
    }

    public ModeloAsignatura cargar(ResultSet set) throws SQLException{
        
        ModeloAsignatura usuario = new ModeloAsignatura();
        
        usuario.setId(set.getInt("id"));
        usuario.setAsignatura(set.getString("nombre_usuario"));
        
        return usuario;
    }
    
    
}
