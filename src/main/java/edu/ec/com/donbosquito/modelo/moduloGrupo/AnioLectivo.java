/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloGrupo;

import java.util.Date;

/**
 *
 * @author fernandosanchez
 */
public class AnioLectivo {
    
    private int codigo;
    private String anioLectivo;
    private Date fechaInicio;
    private Date fechaFinal;

    public AnioLectivo(int codigo, String anioLectivo, Date fechaInicio, Date fechaFinal) {
        this.codigo = codigo;
        this.anioLectivo = anioLectivo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(String anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "AnioLectivo{" + "codigo=" + codigo + ", anioLectivo=" + anioLectivo + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + '}';
    }

    
    
    
    
}
