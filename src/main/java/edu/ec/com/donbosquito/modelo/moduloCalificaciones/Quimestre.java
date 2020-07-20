/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloCalificaciones;

import edu.ec.com.donbosquito.modelo.moduloGrupo.Materia;
import edu.ec.com.donbosquito.modelo.moduloMatricula.Matricula;

/**
 *
 * @author Bryam
 */
public class Quimestre {

    private int codigoQuimestre;
    private Double primerBloque;
    private Double segundoBloque;
    private Double tercerBloque;
    private Double examen;
    private Double aprovechamiento;
    private Double notaQuimestre;
    private String estadoMateria;
    private Matricula matricula;
    private Calificacion calificacion;
    private Materia materia;

    public Quimestre(int codigoQuimestre, Double primerBloque, Double segundoBloque, Double tercerBloque, Double examen, Double aprovechamiento, Double notaQuimestre, String estadoMateria, Matricula matricula, Calificacion calificacion, Materia materia) {
        this.codigoQuimestre = codigoQuimestre;
        this.primerBloque = primerBloque;
        this.segundoBloque = segundoBloque;
        this.tercerBloque = tercerBloque;
        this.examen = examen;
        this.aprovechamiento = aprovechamiento;
        this.notaQuimestre = notaQuimestre;
        this.estadoMateria = estadoMateria;
        this.matricula = matricula;
        this.calificacion = calificacion;
        this.materia = materia;
    }

    public int getCodigoQuimestre() {
        return codigoQuimestre;
    }

    public void setCodigoQuimestre(int codigoQuimestre) {
        this.codigoQuimestre = codigoQuimestre;
    }

    public Double getPrimerBloque() {
        return primerBloque;
    }

    public void setPrimerBloque(Double primerBloque) {
        this.primerBloque = primerBloque;
    }

    public Double getSegundoBloque() {
        return segundoBloque;
    }

    public void setSegundoBloque(Double segundoBloque) {
        this.segundoBloque = segundoBloque;
    }

    public Double getTercerBloque() {
        return tercerBloque;
    }

    public void setTercerBloque(Double tercerBloque) {
        this.tercerBloque = tercerBloque;
    }

    public Double getExamen() {
        return examen;
    }

    public void setExamen(Double examen) {
        this.examen = examen;
    }

    public Double getAprovechamiento() {
        return aprovechamiento;
    }

    public void setAprovechamiento(Double aprovechamiento) {
        this.aprovechamiento = aprovechamiento;
    }

    public Double getNotaQuimestre() {
        return notaQuimestre;
    }

    public void setNotaQuimestre(Double notaQuimestre) {
        this.notaQuimestre = notaQuimestre;
    }

    public String getEstadoMateria() {
        return estadoMateria;
    }

    public void setEstadoMateria(String estadoMateria) {
        this.estadoMateria = estadoMateria;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Quimestre{" + "codigoQuimestre=" + codigoQuimestre + ", primerBloque=" + primerBloque + ", segundoBloque=" + segundoBloque + ", tercerBloque=" + tercerBloque + ", examen=" + examen + ", aprovechamiento=" + aprovechamiento + ", notaQuimestre=" + notaQuimestre + ", estadoMateria=" + estadoMateria + ", matricula=" + matricula + ", calificacion=" + calificacion + ", materia=" + materia + '}';
    }

}
