/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chechis.rest;



import com.chechis.dao.DaoNueva;
import com.chechis.model.ModeloNueva;
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
 * @author Julio Alvarez
 */
@Path("nueva")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Nueva {
    
    @GET
    public List<ModeloNueva> obtenerTareas(){
        try{
            return DaoNueva.getInstance().listar();
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @GET
    @Path("{nuevaId}")
    public ModeloNueva obtenerTarea(@PathParam("nuevaId") int id){
        try{
            return DaoNueva.getInstance().buscar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    @POST
    public void agregarNuevaTarea (ModeloNueva tarea){
        try{
            DaoNueva.getInstance().insertar(tarea);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{nuevaId}")
    public void actualizarTarea (@PathParam("nuevaId") int id, 
            ModeloNueva tarea){
        tarea.setId(id);
        try{
            DaoNueva.getInstance().actualizar(tarea);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("{nuevaId}")
    public void borrarTarea (@PathParam("nuevaId") int id){
        try{
            DaoNueva.getInstance().eliminar(id);
        }catch (SQLException ex){
            Logger.getLogger(Asignatura.class.getName()+
                    "Error al consultar la base de datos"+ex.getMessage()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
