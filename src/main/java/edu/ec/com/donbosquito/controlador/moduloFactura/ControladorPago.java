/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloFactura;


import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloFactura.Pago;
import edu.ec.com.donbosquito.modelo.moduloFactura.TipoDePago;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author alexCT
 */
public class ControladorPago {

   private String sql;
    private PreparedStatement sta;
    private ResultSet res;

    public void crearPago(Pago pago) {

        sql = "INSERT INTO \"edu_pagos\" VALUES (?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, pago.getCodigo());
            sta.setDate(2, new Date(pago.getFecha().getTime()));
            sta.setString(3, pago.getEstado());
            sta.setDouble(4, pago.getValor());
            sta.setString(5, pago.getFormaPago());
            sta.setInt(6, pago.getTipoPago().getCodigo());
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
                p.setFormaPago(res.getString("pag_forma_pago"));
                p.setTipoPago((TipoDePago) ct.buscarTipoPago(res.getInt("fk_tip_codigo")));
                listaPagos.add(p);

            }
            sta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al listar " + ex);
        }
        return listaPagos;
    }

    public Pago buscarPago(int codigoPago) {
        sql = "SELECT * FROM \"edu_pagos\" WHERE pag_codigo=?";
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
            pago.setFormaPago(res.getString("pag_forma_pago"));
            pago.setTipoPago((TipoDePago) ct.buscarTipoPago(res.getInt("fk_tip_codigo")));

        } catch (SQLException ex) {
            System.out.println("Error al listar pago " + ex.getMessage());
        }
        return pago;
    }

    public void actualizarPago(Pago pago) {
        sql = "UPDATE \"edu_pagos\" SET  pag_fecha=?, pag_estado=?, pag_valor=?, pag_forma_pago=?, fk_tip_codigo=? WHERE pag_codigo=?";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setDate(1, new Date(pago.getFecha().getTime()));
            sta.setString(2, pago.getEstado());
            sta.setDouble(3, pago.getValor());
            sta.setString(4, pago.getFormaPago());
            sta.setInt(5, pago.getTipoPago().getCodigo());
            sta.setInt(6, pago.getCodigo());
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

    public int buscarCodigo() {
        Pago pago = new Pago();
        int a = 0;
        sql = "SELECT max(pag_codigo) FROM \"edu_pagos\"";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            res.next();
            pago.setCodigo(res.getInt("max"));
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

    public String buscarEstadoPago(String factura) {

        sql = "SELECT p.pag_estado estado FROM edu_pagos p, edu_tipos_pagos t, edu_facturas_cabecera f WHERE \n"
                + "p.fk_tip_codigo = t.tip_codigo AND t.fk_fcab_codigo = f.fcab_codigo \n"
                + "AND f.fcab_numero = ? ";

        Conexion.coneccion();
        String estadoPago = "";
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            while (res.next()) {
                estadoPago = res.getString("estado");
            }
        } catch (Exception e) {
        }
        return estadoPago;
    }

    public int buscarCodigoPago() {
        Pago pago = new Pago();
        int a = 0;
        sql = "SELECT max(pag_codigo) FROM \"edu_pagos\"";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            res.next();
            pago.setCodigo(res.getInt("max"));
            a = res.getInt("max");
            sta.execute();
            sta.close();
            Conexion.desconectar();
            return a;
        } catch (SQLException e) {
            System.out.println("Error al buscar el codigo de persona " + e.getMessage());
        }
        return a;
    }

    public Pago buscarPorFactura(String factura) {
        sql = "SELECT * FROM edu_pagos p, edu_tipos_pagos t, edu_facturas_cabecera f \n"
                + "WHERE p.fk_tip_codigo = t.tip_codigo AND t.fk_fcab_codigo = f.fcab_codigo\n"
                + "AND f.fcab_numero = ? ";

        Conexion.coneccion();
        Pago pago = new Pago();
        ControladorTipoPago controlTipPago = new ControladorTipoPago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            if (res.next()) {
                pago.setCodigo(res.getInt("pag_codigo"));
                pago.setFecha(res.getDate("pag_fecha"));
                pago.setEstado(res.getString("pag_estado"));
                pago.setValor(res.getDouble("pag_valor"));
                pago.setFormaPago(res.getString("pag_forma_pago"));
                pago.setTipoPago(controlTipPago.buscarTipoPago(res.getInt("fk_tip_codigo")));
            } else {
                System.out.println("No encontrado");
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar pago " + ex.getMessage());
        }
        return pago;
    }

    public String buscarEstado(String factura, String estado) {

        sql = "SELECT p.pag_estado estado FROM edu_pagos p, edu_tipos_pagos t, edu_facturas_cabecera f WHERE \n"
                + "p.fk_tip_codigo = t.tip_codigo AND t.fk_fcab_codigo = f.fcab_codigo \n"
                + "AND f.fcab_numero = ? AND p.pag_estado = ?";

        Conexion.coneccion();
        String estadoPago = "";
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            sta.setString(2, estado);
            res = sta.executeQuery();
            while (res.next()) {
                estadoPago = res.getString("estado");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        System.out.println("metodooo " + estadoPago);
        return estadoPago;
    }

    public Pago buscarEstadoPorPago(String factura, String estado) {

        sql = "SELECT * FROM edu_pagos p, edu_tipos_pagos t, edu_facturas_cabecera f WHERE \n"
                + "p.fk_tip_codigo = t.tip_codigo AND t.fk_fcab_codigo = f.fcab_codigo \n"
                + "AND f.fcab_numero = ? AND p.pag_estado = ?";

        Conexion.coneccion();
        Pago pago = new Pago();
        ControladorTipoPago controlTipPago = new ControladorTipoPago();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            sta.setString(2, estado);
            res = sta.executeQuery();
            if (res.next()) {
                pago.setCodigo(res.getInt("pag_codigo"));
                pago.setFecha(res.getDate("pag_fecha"));
                pago.setEstado(res.getString("pag_estado"));
                pago.setValor(res.getDouble("pag_valor"));
                pago.setFormaPago(res.getString("pag_forma_pago"));
                pago.setTipoPago(controlTipPago.buscarTipoPago(res.getInt("fk_tip_codigo")));
            } else {
                System.out.println("No encontrado");
            }

        } catch (Exception e) {
            System.out.println("Error al buscar: " + e.getMessage());
        }
        System.out.println("metodooo " + pago);
        return pago;
    }
}
