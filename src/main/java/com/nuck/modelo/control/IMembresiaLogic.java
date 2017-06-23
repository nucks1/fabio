package com.nuck.modelo.control;

import com.nuck.modelo.Membresia;
import com.nuck.modelo.dto.MembresiaDTO;

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
public interface IMembresiaLogic {
    public List<Membresia> getMembresia() throws Exception;

    /**
         * Save an new Membresia entity
         */
    public void saveMembresia(Membresia entity) throws Exception;

    /**
         * Delete an existing Membresia entity
         *
         */
    public void deleteMembresia(Membresia entity) throws Exception;

    /**
        * Update an existing Membresia entity
        *
        */
    public void updateMembresia(Membresia entity) throws Exception;

    /**
         * Load an existing Membresia entity
         *
         */
    public Membresia getMembresia(Integer membresiaId)
        throws Exception;

    public List<Membresia> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Membresia> findPageMembresia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMembresia() throws Exception;

    public List<MembresiaDTO> getDataMembresia() throws Exception;
}
