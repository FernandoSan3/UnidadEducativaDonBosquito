/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloMatricula;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.controlador.moduloGrupo.ControladorGrupoCabecera;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorRepresentante;
import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoCabecera;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
import edu.ec.com.donbosquito.modelo.moduloMatricula.FacturaCabecera;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
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
 * @author jorim
 */
public class ControladorFacturaCabecera {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;

    public void crearFacturaCabecera(FacturaCabecera datos) {
        sql = "INSERT INTO \"edu_facturas_cabecera\" VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setInt(2, datos.getNumeroFactura());
            preSta.setDate(3, new Date(datos.getFechaFacturaCabecera().getTime()));
            preSta.setDouble(4, datos.getSubtotal());
            preSta.setDouble(5, datos.getTotal());
            preSta.setInt(6, datos.getRepresentante().getCodigoRepresentante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar el año" + e.getMessage());
        }
    }

    public void actualizarGuia(FacturaCabecera datos) {
        sql = "UPDATE \"edu_facturas_cabecera\" SET  fcab_codigo =? , fcab_numero=? , fcab_fecha=? ,fcab_subtotal=?, fcab_total =?,fk_rep_codigo=?  WHERE fcab_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getNumeroFactura());
            preSta.setDate(2, new Date(datos.getFechaFacturaCabecera().getTime()));
            preSta.setDouble(3, datos.getSubtotal());
            preSta.setDouble(4, datos.getTotal());
            preSta.setInt(5, datos.getRepresentante().getCodigoRepresentante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Guia" + e.getMessage());
        }
    }

    public void eliminarGuia(FacturaCabecera datos) {
        sql = "DELETE FROM \"edu_facturas_cabecera\" WHERE fcab_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la Guia" + e.getMessage());
        }
    }

    public FacturaCabecera buscarFacturaCabeceraCodigo(int codigo) {

        ControladorRepresentante controladorRepresentante = new ControladorRepresentante();

        ControladorGrupoCabecera controladorGrupoCabecera = new ControladorGrupoCabecera();
        Persona persona = new Persona(codigo, "", "", "", "", "", "") {
        };

        Mension mension = new Mension(codigo, "", "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Curso curso = new Curso(0, "", "");
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", "", curso, anioLectivo, mension);
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        FacturaCabecera facturaCabecera = new FacturaCabecera(codigo, codigo, ParseFecha("0/0/0"), codigo, codigo, representante);

        sql = "SELECT * FROM \"edu_factura_detalles\" WHERE fcab_codigo = ? ";

        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery(); //me devuleve y almacena en el result resultset este es el execute
            res.next();
            facturaCabecera.setCodigo(res.getInt("fcab_codigo"));

            facturaCabecera.setNumeroFactura(res.getInt("fcab_numero"));
            facturaCabecera.setFechaFacturaCabecera(res.getDate("fcab_fecha"));
            facturaCabecera.setSubtotal(res.getInt("fcab_subtotal"));
            facturaCabecera.setTotal(res.getInt("fcab_total"));
            facturaCabecera.setRepresentante(controladorRepresentante.buscarCedulaRepresentante(res.getString("fk_rep_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos Factura cabecera por codigo: " + e.getMessage());
        }
        return facturaCabecera;

    }

    public List<FacturaCabecera> listarFacturaCabecera() {

        List<FacturaCabecera> listarFacturaCabecera = new ArrayList<>();
        sql = "SELECT * FROM \"edu_factura_detalles\" ORDER BY mat_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {

                ControladorFacturaCabecera controladorFacturaCabecera = new ControladorFacturaCabecera();
                ControladorMatricula controladorMatricula = new ControladorMatricula();
                ControladorRepresentante controladorRepresentante = new ControladorRepresentante();

                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");

                FacturaCabecera facturaCabecera = new FacturaCabecera(0, 0, ParseFecha("0/0/0"), 0, 0, representante);

                //   Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, sql, sql, sql, sql, sql, sql);
                // Mension mension = new Mension(0, sql, sql, sql);
                //AnioLectivo anioLectivo = new AnioLectivo(0, sql, ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                //Curso curso = new Curso(0, sql, sql);
                //  GrupoCabecera grupoCabecera = new GrupoCabecera(0, sql, sql, sql, curso, anioLectivo, mension);
                // Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), grupoCabecera, estudiante);
                facturaCabecera.setCodigo(res.getInt("fcab_codigo"));
                facturaCabecera.setNumeroFactura(res.getInt("fcab_numero"));
                facturaCabecera.setFechaFacturaCabecera(res.getDate("fcab_fecha"));
                facturaCabecera.setSubtotal(res.getDouble("fcab_subtotal"));
                facturaCabecera.setTotal(res.getDouble("fcab_total"));
                facturaCabecera.setRepresentante(controladorRepresentante.buscarCedulaRepresentante("fk_rep_codigo"));

                listarFacturaCabecera.add(facturaCabecera);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario Materia" + e.getMessage());
        }
        return listarFacturaCabecera;
    }

    public FacturaCabecera buscarPorNumFactura(String numFactura) {
        sql = "SELECT * FROM \"edu_facturas_cabecera\" WHERE fcab_numero = ? ";
        Persona persona = new Persona(0, "", "", "", numFactura, "", "") {
        };
        Representante representante = new Representante(0, numFactura, persona, 0, sql, sql, sql, numFactura, sql, sql);
        FacturaCabecera facturaCabecera = new FacturaCabecera(0, 0, ParseFecha("0/0/0"), 0, 0, representante);
        ControladorRepresentante cr = new ControladorRepresentante();
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, numFactura);
            res = preSta.executeQuery();
            res.next();
            facturaCabecera.setCodigo(res.getInt("fcab_codigo"));
            facturaCabecera.setNumeroFactura(res.getInt("fcab_numero"));
            facturaCabecera.setFechaFacturaCabecera(res.getDate("fcab_fecha"));
            facturaCabecera.setSubtotal(res.getInt("fcab_subtotal"));
            facturaCabecera.setTotal(res.getInt("fcab_total"));
            facturaCabecera.setRepresentante(cr.buscarUsuario(res.getInt("fk_rep_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos Factura cabecera por codigo: " + e.getMessage());
        }
        return facturaCabecera;
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
