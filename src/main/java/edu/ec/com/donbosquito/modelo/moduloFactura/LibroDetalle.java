/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloFactura;

import java.sql.Date;

/**
 *
 * @author alexCT
 */
public class LibroDetalle {
    
    private int codigo;
    private Date fecha;
    private String detalle;
    private double debe;
    private double haber;
    private LibroDiario libroDiario;
    private Pago pago;

    public LibroDetalle(int codigo, Date fecha, String detalle, double debe, double haber, LibroDiario libroDiario, Pago pago) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.detalle = detalle;
        this.debe = debe;
        this.haber = haber;
        this.libroDiario = libroDiario;
        this.pago = pago;
    }

    public LibroDetalle() {
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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

    public LibroDiario getLibroDiario() {
        return libroDiario;
    }

    public void setLibroDiario(LibroDiario libroDiario) {
        this.libroDiario = libroDiario;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    @Override
    public String toString() {
        return "LibroDetalle{" + "codigo=" + codigo + ", fecha=" + fecha + ", detalle=" + detalle + ", debe=" + debe + ", haber=" + haber + ", libroDiario=" + libroDiario + ", pago=" + pago + '}';
    }
}
