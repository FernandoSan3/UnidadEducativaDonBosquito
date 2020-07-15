/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloGrupo;

import edu.ec.com.donbosquito.conexion.Conexion;
import static edu.ec.com.donbosquito.controlador.moduloGrupo.ControladorGrupoDetalle.ParseFecha;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControPersona;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorDocente;
import edu.ec.com.donbosquito.modelo.moduloGrupo.AnioLectivo;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Aula;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Curso;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoCabecera;
import edu.ec.com.donbosquito.modelo.moduloGrupo.GrupoDetalle;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Materia;
import edu.ec.com.donbosquito.modelo.moduloGrupo.Mension;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernandosanchez
 */
public class ControladorGrupoCabecera {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearGrupoCabecera(GrupoCabecera grupoCabecera) {
        sql = "INSERT INTO \"edu_grupos_cabecera\" (gru_cab_grupo, gru_cab_codgrupo, fk_cur_codigo,fk_ani_codigo, fk_men_codigo) VALUES (?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, grupoCabecera.getGrupo());
            preSta.setString(2, grupoCabecera.getCodigoGrupo());
            preSta.setInt(3, grupoCabecera.getCurso().getCodigo());
            preSta.setInt(4, grupoCabecera.getAnioLectivo().getCodigo());
            preSta.setInt(5, grupoCabecera.getMension().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos el Grupo Cabecera: " + ex.getMessage());
        }
    }

    public int buscarCodigoGrupoCabecera() {
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        int a = 0;
        sql = "SELECT max(gru_cab_codigo) FROM \"edu_grupos_cabecera\"";
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
            System.out.println("Error al buscar el codigo de Grupo Cabecera " + e.getMessage());
        }
        return a;
    }

    public void modificarGrupoCabecera(GrupoCabecera grupoCabecera) {
        sql = "UPDATE \"edu_grupos_cabecera\" SET gru_cab_grupo = ?, gru_cab_codgrupo = ?, fk_cur_codigo = ?, fk_ani_codigo = ? , fk_men_codigo = ?  WHERE gru_cab_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, grupoCabecera.getGrupo());
            preSta.setString(2, grupoCabecera.getCodigoGrupo());
            preSta.setInt(3, grupoCabecera.getCurso().getCodigo());
            preSta.setInt(4, grupoCabecera.getAnioLectivo().getCodigo());
            preSta.setInt(5, grupoCabecera.getMension().getCodigo());
            preSta.setInt(6, grupoCabecera.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Grupo Cabecera: " + e.getMessage());
        }

    }

    public GrupoCabecera buscarGrupoCabeceraCodigo(int codigo) {
        ControladorMencion controladorMension = new ControladorMencion();
        ControladorAnioLectivo controladorAnioLectivo = new ControladorAnioLectivo();
        ControladorCurso controladorCurso = new ControladorCurso();
        Curso curso = new Curso(0, "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Mension mension = new Mension(0, "", "", "");
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", curso, anioLectivo, mension);
        sql = "SELECT * FROM \"edu_grupos_cabecera\" g, edu_cursos c, edu_anios_lectivos a, edu_menciones m WHERE\n"
                + "g.fk_ani_codigo = a.ani_codigo AND g.fk_cur_codigo = c.cur_codigo AND g.fk_men_codigo = m.men_codigo AND g.gru_cab_codigo = ?";
        Conexion.coneccion();

        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();
            grupoCabecera.setCodigo(res.getInt("gru_cab_codigo"));
            grupoCabecera.setGrupo(res.getString("gru_cab_grupo"));
            grupoCabecera.setCodigoGrupo(res.getString("gru_cab_codgrupo"));
            grupoCabecera.setCurso(controladorCurso.buscarCursoCodigo(res.getInt("fk_cur_codigo")));
            grupoCabecera.setAnioLectivo(controladorAnioLectivo.buscarAnioLectivo(res.getInt("fk_ani_codigo")));
            grupoCabecera.setMension(controladorMension.buscarMensionCodigo(res.getInt("fk_men_codigo")));
            curso.setCodigo(res.getInt("cur_codigo"));
            curso.setAbrebiatura(res.getString("cur_abrebiatura"));
            curso.setCurso(res.getString("cur_curso"));
            anioLectivo.setCodigo(res.getInt("ani_codigo"));
            anioLectivo.setAnioLectivo(res.getString("ani_anio_lectivo"));
            anioLectivo.setFechaInicio(res.getDate("ani_fecha_inicio"));
            anioLectivo.setFechaFinal(res.getDate("ani_fecha_final"));
            mension.setCodigo(res.getInt("men_codigo"));
            mension.setAbrebiatura(res.getString("men_abrebiatura"));
            mension.setMension(res.getString("men_mension"));
            mension.setHorasTotales(res.getString("men_horast"));
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Grupo Cabecera por codigo: " + e.getMessage());
        }

        return grupoCabecera;
    }

    public GrupoCabecera buscarGrupoCabecera(String grupo) {
        ControladorMateria controladorMateria = new ControladorMateria();
        ControladorDocente controladorDocente = new ControladorDocente();
        ControladorAula controladorAula = new ControladorAula();
        ControladorCurso controladorCurso = new ControladorCurso();
        ControladorAnioLectivo controladorAnioLectivo = new ControladorAnioLectivo();
        ControladorMencion controladorMension = new ControladorMencion();
        ControladorGrupoCabecera controladorGrupoCabecera = new ControladorGrupoCabecera();
        ControPersona cp = new ControPersona();

        Materia materia = new Materia(0, "", "", "", 0);
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Docente peDocente = new Docente(0, "", persona, 0, "", "", "", "", "", "");
        Aula aula = new Aula(0, "", 0, 0, "", "");
        Curso curso = new Curso(0, "", "");
        AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
        Mension mension = new Mension(0, "", "", "");
        GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", curso, anioLectivo, mension);

        GrupoDetalle grupoDetalle = new GrupoDetalle(0, "","","", materia, peDocente, aula, grupoCabecera);
        
        sql = "SELECT * FROM edu_grupo_detalles egd, edu_grupos_cabecera egc, edu_materias mat,\n" +
                "edu_aulas au, edu_personas p, edu_docentes d, edu_cursos cur, edu_anios_lectivos aniol, edu_menciones menc\n" +
                "WHERE egd.fk_gru_cab_codigo = egc.gru_cab_codigo AND egd.fk_mat_codigo = mat.mat_codigo\n" +
                "AND egd.fk_aul_codigo = au.aul_codigo AND egd.fk_doce_codigo = d.doce_codigo  AND p.per_codigo = d.fk_per_codigo\n" +
                "AND egc.fk_cur_codigo = cur.cur_codigo AND egc.fk_ani_codigo = aniol.ani_codigo AND egc.fk_men_codigo = menc.men_codigo\n" +
                "AND egc.gru_cab_codgrupo = ?";
         
        /*
        sql = "SELECT * FROM \"edu_grupos_cabecera\" egc, edu_cursos cur, edu_anios_lectivos aniol, edu_menciones menc\n"
                + "WHERE egc.fk_cur_codigo = cur.cur_codigo\n"
                + "AND egc.fk_ani_codigo = aniol.ani_codigo AND egc.fk_men_codigo = menc.men_codigo\n"
                + "AND egc.gru_cab_codgrupo = ?";
        */
        Conexion.coneccion();

        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, grupo);
            res = preSta.executeQuery();
            res.next();
            grupoCabecera.setCodigo(res.getInt("gru_cab_codigo"));
            grupoCabecera.setGrupo(res.getString("gru_cab_grupo"));
            grupoCabecera.setCodigoGrupo(res.getString("gru_cab_codgrupo"));
            grupoCabecera.setCurso(controladorCurso.buscarCursoCodigo(res.getInt("fk_cur_codigo")));
            grupoCabecera.setAnioLectivo(controladorAnioLectivo.buscarAnioLectivo(res.getInt("fk_ani_codigo")));
            grupoCabecera.setMension(controladorMension.buscarMensionCodigo(res.getInt("fk_men_codigo")));
            curso.setCodigo(res.getInt("cur_codigo"));
            curso.setAbrebiatura(res.getString("cur_abrebiatura"));
            curso.setCurso(res.getString("cur_curso"));
            anioLectivo.setCodigo(res.getInt("ani_codigo"));
            anioLectivo.setAnioLectivo(res.getString("ani_anio_lectivo"));
            anioLectivo.setFechaInicio(res.getDate("ani_fecha_inicio"));
            anioLectivo.setFechaFinal(res.getDate("ani_fecha_final"));
            mension.setCodigo(res.getInt("men_codigo"));
            mension.setAbrebiatura(res.getString("men_abrebiatura"));
            mension.setMension(res.getString("men_mension"));
            mension.setHorasTotales(res.getString("men_horast"));
            materia.setAbrebiatura(res.getString("mat_abrebiatura"));
            materia.setMateria(res.getString("mat_materia"));
            materia.setHoras(res.getString("mat_horas"));
            materia.setCosto(res.getDouble("mat_costo"));
            
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Grupo Cabecera por nombre : " + e.getMessage());
        }

        return grupoCabecera;
    }

    public void eliminarGrupoCabecera(GrupoCabecera grupoCabecera) {
        sql = "DELETE FROM \"edu_grupos_cabecera\" WHERE gru_cab_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, grupoCabecera.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Grupo Detalle: " + ex.getMessage());
        }

    }

    public List<GrupoCabecera> listarGrupoCabeceras() {

        List<GrupoCabecera> listarGrupoCabecera = new ArrayList<>();
        sql = "SELECT * FROM \"edu_grupos_cabecera\" ";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            res = preSta.executeQuery();
            while (res.next()) {
                Mension mension = new Mension(0, "", "", "");
                Curso curso = new Curso(0, "", "");
                AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", curso, anioLectivo, mension);
                ControladorMencion controladorMension = new ControladorMencion();
                ControladorAnioLectivo controladorAnioLectivo = new ControladorAnioLectivo();
                ControladorCurso controladorCurso = new ControladorCurso();
                grupoCabecera.setCodigo(res.getInt("gru_cab_codigo"));
                grupoCabecera.setGrupo(res.getString("gru_cab_grupo"));
                grupoCabecera.setCodigoGrupo(res.getString("gru_cab_codgrupo"));
                grupoCabecera.setCurso(controladorCurso.buscarCursoCodigo(res.getInt("fk_cur_codigo")));
                grupoCabecera.setAnioLectivo(controladorAnioLectivo.buscarAnioLectivo(res.getInt("fk_ani_codigo")));
                grupoCabecera.setMension(controladorMension.buscarMensionCodigo(res.getInt("fk_men_codigo")));

                listarGrupoCabecera.add(grupoCabecera);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Grupo Cabecera " + e.getMessage());
        }
        return listarGrupoCabecera;
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
