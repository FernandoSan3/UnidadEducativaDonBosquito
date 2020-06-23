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
public class Representante extends Persona{
    
    private int codigoRepresentante;
    private String parentescoFamiliar;
    private Persona persona;

    public Representante(int codigoRepresentante, String parentescoFamiliar, Persona persona, int coidgoPersona, String cedula, String nombre, String apellido, String direccion, String telefono, String correo) {
        super(coidgoPersona, cedula, nombre, apellido, direccion, telefono, correo);
        this.codigoRepresentante = codigoRepresentante;
        this.parentescoFamiliar = parentescoFamiliar;
        this.persona = persona;
    }

    public int getCodigoRepresentante() {
        return codigoRepresentante;
    }

    public void setCodigoRepresentante(int codigoRepresentante) {
        this.codigoRepresentante = codigoRepresentante;
    }

    public String getParentescoFamiliar() {
        return parentescoFamiliar;
    }

    public void setParentescoFamiliar(String parentescoFamiliar) {
        this.parentescoFamiliar = parentescoFamiliar;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
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
        return "Representante{" + "codigoRepresentante=" + codigoRepresentante + ", parentescoFamiliar=" + parentescoFamiliar + ", persona=" + persona + '}';
    }

    
}
