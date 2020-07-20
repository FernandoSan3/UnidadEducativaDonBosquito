/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloMatricula;

import edu.ec.com.donbosquito.modelo.moduloMatricula.FacturaCabecera;
import edu.ec.com.donbosquito.modelo.moduloMatricula.FacturaDetalle;
import edu.ec.com.donbosquito.modelo.moduloMatricula.Matricula;

import edu.ec.com.donbosquito.conexion.Conexion;

import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;

import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoCabecera;

import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
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
public class ControladorFacturaDetalle {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;

    public void crear(FacturaDetalle datos) {
        sql = "INSERT INTO \"edu_factura_detalles\" VALUES (?,?,?,?,?,? )";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setDouble(2, datos.getCantidad());
            preSta.setDouble(3, datos.getSubtotal());
            preSta.setString(4, datos.getDescripcion());
            preSta.setInt(5, datos.getMatricula().getCodigo());
            preSta.setInt(6, datos.getFacturaCabecera().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar el año" + e.getMessage());
        }
    }
//Actualizar el FacturaDetalle

    public void actualizarGuia(FacturaDetalle datos) {
        sql = "UPDATE \"edu_factura_detalles\" SET fdet_cantidad=? , fdet_subtotal=? , fdet_descripcion=?,fk_matri_codigo=?,fk_fcab_codigo=?  WHERE fdet_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setDouble(2, datos.getCantidad());
            preSta.setDouble(3, datos.getSubtotal());
            preSta.setString(4, datos.getDescripcion());
            preSta.setInt(5, datos.getMatricula().getCodigo());
            preSta.setInt(6, datos.getFacturaCabecera().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Guia" + e.getMessage());
        }
    }

    public void eliminarGuia(FacturaDetalle datos) {
        sql = "DELETE FROM \"edu_factura_detalles\" WHERE fdet_codigo=?";
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

    /*
    public FacturaDetalle buscarMateria(String descripcion) {

        ControladorMatricula controladorMatricula = new ControladorMatricula();
        Persona persona = new Persona(0, "", "", "", descripcion, "", "") {
        };
        Representante representante = new Representante(0, descripcion, persona, 0, "", "", "", descripcion, "", "");
        Materia materia = new Materia(0, sql, descripcion, sql, 0);
        Aula aula = new Aula(0, sql, 0, 0, descripcion, sql);
        Mension mension = new Mension(0, descripcion, sql, horasTotales);
        Curso curso = new Curso(0, descripcion, sql);
        AnioLectivo anioLectivo = new AnioLectivo(0, descripcion,  ParseFecha("0/0/0"),  ParseFecha("0/0/0"));

        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0,  ParseFecha("0/0/0"), persona, representante, 0, sql, sql, sql, descripcion, sql, sql);
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, sql, descripcion, sql, curso, anioLectivo, mension);

        Matricula matricula = new Matricula(0,  ParseFecha("0/0/0"), grupoCabecera, estudiante);
        
       
        sql = "SELECT * FROM \"edu_factura_detalles\" WHERE mat_materia = ? ";
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
     */
    public FacturaDetalle buscarFacturaDetalleCodigo(int codigo) {

        ControladorMatricula controladorMatricula = new ControladorMatricula();
        ControladorFacturaCabecera controladorFacturaCabecera = new ControladorFacturaCabecera();
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        Mension mension = new Mension(0, "", "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Curso curso = new Curso(0, "", "");
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", "", curso, anioLectivo, mension);
        Matricula matricula = new Matricula(0,  ParseFecha("0/0/0"), estudiante, grupoCabecera);
        FacturaCabecera facturaCabecera = new FacturaCabecera(0, 0, ParseFecha("0/0/0"), 0, 0, representante);
        FacturaDetalle facturaDetalle = new FacturaDetalle(codigo, codigo, codigo, sql, matricula, facturaCabecera);
        sql = "SELECT * FROM \"edu_factura_detalles\" WHERE fdet_codigo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery(); //me devuleve y almacena en el result resultset este es el execute
            res.next();
            facturaDetalle.setCodigo(res.getInt("fdet_codigo"));
            facturaDetalle.setCantidad(res.getDouble("fdet_cantidad"));
            facturaDetalle.setSubtotal(res.getDouble("fdet_subtotal"));
            facturaDetalle.setDescripcion(res.getString("fdet_descripcion"));
            facturaDetalle.setMatricula(controladorMatricula.buscarMatriculaCodigo(res.getInt("fk_matri_codigo")));
            facturaDetalle.setFacturaCabecera(controladorFacturaCabecera.buscarFacturaCabeceraCodigo(res.getInt("fcab_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la Materia por codigo: " + e.getMessage());
        }
        return facturaDetalle;

    }

    public List<FacturaDetalle> listarFacturaDetalle() {

        List<FacturaDetalle> listarFacturaDetalle = new ArrayList<>();
        sql = "SELECT * FROM \"edu_factura_detalles\" ORDER BY mat_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {

                ControladorFacturaCabecera controladorFacturaCabecera = new ControladorFacturaCabecera();
                ControladorMatricula controladorMatricula = new ControladorMatricula();

                Persona persona = new Persona(0, "", sql, sql, sql, sql, sql) {
                };
                Representante representante = new Representante(0, sql, persona, 0, sql, sql, sql, sql, sql, sql);
                Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, sql, sql, sql, sql, sql, sql);
                Mension mension = new Mension(0, sql, sql, sql);
                AnioLectivo anioLectivo = new AnioLectivo(0, sql, ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                Curso curso = new Curso(0, sql, sql);
                GrupoCabecera grupoCabecera = new GrupoCabecera(0, sql, sql, sql, curso, anioLectivo, mension);
                Matricula matricula = new Matricula(0, ParseFecha("0/0/0"), estudiante, grupoCabecera);
                FacturaCabecera facturaCabecera = new FacturaCabecera(0, 0, ParseFecha("0/0/0"), 0, 0, representante);
                FacturaDetalle facturaDetalle = new FacturaDetalle(0, 0, 0, sql, matricula, facturaCabecera);
                facturaDetalle.setCodigo(res.getInt("fdet_codigo"));
                facturaDetalle.setCantidad(res.getDouble("fdet_cantidad"));
                facturaDetalle.setSubtotal(res.getDouble("fdet_subtotal"));
                facturaDetalle.setDescripcion(res.getString("fdet_descripcion"));
                facturaDetalle.setMatricula(controladorMatricula.buscarMatriculaCodigo(res.getInt("fk_matri_codigo")));
                facturaDetalle.setFacturaCabecera(controladorFacturaCabecera.buscarFacturaCabeceraCodigo(res.getInt("fcab_codigo")));
                listarFacturaDetalle.add(facturaDetalle);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario Materia" + e.getMessage());
        }
        return listarFacturaDetalle;
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
