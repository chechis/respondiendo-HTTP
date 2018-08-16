/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.chechis.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chechis
 */
public class TestConexion {
    
    public static void main(String[] args){
        try{
            if(Conexion.getInstance().existeConexion()){
                System.out.println("Se establecio conexion");
            }
                   
        }catch (SQLException ex){
            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
