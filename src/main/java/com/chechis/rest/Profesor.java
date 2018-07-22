/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;

import com.chechis.model.ModeloUsuario;
import com.chechis.sevicios.ServicioUsuario;
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
@Path("profesor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Profesor {
    
    ServicioUsuario servicio= ServicioUsuario.getInstance();
    
    @GET
    public List<ModeloUsuario> obtenerProfesores(){
        return servicio.getUsuarios();
    }
    
    @GET
    @Path("{profesorId}")
    public ModeloUsuario obtenerProfesor(@PathParam("profesorId") int id){
        return servicio.getUsuario(id);
    }
    
    @POST
    public ModeloUsuario agregarNuevoProfesor (ModeloUsuario usuario){
        return servicio.addUsuario(usuario);
    }
    
    @PUT
    @Path("{profesorId}")
    public ModeloUsuario actualizarProfesor (@PathParam("profesorId") int id, 
            ModeloUsuario usuario){
        return servicio.updateUsuario(id, usuario);
    }
    
    @DELETE
    @Path("{profesorId}")
    public ModeloUsuario borrarProfesor (@PathParam("profesorId") int id){
        return servicio.deleteUsuario(id);
    }
    
}
