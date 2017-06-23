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
public class EntradaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EntradaDTO.class);
    private String entradaActivo;
    private Date entradaFechaCreacion;
    private String entradaFinalizado;
    private Integer entradaId;
    private Integer clienteId_Cliente;
    private Integer colaboradorId_Colaborador;
    private Integer miembroId_Miembro;
    private Integer productoId_Producto;
    private Integer servicioId_Servicio;

    public String getEntradaActivo() {
        return entradaActivo;
    }

    public void setEntradaActivo(String entradaActivo) {
        this.entradaActivo = entradaActivo;
    }

    public Date getEntradaFechaCreacion() {
        return entradaFechaCreacion;
    }

    public void setEntradaFechaCreacion(Date entradaFechaCreacion) {
        this.entradaFechaCreacion = entradaFechaCreacion;
    }

    public String getEntradaFinalizado() {
        return entradaFinalizado;
    }

    public void setEntradaFinalizado(String entradaFinalizado) {
        this.entradaFinalizado = entradaFinalizado;
    }

    public Integer getEntradaId() {
        return entradaId;
    }

    public void setEntradaId(Integer entradaId) {
        this.entradaId = entradaId;
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
