/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloCalificaciones;

/**
 *
 * @author Bryam
 */
public class Certificado {

    private int codigoCertificado;
    private String estadoALectivo;
    private Double promedioCertificado;
    private Calificacion calificacion;

    public Certificado(int codigoCertificado, String estadoALectivo, Double promedioCertificado, Calificacion calificacion) {
        this.codigoCertificado = codigoCertificado;
        this.estadoALectivo = estadoALectivo;
        this.promedioCertificado = promedioCertificado;
        this.calificacion = calificacion;
    }

    public int getCodigoCertificado() {
        return codigoCertificado;
    }

    public void setCodigoCertificado(int codigoCertificado) {
        this.codigoCertificado = codigoCertificado;
    }

    public String getEstadoALectivo() {
        return estadoALectivo;
    }

    public void setEstadoALectivo(String estadoALectivo) {
        this.estadoALectivo = estadoALectivo;
    }

    public Double getPromedioCertificado() {
        return promedioCertificado;
    }

    public void setPromedioCertificado(Double promedioCertificado) {
        this.promedioCertificado = promedioCertificado;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Certificado{" + "codigoCertificado=" + codigoCertificado + ", estadoALectivo=" + estadoALectivo + ", promedioCertificado=" + promedioCertificado + ", calificacion=" + calificacion + '}';
    }

}
