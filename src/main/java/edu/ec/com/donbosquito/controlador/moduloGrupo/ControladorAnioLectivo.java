/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloGrupo;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;
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
 * @author fernandosanchez
 */
public class ControladorAnioLectivo {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearAnioLectivo(AnioLectivo anioLectivo) {
        sql = "INSERT INTO \"edu_anios_lectivos\" (ani_anio_lectivo,ani_fecha_inicio,ani_fecha_final) VALUES (?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, anioLectivo.getAnioLectivo());
            preSta.setDate(2, new Date(anioLectivo.getFechaInicio().getTime()));
            preSta.setDate(3, new Date(anioLectivo.getFechaFinal().getTime()));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos el Año Lectivo: " + ex.getMessage());
        }
    }

    public void modificarAnioLectivo(AnioLectivo anioLectivo) {
        sql = "UPDATE \"edu_anios_lectivos\" SET ani_anio_lectivo = ?, ani_fecha_inicio = ?, ani_fecha_final = ? WHERE ani_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, anioLectivo.getAnioLectivo());
            preSta.setDate(2, new Date(anioLectivo.getFechaInicio().getTime()));
            preSta.setDate(3, new Date(anioLectivo.getFechaFinal().getTime()));
            preSta.setInt(4, anioLectivo.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Año Lectivo: " + e.getMessage());
        }

    }

    public AnioLectivo buscarAnioLectivo(String ani) {
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        sql = "SELECT * FROM \"edu_anios_lectivos\" WHERE ani_anio_lectivo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, ani);
            res = preSta.executeQuery();
            res.next();
            anioLectivo.setCodigo(res.getInt("ani_codigo"));
            anioLectivo.setAnioLectivo(res.getString("ani_anio_lectivo"));
            anioLectivo.setFechaInicio(res.getDate("ani_fecha_inicio"));
            anioLectivo.setFechaFinal(res.getDate("ani_fecha_final"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Año Lectivo por nombre: " + e.getMessage());
        }
        return anioLectivo;

    }

    public AnioLectivo buscarAnioLectivo(int codigo) {
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        sql = "SELECT * FROM \"edu_anios_lectivos\" WHERE ani_codigo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            anioLectivo.setCodigo(res.getInt("ani_codigo"));
            anioLectivo.setAnioLectivo(res.getString("ani_anio_lectivo"));
            anioLectivo.setFechaInicio(res.getDate("ani_fecha_inicio"));
            anioLectivo.setFechaFinal(res.getDate("ani_fecha_final"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Año Lectivo por codigo: " + e.getMessage());
        }
        return anioLectivo;

    }

    public void eliminarAnioLectivo(AnioLectivo anioLectivo) {
        sql = "DELETE FROM \"edu_anios_lectivos\" WHERE ani_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, anioLectivo.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Año Lectivo: " + ex.getMessage());
        }

    }

    public List<AnioLectivo> listarAnioLectivo() {

        List<AnioLectivo> listarAnioLectivo = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_anios_lectivos\" ORDER BY ani_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                anioLectivo.setCodigo(res.getInt("ani_codigo"));
                anioLectivo.setAnioLectivo(res.getString("ani_anio_lectivo"));
                anioLectivo.setFechaInicio(res.getDate("ani_fecha_inicio"));
                anioLectivo.setFechaFinal(res.getDate("ani_fecha_final"));
                listarAnioLectivo.add(anioLectivo);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario Año Lectivo " + e.getMessage());
        }
        return listarAnioLectivo;
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
