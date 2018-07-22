/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;

import com.chechis.model.ModeloAsignatura;
import com.chechis.sevicios.ServicioAsignatura;
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

@Path("hola")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Asignatura {
  
    
    ServicioAsignatura servicio= ServicioAsignatura.getInstance();
    
    @GET
    public List<ModeloAsignatura> obtenerAsignaturas(){
        return servicio.getAsignaturas();
    }
    
    @GET
    @Path("{asignaturaId}")
    public ModeloAsignatura obtenerAsignatura(@PathParam("asignaturaId") int id){
        return servicio.getAsignatura(id);
    }
    
    @POST
    public ModeloAsignatura agregarNuevaAsignatura (ModeloAsignatura asignatura){
        return servicio.addAsignatura(asignatura);
    }
    
    @PUT
    @Path("{asignaturaId}")
    public ModeloAsignatura actualizarAsignatura (@PathParam("asignaturaId") int id, 
            ModeloAsignatura asignatura){
        return servicio.updateAsignatura(id, asignatura);
    }
    
    @DELETE
    @Path("{asignaturaId}")
    public ModeloAsignatura borrarAsignatura (@PathParam("asignaturaId") int id){
        return servicio.deleteAsignatura(id);
    }
    
}
