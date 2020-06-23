/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloPersona;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bryam
 */
public class ControladorDocente   {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;

    public void crearUsuario(Estudiante estudiante, Representante representante, Docente docente, Persona persona) {
        sql = "INSERT INTO \"edu_docentes\" VALUES (?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, docente.getCodigoDocente());
            preSta.setString(2, docente.getTituloDocente());
            preSta.setInt(3, persona.getCodigoPersona());

            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar al Docente " + e.getMessage());
        }
    }

}
