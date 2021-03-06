package com.nuck.modelo;
// Generated 23-jun-2017 1:38:17 by Hibernate Tools 4.3.1.Final


import java.util.Date;

/**
 * Ingreso generated by hbm2java
 */
public class Ingreso  implements java.io.Serializable {


     private Integer ingresoId;
     private Consumo consumo;
     private Miembro miembro;
     private Producto producto;
     private Servicio servicio;
     private Date ingresoFecha;

    public Ingreso() {
    }

	
    public Ingreso(Integer ingresoId) {
        this.ingresoId = ingresoId;
    }
    public Ingreso(Integer ingresoId, Consumo consumo, Miembro miembro, Producto producto, Servicio servicio, Date ingresoFecha) {
       this.ingresoId = ingresoId;
       this.consumo = consumo;
       this.miembro = miembro;
       this.producto = producto;
       this.servicio = servicio;
       this.ingresoFecha = ingresoFecha;
    }
   
    public Integer getIngresoId() {
        return this.ingresoId;
    }
    
    public void setIngresoId(Integer ingresoId) {
        this.ingresoId = ingresoId;
    }
    public Consumo getConsumo() {
        return this.consumo;
    }
    
    public void setConsumo(Consumo consumo) {
        this.consumo = consumo;
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
    public Date getIngresoFecha() {
        return this.ingresoFecha;
    }
    
    public void setIngresoFecha(Date ingresoFecha) {
        this.ingresoFecha = ingresoFecha;
    }




}


