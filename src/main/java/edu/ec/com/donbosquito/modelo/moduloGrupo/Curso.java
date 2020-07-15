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
public class Curso {
    
    private int codigo;
    private String abrebiatura;
    private String curso;

    public Curso(int codigo, String abrebiatura, String curso) {
        this.codigo = codigo;
        this.abrebiatura = abrebiatura;
        this.curso = curso;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", abrebiatura=" + abrebiatura + ", curso=" + curso + '}';
    }
    
    
    
}
