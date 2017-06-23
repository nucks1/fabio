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
public class MembresiaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MembresiaDTO.class);
    private Integer membresiaDerecha;
    private Date membresiaFecha;
    private Integer membresiaId;
    private Integer membresiaIzquierda;
    private Integer membresiaNivel;
    private Double membresiaPorcentajeDescuento;
    private Integer membresiaPuntos;
    private Integer consumoId_Consumo;
    private Integer miembroId_Miembro;

    public Integer getMembresiaDerecha() {
        return membresiaDerecha;
    }

    public void setMembresiaDerecha(Integer membresiaDerecha) {
        this.membresiaDerecha = membresiaDerecha;
    }

    public Date getMembresiaFecha() {
        return membresiaFecha;
    }

    public void setMembresiaFecha(Date membresiaFecha) {
        this.membresiaFecha = membresiaFecha;
    }

    public Integer getMembresiaId() {
        return membresiaId;
    }

    public void setMembresiaId(Integer membresiaId) {
        this.membresiaId = membresiaId;
    }

    public Integer getMembresiaIzquierda() {
        return membresiaIzquierda;
    }

    public void setMembresiaIzquierda(Integer membresiaIzquierda) {
        this.membresiaIzquierda = membresiaIzquierda;
    }

    public Integer getMembresiaNivel() {
        return membresiaNivel;
    }

    public void setMembresiaNivel(Integer membresiaNivel) {
        this.membresiaNivel = membresiaNivel;
    }

    public Double getMembresiaPorcentajeDescuento() {
        return membresiaPorcentajeDescuento;
    }

    public void setMembresiaPorcentajeDescuento(
        Double membresiaPorcentajeDescuento) {
        this.membresiaPorcentajeDescuento = membresiaPorcentajeDescuento;
    }

    public Integer getMembresiaPuntos() {
        return membresiaPuntos;
    }

    public void setMembresiaPuntos(Integer membresiaPuntos) {
        this.membresiaPuntos = membresiaPuntos;
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
}
