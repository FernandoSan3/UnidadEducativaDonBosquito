/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloMatricula;



import edu.ec.com.donbosquito.modelo.moduloPersona.Estudiante;
import java.util.Date;

/**
 *
 * @author josepandiguana
 */
public class Matricula {
    
    private int codigo;
    private Date fechaMatricula;
    //private GrupoCabecera grupoCabeveras;
    private Estudiante estudiante;

    public Matricula(int codigo, Date fechaMatricula, Estudiante estudiante) {
        this.codigo = codigo;
        this.fechaMatricula = fechaMatricula;
        this.estudiante = estudiante;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigo=" + codigo + ", fechaMatricula=" + fechaMatricula + ", estudiante=" + estudiante + '}';
    }
    
}
