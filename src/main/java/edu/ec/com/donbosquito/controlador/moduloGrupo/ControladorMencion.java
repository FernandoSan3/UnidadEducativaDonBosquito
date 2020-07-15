package edu.ec.com.donbosquito.controlador.moduloGrupo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernandosanchez
 */
public class ControladorMencion {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearMension(Mension mension) {
        sql = "INSERT INTO \"edu_menciones\" (men_abrebiatura,men_mension,men_horast) VALUES (?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, mension.getAbrebiatura());
            preSta.setString(2, mension.getMension());
            preSta.setString(3, mension.getHorasTotales());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos la Mension: " + ex.getMessage());
        }
    }

    public void modificarMension(Mension mension) {
        sql = "UPDATE \"edu_menciones\" SET men_abrebiatura = ?, men_mension = ?, men_horast = ?  WHERE men_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, mension.getAbrebiatura());
            preSta.setString(2, mension.getMension());
            preSta.setString(3, mension.getHorasTotales());
            preSta.setInt(4, mension.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar la Mension: " + e.getMessage());
        }

    }

    public Mension buscarMension(String mensio) {
        Mension mension = new Mension(0, "", "", "");
        sql = "SELECT * FROM \"edu_menciones\" WHERE men_mension = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, mensio);
            res = preSta.executeQuery();
            res.next();
            mension.setCodigo(res.getInt("men_codigo"));
            mension.setAbrebiatura(res.getString("men_abrebiatura"));
            mension.setMension(res.getString("men_mension"));
            mension.setHorasTotales(res.getString("men_horast"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la Mension por nombre : " + e.getMessage());
        }
        return  mension;

    }

    public Mension buscarMensionCodigo(int codigo) {
        Mension mension = new Mension(0, "", "", "");
        sql = "SELECT * FROM \"edu_menciones\" WHERE men_codigo = ? ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            mension.setCodigo(res.getInt("men_codigo"));
            mension.setAbrebiatura(res.getString("men_abrebiatura"));
            mension.setMension(res.getString("men_mension"));
            mension.setHorasTotales(res.getString("men_horast"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos la Mension por codigo: " + e.getMessage());
        }
        return mension;

    }

    public void eliminarMension(Mension mension) {
        sql = "DELETE FROM \"edu_menciones\" WHERE men_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, mension.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la Mension: " + ex.getMessage());
        }

    }

    public List<Mension> listarMensions() {

        List<Mension> listarMension = new ArrayList<>();
        sql1 = "SELECT * FROM \"edu_menciones\" ORDER BY men_codigo ASC ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql1);
            res = preSta.executeQuery();
            while (res.next()) {
                Mension mension = new Mension(0, "", "", "");
                mension.setCodigo(res.getInt("men_codigo"));
                mension.setAbrebiatura(res.getString("men_abrebiatura"));
                mension.setMension(res.getString("men_mension"));
                mension.setHorasTotales(res.getString("men_horast"));
                listarMension.add(mension);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Usuario Mension " + e.getMessage());
        }
        return listarMension;
    }

    

}
