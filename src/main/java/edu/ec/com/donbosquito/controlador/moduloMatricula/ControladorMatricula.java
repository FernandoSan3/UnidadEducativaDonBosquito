/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloMatricula;


import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloMatricula.Matricula;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorim
 */
public class ControladorMatricula {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
 
    public void crearMatricula(Matricula datos) {
        sql = "INSERT INTO \"Matricula\" VALUES (?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setDate(2,new Date(datos.getFechaMatricula().getTime()));
            preSta.setInt(3, datos.getGrupoCabeveras().getCodigo());
            preSta.setInt(4, datos.getEstudiante().getCodigoEstudiante());
           
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al guardar el año" + e.getMessage());
        }
    }
//Actualizar el FacturaDetalle

    public void actualizarMatricula(Matricula datos) {
        sql = "UPDATE \"Matricula\" SET  fcab_codigo =? , fcab_numero=? , fcab_fecha=? ,fcab_subtotal=?, fcab_total =?,edu_representantes_rep_codigo=?  WHERE fcab_codigo=?";
        Conexion. coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, datos.getCodigo());
            preSta.setDate(2, new Date(datos.getFechaMatricula().getTime()));
            preSta.setInt(3, datos.getGrupoCabeveras().getCodigo());
            preSta.setInt(4, datos.getEstudiante().getCodigoEstudiante());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Guia" + e.getMessage());
        }
    }

    public void eliminarMatricula(Matricula datos) {
        sql = "DELETE FROM \"Matricula\" WHERE fcab_codigo=?";
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
    
      public List<Matricula> listarMatricula() {

        List<Matricula> listarFicha = new ArrayList<>();
        sql = "SELECT * FROM \"Matricula\" ORDER BY fic_codigo ASC";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {
                Ficha_Medica ficha = new Ficha_Medica();
                ControladorMascota conMascota = new ControladorMascota();
                ficha.setCodigoHistorial(res.getInt("fic_codigo"));
                ficha.setHora(res.getString("hora"));
                ficha.setFecha(res.getDate("fecha"));
                ficha.setDescripcion(res.getString("descripcion"));
                ficha.setMedico(res.getString("medico"));
                ficha.setMascota(conMascota.buscarCodigoMascota(res.getInt("mas_codigo")));
                listarFicha.add(ficha);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar a la Ficha medica " + e.getMessage());
        }
        return listarFicha;
    }
      
  
    
}
