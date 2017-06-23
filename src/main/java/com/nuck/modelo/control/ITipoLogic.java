package com.nuck.modelo.control;

import com.nuck.modelo.Tipo;
import com.nuck.modelo.dto.TipoDTO;

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
public interface ITipoLogic {
    public List<Tipo> getTipo() throws Exception;

    /**
         * Save an new Tipo entity
         */
    public void saveTipo(Tipo entity) throws Exception;

    /**
         * Delete an existing Tipo entity
         *
         */
    public void deleteTipo(Tipo entity) throws Exception;

    /**
        * Update an existing Tipo entity
        *
        */
    public void updateTipo(Tipo entity) throws Exception;

    /**
         * Load an existing Tipo entity
         *
         */
    public Tipo getTipo(Integer tipoId) throws Exception;

    public List<Tipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipo> findPageTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipo() throws Exception;

    public List<TipoDTO> getDataTipo() throws Exception;
}
