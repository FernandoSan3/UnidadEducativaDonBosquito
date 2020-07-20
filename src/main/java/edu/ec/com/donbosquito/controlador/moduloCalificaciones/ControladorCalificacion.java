/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloCalificaciones;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorEstudiante;
import edu.ec.com.donbosquito.modelo.moduloCalificaciones.Calificacion;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
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
public class ControladorCalificacion {

    private PreparedStatement preSta;
    private String sql;
    private ResultSet res;

    public void guardarCalificaion(Calificacion calificacion) {
        sql = "INSERT INTO \"edu_calificaiones\" VALUES (?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, calificacion.getCodigoCalificacion());
            preSta.setDouble(2, calificacion.getPromedioCalificion());
            preSta.setInt(3, calificacion.getEstudiante().getCodigoEstudiante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardad las calificaciones" + e.getMessage());
        }
    }

    public void actualizarCalificacion(Calificacion calificacion) {
        sql = "UPDATE \"edu_calificaciones\" SET cal_promedio=? , fk_est_codigo=? WHERE cal_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setDouble(1, calificacion.getPromedioCalificion());
            preSta.setInt(2, calificacion.getEstudiante().getCodigoEstudiante());
            preSta.setInt(2, calificacion.getCodigoCalificacion());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar las Calificaciones" + e.getMessage());
        }
    }

    public void eliminarCalificacion(Calificacion calificacion) {
        sql = "DELETE FROM \"edu_calificaciones\" WHERE cal_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, calificacion.getCodigoCalificacion());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la calificacion" + e.getMessage());
        }
    }

    public Calificacion buscarCodigoCalificacion(int codigo) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        Calificacion calificacion = new Calificacion(0, 0.0, estudiante);
        
        ControladorEstudiante conEstudiante = new ControladorEstudiante();
        sql = "SELECT * FROM \"edu_calificaciones\" WHERE cal_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            calificacion.setCodigoCalificacion(res.getInt("cal_codigo"));
            calificacion.setPromedioCalificion(res.getDouble("cal_promedio"));
            calificacion.setEstudiante(conEstudiante.buscarUsuario(res.getInt("fk_est_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar las calificaciones por el codigo." + e.getMessage());
        }
        return calificacion;
    }

    public Calificacion buscarCedulaCalificacion(int cedula) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        Calificacion calificacion = new Calificacion(0, 0.0, estudiante);

        ControladorEstudiante conEstudiante = new ControladorEstudiante();
        sql = "SELECT * FROM edu_personas p, edu_estudiantes e, edu_calificaciones c WHERE p.per_codigo = e.fk_per_codigo AND e.est_codigo = c.fk_est_codigo AND p.per_cedula = '0105885875'; ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, cedula);
            res = preSta.executeQuery();
            res.next();
            calificacion.setCodigoCalificacion(res.getInt("cal_codigo"));
            calificacion.setPromedioCalificion(res.getDouble("cal_promedio"));
            calificacion.setEstudiante(conEstudiante.buscarUsuario(res.getInt("fk_est_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar las calificaciones por la cedula." + e.getMessage());
        }
        return calificacion;
    }

    public List<Calificacion> listarCalificacion() {

        List<Calificacion> listarCalificacion = new ArrayList<>();
        sql = "SELECT * FROM \"edu_calificaciones\" ORDER BY cal_codigo ASC";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {
                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
                Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
                Calificacion calificacion = new Calificacion(0, 0.0, estudiante);
                ControladorEstudiante conEstudiante = new ControladorEstudiante();

                calificacion.setCodigoCalificacion(res.getInt("cal_codigo"));
                calificacion.setPromedioCalificion(res.getDouble("cal_promedio"));
                calificacion.setEstudiante(conEstudiante.buscarUsuario(res.getInt("fk_est_codigo")));
                listarCalificacion.add(calificacion);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar las calificaciones " + e.getMessage());
        }
        return listarCalificacion;
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
}
