/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;

import com.chechis.dao.DaoAsignatura;
import com.chechis.model.ModeloAsignatura;
import com.chechis.sevicios.ServicioAsignatura;
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

@Path("asignatura")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Asignatura {
  
    
    ServicioAsignatura servicio= ServicioAsignatura.getInstance();
    
    @GET
    public List<ModeloAsignatura> obtenerAsignaturas(){
        
        try{
            return DaoAsignatura.getInstance().listar();
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
            return servicio.getAsignaturas();
        }
        
       
    }
    
    @GET
    @Path("{asignaturaId}")
    public ModeloAsignatura obtenerAsignatura(@PathParam("asignaturaId") int id){
     
        try{
            return DaoAsignatura.getInstance().buscar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    public void agregarNuevaAsignatura (ModeloAsignatura asignatura){
        try{
            DaoAsignatura.getInstance().insertar(asignatura);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @PUT
    @Path("{asignaturaId}")
    public void actualizarAsignatura (@PathParam("asignaturaId") int id, 
            ModeloAsignatura asignatura){
        
        asignatura.setId(id);
        try{
            DaoAsignatura.getInstance().actualizar(asignatura);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("{asignaturaId}")
    public void borrarAsignatura (@PathParam("asignaturaId") int id){
        try{
            DaoAsignatura.getInstance().eliminar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
}
