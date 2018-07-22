/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;

import com.chechis.model.ModeloTarea;
import com.chechis.sevicios.ServicioTarea;
import java.util.List;
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
        return servicio.getTareas();
    }
    
    @GET
    @Path("{tareaId}")
    public ModeloTarea obtenerTarea(@PathParam("tareaId") int id){
        return servicio.getTarea(id);
    }
    
    @POST
    public ModeloTarea agregarNuevaTarea (ModeloTarea tarea){
        return servicio.addTarea(tarea);
    }
    
    @PUT
    @Path("{tareaId}")
    public ModeloTarea actualizarTarea (@PathParam("tareaId") int id, 
            ModeloTarea tarea){
        return servicio.updateTarea(id, tarea);
    }
    
    @DELETE
    @Path("{tareaId}")
    public ModeloTarea borrarTarea (@PathParam("tareaId") int id){
        return servicio.deleteTarea(id);
    }
    
}
