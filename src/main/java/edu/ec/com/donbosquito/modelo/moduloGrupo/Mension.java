/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloGrupo;

import java.util.Date;

/**
 *
 * @author fernandosanchez
 */
public class Mension {
    
    private int codigo;
    private String abrebiatura;
    private String mension;
    private String horasTotales;

    public Mension(int codigo, String abrebiatura, String mension, String horasTotales) {
        this.codigo = codigo;
        this.abrebiatura = abrebiatura;
        this.mension = mension;
        this.horasTotales = horasTotales;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAbrebiatura() {
        return abrebiatura;
    }

    public void setAbrebiatura(String abrebiatura) {
        this.abrebiatura = abrebiatura;
    }

    public String getMension() {
        return mension;
    }

    public void setMension(String mension) {
        this.mension = mension;
    }

    public String getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(String horasTotales) {
        this.horasTotales = horasTotales;
    }

    @Override
    public String toString() {
        return "Mension{" + "codigo=" + codigo + ", abrebiatura=" + abrebiatura + ", mension=" + mension + ", horasTotales=" + horasTotales + '}';
    }

    

    
    
    
    
}
