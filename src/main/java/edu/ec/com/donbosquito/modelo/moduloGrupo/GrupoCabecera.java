/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloGrupo;

import java.util.List;

/**
 *
 * @author fernandosanchez
 */
public class GrupoCabecera {
    
    private int codigo;
    private String grupo;
    private String codigoGrupo;
    private Curso curso;
    private AnioLectivo anioLectivo;
    private Mension mension;

    public GrupoCabecera(int codigo, String grupo, String codigoGrupo, Curso curso, AnioLectivo anioLectivo, Mension mension) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.codigoGrupo = codigoGrupo;
        this.curso = curso;
        this.anioLectivo = anioLectivo;
        this.mension = mension;
    }

    public GrupoCabecera(int i, String string, String string0, String string1, Curso curso, AnioLectivo anioLectivo, Mension mension) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public AnioLectivo getAnioLectivo() {
        return anioLectivo;
    }

    public void setAnioLectivo(AnioLectivo anioLectivo) {
        this.anioLectivo = anioLectivo;
    }

    public Mension getMension() {
        return mension;
    }

    public void setMension(Mension mension) {
        this.mension = mension;
    }

    @Override
    public String toString() {
        return "GrupoCabecera{" + "codigo=" + codigo + ", grupo=" + grupo + ", codigoGrupo=" + codigoGrupo + ", curso=" + curso + ", anioLectivo=" + anioLectivo + ", mension=" + mension + '}';
    }
    
    

}