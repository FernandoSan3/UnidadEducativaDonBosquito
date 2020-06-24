/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloFactura;

/**
 *
 * @author alexCT
 */
public abstract class FormasDePago {
    
    private int codigo;
    private double valor;
    private double comision;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    
    public double calcularCosto(){
        
        return 1;
    }
    
    public abstract double costoComision();
    
    public abstract double costoTotal();
}
