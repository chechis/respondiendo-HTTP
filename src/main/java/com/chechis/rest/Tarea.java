/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;


import com.chechis.dao.DaoTareas;
import com.chechis.model.ModeloTarea;
import com.chechis.sevicios.ServicioTarea;
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
@Path("tarea")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Tarea {
    
    ServicioTarea servicio= ServicioTarea.getInstance();
    
    @GET
    public List<ModeloTarea> obtenerTareas(){
        try{
            return DaoTareas.getInstance().listar();
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @GET
    @Path("{tareaId}")
    public ModeloTarea obtenerTarea(@PathParam("tareaId") int id){
        try{
            return DaoTareas.getInstance().buscar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    public void agregarNuevaTarea (ModeloTarea tarea){
        try{
            DaoTareas.getInstance().insertar(tarea);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{tareaId}")
    public void actualizarTarea (@PathParam("tareaId") int id, 
            ModeloTarea tarea){
        tarea.setId(id);
        try{
            DaoTareas.getInstance().actualizar(tarea);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("{tareaId}")
    public void borrarTarea (@PathParam("tareaId") int id){
        try{
            DaoTareas.getInstance().eliminar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
}
