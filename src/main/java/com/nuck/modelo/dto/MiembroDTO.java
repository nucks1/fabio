package com.nuck.modelo.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public class MiembroDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MiembroDTO.class);
    private String miembroApellido;
    private String miembroBarrio;
    private String miembroCorreoElctronico;
    private String miembroDireccion;
    private Date miembroFechaCreacion;
    private Date miembroFechaModificacion;
    private Date miembroFechaNacimiento;
    private Integer miembroId;
    private String miembroNombre;
    private String miembroNumeroCelular;
    private String miembroNumeroIdentificacion;
    private String miembroNumeroTelefono;
    private Integer usuarioId_Usuario;

    public String getMiembroApellido() {
        return miembroApellido;
    }

    public void setMiembroApellido(String miembroApellido) {
        this.miembroApellido = miembroApellido;
    }

    public String getMiembroBarrio() {
        return miembroBarrio;
    }

    public void setMiembroBarrio(String miembroBarrio) {
        this.miembroBarrio = miembroBarrio;
    }

    public String getMiembroCorreoElctronico() {
        return miembroCorreoElctronico;
    }

    public void setMiembroCorreoElctronico(String miembroCorreoElctronico) {
        this.miembroCorreoElctronico = miembroCorreoElctronico;
    }

    public String getMiembroDireccion() {
        return miembroDireccion;
    }

    public void setMiembroDireccion(String miembroDireccion) {
        this.miembroDireccion = miembroDireccion;
    }

    public Date getMiembroFechaCreacion() {
        return miembroFechaCreacion;
    }

    public void setMiembroFechaCreacion(Date miembroFechaCreacion) {
        this.miembroFechaCreacion = miembroFechaCreacion;
    }

    public Date getMiembroFechaModificacion() {
        return miembroFechaModificacion;
    }

    public void setMiembroFechaModificacion(Date miembroFechaModificacion) {
        this.miembroFechaModificacion = miembroFechaModificacion;
    }

    public Date getMiembroFechaNacimiento() {
        return miembroFechaNacimiento;
    }

    public void setMiembroFechaNacimiento(Date miembroFechaNacimiento) {
        this.miembroFechaNacimiento = miembroFechaNacimiento;
    }

    public Integer getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(Integer miembroId) {
        this.miembroId = miembroId;
    }

    public String getMiembroNombre() {
        return miembroNombre;
    }

    public void setMiembroNombre(String miembroNombre) {
        this.miembroNombre = miembroNombre;
    }

    public String getMiembroNumeroCelular() {
        return miembroNumeroCelular;
    }

    public void setMiembroNumeroCelular(String miembroNumeroCelular) {
        this.miembroNumeroCelular = miembroNumeroCelular;
    }

    public String getMiembroNumeroIdentificacion() {
        return miembroNumeroIdentificacion;
    }

    public void setMiembroNumeroIdentificacion(
        String miembroNumeroIdentificacion) {
        this.miembroNumeroIdentificacion = miembroNumeroIdentificacion;
    }

    public String getMiembroNumeroTelefono() {
        return miembroNumeroTelefono;
    }

    public void setMiembroNumeroTelefono(String miembroNumeroTelefono) {
        this.miembroNumeroTelefono = miembroNumeroTelefono;
    }

    public Integer getUsuarioId_Usuario() {
        return usuarioId_Usuario;
    }

    public void setUsuarioId_Usuario(Integer usuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
    }
}
