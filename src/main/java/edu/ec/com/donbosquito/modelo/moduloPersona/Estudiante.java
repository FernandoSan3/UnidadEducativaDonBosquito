/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ec.com.donbosquito.modelo.moduloPersona;

import java.util.Date;

/**
 *
 * @author Bryam
 */
public class Estudiante extends Persona{
    
    private int codigoEstudiante;
    private Date fechaNaciemiento;
    private int edad;
    private Date fechaInscripcion;
    private Persona persona;
    private Representante representante;

    public Estudiante(int codigoEstudiante, Date fechaNaciemiento, int edad, Date fechaInscripcion, Persona persona, Representante representante, int coidgoPersona, String cedula, String nombre, String apellido, String direccion, String telefono, String correo) {
        super(coidgoPersona, cedula, nombre, apellido, direccion, telefono, correo);
        this.codigoEstudiante = codigoEstudiante;
        this.fechaNaciemiento = fechaNaciemiento;
        this.edad = edad;
        this.fechaInscripcion = fechaInscripcion;
        this.persona = persona;
        this.representante = representante;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Date getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public void setFechaNaciemiento(Date fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
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
        return "Estudiante{" + "codigoEstudiante=" + codigoEstudiante + ", fechaNaciemiento=" + fechaNaciemiento + ", edad=" + edad + ", fechaInscripcion=" + fechaInscripcion + ", persona=" + persona + ", representante=" + representante + '}';
    }

   
   
}
