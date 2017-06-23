package com.nuck.modelo.control;

import com.nuck.modelo.Ingreso;
import com.nuck.modelo.dto.IngresoDTO;

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
public interface IIngresoLogic {
    public List<Ingreso> getIngreso() throws Exception;

    /**
         * Save an new Ingreso entity
         */
    public void saveIngreso(Ingreso entity) throws Exception;

    /**
         * Delete an existing Ingreso entity
         *
         */
    public void deleteIngreso(Ingreso entity) throws Exception;

    /**
        * Update an existing Ingreso entity
        *
        */
    public void updateIngreso(Ingreso entity) throws Exception;

    /**
         * Load an existing Ingreso entity
         *
         */
    public Ingreso getIngreso(Integer ingresoId) throws Exception;

    public List<Ingreso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Ingreso> findPageIngreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberIngreso() throws Exception;

    public List<IngresoDTO> getDataIngreso() throws Exception;
}
