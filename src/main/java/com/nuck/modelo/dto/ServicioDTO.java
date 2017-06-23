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
public class ServicioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ServicioDTO.class);
    private String servicioBeneficios;
    private Date servicioFechaCreacion;
    private Integer servicioId;
    private String servicioImagen;
    private Date servicionFechaModificacion;
    private Integer claseTipoId_ClaseTipo;

    public String getServicioBeneficios() {
        return servicioBeneficios;
    }

    public void setServicioBeneficios(String servicioBeneficios) {
        this.servicioBeneficios = servicioBeneficios;
    }

    public Date getServicioFechaCreacion() {
        return servicioFechaCreacion;
    }

    public void setServicioFechaCreacion(Date servicioFechaCreacion) {
        this.servicioFechaCreacion = servicioFechaCreacion;
    }

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public String getServicioImagen() {
        return servicioImagen;
    }

    public void setServicioImagen(String servicioImagen) {
        this.servicioImagen = servicioImagen;
    }

    public Date getServicionFechaModificacion() {
        return servicionFechaModificacion;
    }

    public void setServicionFechaModificacion(Date servicionFechaModificacion) {
        this.servicionFechaModificacion = servicionFechaModificacion;
    }

    public Integer getClaseTipoId_ClaseTipo() {
        return claseTipoId_ClaseTipo;
    }

    public void setClaseTipoId_ClaseTipo(Integer claseTipoId_ClaseTipo) {
        this.claseTipoId_ClaseTipo = claseTipoId_ClaseTipo;
    }
}
