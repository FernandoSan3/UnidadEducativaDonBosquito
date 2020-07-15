/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.controlador.moduloGrupo;

import edu.ec.com.donbosquito.conexion.Conexion;
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
public class ControladorGrupoDetalle {

    private PreparedStatement preSta;
    private ResultSet res;
    private String sql;
    private String sql1;

    public void crearGrupoDetalle(GrupoDetalle grupoDetalle) {
        sql = "INSERT INTO \"edu_grupo_detalles\" (gru_det_descripcion, gru_det_hora_inicial, gru_det_hora_final, fk_mat_codigo, fk_aul_codigo, fk_doce_codigo,fk_gru_cab_codigo) VALUES (?,?,?,?,?,?,?)";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, grupoDetalle.getDescripcion());
            preSta.setString(2, grupoDetalle.getFecha_inicio());
            preSta.setString(3, grupoDetalle.getFecha_final());
            preSta.setInt(4, grupoDetalle.getMateria().getCodigo());
            preSta.setInt(5, grupoDetalle.getAula().getCodigo());
            preSta.setInt(6, grupoDetalle.getPersona().getCodigoDocente());
            preSta.setInt(7, grupoDetalle.getGrupoCabecerae().getCodigo());
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al insertar en la base de datos el Grupo Detalle: " + ex.getMessage());
        }
    }

    public void modificarGrupoDetalle(GrupoDetalle grupoDetalle) {
        sql = "UPDATE \"edu_grupo_detalles\" SET gru_det_descripcion = ?, gru_det_hora_inicial = ?, gru_det_hora_final = ?, fk_mat_codigo = ?, fk_aul_codigo = ? , fk_doce_codigo = ?, fk_gru_cab_codigo = ?   WHERE gru_det_codigo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, grupoDetalle.getDescripcion());
            preSta.setString(2, grupoDetalle.getFecha_inicio());
            preSta.setString(3, grupoDetalle.getFecha_final());
            preSta.setInt(4, grupoDetalle.getMateria().getCodigo());
            preSta.setInt(5, grupoDetalle.getAula().getCodigo());
            preSta.setInt(6, grupoDetalle.getPersona().getCodigoDocente());
            preSta.setInt(7, grupoDetalle.getGrupoCabecerae().getCodigo());
            preSta.setInt(8, grupoDetalle.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el Grupo Detalle: " + e.getMessage());
        }

    }

    public GrupoDetalle buscarGrupoDetalleCodigo(int codigo) {

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

        GrupoDetalle grupoDetalle = new GrupoDetalle(0, "", "", "", materia, peDocente, aula, grupoCabecera);

        sql = "SELECT * FROM edu_grupo_detalles gd, edu_materias m, edu_aulas a, edu_docentes d, edu_grupos_cabecera gc, edu_personas p WHERE\n"
                + "gd.fk_mat_codigo = m.mat_codigo AND gd.fk_aul_codigo = a.aul_codigo AND gd.fk_doce_codigo = d.doce_codigo AND \n"
                + "d.fk_per_codigo = p.per_codigo AND gd.fk_gru_cab_codigo = gc.gru_cab_codigo AND gd.gru_det_codigo = ?";
        Conexion.coneccion();

        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, codigo);
            res = preSta.executeQuery();
            res.next();

            grupoDetalle.setCodigo(res.getInt("gru_det_codigo"));
            grupoDetalle.setDescripcion(res.getString("gru_det_descripcion"));
            grupoDetalle.setFecha_inicio(res.getString("gru_det_hora_inicial"));
            grupoDetalle.setFecha_final(res.getString("gru_det_hora_final"));
            grupoDetalle.setMateria(controladorMateria.buscarMateriaCodigo(res.getInt("fk_mat_codigo")));
            grupoDetalle.setAula(controladorAula.buscarAulaCodigo(res.getInt("fk_aul_codigo")));
            grupoDetalle.setPersona((Docente) controladorDocente.buscarUsuario(res.getInt("fk_doce_codigo")));
            grupoDetalle.setGrupoCabecerae(controladorGrupoCabecera.buscarGrupoCabeceraCodigo(res.getInt("fk_gru_cab_codigo")));
            materia.setCodigo(res.getInt("mat_codigo"));
            materia.setMateria(res.getString("mat_materia"));
            materia.setAbrebiatura(res.getString("mat_abrebiatura"));
            materia.setHoras(res.getString("mat_horas"));
            materia.setCosto(res.getDouble("mat_costo"));
            aula.setCodigo(res.getInt("aul_codigo"));
            aula.setAula(res.getString("aul_aula"));
            aula.setPiso(res.getInt("aul_piso"));
            aula.setNumeroAula(res.getInt("aul_num_aula"));
            aula.setEdificio(res.getString("aul_edificio"));
            aula.setTipo(res.getString("aul_tipo"));
            peDocente.setCodigoDocente(res.getInt("doce_codigo"));
            peDocente.setTituloDocente(res.getString("doce_titulo"));
            peDocente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            grupoCabecera.setCodigo(res.getInt("gru_cab_codigo"));
            grupoCabecera.setGrupo(res.getString("gru_cab_grupo"));
            grupoCabecera.setCodigoGrupo(res.getString("gru_cab_codgrupo"));
            grupoCabecera.setCurso(controladorCurso.buscarCursoCodigo(res.getInt("fk_cur_codigo")));
            grupoCabecera.setAnioLectivo(controladorAnioLectivo.buscarAnioLectivo(res.getInt("fk_ani_codigo")));
            grupoCabecera.setMension(controladorMension.buscarMensionCodigo(res.getInt("fk_men_codigo")));
            persona.setCodigoPersona(res.getInt("per_codigo"));
            persona.setCedula(res.getString("per_cedula"));
            persona.setNombre(res.getString("per_nombre"));
            persona.setApellido(res.getString("per_apellido"));
            persona.setDireccion(res.getString("per_direccion"));
            persona.setTelefono(res.getString("per_telefono"));
            persona.setCorreo(res.getString("per_correo"));
            /*
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
            mension.setHorasTotales(res.getDate("men_horast"));
             */
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Grupo Detalle por codigo: " + e.getMessage());
        }

        return grupoDetalle;
    }

    public GrupoDetalle buscarGrupoDetalle(String descripcion) {

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

        GrupoDetalle grupoDetalle = new GrupoDetalle(0, "", "", "", materia, peDocente, aula, grupoCabecera);

        sql = "SELECT * FROM edu_grupo_detalles gd, edu_materias m, edu_aulas a, edu_docentes d, edu_grupos_cabecera gc, edu_personas p WHERE\n"
                + "gd.fk_mat_codigo = m.mat_codigo AND gd.fk_aul_codigo = a.aul_codigo AND gd.fk_doce_codigo = d.doce_codigo AND \n"
                + "d.fk_per_codigo = p.per_codigo AND gd.fk_gru_cab_codigo = gc.gru_cab_codigo AND gd.gru_det_descripcion = ?";
        Conexion.coneccion();

        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, descripcion);
            res = preSta.executeQuery();
            res.next();

            grupoDetalle.setCodigo(res.getInt("gru_det_codigo"));
            grupoDetalle.setDescripcion(res.getString("gru_det_descripcion"));
            grupoDetalle.setFecha_inicio(res.getString("gru_det_hora_inicial"));
            grupoDetalle.setFecha_final(res.getString("gru_det_hora_final"));
            grupoDetalle.setMateria(controladorMateria.buscarMateriaCodigo(res.getInt("fk_mat_codigo")));
            grupoDetalle.setAula(controladorAula.buscarAulaCodigo(res.getInt("fk_aul_codigo")));
            grupoDetalle.setPersona((Docente) controladorDocente.buscarUsuario(res.getInt("fk_doce_codigo")));
            grupoDetalle.setGrupoCabecerae(controladorGrupoCabecera.buscarGrupoCabeceraCodigo(res.getInt("fk_gru_cab_codigo")));
            materia.setCodigo(res.getInt("mat_codigo"));
            materia.setMateria(res.getString("mat_materia"));
            materia.setAbrebiatura(res.getString("mat_abrebiatura"));
            materia.setHoras(res.getString("mat_horas"));
            materia.setCosto(res.getDouble("mat_costo"));
            aula.setCodigo(res.getInt("aul_codigo"));
            aula.setAula(res.getString("aul_aula"));
            aula.setPiso(res.getInt("aul_piso"));
            aula.setNumeroAula(res.getInt("aul_num_aula"));
            aula.setEdificio(res.getString("aul_edificio"));
            aula.setTipo(res.getString("aul_tipo"));
            peDocente.setCodigoDocente(res.getInt("doce_codigo"));
            peDocente.setTituloDocente(res.getString("doce_titulo"));
            peDocente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            grupoCabecera.setCodigo(res.getInt("gru_cab_codigo"));
            grupoCabecera.setGrupo(res.getString("gru_cab_grupo"));
            grupoCabecera.setCodigoGrupo(res.getString("gru_cab_codgrupo"));
            grupoCabecera.setCurso(controladorCurso.buscarCursoCodigo(res.getInt("fk_cur_codigo")));
            grupoCabecera.setAnioLectivo(controladorAnioLectivo.buscarAnioLectivo(res.getInt("fk_ani_codigo")));
            grupoCabecera.setMension(controladorMension.buscarMensionCodigo(res.getInt("fk_men_codigo")));
            persona.setCodigoPersona(res.getInt("per_codigo"));
            persona.setCedula(res.getString("per_cedula"));
            persona.setNombre(res.getString("per_nombre"));
            persona.setApellido(res.getString("per_apellido"));
            persona.setDireccion(res.getString("per_direccion"));
            persona.setTelefono(res.getString("per_telefono"));
            persona.setCorreo(res.getString("per_correo"));
            /*
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
            mension.setHorasTotales(res.getDate("men_horast"));
             */
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Grupo Detalle por descripcion: " + e.getMessage());
        }

        return grupoDetalle;
    }

    public GrupoDetalle buscarGrupoDetalleGrupoCabecera(String descripcion) {

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

        GrupoDetalle grupoDetalle = new GrupoDetalle(0, "", "", "", materia, peDocente, aula, grupoCabecera);

        sql = "SELECT * FROM edu_grupo_detalles egd, edu_grupos_cabecera egc, edu_materias mat,\n"
                + "edu_aulas au, edu_personas p, edu_docentes d\n"
                + "WHERE egd.fk_gru_cab_codigo = egc.gru_cab_codigo AND egd.fk_mat_codigo = mat.mat_codigo\n"
                + "AND egd.fk_aul_codigo = au.aul_codigo AND egd.fk_doce_codigo = d.doce_codigo  AND p.per_codigo = d.fk_per_codigo\n"
                + "AND egc.gru_cab_codgrupo = ?";
        Conexion.coneccion();

        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, descripcion);
            res = preSta.executeQuery();
            res.next();

            grupoDetalle.setCodigo(res.getInt("gru_det_codigo"));
            grupoDetalle.setDescripcion(res.getString("gru_det_descripcion"));
            grupoDetalle.setFecha_inicio(res.getString("gru_det_hora_inicial"));
            grupoDetalle.setFecha_final(res.getString("gru_det_hora_final"));
            grupoDetalle.setMateria(controladorMateria.buscarMateriaCodigo(res.getInt("fk_mat_codigo")));
            grupoDetalle.setAula(controladorAula.buscarAulaCodigo(res.getInt("fk_aul_codigo")));
            grupoDetalle.setPersona((Docente) controladorDocente.buscarUsuario(res.getInt("fk_doce_codigo")));
            grupoDetalle.setGrupoCabecerae(controladorGrupoCabecera.buscarGrupoCabeceraCodigo(res.getInt("fk_gru_cab_codigo")));
            materia.setCodigo(res.getInt("mat_codigo"));
            materia.setMateria(res.getString("mat_materia"));
            materia.setAbrebiatura(res.getString("mat_abrebiatura"));
            materia.setHoras(res.getString("mat_horas"));
            materia.setCosto(res.getDouble("mat_costo"));
            aula.setCodigo(res.getInt("aul_codigo"));
            aula.setAula(res.getString("aul_aula"));
            aula.setPiso(res.getInt("aul_piso"));
            aula.setNumeroAula(res.getInt("aul_num_aula"));
            aula.setEdificio(res.getString("aul_edificio"));
            aula.setTipo(res.getString("aul_tipo"));
            peDocente.setCodigoDocente(res.getInt("doce_codigo"));
            peDocente.setTituloDocente(res.getString("doce_titulo"));
            peDocente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
            grupoCabecera.setCodigo(res.getInt("gru_cab_codigo"));
            grupoCabecera.setGrupo(res.getString("gru_cab_grupo"));
            grupoCabecera.setCodigoGrupo(res.getString("gru_cab_codgrupo"));
            grupoCabecera.setCurso(controladorCurso.buscarCursoCodigo(res.getInt("fk_cur_codigo")));
            grupoCabecera.setAnioLectivo(controladorAnioLectivo.buscarAnioLectivo(res.getInt("fk_ani_codigo")));
            grupoCabecera.setMension(controladorMension.buscarMensionCodigo(res.getInt("fk_men_codigo")));
            persona.setCodigoPersona(res.getInt("per_codigo"));
            persona.setCedula(res.getString("per_cedula"));
            persona.setNombre(res.getString("per_nombre"));
            persona.setApellido(res.getString("per_apellido"));
            persona.setDireccion(res.getString("per_direccion"));
            persona.setTelefono(res.getString("per_telefono"));
            persona.setCorreo(res.getString("per_correo"));
            /*
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
            mension.setHorasTotales(res.getDate("men_horast"));
             */
            preSta.execute();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al buscar en la Base de Datos el Grupo Detalle por descripcion: " + e.getMessage());
        }

        return grupoDetalle;
    }

    public void eliminarGrupoDetalle(GrupoDetalle grupoDetalle) {
        sql = "DELETE FROM \"edu_grupo_detalles\" WHERE gru_det_codigo = ? ;";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setInt(1, grupoDetalle.getCodigo());
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el Grupo Detalle: " + ex.getMessage());
        }

    }

    public List<GrupoDetalle> listarGrupoDetalles(String d) {

        List<GrupoDetalle> listarGrupoDetalle = new ArrayList<>();
        sql = "SELECT * FROM edu_grupo_detalles egd, edu_grupos_cabecera egc, edu_materias mat,\n"
                + "edu_aulas au, edu_personas p, edu_docentes d\n"
                + "WHERE egd.fk_gru_cab_codigo = egc.gru_cab_codigo AND egd.fk_mat_codigo = mat.mat_codigo\n"
                + "AND egd.fk_aul_codigo = au.aul_codigo AND egd.fk_doce_codigo = d.doce_codigo  AND p.per_codigo = d.fk_per_codigo\n"
                + "AND egc.gru_cab_codgrupo = ?";
        Conexion.coneccion();
        try {
            preSta = Conexion.getCon().prepareStatement(sql);
            preSta.setString(1, d);
            res = preSta.executeQuery();
            res.next();
            while (res.next()) {
                Mension mension = new Mension(0, "", "", "");
                Curso curso = new Curso(0, "", "");
                AnioLectivo anioLectivo = new AnioLectivo(0, "", ParseFecha("0/0/0"), ParseFecha("0/0/0"));
                GrupoCabecera grupoCabecera = new GrupoCabecera(0, "", "", curso, anioLectivo, mension);

                Aula aula = new Aula(0, "", 0, 0, "", "");
                Persona persona = new Persona(0, "", "", "", "", "", "") {
                };
                Docente docente = new Docente(0, "", persona, 0, "", "", "", "", "", "");
                Materia materia = new Materia(0, "", "", "", 0);
                GrupoDetalle grupoDetalle = new GrupoDetalle(0, "", "", "", materia, docente, aula, grupoCabecera);

                ControladorMateria controladorMateria = new ControladorMateria();
                ControladorDocente controladorDocente = new ControladorDocente();
                ControladorAula controladorAula = new ControladorAula();
                ControladorGrupoCabecera controladorGrupoCabecera = new ControladorGrupoCabecera();
                ControPersona cp = new ControPersona();

                grupoDetalle.setCodigo(res.getInt("gru_det_codigo"));
                grupoDetalle.setDescripcion(res.getString("gru_det_descripcion"));
                grupoDetalle.setFecha_inicio(res.getString("gru_det_hora_inicial"));
                grupoDetalle.setFecha_final(res.getString("gru_det_hora_final"));
                grupoDetalle.setMateria(controladorMateria.buscarMateriaCodigo(res.getInt("fk_mat_codigo")));
                grupoDetalle.setAula(controladorAula.buscarAulaCodigo(res.getInt("fk_aul_codigo")));
                grupoDetalle.setPersona(controladorDocente.buscarDocenteCedula(res.getString("per_cedula")));
                grupoDetalle.setGrupoCabecerae(controladorGrupoCabecera.buscarGrupoCabeceraCodigo(res.getInt("fk_gru_cab_codigo")));
                docente.setCodigoDocente(res.getInt("doce_codigo"));
                docente.setTituloDocente(res.getString("doce_titulo"));
                docente.setPersona(cp.buscarPersona(res.getInt("fk_per_codigo")));
                docente.setCodigoPersona(res.getInt("per_codigo"));
                docente.setCedula(res.getString("per_cedula"));
                docente.setNombre(res.getString("per_nombre"));
                docente.setApellido(res.getString("per_apellido"));
                docente.setDireccion(res.getString("per_direccion"));
                docente.setTelefono(res.getString("per_telefono"));
                docente.setCorreo(res.getString("per_correo"));
                listarGrupoDetalle.add(grupoDetalle);
            }
            preSta.executeUpdate();
            preSta.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            System.out.println("Erro al listar al Grupo Detalle " + e.getMessage());
        }
        return listarGrupoDetalle;
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
