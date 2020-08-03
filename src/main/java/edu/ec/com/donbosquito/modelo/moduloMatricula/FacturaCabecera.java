/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ec.com.donbosquito.modelo.moduloMatricula;


import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
import java.util.Date;


/**
 *
 * @author josepandiguana
 */

public class FacturaCabecera {
    private int codigo;
    private int numeroFactura;
    private Date fechaFacturaCabecera;
    private double subtotal;
    private double total;
    private Representante representante;

    public FacturaCabecera(int codigo, int numeroFactura, Date fechaFacturaCabecera, double subtotal, double total, Representante representante) {
        this.codigo = codigo;
        this.numeroFactura = numeroFactura;
        this.fechaFacturaCabecera = fechaFacturaCabecera;
        this.subtotal = subtotal;
        this.total = total;
        this.representante = representante;
    }

    public FacturaCabecera() {
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaFacturaCabecera() {
        return fechaFacturaCabecera;
    }

    public void setFechaFacturaCabecera(Date fechaFacturaCabecera) {
        this.fechaFacturaCabecera = fechaFacturaCabecera;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    @Override
    public String toString() {
        return "FacturaCabecera{" + "codigo=" + codigo + ", numeroFactura=" + numeroFactura + ", fechaFacturaCabecera=" + fechaFacturaCabecera + ", subtotal=" + subtotal + ", total=" + total + ", representante=" + representante + '}';
    }

  

}
