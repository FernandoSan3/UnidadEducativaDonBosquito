/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloFactura;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloFactura.LibroDetalle;
import edu.ec.com.donbosquito.modelo.moduloFactura.LibroDiario;
import edu.ec.com.donbosquito.modelo.moduloFactura.Pago;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexCT
 */
public class ControladorLibroDetalle {

    private String sql;
    private PreparedStatement sta;
    private ResultSet res;

    public void crearLibroDetalle(LibroDetalle libroDetalle) {

        sql = "INSERT INTO \"edu_libro_detalles\" VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, libroDetalle.getCodigo());
            sta.setDate(2, new Date(libroDetalle.getFecha().getTime()));
            sta.setString(3, libroDetalle.getDetalle());
            sta.setDouble(4, libroDetalle.getDebe());
            sta.setDouble(5, libroDetalle.getHaber());
            sta.setInt(6, libroDetalle.getLibroDiario().getCodigo());
            sta.setInt(7, libroDetalle.getPago().getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Ingresados!");
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("Error de ingreso: " + ex.getMessage());
        }
    }

    public List<LibroDetalle> listarLibroDetalle() {
        List<LibroDetalle> listlibroDetalle = new ArrayList<>();
        sql = "SELECT * FROM \"edu_libro_detalles\"";
        Conexion.coneccion();
        ControladorLibroDiario contLib;
        ControladorPago contPag;
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                contLib = new ControladorLibroDiario();
                contPag = new ControladorPago();
                LibroDetalle libroDet = new LibroDetalle();
                libroDet.setCodigo(res.getInt("ldet_codigo"));
                libroDet.setFecha(res.getDate("ldet_fecha"));
                libroDet.setDetalle(res.getString("ldet_detalle"));
                libroDet.setDebe(res.getDouble("ldet_debe"));
                libroDet.setHaber(res.getDouble("ldet_haber"));
                libroDet.setLibroDiario((LibroDiario) contLib.buscarLibroDia(res.getInt("fk_ldia_codigo")));
                libroDet.setPago((Pago) contPag.buscarPago(res.getInt("fk_pag_codigo")));//VER RELACION DIAGRAMA-BASE
                listlibroDetalle.add(libroDet);
            }
            sta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al listar " + ex);
        }
        return listlibroDetalle;
    }

    public Object buscarLibroDetalle(int codigoLibroDetalle) {
        LibroDetalle libroDetalle = new LibroDetalle();
        ControladorPago contPag = new ControladorPago();
        ControladorLibroDiario contLib = new ControladorLibroDiario();
        try {
            sql = "SELECT * FROM \"edu_libro_detalles\" WHERE ldet_codigo=?";
            Conexion.coneccion();
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, codigoLibroDetalle);
            res = sta.executeQuery();
            res.next();
            libroDetalle.setCodigo(res.getInt("ldet_codigo"));
            libroDetalle.setFecha(res.getDate("ldet_fecha"));
            libroDetalle.setDetalle(res.getString("ldet_detalle"));
            libroDetalle.setDebe(res.getDouble("ldet_debe"));
            libroDetalle.setHaber(res.getDouble("ldet_haber"));
            libroDetalle.setLibroDiario((LibroDiario) contLib.buscarLibroDia(res.getInt("fk_ldia_codigo")));
            libroDetalle.setPago((Pago) contPag.buscarPago(res.getInt("fk_pag_codigo")));//VER RELAC
            System.out.println("Libro encontrado !!");
        } catch (SQLException ex) {
            System.out.println("Error al buscar " + ex.getMessage());
        }
        return libroDetalle;
    }

    public void actualizarLibroDetalle(LibroDetalle libroDetalle) {
        sql = "UPDATE \"edu_libro_detalles\" SET  ldet_fecha=?, ldet_detalle=?, ldet_debe=?, ldet_haber, fk_ldia_codigo, fk_pag_codigo WHERE ldet_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setDate(1, new Date(libroDetalle.getFecha().getTime()));
            sta.setString(2, libroDetalle.getDetalle());
            sta.setDouble(3, libroDetalle.getDebe());
            sta.setDouble(4, libroDetalle.getHaber());
            sta.setInt(5, libroDetalle.getLibroDiario().getCodigo());
            sta.setInt(6, libroDetalle.getPago().getCodigo());
            sta.setInt(7, libroDetalle.getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Actualizados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al Actualizar: " + ex.getMessage());
        }
    }

    public void eliminarLibroDetalle(LibroDetalle libroDetalle) {
        sql = "DELETE FROM \"edu_libro_detalles\" WHERE ldet_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, libroDetalle.getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Eliminados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex.getMessage());
        }
    }

    public int buscarCodigo() {
        LibroDetalle libroDetalle = new LibroDetalle();
        int a = 0;
        sql = "SELECT max(ldet_codigo) FROM \"edu_libro_detalles\"";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            res.next();
            libroDetalle.setCodigo(res.getInt("max"));
            a = res.getInt("max") + 1;
            sta.execute();
            sta.close();
            Conexion.desconectar();
            return a;
        } catch (SQLException e) {
            System.out.println("Error al buscar el codigo de persona " + e.getMessage());
        }
        return a;
    }

    public ArrayList<String> buscarDebePorFactura(String factura) {
        ArrayList<String> lista = new ArrayList<>();
        sql = "select ldet_debe from edu_libro_detalles d, edu_pagos p, edu_tipos_pagos t, edu_facturas_cabecera f\n"
                + "where d.fk_pag_codigo = p.pag_codigo AND p.fk_tip_codigo = t.tip_codigo AND \n"
                + "t.fk_fcab_codigo = f.fcab_codigo AND f.fcab_numero = ?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            while (res.next()) {
                lista.add(res.getString("ldet_debe"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Conexion.desconectar();
        return lista;
    }

    public ArrayList<LibroDetalle> buscarLibrosDetallesPorFactura(String factura) {
        ArrayList<LibroDetalle> lista = new ArrayList<>();
        sql = "select * from edu_libro_detalles l, edu_pagos p, edu_tipos_pagos t, edu_facturas_cabecera f\n"
                + "where l.fk_pag_codigo = p.pag_codigo AND p.fk_tip_codigo = t.tip_codigo AND\n"
                + "t.fk_fcab_codigo = f.fcab_codigo AND f.fcab_numero = ?";
        Conexion.coneccion();
        ControladorLibroDiario controlLDiario = new ControladorLibroDiario();
        ControladorPago controlPago = new ControladorPago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            while (res.next()) {
                LibroDetalle libroDetalle = new LibroDetalle();
                libroDetalle.setCodigo(res.getInt("ldet_codigo"));
                libroDetalle.setFecha(res.getDate("ldet_fecha"));
                libroDetalle.setDetalle(res.getString("ldet_detalle"));
                libroDetalle.setDebe(res.getDouble("ldet_debe"));
                libroDetalle.setHaber(res.getDouble("ldet_haber"));
                libroDetalle.setLibroDiario((LibroDiario) controlLDiario.buscarLibroDia(res.getInt("fk_ldia_codigo")));
                libroDetalle.setPago((Pago) controlPago.buscarPago(res.getInt("fk_pag_codigo")));
                lista.add(libroDetalle);
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar pago " + ex.getMessage());
        }
        return lista;
    }
}
