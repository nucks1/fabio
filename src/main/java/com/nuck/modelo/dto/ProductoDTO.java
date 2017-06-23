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
public class ProductoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProductoDTO.class);
    private String productoBeneficios;
    private Integer productoCantidad;
    private Date productoFechaCrecaion;
    private Date productoFechaModificacion;
    private Integer productoId;
    private String productoImagen;
    private Integer claseTipoId_ClaseTipo;

    public String getProductoBeneficios() {
        return productoBeneficios;
    }

    public void setProductoBeneficios(String productoBeneficios) {
        this.productoBeneficios = productoBeneficios;
    }

    public Integer getProductoCantidad() {
        return productoCantidad;
    }

    public void setProductoCantidad(Integer productoCantidad) {
        this.productoCantidad = productoCantidad;
    }

    public Date getProductoFechaCrecaion() {
        return productoFechaCrecaion;
    }

    public void setProductoFechaCrecaion(Date productoFechaCrecaion) {
        this.productoFechaCrecaion = productoFechaCrecaion;
    }

    public Date getProductoFechaModificacion() {
        return productoFechaModificacion;
    }

    public void setProductoFechaModificacion(Date productoFechaModificacion) {
        this.productoFechaModificacion = productoFechaModificacion;
    }

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public String getProductoImagen() {
        return productoImagen;
    }

    public void setProductoImagen(String productoImagen) {
        this.productoImagen = productoImagen;
    }

    public Integer getClaseTipoId_ClaseTipo() {
        return claseTipoId_ClaseTipo;
    }

    public void setClaseTipoId_ClaseTipo(Integer claseTipoId_ClaseTipo) {
        this.claseTipoId_ClaseTipo = claseTipoId_ClaseTipo;
    }
}
