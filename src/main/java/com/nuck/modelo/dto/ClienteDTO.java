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
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClienteDTO.class);
    private String clienteApellido;
    private String clienteBarrio;
    private String clienteCorreoElctronico;
    private String clienteDireccion;
    private Date clienteFechaCreacion;
    private Date clienteFechaModificacion;
    private Date clienteFechaNacimiento;
    private Integer clienteId;
    private String clienteNombre;
    private String clienteNumeroCelular;
    private String clienteNumeroIdentificacion;
    private String clienteNumeroTelefono;

    public String getClienteApellido() {
        return clienteApellido;
    }

    public void setClienteApellido(String clienteApellido) {
        this.clienteApellido = clienteApellido;
    }

    public String getClienteBarrio() {
        return clienteBarrio;
    }

    public void setClienteBarrio(String clienteBarrio) {
        this.clienteBarrio = clienteBarrio;
    }

    public String getClienteCorreoElctronico() {
        return clienteCorreoElctronico;
    }

    public void setClienteCorreoElctronico(String clienteCorreoElctronico) {
        this.clienteCorreoElctronico = clienteCorreoElctronico;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public Date getClienteFechaCreacion() {
        return clienteFechaCreacion;
    }

    public void setClienteFechaCreacion(Date clienteFechaCreacion) {
        this.clienteFechaCreacion = clienteFechaCreacion;
    }

    public Date getClienteFechaModificacion() {
        return clienteFechaModificacion;
    }

    public void setClienteFechaModificacion(Date clienteFechaModificacion) {
        this.clienteFechaModificacion = clienteFechaModificacion;
    }

    public Date getClienteFechaNacimiento() {
        return clienteFechaNacimiento;
    }

    public void setClienteFechaNacimiento(Date clienteFechaNacimiento) {
        this.clienteFechaNacimiento = clienteFechaNacimiento;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteNumeroCelular() {
        return clienteNumeroCelular;
    }

    public void setClienteNumeroCelular(String clienteNumeroCelular) {
        this.clienteNumeroCelular = clienteNumeroCelular;
    }

    public String getClienteNumeroIdentificacion() {
        return clienteNumeroIdentificacion;
    }

    public void setClienteNumeroIdentificacion(
        String clienteNumeroIdentificacion) {
        this.clienteNumeroIdentificacion = clienteNumeroIdentificacion;
    }

    public String getClienteNumeroTelefono() {
        return clienteNumeroTelefono;
    }

    public void setClienteNumeroTelefono(String clienteNumeroTelefono) {
        this.clienteNumeroTelefono = clienteNumeroTelefono;
    }
}
