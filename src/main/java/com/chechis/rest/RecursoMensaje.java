/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Next University
 */
@Path("mensajess")
public class RecursoMensaje {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMensaje() {
        return "Se ha procesado la peticion sd.";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String postMensaje(String mensaje) {
        return "Se ha recibido el siguiente mensaje en una peticion POST: "
                + mensaje;
    }
    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String putMensaje(String mensaje) {
        return "Se ha recibido el siguiente mensaje en una peticion PUT: "
                + mensaje;
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public String deleteMensaje(String mensaje) {
        return "Se ha recibido el siguiente mensaje en una peticion DELETE: "
                + mensaje;
    }
    
}
