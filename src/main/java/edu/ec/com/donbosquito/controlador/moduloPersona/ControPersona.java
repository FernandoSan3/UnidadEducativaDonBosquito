/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloPersona;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author Bryam
 */
public class ControPersona {
    
    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    
    public Persona buscarPersona(int codigoPersona) {

        Persona persona = new Persona(0, "", "", "", "", "", "") {};

        sql = "SELECT * FROM \"edu_personas\" WHERE per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigoPersona);
            res = preSta.executeQuery();
            res.next();
            persona.setCodigoPersona(res.getInt("per_codigo"));
            persona.setCedula(res.getString("per_cedula"));
            persona.setNombre(res.getString("per_nombre"));
            persona.setApellido(res.getString("per_apellido"));
            persona.setDireccion(res.getString("per_direccion"));
            persona.setTelefono(res.getString("per_telefono"));
            persona.setCorreo(res.getString("per_correo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar a la Persona por el codigo " + e.getMessage());
        }
        return persona;
    }

    
}
