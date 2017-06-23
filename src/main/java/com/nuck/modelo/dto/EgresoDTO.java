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
public class EgresoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EgresoDTO.class);
    private Date egresoFecha;
    private Integer egresoId;
    private Double egresoValor;
    private Integer claseTipoId_ClaseTipo;

    public Date getEgresoFecha() {
        return egresoFecha;
    }

    public void setEgresoFecha(Date egresoFecha) {
        this.egresoFecha = egresoFecha;
    }

    public Integer getEgresoId() {
        return egresoId;
    }

    public void setEgresoId(Integer egresoId) {
        this.egresoId = egresoId;
    }

    public Double getEgresoValor() {
        return egresoValor;
    }

    public void setEgresoValor(Double egresoValor) {
        this.egresoValor = egresoValor;
    }

    public Integer getClaseTipoId_ClaseTipo() {
        return claseTipoId_ClaseTipo;
    }

    public void setClaseTipoId_ClaseTipo(Integer claseTipoId_ClaseTipo) {
        this.claseTipoId_ClaseTipo = claseTipoId_ClaseTipo;
    }
}
