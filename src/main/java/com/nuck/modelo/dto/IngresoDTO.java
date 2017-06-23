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
public class IngresoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(IngresoDTO.class);
    private Date ingresoFecha;
    private Integer ingresoId;
    private Integer consumoId_Consumo;
    private Integer miembroId_Miembro;
    private Integer productoId_Producto;
    private Integer servicioId_Servicio;

    public Date getIngresoFecha() {
        return ingresoFecha;
    }

    public void setIngresoFecha(Date ingresoFecha) {
        this.ingresoFecha = ingresoFecha;
    }

    public Integer getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(Integer ingresoId) {
        this.ingresoId = ingresoId;
    }

    public Integer getConsumoId_Consumo() {
        return consumoId_Consumo;
    }

    public void setConsumoId_Consumo(Integer consumoId_Consumo) {
        this.consumoId_Consumo = consumoId_Consumo;
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
