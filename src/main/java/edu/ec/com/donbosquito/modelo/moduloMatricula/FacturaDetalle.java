/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloMatricula;

/**
 *
 * @author josepandiguana
 */
public class FacturaDetalle {
    private int codigo;
    private double cantidad;
    private double subtotal;
    private String descripcion;
    private Matricula matricula;
    private FacturaCabecera facturaCabecera;

    public FacturaDetalle(int codigo, double cantidad, double subtotal, String descripcion, Matricula matricula, FacturaCabecera facturaCabecera) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.descripcion = descripcion;
        this.matricula = matricula;
        this.facturaCabecera = facturaCabecera;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public FacturaCabecera getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    @Override
    public String toString() {
        return "FacturaDetalle{" + "codigo=" + codigo + ", cantidad=" + cantidad + ", subtotal=" + subtotal + ", descripcion=" + descripcion + ", matricula=" + matricula + ", facturaCabecera=" + facturaCabecera + '}';
    }

}
