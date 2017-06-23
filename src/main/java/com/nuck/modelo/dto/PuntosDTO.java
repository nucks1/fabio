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
public class PuntosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PuntosDTO.class);
    private Integer puntosId;
    private Integer puntosPuntos;
    private Integer claseTipoId_ClaseTipo;

    public Integer getPuntosId() {
        return puntosId;
    }

    public void setPuntosId(Integer puntosId) {
        this.puntosId = puntosId;
    }

    public Integer getPuntosPuntos() {
        return puntosPuntos;
    }

    public void setPuntosPuntos(Integer puntosPuntos) {
        this.puntosPuntos = puntosPuntos;
    }

    public Integer getClaseTipoId_ClaseTipo() {
        return claseTipoId_ClaseTipo;
    }

    public void setClaseTipoId_ClaseTipo(Integer claseTipoId_ClaseTipo) {
        this.claseTipoId_ClaseTipo = claseTipoId_ClaseTipo;
    }
}
