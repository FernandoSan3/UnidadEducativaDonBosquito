
import edu.ec.com.donbosquito.conexion.Conexion;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControPersona;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorDocente;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorEstudiante;
import static edu.ec.com.donbosquito.controlador.moduloPersona.ControladorEstudiante.ParseFecha;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorPersona;
import edu.ec.com.donbosquito.controlador.moduloPersona.ControladorRepresentante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;
import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import edu.ec.com.donbosquito.modelo.moduloPersona.Persona;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import static java.nio.file.Files.list;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryam
 */
public class Prueba {

    public static void main(String args[]) {

        ControladorRepresentante cr = new ControladorRepresentante();
        ControladorEstudiante ce = new ControladorEstudiante();
        Docente docente = new Docente(0, "", 0, "", "", "", "", "", "");
        Persona persona = new Persona(0, "", "", "", "", "", "") {
        };
        Representante representante = new Representante(0, "", persona, 0, "", "", "", "", "", "");
        Estudiante estudiante = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), persona, representante, 0, "", "", "", "", "", "");
        /*
        representante.setCodigoPersona(1);
        representante.setCedula("0105885101");
        representante.setNombre("Anable Carolina");
        representante.setApellido("Lituma Suin");
        representante.setDireccion("Jima");
        representante.setTelefono("0969138544");
        representante.setCorreo("anabel@outlook.es");
        representante.setCodigoRepresentante(1);
        representante.setParentescoFamiliar("Tia");
        representante.setPersona(representante);
        cr.modificarUsuario(estudiante, docente, representante, persona);
         
        ///////////munfo
        ////asassssmmmm
        
        
        Iterator iter = cr.listarUsuario().iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }/*

        //System.out.println(cr.buscarCedulaRepresentante("0105885101"));        
        /*
        estudiante.setCodigoPersona(3);
        estudiante.setCedula("0105885870");
        estudiante.setNombre("assa");
        estudiante.setApellido("asas");
        estudiante.setDireccion("assas");
        estudiante.setTelefono("asas");
        estudiante.setCorreo("assa@asas.es");
        estudiante.setCodigoEstudiante(3);
        estudiante.setFechaNaciemiento(ParseFecha("19/12/1995"));
        estudiante.setEdad(24);
        estudiante.setFechaInscripcion(ParseFecha("21/06/2020"));
        estudiante.setPersona(estudiante);
        estudiante.setRepresentante((Representante) cr.buscarUsuario(1));
        ce.crearUsuario(estudiante, docente, representante, persona);
         */
        
        //System.out.println(ce.buscarUsuario(2));
        
        
        Iterator iter = ce.listarUsuario().iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
        /*
        estudiante.setCodigoPersona(3);
        estudiante.setCedula("0105885870");
        estudiante.setNombre("Melisa");
        estudiante.setApellido("Cedilo");
        estudiante.setDireccion("Cuenca");
        estudiante.setTelefono("0969138544");
        estudiante.setCorreo("meli@outlook.es");
        estudiante.setCodigoEstudiante(3);
        estudiante.setFechaNaciemiento(ParseFecha("12/12/1995"));
        estudiante.setEdad(20);
        estudiante.setFechaInscripcion(ParseFecha("12/06/2020"));
        estudiante.setPersona(estudiante);
        estudiante.setRepresentante((Representante) cr.buscarUsuario(1));
        ce.modificarUsuario(estudiante, docente, representante, persona);
        */
        
        /*representante.setCodigoPersona(4);
        persona.setCodigoPersona(4);
        cr.eliminarUsuario(estudiante, docente, representante, persona);
        
        
        //System.out.println(cr.buscarUsuario(2));
        /*
        ControladorEstudiante ce = new ControladorEstudiante();
        ControladorRepresentante cr = new ControladorRepresentante();
        ControladorDocente cd = new ControladorDocente();
        
        System.out.println(ce.buscarUsuario(100));
        
        
        //System.out.println(cp.listarPersona());
        
        
        
        
        
        Docente d = new Docente(0, "", 0, "", "", "", "", "", "");
        Representante r = new Representante(0, "", 0, "", "", "", "", "", "");
        Estudiante es = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), 0, "", "", "", "", "", "");
        Persona p = new Persona(0,"","","","","",""){};
        d.setCodigoPersona(4);
        d.setCedula("0105885107");
        d.setNombre("Diego Israel");
        d.setApellido("Lituma Suin");
        d.setDireccion("Jima");
        d.setTelefono("0969138544");
        d.setCorreo("diego@outlook.es");
        cp.guardarPersona(d);
        d = new Docente(0, "", 0, "", "", "", "", "", "");
        d.setCodigoDocente(1);
        d.setTituloDocente("Ingeniero en Sistemas");
        p.setCodigoPersona(4);
        cd.crearUsuario(es, r, d, p);
        
        
        Docente d = new Docente(0, "", 0, "", "", "", "", "", "");
        Representante r = new Representante(0, "", 0, "", "", "", "", "", "");
        Estudiante es = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), 0, "", "", "", "", "", "");
        Persona p = new Persona(0,"","","","","",""){};
        r.setCodigoPersona(1);
        r.setCedula("0105885875");
        r.setNombre("Sonia Marquina");
        r.setApellido("Marquina Amon");
        r.setDireccion("Americas");
        r.setTelefono("0969138544");
        r.setCorreo("sonia95_19@hotmail.com");
        cp.guardarPersona(r);
        r = new Representante(0, "", 0, "", "", "", "", "", "");        
        r.setCodigoRepresentante(1);
        r.setParentescoFamiliar("Madre");
        r.setCodigoPersona(1);
        cr.crearUsuario(es, r, d, p);
        
        
        es = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), 0, "", "", "", "", "", "");
        d = new Docente(0, "", 0, "", "", "", "", "", "");
        r = new Representante(0, "", 0, "", "", "", "", "", "");
        p = new Persona(0,"","","","","",""){};
        r = new Representante(0, "", 0, "", "", "", "", "", "");
        es.setCodigoPersona(2);
        es.setCedula("0105885878");
        es.setNombre("Bryam Gabriel");
        es.setApellido("Mora Lituma");
        es.setDireccion("Americas");
        es.setTelefono("0969138544");
        es.setCorreo("bryan95_19@hotmail.com");
        cp.guardarPersona(es);
        es = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), 0, "", "", "", "", "", "");
        es.setCodigoEstudiante(100);
        es.setFechaNaciemiento(ParseFecha("19/12/1995"));
        es.setEdad(24);
        es.setFechaInscripcion(ParseFecha("20/0/2019"));
        es.setCodigoPersona(2);
        r.setCodigoRepresentante(1);
        ce.crearUsuario(es, r, d, p);
        
        es = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), 0, "", "", "", "", "", "");
        r = new Representante(0, "", 0, "", "", "", "", "", "");
        es.setCodigoPersona(3);
        es.setCedula("0105885879");
        es.setNombre("Anabel Carolina");
        es.setApellido("Lituma Suin");
        es.setDireccion("Americas");
        es.setTelefono("0969138544");
        es.setCorreo("anabel95_19@hotmail.com");
        cp.guardarPersona(es);
        es = new Estudiante(0, ParseFecha("0/0/0"), 0, ParseFecha("0/0/0"), 0, "", "", "", "", "", "");
        es.setCodigoEstudiante(200);
        es.setFechaNaciemiento(ParseFecha("19/12/1990"));
        es.setEdad(30);
        es.setFechaInscripcion(ParseFecha("20/0/2019"));
        es.setCodigoPersona(3);
        r.setCodigoRepresentante(1);
        ce.crearUsuario(es, r, d, p);
         */
    }

    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

}
