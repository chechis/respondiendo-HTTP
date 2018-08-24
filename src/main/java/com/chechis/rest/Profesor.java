/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;

import com.chechis.dao.DaoAsignatura;
import com.chechis.dao.DaoUsuario;
import com.chechis.model.ModeloUsuario;
import com.chechis.sevicios.ServicioUsuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author chechis
 */
@Path("profesor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Profesor {
    
    ServicioUsuario servicio= ServicioUsuario.getInstance();
    
    @GET
    public List<ModeloUsuario> obtenerProfesores(){
        try{
            return DaoUsuario.getInstance().listar();
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
            return servicio.getUsuarios();
        }
       
    }
    
    @GET
    @Path("{profesorId}")
    public ModeloUsuario obtenerProfesor(@PathParam("profesorId") int id){
        try{
            return DaoUsuario.getInstance().buscar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    public void agregarNuevoProfesor (ModeloUsuario usuario){
        try{
            DaoUsuario.getInstance().insertar(usuario);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{profesorId}")
    public void actualizarProfesor (@PathParam("profesorId") int id, 
            ModeloUsuario usuario){
        usuario.setId(id);
        try{
            DaoUsuario.getInstance().actualizar(usuario);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("{profesorId}")
    public void borrarProfesor (@PathParam("profesorId") int id){
        try{
            DaoUsuario.getInstance().eliminar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
}
