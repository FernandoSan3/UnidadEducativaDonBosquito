/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloMatricula;


import edu.ec.com.donbosquito.modelo.moduloFactura.FormasDePago;
import edu.ec.com.donbosquito.modelo.moduloPersona.Representante;
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
    private Representante representante;
    private FormasDePago formarDePago;
    //private List<GrupoCabecera> detalleGrupo;
    private double subtotal;
    private double total;

    public FacturaCabecera(int codigo, int numeroFacura, Date fecha, Representante representante, FormasDePago formarDePago, double subtotal, double total) {
        this.codigo = codigo;
        this.numeroFacura = numeroFacura;
        this.fecha = fecha;
        this.representante = representante;
        this.formarDePago = formarDePago;
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

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public FormasDePago getFormarDePago() {
        return formarDePago;
    }

    public void setFormarDePago(FormasDePago formarDePago) {
        this.formarDePago = formarDePago;
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
        return "FacturaCabecera{" + "codigo=" + codigo + ", numeroFacura=" + numeroFacura + ", fecha=" + fecha + ", representante=" + representante + ", formarDePago=" + formarDePago + ", subtotal=" + subtotal + ", total=" + total + '}';
    }

    
}
