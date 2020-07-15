/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloGrupo;

/**
 *
 * @author fernandosanchez
 */
public class Materia {
    
    private int codigo;
    private String materia;
    private String abrebiatura;
    private String horas;
    private double costo;

    public Materia(int codigo, String materia, String abrebiatura, String horas, double costo) {
        this.codigo = codigo;
        this.materia = materia;
        this.abrebiatura = abrebiatura;
        this.horas = horas;
        this.costo = costo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getAbrebiatura() {
        return abrebiatura;
    }

    public void setAbrebiatura(String abrebiatura) {
        this.abrebiatura = abrebiatura;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
 
    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Materia{" + "codigo=" + codigo + ", materia=" + materia + ", abrebiatura=" + abrebiatura + ", horas=" + horas + ", costo=" + costo + '}';
    }
    
    
    
    
}
