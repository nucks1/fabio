package com.nuck.modelo.control;

import com.nuck.modelo.ClaseTipo;
import com.nuck.modelo.dto.ClaseTipoDTO;

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
public interface IClaseTipoLogic {
    public List<ClaseTipo> getClaseTipo() throws Exception;

    /**
         * Save an new ClaseTipo entity
         */
    public void saveClaseTipo(ClaseTipo entity) throws Exception;

    /**
         * Delete an existing ClaseTipo entity
         *
         */
    public void deleteClaseTipo(ClaseTipo entity) throws Exception;

    /**
        * Update an existing ClaseTipo entity
        *
        */
    public void updateClaseTipo(ClaseTipo entity) throws Exception;

    /**
         * Load an existing ClaseTipo entity
         *
         */
    public ClaseTipo getClaseTipo(Integer claseTipoId)
        throws Exception;

    public List<ClaseTipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ClaseTipo> findPageClaseTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberClaseTipo() throws Exception;

    public List<ClaseTipoDTO> getDataClaseTipo() throws Exception;
}
