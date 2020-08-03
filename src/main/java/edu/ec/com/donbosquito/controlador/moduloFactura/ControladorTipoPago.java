/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloFactura;


import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.controlador.moduloMatricula.ControladorFacturaCabecera;
import edu.ec.com.donbosquito.modelo.moduloFactura.TipoDePago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        ControladorFacturaCabecera controladorFacCab = new ControladorFacturaCabecera();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                tipPag.setCodigo(res.getInt("tip_codigo"));
                tipPag.setTipoPago(res.getString("tip_tipo_pago"));
                tipPag.setNumeroPago(res.getInt("tip_numero_pagos"));
                tipPag.setFacturaCabecera(controladorFacCab.buscarFacturaCabeceraCodigo(res.getInt("fk_fcab_codigo")));
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
        ControladorFacturaCabecera controlFacturaCab = new ControladorFacturaCabecera();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setInt(1, codigoTipoPago);
            res = sta.executeQuery();
            if (res.next()) {
                tipPag.setCodigo(res.getInt("tip_codigo"));
                tipPag.setTipoPago(res.getString("tip_tipo_pago"));
                tipPag.setNumeroPago(res.getInt("tip_numero_pagos"));
                tipPag.setFacturaCabecera(controlFacturaCab.buscarFacturaCabeceraCodigo(res.getInt("fk_fcab_codigo")));
            } else {
                JOptionPane.showMessageDialog(null, "No encontrado!");
            }

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
            sta.setInt(3, tipoPago.getFacturaCabecera().getCodigo());
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

    public ArrayList<String> buscarNumFactura() {
        ArrayList<String> lista = new ArrayList<>();
        Conexion.coneccion();
        sql = "SELECT * FROM edu_facturas_cabecera";
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            while (res.next()) {
                lista.add(res.getString("fcab_numero"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public String buscarRepresentantePago(String factura) {

        sql = "SELECT  concat(per_nombre, ' ' ,per_apellido) nombre FROM edu_facturas_cabecera f, edu_representantes r,\n"
                + "edu_personas p WHERE  f.fk_rep_codigo = r.rep_codigo and r.fk_per_codigo =  p.per_codigo and f.fcab_numero = ?";

        Conexion.coneccion();
        String nombre = "";
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            while (res.next()) {
                nombre = res.getString("nombre");
            }
        } catch (Exception e) {
        }
        return nombre;
    }

    public int buscarCodigo() {
        TipoDePago tipPago = new TipoDePago();
        int a = 0;
        sql = "SELECT max(tip_codigo) FROM \"edu_tipos_pagos\"";
        Conexion.coneccion();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            res = sta.executeQuery();
            res.next();
            tipPago.setCodigo(res.getInt("max"));
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

    public int buscarCodigoFactura(String factura) {

        sql = "select t.fk_fcab_codigo codigo from edu_tipos_pagos t, edu_facturas_cabecera f \n"
                + "where  t.fk_fcab_codigo = f.fcab_codigo and f.fcab_numero=?";

        Conexion.coneccion();
        int codigo = 0;
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            while (res.next()) {
                codigo = res.getInt("codigo");
            }
        } catch (Exception e) {
        }
        return codigo;
    }

    public TipoDePago buscarPorFactura(String factura) {
        sql = "select  * from  edu_facturas_cabecera f, edu_tipos_pagos t \n"
                + "where  t.fk_fcab_codigo = f.fcab_codigo and f.fcab_numero = ? ";
        Conexion.coneccion();
        TipoDePago tipPag = new TipoDePago();
        ControladorFacturaCabecera controlFacturaCab = new ControladorFacturaCabecera();
        try {
            sta = Conexion.getCon().prepareStatement(sql);
            sta.setString(1, factura);
            res = sta.executeQuery();
            if (res.next()) {
                tipPag.setCodigo(res.getInt("tip_codigo"));
                tipPag.setTipoPago(res.getString("tip_tipo_pago"));
                tipPag.setNumeroPago(res.getInt("tip_numero_pagos"));
                tipPag.setFacturaCabecera(controlFacturaCab.buscarFacturaCabeceraCodigo(res.getInt("fk_fcab_codigo")));
                
            } else {
                System.out.println("No encontrado");
            }

        } catch (SQLException ex) {
            System.out.println("Error al listar pago " + ex.getMessage());
        }
        return tipPag;
    }
}
