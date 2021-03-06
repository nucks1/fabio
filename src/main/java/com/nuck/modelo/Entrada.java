package com.nuck.modelo;
// Generated 23-jun-2017 1:38:17 by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * Entrada generated by hbm2java
 */
public class Entrada  implements java.io.Serializable {


     private Integer entradaId;
     private Cliente cliente;
     private Colaborador colaborador;
     private Miembro miembro;
     private Producto producto;
     private Servicio servicio;
     private String entradaActivo;
     private String entradaFinalizado;
     private Date entradaFechaCreacion;

    public Entrada() {
    }

	
    public Entrada(Integer entradaId) {
        this.entradaId = entradaId;
    }
    public Entrada(Integer entradaId, Cliente cliente, Colaborador colaborador, Miembro miembro, Producto producto, Servicio servicio, String entradaActivo, String entradaFinalizado, Date entradaFechaCreacion) {
       this.entradaId = entradaId;
       this.cliente = cliente;
       this.colaborador = colaborador;
       this.miembro = miembro;
       this.producto = producto;
       this.servicio = servicio;
       this.entradaActivo = entradaActivo;
       this.entradaFinalizado = entradaFinalizado;
       this.entradaFechaCreacion = entradaFechaCreacion;
    }
   
    public Integer getEntradaId() {
        return this.entradaId;
    }
    
    public void setEntradaId(Integer entradaId) {
        this.entradaId = entradaId;
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
    public String getEntradaActivo() {
        return this.entradaActivo;
    }
    
    public void setEntradaActivo(String entradaActivo) {
        this.entradaActivo = entradaActivo;
    }
    public String getEntradaFinalizado() {
        return this.entradaFinalizado;
    }
    
    public void setEntradaFinalizado(String entradaFinalizado) {
        this.entradaFinalizado = entradaFinalizado;
    }
    public Date getEntradaFechaCreacion() {
        return this.entradaFechaCreacion;
    }
    
    public void setEntradaFechaCreacion(Date entradaFechaCreacion) {
        this.entradaFechaCreacion = entradaFechaCreacion;
    }




}


