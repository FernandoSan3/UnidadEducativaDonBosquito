/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bryam
 */
public class Conexion {
    
    private static Connection con = null;
    
    public static void coneccion(){
        
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/UnidadEducativa", "postgres", "cuenca");
            if(con != null){
                System.out.println("Coneccion exitosa");
            } else {
                System.out.println("Error a la coneccion");
            }
        } catch (SQLException e) {
            System.out.println("Error al Conectar la Base de Datos "+ e.getMessage());
        }
    }  
    
    public static void desconectar(){
        if(con != null){
            try {
                con.close();
                System.out.println("Desconeccion Exitosa");
            } catch (SQLException e) {
                System.out.println("Error al Desconectar "+e.getMessage());
            }
        }
    }

    public static Connection getCon() {
        return con;
    }
}
