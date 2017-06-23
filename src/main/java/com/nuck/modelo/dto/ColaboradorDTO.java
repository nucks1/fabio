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
public class ColaboradorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ColaboradorDTO.class);
    private String colaboradorApellido;
    private String colaboradorBarrio;
    private String colaboradorCorreoElctronico;
    private String colaboradorDireccion;
    private Date colaboradorFechaCreacion;
    private Date colaboradorFechaModificacion;
    private Date colaboradorFechaNacimiento;
    private Integer colaboradorId;
    private String colaboradorNombre;
    private String colaboradorNumeroCelular;
    private String colaboradorNumeroIdentificacion;
    private String colaboradorNumeroTelefono;
    private Integer usuarioId_Usuario;

    public String getColaboradorApellido() {
        return colaboradorApellido;
    }

    public void setColaboradorApellido(String colaboradorApellido) {
        this.colaboradorApellido = colaboradorApellido;
    }

    public String getColaboradorBarrio() {
        return colaboradorBarrio;
    }

    public void setColaboradorBarrio(String colaboradorBarrio) {
        this.colaboradorBarrio = colaboradorBarrio;
    }

    public String getColaboradorCorreoElctronico() {
        return colaboradorCorreoElctronico;
    }

    public void setColaboradorCorreoElctronico(
        String colaboradorCorreoElctronico) {
        this.colaboradorCorreoElctronico = colaboradorCorreoElctronico;
    }

    public String getColaboradorDireccion() {
        return colaboradorDireccion;
    }

    public void setColaboradorDireccion(String colaboradorDireccion) {
        this.colaboradorDireccion = colaboradorDireccion;
    }

    public Date getColaboradorFechaCreacion() {
        return colaboradorFechaCreacion;
    }

    public void setColaboradorFechaCreacion(Date colaboradorFechaCreacion) {
        this.colaboradorFechaCreacion = colaboradorFechaCreacion;
    }

    public Date getColaboradorFechaModificacion() {
        return colaboradorFechaModificacion;
    }

    public void setColaboradorFechaModificacion(
        Date colaboradorFechaModificacion) {
        this.colaboradorFechaModificacion = colaboradorFechaModificacion;
    }

    public Date getColaboradorFechaNacimiento() {
        return colaboradorFechaNacimiento;
    }

    public void setColaboradorFechaNacimiento(Date colaboradorFechaNacimiento) {
        this.colaboradorFechaNacimiento = colaboradorFechaNacimiento;
    }

    public Integer getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Integer colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public String getColaboradorNombre() {
        return colaboradorNombre;
    }

    public void setColaboradorNombre(String colaboradorNombre) {
        this.colaboradorNombre = colaboradorNombre;
    }

    public String getColaboradorNumeroCelular() {
        return colaboradorNumeroCelular;
    }

    public void setColaboradorNumeroCelular(String colaboradorNumeroCelular) {
        this.colaboradorNumeroCelular = colaboradorNumeroCelular;
    }

    public String getColaboradorNumeroIdentificacion() {
        return colaboradorNumeroIdentificacion;
    }

    public void setColaboradorNumeroIdentificacion(
        String colaboradorNumeroIdentificacion) {
        this.colaboradorNumeroIdentificacion = colaboradorNumeroIdentificacion;
    }

    public String getColaboradorNumeroTelefono() {
        return colaboradorNumeroTelefono;
    }

    public void setColaboradorNumeroTelefono(String colaboradorNumeroTelefono) {
        this.colaboradorNumeroTelefono = colaboradorNumeroTelefono;
    }

    public Integer getUsuarioId_Usuario() {
        return usuarioId_Usuario;
    }

    public void setUsuarioId_Usuario(Integer usuarioId_Usuario) {
        this.usuarioId_Usuario = usuarioId_Usuario;
    }
}
