package com.nuck.modelo.control;

import com.nuck.modelo.Salida;
import com.nuck.modelo.dto.SalidaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface ISalidaLogic {
    public List<Salida> getSalida() throws Exception;

    /**
         * Save an new Salida entity
         */
    public void saveSalida(Salida entity) throws Exception;

    /**
         * Delete an existing Salida entity
         *
         */
    public void deleteSalida(Salida entity) throws Exception;

    /**
        * Update an existing Salida entity
        *
        */
    public void updateSalida(Salida entity) throws Exception;

    /**
         * Load an existing Salida entity
         *
         */
    public Salida getSalida(Integer salidaId) throws Exception;

    public List<Salida> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Salida> findPageSalida(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSalida() throws Exception;

    public List<SalidaDTO> getDataSalida() throws Exception;
}
