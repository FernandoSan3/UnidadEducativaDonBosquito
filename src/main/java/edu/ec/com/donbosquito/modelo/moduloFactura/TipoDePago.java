/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloFactura;

import edu.ec.com.donbosquito.modelo.moduloMatricula.FacturaCabecera;

/**
 *
 * @author alexCT
 */
public class TipoDePago {
    
    private int codigo;
    private FacturaCabecera facturaCabecera;
    private String tipoPago;
    private int numeroPago;

    public TipoDePago(int codigo, FacturaCabecera facturaCabecera, String tipoPago, int numeroPago) {
        this.codigo = codigo;
        this.facturaCabecera = facturaCabecera;
        this.tipoPago = tipoPago;
        this.numeroPago = numeroPago;
    }

    public TipoDePago() {
    }
    
      public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   public FacturaCabecera getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(FacturaCabecera facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getNumeroPago() {
        return numeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        this.numeroPago = numeroPago;
    }

    @Override
    public String toString() {
        return "TipoDePago{" + "codigo=" + codigo + ", facturaCabecera=" + facturaCabecera + ", tipoPago=" + tipoPago + ", numeroPago=" + numeroPago + '}';
    }

    
}
