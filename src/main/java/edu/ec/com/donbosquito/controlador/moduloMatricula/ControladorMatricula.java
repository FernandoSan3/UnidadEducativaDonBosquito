/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloMatricula;

import edu.ec.com.donbosquito.modelo.moduloMatricula.Matricula;
import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.controlador.moduloGrupo.ControladorGrupoCabecera;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorEstudiante;
import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;

import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoCabecera;

import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
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
 * @author jorim
 */
public class ControladorMatricula {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;

    public void crearMatricula(Matricula datos) {
        sql = "INSERT INTO \"edu_matriculas\" VALUES (?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setDate(2, new Date(datos.getFechaMatricula().getTime()));
            preSta.setInt(3, datos.getEstudiante().getCodigoEstudiante());
            preSta.setInt(4, datos.getGrupoCabecera().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar el año" + e.getMessage());
        }
    }

    public void actualizarMatricula(Matricula datos) {
        sql = "UPDATE \"edu_matriculas\" SET  matri_fecha=? , gru_cab_codigo=? ,est_codigo=?  WHERE matri_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setDate(2, new Date(datos.getFechaMatricula().getTime()));
            preSta.setInt(3, datos.getEstudiante().getCodigoEstudiante());
            preSta.setInt(4, datos.getGrupoCabecera().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Guia" + e.getMessage());
        }
    }

    public void eliminarMatricula(Matricula datos) {
        sql = "DELETE FROM \"edu_matriculas\" WHERE matri_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Guia" + e.getMessage());
        }
    }

    public Matricula buscarMatriculaCodigo(int codigo) {
        ControladorEstudiante controladorEstudiante = new ControladorEstudiante();
        ControladorGrupoCabecera controladorGrupoCabecera = new ControladorGrupoCabecera();
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), codigo, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        Mension mension = new Mension(0, "", "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Curso curso = new Curso(0, "", "");
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", "", curso, anioLectivo, mension);
        Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), estudiante, grupoCabecera);

        sql = "SELECT * FROM \"edu_matriculas\" WHERE matri_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            matricula.setCodigo(res.getInt("matri_codigo"));
            matricula.setFechaMatricula(res.getDate("matri_fecha"));
            matricula.setEstudiante(controladorEstudiante.buscarCedulaEstudiante(res.getString("est_codigo")));
            matricula.setGrupoCabecera(controladorGrupoCabecera.buscarGrupoCabeceraCodigo(res.getInt("gru_cab_codigo")));

            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar la ficha medica por el codigo" + e.getMessage());
        }
        return matricula;
    }

    public List<Matricula> listarMatriculas() {

        List<Matricula> listarMatriculas = new ArrayList<>();
        sql = "SELECT * FROM \"edu_matriculas\" ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {

                Persona persona = new Persona(0, "", "", "", "", "", sql) {
                };
                Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
                Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
                Mension mension = new Mension(0, sql, sql, sql);
                AnioLectivo anioLectivo = new AnioLectivo(0, sql, ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                Curso curso = new Curso(0, sql, sql);
                GrupoCabecera grupoCabecera = new GrupoCabecera(0, sql, sql, sql, curso, anioLectivo, mension);
                Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), estudiante, grupoCabecera);

                ControladorGrupoCabecera controladorGrupoCabecera = new ControladorGrupoCabecera();
                ControladorEstudiante controladorEstudiante = new ControladorEstudiante();

                matricula.setCodigo(res.getInt("matri_codigo"));
                matricula.setFechaMatricula(res.getDate("matri_fecha"));
                matricula.setEstudiante(controladorEstudiante.buscarCedulaEstudiante(res.getString("est_codigo")));
                matricula.setGrupoCabecera(controladorGrupoCabecera.buscarGrupoCabeceraCodigo(res.getInt("gru_cab_codigo")));

                matricula.setGrupoCabecera(grupoCabecera);
                listarMatriculas.add(matricula);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Grupo Detalle " + e.getMessage());
        }
        return listarMatriculas;
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
