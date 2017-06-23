package com.nuck.modelo.control;

import com.nuck.modelo.Miembro;
import com.nuck.modelo.dto.MiembroDTO;

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
public interface IMiembroLogic {
    public List<Miembro> getMiembro() throws Exception;

    /**
         * Save an new Miembro entity
         */
    public void saveMiembro(Miembro entity) throws Exception;

    /**
         * Delete an existing Miembro entity
         *
         */
    public void deleteMiembro(Miembro entity) throws Exception;

    /**
        * Update an existing Miembro entity
        *
        */
    public void updateMiembro(Miembro entity) throws Exception;

    /**
         * Load an existing Miembro entity
         *
         */
    public Miembro getMiembro(Integer miembroId) throws Exception;

    public List<Miembro> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Miembro> findPageMiembro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMiembro() throws Exception;

    public List<MiembroDTO> getDataMiembro() throws Exception;
}
