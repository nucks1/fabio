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
public class TipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoDTO.class);
    private String tipoClase;
    private String tipoDescripcion;
    private Date tipoFechaCreacrion;
    private Date tipoFechaModificacion;
    private Integer tipoId;
    private String tipoRef;

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public String getTipoDescripcion() {
        return tipoDescripcion;
    }

    public void setTipoDescripcion(String tipoDescripcion) {
        this.tipoDescripcion = tipoDescripcion;
    }

    public Date getTipoFechaCreacrion() {
        return tipoFechaCreacrion;
    }

    public void setTipoFechaCreacrion(Date tipoFechaCreacrion) {
        this.tipoFechaCreacrion = tipoFechaCreacrion;
    }

    public Date getTipoFechaModificacion() {
        return tipoFechaModificacion;
    }

    public void setTipoFechaModificacion(Date tipoFechaModificacion) {
        this.tipoFechaModificacion = tipoFechaModificacion;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getTipoRef() {
        return tipoRef;
    }

    public void setTipoRef(String tipoRef) {
        this.tipoRef = tipoRef;
    }
}
