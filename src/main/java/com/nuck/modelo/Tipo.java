package com.nuck.modelo;
// Generated 23-jun-2017 1:38:17 by Hibernate Tools 4.3.1.Final


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Tipo generated by hbm2java
 */
public class Tipo  implements java.io.Serializable {


     private Integer tipoId;
     private String tipoDescripcion;
     private String tipoClase;
     private String tipoRef;
     private Date tipoFechaCreacrion;
     private Date tipoFechaModificacion;
     private Set<ClaseTipo> claseTipos = new HashSet<ClaseTipo>(0);

    public Tipo() {
    }

	
    public Tipo(Integer tipoId) {
        this.tipoId = tipoId;
    }
    public Tipo(Integer tipoId, String tipoDescripcion, String tipoClase, String tipoRef, Date tipoFechaCreacrion, Date tipoFechaModificacion, Set<ClaseTipo> claseTipos) {
       this.tipoId = tipoId;
       this.tipoDescripcion = tipoDescripcion;
       this.tipoClase = tipoClase;
       this.tipoRef = tipoRef;
       this.tipoFechaCreacrion = tipoFechaCreacrion;
       this.tipoFechaModificacion = tipoFechaModificacion;
       this.claseTipos = claseTipos;
    }
   
    public Integer getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }
    public String getTipoDescripcion() {
        return this.tipoDescripcion;
    }
    
    public void setTipoDescripcion(String tipoDescripcion) {
        this.tipoDescripcion = tipoDescripcion;
    }
    public String getTipoClase() {
        return this.tipoClase;
    }
    
    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }
    public String getTipoRef() {
        return this.tipoRef;
    }
    
    public void setTipoRef(String tipoRef) {
        this.tipoRef = tipoRef;
    }
    public Date getTipoFechaCreacrion() {
        return this.tipoFechaCreacrion;
    }
    
    public void setTipoFechaCreacrion(Date tipoFechaCreacrion) {
        this.tipoFechaCreacrion = tipoFechaCreacrion;
    }
    public Date getTipoFechaModificacion() {
        return this.tipoFechaModificacion;
    }
    
    public void setTipoFechaModificacion(Date tipoFechaModificacion) {
        this.tipoFechaModificacion = tipoFechaModificacion;
    }
    public Set<ClaseTipo> getClaseTipos() {
        return this.claseTipos;
    }
    
    public void setClaseTipos(Set<ClaseTipo> claseTipos) {
        this.claseTipos = claseTipos;
    }




}

