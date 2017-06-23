package com.nuck.modelo;
// Generated 23-jun-2017 1:38:17 by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * Salida generated by hbm2java
 */
public class Salida  implements java.io.Serializable {


     private Integer salidaId;
     private Cliente cliente;
     private Colaborador colaborador;
     private Miembro miembro;
     private Producto producto;
     private Servicio servicio;
     private Date salidaFechaCreacion;

    public Salida() {
    }

	
    public Salida(Integer salidaId) {
        this.salidaId = salidaId;
    }
    public Salida(Integer salidaId, Cliente cliente, Colaborador colaborador, Miembro miembro, Producto producto, Servicio servicio, Date salidaFechaCreacion) {
       this.salidaId = salidaId;
       this.cliente = cliente;
       this.colaborador = colaborador;
       this.miembro = miembro;
       this.producto = producto;
       this.servicio = servicio;
       this.salidaFechaCreacion = salidaFechaCreacion;
    }
   
    public Integer getSalidaId() {
        return this.salidaId;
    }
    
    public void setSalidaId(Integer salidaId) {
        this.salidaId = salidaId;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Colaborador getColaborador() {
        return this.colaborador;
    }
    
    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
    public Miembro getMiembro() {
        return this.miembro;
    }
    
    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Date getSalidaFechaCreacion() {
        return this.salidaFechaCreacion;
    }
    
    public void setSalidaFechaCreacion(Date salidaFechaCreacion) {
        this.salidaFechaCreacion = salidaFechaCreacion;
    }




}


