/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloFactura;

import java.util.List;

/**
 *
 * @author alexCT
 */
public class LibroDiario {

    private int codigo;
    private String empresa;
    private String descripcion;
    private double debe;
    private double haber;
   // private List<LibroDetalle> listLibroDetalle;

    /*public LibroDiario(int codigo, String empresa, String descripcion, double debe, double haber) {
        this.codigo = codigo;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.debe = debe;
        this.haber = haber;
    }*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDebe() {
        return debe;
    }

    public void setDebe(double debe) {
        this.debe = debe;
    }

    public double getHaber() {
        return haber;
    }

    public void setHaber(double haber) {
        this.haber = haber;
    }

    @Override
    public String toString() {
        return "LibroDiario{" + "codigo=" + codigo + ", empresa=" + empresa + ", descripcion=" + descripcion + ", debe=" + debe + ", haber=" + haber + '}';
    }

    
}
