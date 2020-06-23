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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class ControladorEstudiante extends ControladorPersona {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql = "INSERT INTO \"edu_personas\" VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, estudiante.getCodigoPersona());
            preSta.setString(2, estudiante.getCedula());
            preSta.setString(3, estudiante.getNombre());
            preSta.setString(4, estudiante.getApellido());
            preSta.setString(5, estudiante.getDireccion());
            preSta.setString(6, estudiante.getTelefono());
            preSta.setString(7, estudiante.getCorreo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar la Persona" + e.getMessage());
        }

        sql1 = "INSERT INTO \"edu_estudiantes\" VALUES (?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, estudiante.getCodigoEstudiante());
            preSta.setDate(2, new Date(estudiante.getFechaNaciemiento().getTime()));
            preSta.setInt(3, estudiante.getEdad());
            preSta.setDate(4, new Date(estudiante.getFechaInscripcion().getTime()));
            preSta.setInt(5, estudiante.getPersona().getCodigoPersona());
            preSta.setInt(6, estudiante.getRepresentante().getCodigoRepresentante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar al Estudiante " + e.getMessage());
        }
    }

    public Estudiante buscarUsuario(int codigoEstudiante) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        sql = "SELECT * FROM \"edu_estudiantes\" WHERE est_codigo=?";
        Conexion.coneccion();
        try {
            ControPersona cp = new ControPersona();
            ControladorRepresentante cr = new ControladorRepresentante();
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigoEstudiante);
            res = preSta.executeQuery();
            res.next();
            estudiante.setCodigoEstudiante(res.getInt("est_codigo"));
            estudiante.setFechaNaciemiento(res.getDate("est_fecha_nacimiento"));
            estudiante.setEdad(res.getInt("est_edad"));
            estudiante.setFechaInscripcion(res.getDate("est_fecha_inscripcion"));
            estudiante.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            estudiante.setRepresentante((Representante) cr.buscarUsuario(res.getInt("fk_rep_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar al Estudiante por el codigo" + e.getMessage());
        }
        return estudiante;
    }

    public void modificarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql1 = "UPDATE \"edu_personas\" SET per_cedula=? , per_nombre=?, per_apellido=?, per_direccion=? , per_telefono=? , per_correo=? WHERE per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setString(1, estudiante.getCedula());
            preSta.setString(2, estudiante.getNombre());
            preSta.setString(3, estudiante.getApellido());
            preSta.setString(4, estudiante.getDireccion());
            preSta.setString(5, estudiante.getTelefono());
            preSta.setString(6, estudiante.getCorreo());
            preSta.setInt(7, estudiante.getCodigoPersona());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar a la Persona" + e.getMessage());
        }

        sql = "UPDATE \"edu_estudiantes\" SET est_fecha_nacimiento=?, est_edad=?, est_fecha_inscripcion=?, fk_per_codigo=?, fk_rep_codigo=? WHERE est_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setDate(1, new Date (estudiante.getFechaNaciemiento().getTime()));
            preSta.setInt(2, estudiante.getEdad());
            preSta.setDate(3, new Date (estudiante.getFechaInscripcion().getTime()));
            preSta.setInt(4, estudiante.getPersona().getCodigoPersona());
            preSta.setInt(5, estudiante.getRepresentante().getCodigoRepresentante());
            preSta.setInt(6, estudiante.getCodigoEstudiante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar a Estudiante " + e.getMessage());
        }
    }
    
    public List<Estudiante> listarUsuario() {

        List<Estudiante> listarEstudiante = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_estudiantes\" ORDER BY est_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
                Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
                ControPersona cp = new ControPersona();
                ControladorRepresentante cr = new ControladorRepresentante();
                estudiante.setCodigoEstudiante(res.getInt("est_codigo"));
                estudiante.setFechaNaciemiento(res.getDate("est_fecha_nacimiento"));
                estudiante.setEdad(res.getInt("est_edad"));
                estudiante.setFechaInscripcion(res.getDate("est_fecha_inscripcion"));
                estudiante.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
                estudiante.setRepresentante((Representante) cr.buscarUsuario(res.getInt("fk_rep_codigo")));
                listarEstudiante.add(estudiante);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario " + e.getMessage());
        }
        return listarEstudiante;
    }
    
    

    public static java.util.Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    @Override
    public void eliminarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
