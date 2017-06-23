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
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioDTO.class);
    private String usuarioAdmin;
    private Date usuarioFechaCreacion;
    private Date usuarioFechaModificacion;
    private Integer usuarioId;
    private String usuarioImagen;
    private String usuarioNombre;
    private String usuarioPasswd;

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public Date getUsuarioFechaCreacion() {
        return usuarioFechaCreacion;
    }

    public void setUsuarioFechaCreacion(Date usuarioFechaCreacion) {
        this.usuarioFechaCreacion = usuarioFechaCreacion;
    }

    public Date getUsuarioFechaModificacion() {
        return usuarioFechaModificacion;
    }

    public void setUsuarioFechaModificacion(Date usuarioFechaModificacion) {
        this.usuarioFechaModificacion = usuarioFechaModificacion;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioImagen() {
        return usuarioImagen;
    }

    public void setUsuarioImagen(String usuarioImagen) {
        this.usuarioImagen = usuarioImagen;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioPasswd() {
        return usuarioPasswd;
    }

    public void setUsuarioPasswd(String usuarioPasswd) {
        this.usuarioPasswd = usuarioPasswd;
    }
}
