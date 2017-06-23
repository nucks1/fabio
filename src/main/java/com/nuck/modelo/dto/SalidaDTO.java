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
public class SalidaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SalidaDTO.class);
    private Date salidaFechaCreacion;
    private Integer salidaId;
    private Integer clienteId_Cliente;
    private Integer colaboradorId_Colaborador;
    private Integer miembroId_Miembro;
    private Integer productoId_Producto;
    private Integer servicioId_Servicio;

    public Date getSalidaFechaCreacion() {
        return salidaFechaCreacion;
    }

    public void setSalidaFechaCreacion(Date salidaFechaCreacion) {
        this.salidaFechaCreacion = salidaFechaCreacion;
    }

    public Integer getSalidaId() {
        return salidaId;
    }

    public void setSalidaId(Integer salidaId) {
        this.salidaId = salidaId;
    }

    public Integer getClienteId_Cliente() {
        return clienteId_Cliente;
    }

    public void setClienteId_Cliente(Integer clienteId_Cliente) {
        this.clienteId_Cliente = clienteId_Cliente;
    }

    public Integer getColaboradorId_Colaborador() {
        return colaboradorId_Colaborador;
    }

    public void setColaboradorId_Colaborador(Integer colaboradorId_Colaborador) {
        this.colaboradorId_Colaborador = colaboradorId_Colaborador;
    }

    public Integer getMiembroId_Miembro() {
        return miembroId_Miembro;
    }

    public void setMiembroId_Miembro(Integer miembroId_Miembro) {
        this.miembroId_Miembro = miembroId_Miembro;
    }

    public Integer getProductoId_Producto() {
        return productoId_Producto;
    }

    public void setProductoId_Producto(Integer productoId_Producto) {
        this.productoId_Producto = productoId_Producto;
    }

    public Integer getServicioId_Servicio() {
        return servicioId_Servicio;
    }

    public void setServicioId_Servicio(Integer servicioId_Servicio) {
        this.servicioId_Servicio = servicioId_Servicio;
    }
}
