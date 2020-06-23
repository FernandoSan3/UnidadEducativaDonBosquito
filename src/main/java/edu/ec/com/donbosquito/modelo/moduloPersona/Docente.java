/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloPersona;

/**
 *
 * @author Bryam
 */
public class Docente extends Persona {
    
    private int codigoDocente;
    private String tituloDocente;

    public Docente(int codigoDocente, String tituloDocente, int coidgoPersona, String cedula, String nombre, String apellido, String direccion, String telefono, String correo) {
        super(coidgoPersona, cedula, nombre, apellido, direccion, telefono, correo);
        this.codigoDocente = codigoDocente;
        this.tituloDocente = tituloDocente;
    }

    public int getCodigoDocente() {
        return codigoDocente;
    }

    public void setCodigoDocente(int codigoDocente) {
        this.codigoDocente = codigoDocente;
    }

    public String getTituloDocente() {
        return tituloDocente;
    }

    public void setTituloDocente(String tituloDocente) {
        this.tituloDocente = tituloDocente;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int coidgoPersona) {
        this.codigoPersona = coidgoPersona;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Docente{" + "codigoDocente=" + codigoDocente + ", tituloDocente=" + tituloDocente + '}';
    }
    
}
