/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloMatricula;

import ModeloPersona.Persona;
import java.util.Date;

/**
 *
 * @author josepandiguana
 */
public class Matricula {
    
    private int codigo;
    private Date fechaMatricula;
    private GrupoCabecera grupoCabeveras;
    private Persona estudiante;
    private AnoLectivo anoLectivo;

    public Matricula(int codigo, Date fechaMatricula, GrupoCabecera grupoCabeveras, Persona estudiante, AnoLectivo anoLectivo) {
        this.codigo = codigo;
        this.fechaMatricula = fechaMatricula;
        this.grupoCabeveras = grupoCabeveras;
        this.estudiante = estudiante;
        this.anoLectivo = anoLectivo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public GrupoCabecera getGrupoCabeveras() {
        return grupoCabeveras;
    }

    public void setGrupoCabeveras(GrupoCabecera grupoCabeveras) {
        this.grupoCabeveras = grupoCabeveras;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public AnoLectivo getAnoLectivo() {
        return anoLectivo;
    }

    public void setAnoLectivo(AnoLectivo anoLectivo) {
        this.anoLectivo = anoLectivo;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo=" + codigo + ", fechaMatricula=" + fechaMatricula + ", grupoCabeveras=" + grupoCabeveras + ", estudiante=" + estudiante + ", anoLectivo=" + anoLectivo + '}';
    }

    
    
    
    
    
}
