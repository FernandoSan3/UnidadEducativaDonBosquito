/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloFactura;

import java.util.Date;

/**
 *
 * @author alexCT
 */
public class Pago {
    
    private int codigo;
    private Date fecha;
    private String estado;
    private double valor;
    private String formaPago;
    private TipoDePago tipoPago;

    public Pago(int codigo, Date fecha, String estado, double valor, TipoDePago tipoPago, String formaPAgo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.estado = estado;
        this.valor = valor;
        this.tipoPago = tipoPago;
        this.formaPago = formaPAgo;
    }

    public Pago() {
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoDePago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoDePago tipoPago) {
        this.tipoPago = tipoPago;
    }

    @Override
    public String toString() {
        return "Pago{" + "codigo=" + codigo + ", fecha=" + fecha + ", estado=" + estado + ", valor=" + valor + ", tipoPago=" + tipoPago + '}';
    }
}
