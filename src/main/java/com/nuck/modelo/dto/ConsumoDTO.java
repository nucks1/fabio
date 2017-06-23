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
public class ConsumoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ConsumoDTO.class);
    private Date consumoFecha;
    private Integer consumoId;
    private Double consumoTotalIngreso;

    public Date getConsumoFecha() {
        return consumoFecha;
    }

    public void setConsumoFecha(Date consumoFecha) {
        this.consumoFecha = consumoFecha;
    }

    public Integer getConsumoId() {
        return consumoId;
    }

    public void setConsumoId(Integer consumoId) {
        this.consumoId = consumoId;
    }

    public Double getConsumoTotalIngreso() {
        return consumoTotalIngreso;
    }

    public void setConsumoTotalIngreso(Double consumoTotalIngreso) {
        this.consumoTotalIngreso = consumoTotalIngreso;
    }
}
