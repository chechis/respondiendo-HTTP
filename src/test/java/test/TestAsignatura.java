/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.chechis.dao.DaoAsignatura;
import com.chechis.model.ModeloAsignatura;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chechis
 */
public class TestAsignatura {
    
    public static void main(String [] args){
        DaoAsignatura dao = new DaoAsignatura();
        
        try{
//            dao.insertar(new ModeloAsignatura("costos"));
//            dao.insertar(new ModeloAsignatura("puentes"));
//            System.out.println("Usuarios insertados");
//          lo de arriba es para insetar y lo de abajo para borrar primero lo de arriba
//            eliminar
//            dao.eliminar(1);
//            System.out.println("Usuario eliminado");

//            actualizar

//            ModeloAsignatura modelo = new ModeloAsignatura("cimentaciones");
//            modelo.setId(2);
//            dao.actualizar(modelo);
//            System.out.println("Usuario modificado");

//            buscar recordar poner toString en el modelo

//            System.out.println(dao.buscar(2));
            
//            listar, para verlo mejor se cambio el to string del modelo, mejor si hay varios usuarios 

              System.out.println(dao.listar());

        }catch(SQLException ex){
            Logger.getLogger(TestAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Ha ocurrido un error"+ex.getMessage());
            
        }
       
    }
    
}
