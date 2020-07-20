/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloCalificaciones;

import edu.ec.com.donbosquito.conexion.Conexion;
import static edu.ec.com.donbosquito.controlador.moduloCalificaciones.ControladorCalificacion.ParseFecha;
import edu.ec.com.donbosquito.controlador.moduloGrupo.ControladorMateria;
import edu.ec.com.donbosquito.controlador.moduloMatricula.ControladorMatricula;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorEstudiante;
import edu.ec.com.donbosquito.modelo.moduloCalificaciones.Calificacion;
import edu.ec.com.donbosquito.modelo.moduloCalificaciones.Quimestre;
import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoCabecera;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Materia;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
import edu.ec.com.donbosquito.modelo.moduloMatricula.Matricula;
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
public class ControladorQuimestre {

    private PreparedStatement preSta;
    private String sql;
    private ResultSet res;

    public void guardarQuimestre(Quimestre quimestre) {
        sql = "INSERT INTO \"edu_quimestres\" VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, quimestre.getCodigoQuimestre());
            preSta.setDouble(2, quimestre.getPrimerBloque());
            preSta.setDouble(3, quimestre.getSegundoBloque());
            preSta.setDouble(4, quimestre.getTercerBloque());
            preSta.setDouble(5, quimestre.getExamen());
            preSta.setDouble(6, quimestre.getAprovechamiento());
            preSta.setDouble(7, quimestre.getNotaQuimestre());
            preSta.setString(8, quimestre.getEstadoMateria());
            preSta.setInt(9, quimestre.getMatricula().getCodigo());
            preSta.setInt(10, quimestre.getCalificacion().getCodigoCalificacion());
            preSta.setInt(11, quimestre.getMateria().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardad las notas del quimestre" + e.getMessage());
        }
    }

    public void actualizarQuimestre(Quimestre quimestre) {
        sql = "UPDATE \"edu_quimestres\" SET qui_primer_bloque=?, qui_segundo_bloque=?, qui_tercer_bloque=?, qui_examen=?, qui_aprovechamiento=?, qui_nota_quimestre=?, "
                + "qui_estadoo_materia=?, fk_matri_codigo=?, fk_cal_codigo=?, fk__mat_codigo=?   WHERE qui_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setDouble(1, quimestre.getPrimerBloque());
            preSta.setDouble(2, quimestre.getSegundoBloque());
            preSta.setDouble(3, quimestre.getTercerBloque());
            preSta.setDouble(4, quimestre.getExamen());
            preSta.setDouble(5, quimestre.getAprovechamiento());
            preSta.setDouble(6, quimestre.getNotaQuimestre());
            preSta.setString(7, quimestre.getEstadoMateria());
            preSta.setInt(8, quimestre.getMatricula().getCodigo());
            preSta.setInt(9, quimestre.getCalificacion().getCodigoCalificacion());
            preSta.setInt(10, quimestre.getMateria().getCodigo());
            preSta.setInt(11, quimestre.getCodigoQuimestre());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar las notas del quimestre" + e.getMessage());
        }
    }

    public void eliminarCalificacion(Quimestre quimestre) {
        sql = "DELETE FROM \"edu_quimestres\" WHERE qui_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, quimestre.getCodigoQuimestre());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el quimestre" + e.getMessage());
        }
    }

    public Quimestre buscarCodigoQuimestre(int codigo) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");

        Mension mension = new Mension(0, "", "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Curso curso = new Curso(0, "", "");
        GrupoCabecera grupo = new GrupoCabecera(codigo, sql, sql, curso, anioLectivo, mension);

        Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), estudiante, grupo);
        Calificacion calificacion = new Calificacion(0, 0.0, estudiante);
        Materia materia = new Materia(0, "", "", "", 0);
        Quimestre quimestre = new Quimestre(0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "", matricula, calificacion, materia);

        ControladorMatricula controMatricula = new ControladorMatricula();
        ControladorMateria controMateria = new ControladorMateria();
        ControladorCalificacion controCalificacion = new ControladorCalificacion();

        sql = "SELECT * FROM \"edu_quimestres\" WHERE qui_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            quimestre.setCodigoQuimestre(res.getInt("qui_coidgo"));
            quimestre.setPrimerBloque(res.getDouble("qui_primer_bloque"));
            quimestre.setSegundoBloque(res.getDouble("qui_segundo_bloque"));
            quimestre.setTercerBloque(res.getDouble("qui_tercer_bloque"));
            quimestre.setExamen(res.getDouble("qui_examne"));
            quimestre.setAprovechamiento(res.getDouble("qui_aprovechamiento"));
            quimestre.setNotaQuimestre(res.getDouble("qui_nota_quimestre"));
            quimestre.setEstadoMateria(res.getString("qui_estado_materia"));
            quimestre.setMatricula(controMatricula.buscarMatriculaCodigo(res.getInt("fk_matri_codigo")));
            quimestre.setCalificacion(controCalificacion.buscarCodigoCalificacion(res.getInt("fk_cal_codigo")));
            quimestre.setMateria(controMateria.buscarMateriaCodigo(res.getInt("fk_mat_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar el quimestre por el codigo." + e.getMessage());
        }
        return quimestre;
    }

    public List<Quimestre> listarQuimestre() {

        List<Quimestre> listarQuimestre = new ArrayList<>();
        sql = "SELECT * FROM \"edu_quimestres\" ORDER BY qui_codigo ASC";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {
                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
                Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");

                Mension mension = new Mension(0, "", "", "");
                AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                Curso curso = new Curso(0, "", "");
                GrupoCabecera grupo = new GrupoCabecera(0, sql, sql, curso, anioLectivo, mension);

                Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), estudiante, grupo);
                Calificacion calificacion = new Calificacion(0, 0.0, estudiante);
                Materia materia = new Materia(0, "", "", "", 0);
                Quimestre quimestre = new Quimestre(0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "", matricula, calificacion, materia);

                ControladorMatricula controMatricula = new ControladorMatricula();
                ControladorMateria controMateria = new ControladorMateria();
                ControladorCalificacion controCalificacion = new ControladorCalificacion();

                quimestre.setCodigoQuimestre(res.getInt("qui_coidgo"));
                quimestre.setPrimerBloque(res.getDouble("qui_primer_bloque"));
                quimestre.setSegundoBloque(res.getDouble("qui_segundo_bloque"));
                quimestre.setTercerBloque(res.getDouble("qui_tercer_bloque"));
                quimestre.setExamen(res.getDouble("qui_examne"));
                quimestre.setAprovechamiento(res.getDouble("qui_aprovechamiento"));
                quimestre.setNotaQuimestre(res.getDouble("qui_nota_quimestre"));
                quimestre.setEstadoMateria(res.getString("qui_estado_materia"));
                quimestre.setMatricula(controMatricula.buscarMatriculaCodigo(res.getInt("fk_matri_codigo")));
                quimestre.setCalificacion(controCalificacion.buscarCodigoCalificacion(res.getInt("fk_cal_codigo")));
                quimestre.setMateria(controMateria.buscarMateriaCodigo(res.getInt("fk_mat_codigo")));
                listarQuimestre.add(quimestre);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar los quimestres " + e.getMessage());
        }
        return listarQuimestre;
    }
}
