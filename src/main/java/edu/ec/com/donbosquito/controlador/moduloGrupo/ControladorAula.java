package edu.ec.com.donbosquito.controlador.moduloGrupo;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Aula;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernandosanchez
 */
public class ControladorAula {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearAula(Aula aula) {
        sql = "INSERT INTO \"edu_aulas\" (aul_aula,aul_piso,aul_num_aula,aul_edificio,aul_tipo) VALUES (?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, aula.getAula());
            preSta.setInt(2, aula.getPiso());
            preSta.setInt(3, aula.getNumeroAula());
            preSta.setString(4, aula.getEdificio());
            preSta.setString(5, aula.getTipo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos la aula: " + ex.getMessage());
        }
    }

    public void modificarAula(Aula aula) {
        sql = "UPDATE \"edu_aulas\" SET aul_aula = ?, aul_piso = ?, aul_num_aula = ?, aul_edificio = ?, aul_tipo = ? WHERE aul_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, aula.getAula());
            preSta.setInt(2, aula.getPiso());
            preSta.setInt(3, aula.getNumeroAula());
            preSta.setString(4, aula.getEdificio());
            preSta.setString(5, aula.getTipo());
            preSta.setInt(6, aula.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la aula: " + e.getMessage());
        }

    }

    public Aula buscarAula(String nombreaula) {
        Aula aula = new Aula(0, "", 0, 0, "", "");
        sql = "SELECT * FROM \"edu_aulas\" WHERE aul_aula = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, nombreaula);
            res = preSta.executeQuery(); //me devuleve y almacena en el result resultset este es el execute
            res.next();
            aula.setCodigo(res.getInt("aul_codigo"));
            aula.setAula(res.getString("aul_aula"));
            aula.setPiso(res.getInt("aul_piso"));
            aula.setNumeroAula(res.getInt("aul_num_aula"));
            aula.setEdificio(res.getString("aul_edificio"));
            aula.setTipo(res.getString("aul_tipo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la aula por nombre: " + e.getMessage());
        }
        return aula;

    }

    public Aula buscarAulaCodigo(int codigo) {
        Aula aula = new Aula(0, "", 0, 0, "", "");
        sql = "SELECT * FROM \"edu_aulas\" WHERE aul_codigo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            aula.setCodigo(res.getInt("aul_codigo"));
            aula.setAula(res.getString("aul_aula"));
            aula.setPiso(res.getInt("aul_piso"));
            aula.setNumeroAula(res.getInt("aul_num_aula"));
            aula.setEdificio(res.getString("aul_edificio"));
            aula.setTipo(res.getString("aul_tipo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la aula por codigo: " + e.getMessage());
        }
        return aula;

    }

    public void eliminarAula(Aula aula) {
        sql = "DELETE FROM \"edu_aulas\" WHERE aul_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, aula.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la aula: " + ex.getMessage());
        }

    }

    public List<Aula> listarAulas() {

        List<Aula> listarAula = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_aulas\" ORDER BY aul_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Aula aula = new Aula(0, "", 0, 0, "", "");
                aula.setCodigo(res.getInt("aul_codigo"));
                aula.setAula(res.getString("aul_aula"));
                aula.setPiso(res.getInt("aul_piso"));
                aula.setNumeroAula(res.getInt("aul_num_aula"));
                aula.setEdificio(res.getString("aul_edificio"));
                aula.setTipo(res.getString("aul_tipo"));
                listarAula.add(aula);
            }
            preSta.executeUpdate();
            preSta.close();
            
        } catch (SQLException e) {
            System.out.println("Error al listar al Aula " + e.getMessage());
        }
        Conexion.desconectar();
        return listarAula;
    }
}
