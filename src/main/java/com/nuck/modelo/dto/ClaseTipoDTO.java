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
public class ClaseTipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClaseTipoDTO.class);
    private Double claseTipoCostoEgreso;
    private Double claseTipoCostoIngreso;
    private String claseTipoDescripcion;
    private Date claseTipoFechaCreacion;
    private Date claseTipoFechaModificacion;
    private Integer claseTipoId;
    private Integer claseTipoPuntos;
    private String claseTipoRef;
    private Integer tipoId_Tipo;

    public Double getClaseTipoCostoEgreso() {
        return claseTipoCostoEgreso;
    }

    public void setClaseTipoCostoEgreso(Double claseTipoCostoEgreso) {
        this.claseTipoCostoEgreso = claseTipoCostoEgreso;
    }

    public Double getClaseTipoCostoIngreso() {
        return claseTipoCostoIngreso;
    }

    public void setClaseTipoCostoIngreso(Double claseTipoCostoIngreso) {
        this.claseTipoCostoIngreso = claseTipoCostoIngreso;
    }

    public String getClaseTipoDescripcion() {
        return claseTipoDescripcion;
    }

    public void setClaseTipoDescripcion(String claseTipoDescripcion) {
        this.claseTipoDescripcion = claseTipoDescripcion;
    }

    public Date getClaseTipoFechaCreacion() {
        return claseTipoFechaCreacion;
    }

    public void setClaseTipoFechaCreacion(Date claseTipoFechaCreacion) {
        this.claseTipoFechaCreacion = claseTipoFechaCreacion;
    }

    public Date getClaseTipoFechaModificacion() {
        return claseTipoFechaModificacion;
    }

    public void setClaseTipoFechaModificacion(Date claseTipoFechaModificacion) {
        this.claseTipoFechaModificacion = claseTipoFechaModificacion;
    }

    public Integer getClaseTipoId() {
        return claseTipoId;
    }

    public void setClaseTipoId(Integer claseTipoId) {
        this.claseTipoId = claseTipoId;
    }

    public Integer getClaseTipoPuntos() {
        return claseTipoPuntos;
    }

    public void setClaseTipoPuntos(Integer claseTipoPuntos) {
        this.claseTipoPuntos = claseTipoPuntos;
    }

    public String getClaseTipoRef() {
        return claseTipoRef;
    }

    public void setClaseTipoRef(String claseTipoRef) {
        this.claseTipoRef = claseTipoRef;
    }

    public Integer getTipoId_Tipo() {
        return tipoId_Tipo;
    }

    public void setTipoId_Tipo(Integer tipoId_Tipo) {
        this.tipoId_Tipo = tipoId_Tipo;
    }
}
