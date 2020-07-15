/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloGrupo;

import edu.ec.com.donbosquito.modelo.moduloPersona.Docente;

/**
 *
 * @author fernandosanchez
 */
public class GrupoDetalle {
    
    private int codigo;
    private String descripcion;
    private String fecha_inicio;
    private String fecha_final;
    private Materia materia;
    private Docente persona;
    private Aula aula;
    private GrupoCabecera grupoCabecerae;

    public GrupoDetalle(int codigo, String descripcion, String fecha_inicio, String fecha_final, Materia materia, Docente persona, Aula aula, GrupoCabecera grupoCabecerae) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.materia = materia;
        this.persona = persona;
        this.aula = aula;
        this.grupoCabecerae = grupoCabecerae;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Docente getPersona() {
        return persona;
    }

    public void setPersona(Docente persona) {
        this.persona = persona;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public GrupoCabecera getGrupoCabecerae() {
        return grupoCabecerae;
    }

    public void setGrupoCabecerae(GrupoCabecera grupoCabecerae) {
        this.grupoCabecerae = grupoCabecerae;
    }

    @Override
    public String toString() {
        return "GrupoDetalle{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final + ", materia=" + materia + ", persona=" + persona + ", aula=" + aula + ", grupoCabecerae=" + grupoCabecerae + '}';
    }

    
    
    
}
   