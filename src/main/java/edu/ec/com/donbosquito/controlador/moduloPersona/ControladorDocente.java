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
public class ControladorDocente extends ControladorPersona {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql = "INSERT INTO \"edu_personas\" VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, docente.getCodigoPersona());
            preSta.setString(2, docente.getCedula());
            preSta.setString(3, docente.getNombre());
            preSta.setString(4, docente.getApellido());
            preSta.setString(5, docente.getDireccion());
            preSta.setString(6, docente.getTelefono());
            preSta.setString(7, docente.getCorreo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar la Persona" + e.getMessage());
        }

        sql1 = "INSERT INTO \"edu_docentes\" VALUES (?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, docente.getCodigoDocente());
            preSta.setString(2, docente.getTituloDocente());
            preSta.setInt(3, docente.getPersona().getCodigoPersona());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar al Docente " + e.getMessage());
        }
    }

    @Override
    public Object buscarUsuario(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
