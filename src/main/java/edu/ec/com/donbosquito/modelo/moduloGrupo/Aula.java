/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloGrupo;

/**
 *
 * @author fernandosanchez
 */
public class Aula {
    
    private int codigo;
    private String aula;
    private int piso;
    private int numeroAula;
    private String edificio;
    private String tipo;

    public Aula(int codigo, String aula, int piso, int numeroAula, String edificio, String tipo) {
        this.codigo = codigo;
        this.aula = aula;
        this.piso = piso;
        this.numeroAula = numeroAula;
        this.edificio = edificio;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Aula{" + "codigo=" + codigo + ", aula=" + aula + ", piso=" + piso + ", numeroAula=" + numeroAula + ", edificio=" + edificio + ", tipo=" + tipo + '}';
    }

    
    
    

    
}
