package com.nuck.modelo.control;

import com.nuck.modelo.ColaboradorServicio;
import com.nuck.modelo.ColaboradorServicioId;
import com.nuck.modelo.dto.ColaboradorServicioDTO;

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
public interface IColaboradorServicioLogic {
    public List<ColaboradorServicio> getColaboradorServicio()
        throws Exception;

    /**
         * Save an new ColaboradorServicio entity
         */
    public void saveColaboradorServicio(ColaboradorServicio entity)
        throws Exception;

    /**
         * Delete an existing ColaboradorServicio entity
         *
         */
    public void deleteColaboradorServicio(ColaboradorServicio entity)
        throws Exception;

    /**
        * Update an existing ColaboradorServicio entity
        *
        */
    public void updateColaboradorServicio(ColaboradorServicio entity)
        throws Exception;

    /**
         * Load an existing ColaboradorServicio entity
         *
         */
    public ColaboradorServicio getColaboradorServicio(ColaboradorServicioId id)
        throws Exception;

    public List<ColaboradorServicio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ColaboradorServicio> findPageColaboradorServicio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberColaboradorServicio() throws Exception;

    public List<ColaboradorServicioDTO> getDataColaboradorServicio()
        throws Exception;
}
