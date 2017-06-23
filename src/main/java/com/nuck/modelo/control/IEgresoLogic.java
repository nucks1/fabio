package com.nuck.modelo.control;

import com.nuck.modelo.Egreso;
import com.nuck.modelo.dto.EgresoDTO;

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
public interface IEgresoLogic {
    public List<Egreso> getEgreso() throws Exception;

    /**
         * Save an new Egreso entity
         */
    public void saveEgreso(Egreso entity) throws Exception;

    /**
         * Delete an existing Egreso entity
         *
         */
    public void deleteEgreso(Egreso entity) throws Exception;

    /**
        * Update an existing Egreso entity
        *
        */
    public void updateEgreso(Egreso entity) throws Exception;

    /**
         * Load an existing Egreso entity
         *
         */
    public Egreso getEgreso(Integer egresoId) throws Exception;

    public List<Egreso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Egreso> findPageEgreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEgreso() throws Exception;

    public List<EgresoDTO> getDataEgreso() throws Exception;
}
