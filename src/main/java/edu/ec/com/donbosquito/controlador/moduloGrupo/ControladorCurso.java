package edu.ec.com.donbosquito.controlador.moduloGrupo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernandosanchez
 */
public class ControladorCurso {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearCurso(Curso curso) {
        sql = "INSERT INTO \"edu_cursos\" (cur_abrebiatura,cur_curso) VALUES (?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, curso.getAbrebiatura());
            preSta.setString(2, curso.getCurso());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos el Curso: " + ex.getMessage());
        }
    }

    public void modificarCurso(Curso curso) {
        sql = "UPDATE \"edu_cursos\" SET cur_abrebiatura = ?, cur_curso = ?  WHERE cur_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, curso.getAbrebiatura());
            preSta.setString(2, curso.getCurso());
            preSta.setInt(3, curso.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();;
        } catch (SQLException e) {
            System.out.println("Error al actualizar el curso: " + e.getMessage());
        }

    }

    public Curso buscarCurso(String nombrecurso) {
        Curso curso = new Curso(0, "", "");
        sql = "SELECT * FROM \"edu_cursos\" WHERE cur_curso = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, nombrecurso);
            res = preSta.executeQuery();
            res.next();
            curso.setCodigo(res.getInt("cur_codigo"));
            curso.setAbrebiatura(res.getString("cur_abrebiatura"));
            curso.setCurso(res.getString("cur_curso"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Curso por nombre: " + e.getMessage());
        }
        return curso;

    }

    public Curso buscarCursoCodigo(int codigo) {
        Curso curso = new Curso(0, "", "");
        sql = "SELECT * FROM \"edu_cursos\" WHERE cur_codigo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            curso.setCodigo(res.getInt("cur_codigo"));
            curso.setAbrebiatura(res.getString("cur_abrebiatura"));
            curso.setCurso(res.getString("cur_curso"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Curso por codigo: " + e.getMessage());
        }
        return curso;

    }

    public void eliminarCurso(Curso curso) {
        sql = "DELETE FROM \"edu_cursos\" WHERE cur_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, curso.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el curso: " + ex.getMessage());
        }

    }

    public List<Curso> listarCursos() {

        List<Curso> listarCurso = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_cursos\" ORDER BY cur_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Curso curso = new Curso(0, "", "");
                curso.setCodigo(res.getInt("cur_codigo"));
                curso.setAbrebiatura(res.getString("cur_abrebiatura"));
                curso.setCurso(res.getString("cur_curso"));
                listarCurso.add(curso);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario Curso " + e.getMessage());
        }
        return listarCurso;
    }

}
