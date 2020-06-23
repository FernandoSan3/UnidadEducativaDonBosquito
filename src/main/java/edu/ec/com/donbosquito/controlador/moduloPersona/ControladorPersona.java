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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryam
 */
public abstract class ControladorPersona {

    public abstract void crearUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona);

    public abstract Object buscarUsuario(int codigo);

    public abstract void modificarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona);

    public abstract void eliminarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona);
}
