/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloGrupo;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernandosanchez
 */
public class ControladorMateria {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearMateria(Materia materia) {
        sql = "INSERT INTO \"edu_materias\" (mat_materia, mat_abrebiatura, mat_horas, mat_costo) VALUES (?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, materia.getMateria());
            preSta.setString(2, materia.getAbrebiatura());
            preSta.setString(3, materia.getHoras());
            preSta.setDouble(4, materia.getCosto());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos la Materia: " + ex.getMessage());
        }
    }

    public void modificarMateria(Materia materia) {
        sql = "UPDATE \"edu_materias\" SET mat_materia = ?, mat_abrebiatura = ?, mat_horas = ? ,mat_costo = ? WHERE mat_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, materia.getMateria());
            preSta.setString(2, materia.getAbrebiatura());
            preSta.setString(3, materia.getHoras());
            preSta.setDouble(4, materia.getCosto());
            preSta.setInt(5, materia.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Materia: " + e.getMessage());
        }

    }

    public Materia buscarMateria(String nombremateria) {
        Materia materia = new Materia(0, "", "", "", 0);
        sql = "SELECT * FROM \"edu_materias\" WHERE mat_materia = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, nombremateria);
            res = preSta.executeQuery();
            res.next();
            materia.setCodigo(res.getInt("mat_codigo"));
            materia.setMateria(res.getString("mat_materia"));
            materia.setAbrebiatura(res.getString("mat_abrebiatura"));
            materia.setHoras(res.getString("mat_horas"));
            materia.setCosto(res.getDouble("mat_costo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la Materia por nombre: " + e.getMessage());
        }
        return materia;

    }

    public Materia buscarMateriaCodigo(int codigo) {
        Materia materia = new Materia(0, "", "", "", 0);
        sql = "SELECT * FROM \"edu_materias\" WHERE mat_codigo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery(); //me devuleve y almacena en el result resultset este es el execute
            res.next();
            materia.setCodigo(res.getInt("mat_codigo"));
            materia.setMateria(res.getString("mat_materia"));
            materia.setAbrebiatura(res.getString("mat_abrebiatura"));
            materia.setHoras(res.getString("mat_horas"));
            materia.setCosto(res.getDouble("mat_costo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la Materia por codigo: " + e.getMessage());
        }
        return  materia;

    }

    public void eliminarMateria(Materia materia) {
        sql = "DELETE FROM \"edu_materias\" WHERE mat_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, materia.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la materia: " + ex.getMessage());
        }

    }

    public List<Materia> listarMaterias() {

        List<Materia> listarMateria = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_materias\" ORDER BY mat_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Materia materia = new Materia(0, "", "", "", 0);
                materia.setCodigo(res.getInt("mat_codigo"));
                materia.setMateria(res.getString("mat_materia"));
                materia.setAbrebiatura(res.getString("mat_abrebiatura"));
                materia.setHoras(res.getString("mat_horas"));
                materia.setCosto(res.getDouble("mat_costo"));
                listarMateria.add(materia);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario Materia" + e.getMessage());
        }
        return listarMateria;
    }

}
