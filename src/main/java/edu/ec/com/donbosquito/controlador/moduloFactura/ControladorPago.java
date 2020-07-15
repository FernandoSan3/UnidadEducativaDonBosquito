/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloFactura;


import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloFactura.Pago;
import edu.ec.com.donbosquito.modelo.moduloFactura.TipoDePago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexCT
 */
public class ControladorPago {

    private String sql;
    private PreparedStatement sta;
    private ResultSet res;

    public void crearPago(Pago pago) {

        sql = "INSERT INTO \"edu_pagos\" VALUES (?,?,?,?,?)";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, pago.getCodigo());
            sta.setDate(2, pago.getFecha());
            sta.setString(3, pago.getEstado());
            sta.setDouble(4, pago.getValor());
            sta.setInt(5, pago.getTipoPago().getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Ingresados!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error de ingreso: " + ex.getMessage());
        }
    }

    public ArrayList<Pago> listarPagos() {
        ArrayList<Pago> listaPagos = new ArrayList<Pago>();
        sql = "SELECT * FROM \"edu_pagos\"";
        Conexion.coneccion();
        Pago p = new Pago();
        ControladorTipoPago ct = new ControladorTipoPago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                p.setCodigo(res.getInt("pag_codigo"));
                p.setFecha(res.getDate("pag_fecha"));
                p.setEstado(res.getString("pag_estado"));
                p.setValor(res.getDouble("pag_valor"));
                //p.setFormaPago(); 
                p.setTipoPago((TipoDePago) ct.buscarTipoPago(res.getInt("fk_pag")));
                listaPagos.add(p);

            }
            sta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al listar " + ex);
        }
        return listaPagos;
    }

    public Object buscarPago(int codigoPago) {
        sql = "SELECT * FROM \"edu_pagos\" WHERE edu_codigo=?";
        Conexion.coneccion();
        Pago pago = new Pago();
        ControladorTipoPago ct = new ControladorTipoPago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, codigoPago);
            res = sta.executeQuery();
            res.next();
            pago.setCodigo(res.getInt("pag_codigo"));
            pago.setFecha(res.getDate("pag_fecha"));
            pago.setEstado(res.getString("pag_estado"));
            pago.setValor(res.getInt("pag_valor"));
            //p.setFormaPago(); 
            pago.setTipoPago((TipoDePago) ct.buscarTipoPago(res.getInt("fk_pag")));

        } catch (SQLException ex) {
            System.out.println("Error al listar pago " + ex.getMessage());
        }
        return pago;
    }

    public void actualizarPago(Pago pago) {
        sql = "UPDATE \"edu_pagos\" SET  pag_fecha=?, pag_estado=?, pag_valor=?,  fk_tip_codigo=? WHERE pag_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setDate(1, pago.getFecha());
            sta.setString(2, pago.getEstado());
            sta.setDouble(3, pago.getValor());
            sta.setInt(4, pago.getTipoPago().getCodigo());
            sta.setInt(5, pago.getCodigo());
            sta.executeQuery();
            sta.close();
            System.out.println("Datos Actualizados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al Actualizar: " + ex);
        }
    }

    public void eliminarPago(Pago pago) {
        sql = "DELETE FROM \"edu_pagos\" WHERE pag_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, pago.getCodigo());
            sta.executeQuery();
            sta.close();
            System.out.println("Datos Eliminados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex);
        }
    }
}
