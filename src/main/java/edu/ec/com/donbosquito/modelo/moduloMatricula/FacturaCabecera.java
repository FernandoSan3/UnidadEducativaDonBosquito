/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloMatricula;

import ModeloFactura.FormaDePago;
import ModeloPersona.Persona;
import java.util.Date;
import java.util.List;

/**
 *
 * @author josepandiguana
 */

public class FacturaCabecera {
    private int codigo;
    private int numeroFacura;
    private Date fecha;
    private Persona representante;
    private FormaDePago formaDePago;
    private List<GrupoCabecera> detalleGrupo;
    private double subtotal;
    private double total;

    public FacturaCabecera(int codigo, int numeroFacura, Date fecha, Persona representante, FormaDePago formaDePago, List<GrupoCabecera> detalleGrupo, double subtotal, double total) {
        this.codigo = codigo;
        this.numeroFacura = numeroFacura;
        this.fecha = fecha;
        this.representante = representante;
        this.formaDePago = formaDePago;
        this.detalleGrupo = detalleGrupo;
        this.subtotal = subtotal;
        this.total = total;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroFacura() {
        return numeroFacura;
    }

    public void setNumeroFacura(int numeroFacura) {
        this.numeroFacura = numeroFacura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public void setRepresentante(Persona representante) {
        this.representante = representante;
    }

    public FormaDePago getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(FormaDePago formaDePago) {
        this.formaDePago = formaDePago;
    }

    public List<GrupoCabecera> getDetalleGrupo() {
        return detalleGrupo;
    }

    public void setDetalleGrupo(List<GrupoCabecera> detalleGrupo) {
        this.detalleGrupo = detalleGrupo;
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

    @Override
    public String toString() {
        return "FacturaCabecera{" + "codigo=" + codigo + ", numeroFacura=" + numeroFacura + ", fecha=" + fecha + ", representante=" + representante + ", formaDePago=" + formaDePago + ", detalleGrupo=" + detalleGrupo + ", subtotal=" + subtotal + ", total=" + total + '}';
    }

  
    
    
    
}
