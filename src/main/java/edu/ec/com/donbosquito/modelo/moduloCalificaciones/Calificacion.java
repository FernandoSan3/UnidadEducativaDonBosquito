/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloCalificaciones;

import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;

/**
 *
 * @author Bryam
 */
public class Calificacion {

    private int codigoCalificacion;
    private Double promedioCalificion;
    private Estudiante estudiante;

    public Calificacion(int codigoCalificacion, Double promedioCalificion, Estudiante estudiante) {
        this.codigoCalificacion = codigoCalificacion;
        this.promedioCalificion = promedioCalificion;
        this.estudiante = estudiante;
    }

    public int getCodigoCalificacion() {
        return codigoCalificacion;
    }

    public void setCodigoCalificacion(int codigoCalificacion) {
        this.codigoCalificacion = codigoCalificacion;
    }

    public Double getPromedioCalificion() {
        return promedioCalificion;
    }

    public void setPromedioCalificion(Double promedioCalificion) {
        this.promedioCalificion = promedioCalificion;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "codigoCalificacion=" + codigoCalificacion + ", promedioCalificion=" + promedioCalificion + ", estudiante=" + estudiante + '}';
    }
}
