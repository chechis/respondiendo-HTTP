/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.dao;

import com.chechis.Conexion;
import com.chechis.IDAO;
import com.chechis.model.ModeloTarea;
import com.chechis.model.ModeloUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Alvarez
 */
public class DaoUsuario implements IDAO<ModeloUsuario> {
    
    private PreparedStatement insertar;
    private PreparedStatement eliminar;
    private PreparedStatement actualizar;
    private PreparedStatement buscar;
    private PreparedStatement listar;

    @Override
    public void insertar(ModeloUsuario entidad) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, contrasena, rol) VALUES (?, ?, ?)";
        
        if(insertar == null){
           insertar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        insertar.setString(1, entidad.getNombre());
        insertar.setString(2, entidad.getContrasena());
        insertar.setString(3, entidad.getRol());
        
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
    public List<ModeloUsuario> listar() throws SQLException {
        String query = "SELECT * FROM usuarios";
        
        if (listar == null) {
            listar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        ResultSet set = listar.executeQuery();
        ArrayList<ModeloUsuario> result = new ArrayList<>();
        while(set.next()){
            result.add(cargar(set));
        }
        
        return result;
    }

    @Override
    public ModeloUsuario buscar(Integer id) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        
        if (buscar == null) {
            buscar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(ModeloUsuario entidad) throws SQLException {
        String query = "UPDATE usuarios SET nombre=?, contrasena=?, rol=? WHERE id = ?";
        
        if (actualizar == null){
            actualizar = Conexion.getInstance().getCon().prepareStatement(query);
        }
        
        actualizar.setString(1, entidad.getNombre());
        actualizar.setString(2, entidad.getContrasena());
        actualizar.setString(3, entidad.getRol());
        actualizar.setInt(4, entidad.getId());
        actualizar.executeUpdate();
    }
    
    public ModeloUsuario cargar(ResultSet set) throws SQLException{
        
        ModeloUsuario usuario = new ModeloUsuario();
        
        usuario.setId(set.getInt("id"));
        usuario.setNombre(set.getString("nombre"));
        usuario.setContrasena(set.getString("contrasena"));
        usuario.setRol(set.getString("rol"));
        
        return usuario;
    }
    
}
