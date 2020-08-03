/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloPersona;

import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class ControladorRepresentante extends ControladorPersona {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql1;
    private String sql2;
    private String sql;

    public void crearUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql1 = "INSERT INTO \"edu_personas\" VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, representante.getCodigoPersona());
            preSta.setString(2, representante.getCedula());
            preSta.setString(3, representante.getNombre());
            preSta.setString(4, representante.getApellido());
            preSta.setString(5, representante.getDireccion());
            preSta.setString(6, representante.getTelefono());
            preSta.setString(7, representante.getCorreo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar la Persona en Representante" + e.getMessage());
        }

        sql2 = "INSERT INTO \"edu_representantes\"  (rep_par_familiar, fk_per_codigo ) VALUES (?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql2);
            preSta.setString(1, representante.getParentescoFamiliar());
            preSta.setInt(2, representante.getCodigoPersona());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar al Representante " + e.getMessage());
        }
    }

    public int buscarCodigoMaxRepresentante() {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        int a = 0;
        sql = "SELECT max(per_codigo) FROM \"edu_personas\"";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            res.next();
            persona.setCodigoPersona(res.getInt("max"));
            a = res.getInt("max") + 1;
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
            return a;
        } catch (SQLException e) {
            System.out.println("Error al buscar el codigo de persona " + e.getMessage());
        }
        return a;
    }

    public Representante buscarUsuario(int codigoRepresentante) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        sql1 = "SELECT * FROM edu_personas p, edu_representantes r WHERE p.per_codigo = r.fk_per_codigo AND p.per_codigo=?";
        Conexion.coneccion();
        try {
            ControPersona cp = new ControPersona();
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, codigoRepresentante);
            res = preSta.executeQuery();
            res.next();
            representante.setCodigoRepresentante(res.getInt("rep_codigo"));
            representante.setParentescoFamiliar(res.getString("rep_par_familiar"));
            representante.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            representante.setCodigoPersona(res.getInt("per_codigo"));
            representante.setCedula(res.getString("per_cedula"));
            representante.setNombre(res.getString("per_nombre"));
            representante.setApellido(res.getString("per_apellido"));
            representante.setDireccion(res.getString("per_direccion"));
            representante.setTelefono(res.getString("per_telefono"));
            representante.setCorreo(res.getString("per_correo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar al Representante por el codigo " + e.getMessage());
        }
        return representante;
    }
    
    public Representante buscarUsuarioRepresentante(int codigoRepresentante) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        sql1 = "SELECT * FROM edu_personas p, edu_representantes r WHERE p.per_codigo = r.fk_per_codigo AND r.rep_codigo =?";
        Conexion.coneccion();
        try {
            ControPersona cp = new ControPersona();
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, codigoRepresentante);
            res = preSta.executeQuery();
            res.next();
            representante.setCodigoRepresentante(res.getInt("rep_codigo"));
            representante.setParentescoFamiliar(res.getString("rep_par_familiar"));
            representante.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            representante.setCodigoPersona(res.getInt("per_codigo"));
            representante.setCedula(res.getString("per_cedula"));
            representante.setNombre(res.getString("per_nombre"));
            representante.setApellido(res.getString("per_apellido"));
            representante.setDireccion(res.getString("per_direccion"));
            representante.setTelefono(res.getString("per_telefono"));
            representante.setCorreo(res.getString("per_correo"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar al Representante por el codigo " + e.getMessage());
        }
        return representante;
    }

    public void modificarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql1 = "UPDATE \"edu_personas\" SET per_cedula=? , per_nombre=?, per_apellido=?, per_direccion=? , per_telefono=? , per_correo=? WHERE per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setString(1, representante.getCedula());
            preSta.setString(2, representante.getNombre());
            preSta.setString(3, representante.getApellido());
            preSta.setString(4, representante.getDireccion());
            preSta.setString(5, representante.getTelefono());
            preSta.setString(6, representante.getCorreo());
            preSta.setInt(7, representante.getCodigoPersona());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar a la Representante" + e.getMessage());
        }

        sql2 = "UPDATE \"edu_representantes\" SET rep_par_familiar=? , fk_per_codigo=? WHERE rep_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql2);
            preSta.setString(1, representante.getParentescoFamiliar());
            preSta.setInt(2, representante.getPersona().getCodigoPersona());
            preSta.setInt(3, representante.getCodigoRepresentante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar a la Representante" + e.getMessage());
        }
    }

    public List<Representante> listarUsuario() {

        List<Representante> listarRepresentante = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_personas\"  p , \"edu_representantes\" r WHERE r.fk_per_codigo= p.per_codigo  ORDER BY r.rep_codigo ASC";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
                ControPersona cp = new ControPersona();
                representante.setCodigoRepresentante(res.getInt("rep_codigo"));
                representante.setParentescoFamiliar(res.getString("rep_par_familiar"));
                representante.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
                representante.setCodigoPersona(res.getInt("per_codigo"));
                representante.setCedula(res.getString("per_cedula"));
                representante.setNombre(res.getString("per_nombre"));
                representante.setApellido(res.getString("per_apellido"));
                representante.setDireccion(res.getString("per_direccion"));
                representante.setTelefono(res.getString("per_telefono"));
                representante.setCorreo(res.getString("per_correo"));
                listarRepresentante.add(representante);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario" + e.getMessage());
        }
        return listarRepresentante;
    }

    public Representante buscarCedulaRepresentante(String cedulaPersona) {

        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        sql = "SELECT * FROM edu_personas p, edu_representantes r WHERE p.per_codigo = r.fk_per_codigo AND p.per_cedula=?";
        Conexion.coneccion();
        try {
            ControPersona cp = new ControPersona();
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, cedulaPersona);
            res = preSta.executeQuery();
            res.next();
            representante.setCodigoRepresentante(res.getInt("rep_codigo"));
            representante.setParentescoFamiliar(res.getString("rep_par_familiar"));
            representante.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            representante.setCodigoPersona(res.getInt("per_codigo"));
            representante.setCedula(res.getString("per_cedula"));
            representante.setNombre(res.getString("per_nombre"));
            representante.setApellido(res.getString("per_apellido"));
            representante.setDireccion(res.getString("per_direccion"));
            representante.setTelefono(res.getString("per_telefono"));
            representante.setCorreo(res.getString("per_correo"));

            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar al Representante por la cédula " + e.getMessage());
        }
        return representante;
    }

    public void eliminarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql1 = "DELETE FROM \"edu_representantes\" WHERE fk_per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, representante.getCodigoPersona());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar al Representante " + e.getMessage());
        }

        sql2 = "DELETE FROM \"edu_personas\" WHERE per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql2);
            preSta.setInt(1, persona.getCodigoPersona());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar a la Persona" + e.getMessage());
        }
    }
}
