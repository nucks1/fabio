package com.nuck.modelo;
// Generated 23-jun-2017 1:38:17 by Hibernate Tools 4.3.1.Final



/**
 * ColaboradorServicioId generated by hbm2java
 */
public class ColaboradorServicioId  implements java.io.Serializable {


     private Integer colaboradorId;
     private Integer servicioId;

    public ColaboradorServicioId() {
    }

    public ColaboradorServicioId(Integer colaboradorId, Integer servicioId) {
       this.colaboradorId = colaboradorId;
       this.servicioId = servicioId;
    }
   
    public Integer getColaboradorId() {
        return this.colaboradorId;
    }
    
    public void setColaboradorId(Integer colaboradorId) {
        this.colaboradorId = colaboradorId;
    }
    public Integer getServicioId() {
        return this.servicioId;
    }
    
    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ColaboradorServicioId) ) return false;
		 ColaboradorServicioId castOther = ( ColaboradorServicioId ) other; 
         
		 return ( (this.getColaboradorId()==castOther.getColaboradorId()) || ( this.getColaboradorId()!=null && castOther.getColaboradorId()!=null && this.getColaboradorId().equals(castOther.getColaboradorId()) ) )
 && ( (this.getServicioId()==castOther.getServicioId()) || ( this.getServicioId()!=null && castOther.getServicioId()!=null && this.getServicioId().equals(castOther.getServicioId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getColaboradorId() == null ? 0 : this.getColaboradorId().hashCode() );
         result = 37 * result + ( getServicioId() == null ? 0 : this.getServicioId().hashCode() );
         return result;
   }   


}

