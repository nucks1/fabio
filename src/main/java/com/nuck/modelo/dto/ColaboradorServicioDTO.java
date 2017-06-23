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
public class ColaboradorServicioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ColaboradorServicioDTO.class);
    private Date colaboradorServicioFechaFin;
    private Date colaboradorServicioFechaIni;
    private Integer colaboradorId;
    private Integer servicioId;
    private Integer colaboradorId_Colaborador;
    private Integer servicioId_Servicio;

    public Date getColaboradorServicioFechaFin() {
        return colaboradorServicioFechaFin;
    }

    public void setColaboradorServicioFechaFin(Date colaboradorServicioFechaFin) {
        this.colaboradorServicioFechaFin = colaboradorServicioFechaFin;
    }

    public Date getColaboradorServicioFechaIni() {
        return colaboradorServicioFechaIni;
    }

    public void setColaboradorServicioFechaIni(Date colaboradorServicioFechaIni) {
        this.colaboradorServicioFechaIni = colaboradorServicioFechaIni;
    }

    public Integer getColaboradorId() {
        return colaboradorId;
    }

    public void setColaboradorId(Integer colaboradorId) {
        this.colaboradorId = colaboradorId;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public Integer getColaboradorId_Colaborador() {
        return colaboradorId_Colaborador;
    }

    public void setColaboradorId_Colaborador(Integer colaboradorId_Colaborador) {
        this.colaboradorId_Colaborador = colaboradorId_Colaborador;
    }

    public Integer getServicioId_Servicio() {
        return servicioId_Servicio;
    }

    public void setServicioId_Servicio(Integer servicioId_Servicio) {
        this.servicioId_Servicio = servicioId_Servicio;
    }
}
