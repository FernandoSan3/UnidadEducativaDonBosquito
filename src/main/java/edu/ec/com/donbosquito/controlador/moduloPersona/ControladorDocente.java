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
public class ControladorDocente extends ControladorPersona {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql = "INSERT INTO \"edu_personas\" VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, docente.getCodigoPersona());
            preSta.setString(2, docente.getCedula());
            preSta.setString(3, docente.getNombre());
            preSta.setString(4, docente.getApellido());
            preSta.setString(5, docente.getDireccion());
            preSta.setString(6, docente.getTelefono());
            preSta.setString(7, docente.getCorreo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar la Persona" + e.getMessage());
        }

        sql1 = "INSERT INTO \"edu_docentes\" VALUES (?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, docente.getCodigoDocente());
            preSta.setString(2, docente.getTituloDocente());
            preSta.setInt(3, docente.getPersona().getCodigoPersona());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar al Docente " + e.getMessage());
        }
    }

    public Object buscarUsuario(int codigoDocente) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente docente = new Docente(0, sql, persona, 0, "", "", "", "", "", "");
        sql1 = "SELECT * FROM \"edu_docentes\" WHERE doce_codigo=?";
        Conexion.coneccion();
        try {
            ControPersona cp = new ControPersona();
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, codigoDocente);
            res = preSta.executeQuery();
            res.next();
            docente.setCodigoDocente(res.getInt("doce_codigo"));
            docente.setTituloDocente(res.getString("doce_titulo"));
            docente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar al Docente por el codigo " + e.getMessage());
        }
        return docente;
    }

    public Docente buscarDocenteCedula(String cedulaDocente) {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente docente = new Docente(0, sql, persona, 0, "", "", "", "", "", "");
        sql = "SELECT * FROM edu_personas p, edu_docentes d WHERE p.per_codigo = d.fk_per_codigo AND p.per_cedula=?";
        Conexion.coneccion();
        try {
            ControPersona cp = new ControPersona();
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, cedulaDocente);
            res = preSta.executeQuery();
            res.next();
            docente.setCodigoDocente(res.getInt("doce_codigo"));
            docente.setTituloDocente(res.getString("doce_titulo"));
            docente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al buscar al Docente por la cedula " + e.getMessage());
        }
        return docente;
    }

    public void modificarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql1 = "UPDATE \"edu_personas\" SET per_cedula=? , per_nombre=?, per_apellido=?, per_direccion=? , per_telefono=? , per_correo=? WHERE per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setString(1, docente.getCedula());
            preSta.setString(2, docente.getNombre());
            preSta.setString(3, docente.getApellido());
            preSta.setString(4, docente.getDireccion());
            preSta.setString(5, docente.getTelefono());
            preSta.setString(6, docente.getCorreo());
            preSta.setInt(7, docente.getCodigoPersona());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar a la Persona" + e.getMessage());
        }

        sql = "UPDATE \"edu_docentes\" SET doce_titulo=?, fk_per_codigo=? WHERE doce_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, docente.getTituloDocente());
            preSta.setInt(2, docente.getPersona().getCodigoPersona());
            preSta.setInt(3, docente.getCodigoDocente());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar al Docente " + e.getMessage());
        }
    }

    public void eliminarUsuario(Estudiante estudiante, Docente docente, Representante representante, Persona persona) {
        sql = "DELETE FROM \"edu_docentes\" WHERE fk_per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, docente.getCodigoPersona());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar al Docente " + e.getMessage());
        }

        sql1 = "DELETE FROM \"edu_personas\" WHERE per_codigo=?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            preSta.setInt(1, persona.getCodigoPersona());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al eliminar a la Persona" + e.getMessage());
        }
    }

    public List<Docente> listarUsuario() {

        List<Docente> listarDocente = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_docentes\" ORDER BY doce_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Docente docente = new Docente(0, "", persona, 0, "", "", "", "", "", "");
                ControPersona cp = new ControPersona();
                docente.setCodigoDocente(res.getInt("doce_codigo"));
                docente.setTituloDocente(res.getString("doce_titulo"));
                docente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
                listarDocente.add(docente);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario " + e.getMessage());
        }
        return listarDocente;
    }    
    
}
