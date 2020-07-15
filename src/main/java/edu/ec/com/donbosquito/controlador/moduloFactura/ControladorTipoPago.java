/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloFactura;


import edu.ec.com.donbosquito.conexion.Conexion;
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
public class ControladorTipoPago {

    private String sql;
    private PreparedStatement sta;
    private ResultSet res;

    public void crearTipoPago(TipoDePago tipoPago) {

        sql = "INSERT INTO \"edu_tipos_pagos\" VALUES (?,?,?,?)";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, tipoPago.getCodigo());
            sta.setString(2, tipoPago.getTipoPago());
            sta.setInt(3, tipoPago.getNumeroPago());
            sta.setInt(4, tipoPago.getFacturaCabecera().getCodigo());
            sta.execute();
            sta.close();
            System.out.println("Datos Ingresados!");
        } catch (SQLException ex) {
            System.out.println("Error de ingreso: " + ex.getMessage());
        }
    }

    public ArrayList<TipoDePago> listarTipoPagos() {
        ArrayList<TipoDePago> listaPagos = new ArrayList<TipoDePago>();
        sql = "SELECT * FROM \"edu_tipos_pagos\"";
        Conexion.coneccion();
        TipoDePago tipPag = new TipoDePago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                tipPag.setCodigo(res.getInt("tip_codigo"));
                tipPag.setTipoPago(res.getString("tip_tipo_pago"));
                tipPag.setNumeroPago(res.getInt("tip_numero_pagos"));
                //tipPag.setFacturaCabecera(res.getInt("fk_fcab_codigo"));
                listaPagos.add(tipPag);

            }
            sta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al listar " + ex);
        }
        return listaPagos;
    }

    public TipoDePago buscarTipoPago(int codigoTipoPago) {
        sql = "SELECT * FROM \"edu_tipos_pagos\" WHERE tip_codigo=?";
        Conexion.coneccion();
        TipoDePago tipPag = new TipoDePago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, codigoTipoPago);
            res = sta.executeQuery();
            res.next();
            tipPag.setCodigo(res.getInt("tip_codigo"));
            tipPag.setTipoPago(res.getString("tip_tipo_pago"));
            tipPag.setNumeroPago(res.getInt("tip_numero_pagos"));
           // tipPag.setFacturaCabecera(res.getInt("fk_fcab_codigo"));

        } catch (SQLException ex) {
            System.out.println("Error al listar pago " + ex.getMessage());
        }
        return tipPag;
    }

    public void actualizarTipoPago(TipoDePago tipoPago) {
        sql = "UPDATE \"edu_tipos_pagos\" SET  tip_tipo_pago=?, tip_numero_pagos=?, fk_fcab_codigo=? WHERE tip_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, tipoPago.getTipoPago());
            sta.setInt(2, tipoPago.getNumeroPago());
//            sta.setInt(3, tipoPago.getFacturaCabecera().getCodigo());
            sta.setInt(4, tipoPago.getCodigo());
            sta.executeQuery();
            sta.close();
            System.out.println("Datos Actualizados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al Actualizar: " + ex);
        }
    }

    public void eliminarTipoPago(TipoDePago tipoPago) {
        sql = "DELETE FROM \"edu_tipos_pagos\" WHERE tip_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, tipoPago.getCodigo());
            sta.executeQuery();
            sta.close();
            System.out.println("Datos Eliminados!");
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar " + ex);
        }
    }

}
