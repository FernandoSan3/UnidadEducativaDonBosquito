/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloFactura;


import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloFactura.LibroDiario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alexCT
 */
public class ControladorLibroDiario {

    private String sql;
    private PreparedStatement sta;
    private ResultSet res;

    public void crearLibroDiario(LibroDiario libroDiario) {

        sql = "INSERT INTO \"edu_libros_diarios\" VALUES (?,?,?,?,?)";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, libroDiario.getCodigo());
            sta.setString(2, libroDiario.getEmpresa());
            sta.setString(3, libroDiario.getDescripcion());
            sta.setDouble(4, libroDiario.getDebe());
            sta.setDouble(5, libroDiario.getHaber());
            sta.execute();
            sta.close();
            System.out.println("Datos Ingresados!");
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("Error de ingreso: " + ex);
        }
    }

    public ArrayList<LibroDiario> listarLibrosDiarios() {
        ArrayList<LibroDiario> listlibroDiario = new ArrayList<LibroDiario>();
        sql = "SELECT * FROM \"edu_libros_diarios\"";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                LibroDiario libroD = new LibroDiario();
                libroD.setCodigo(res.getInt("ldia_codigo"));
                libroD.setEmpresa(res.getString("ldia_empresa"));
                libroD.setDescripcion(res.getString("ldia_descripcion"));
                libroD.setDebe(res.getDouble("ldia_total_debe"));
                libroD.setHaber(res.getDouble("ldia_debe_haber"));
                listlibroDiario.add(libroD);
            }
            sta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al listar " + ex);
        }
        return listlibroDiario;
    }

    public LibroDiario buscarLibroDia(int codigoLibroDiario) {
        LibroDiario libroDiario =  new LibroDiario();
        try {
            sql = "SELECT * FROM \"edu_libros_diarios\" WHERE ldia_codigo=?";
            Conexion.coneccion();
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, codigoLibroDiario);
            res = sta.executeQuery();
            res.next();
            libroDiario.setCodigo(res.getInt("ldia_codigo"));
            libroDiario.setEmpresa(res.getString("ldia_empresa"));
            libroDiario.setDescripcion(res.getString("ldia_descripcion"));
            libroDiario.setDebe(res.getInt("ldia_total_debe"));
            libroDiario.setHaber(res.getInt("ldia_debe_haber"));
            System.out.println("Libro encontrado !!");
        } catch (SQLException ex) {
            System.out.println("Error al buscar " + ex.getMessage());
        }
        return libroDiario;
    }
    
    public Object buscarLibroDiario(int codigoLibroDiario, LibroDiario libroDiario) {

        try {
            sql = "SELECT * FROM \"edu_libros_diarios\" WHERE ldia_codigo=?";
            Conexion.coneccion();
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, codigoLibroDiario);
            res = sta.executeQuery();
            res.next();
            libroDiario.setCodigo(res.getInt("ldia_codigo"));
            libroDiario.setEmpresa(res.getString("ldia_empresa"));
            libroDiario.setDescripcion(res.getString("ldia_descripcion"));
            libroDiario.setDebe(res.getInt("ldia_total_debe"));
            libroDiario.setHaber(res.getInt("ldia_debe_haber"));
            System.out.println("Libro encontrado !!");
        } catch (SQLException ex) {
            System.out.println("Error al buscar " + ex.getMessage());
        }
        return libroDiario;
    }
    

    public void actualizarLibroDiario(LibroDiario libroDiario) {

        try {
            sql = "UPDATE edu_libros_diarios SET  ldia_empresa = ?, ldia_descripcion = ?, ldia_total_debe = ?, ldia_debe_haber = ? WHERE ldia_codigo = ?";
            Conexion.coneccion();
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, libroDiario.getEmpresa());
            sta.setString(2, libroDiario.getDescripcion());
            sta.setDouble(3, libroDiario.getDebe());
            sta.setDouble(4, libroDiario.getHaber());
            sta.setInt(5, libroDiario.getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Actualizados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al Actualizar: " + ex);
        }
    }

    public void eliminarLibroDiario(LibroDiario libroDiario) {
        sql = "DELETE FROM \"edu_libros_diarios\" WHERE ldia_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, libroDiario.getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Eliminados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex);
        }
    }

    public int obtenerCodigo() {
        sql = "SELECT count(*) FROM \"edu_libros_diarios\"";
        int cod = 0;
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            if (res.next()) {
                cod = res.getInt(1) + 1;
            }

            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al obtener codigo " + ex.getMessage());
        }
        return cod;
    }
   
}
