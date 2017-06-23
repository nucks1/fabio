package com.nuck.modelo.control;

import com.nuck.modelo.Colaborador;
import com.nuck.modelo.dto.ColaboradorDTO;

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
public interface IColaboradorLogic {
    public List<Colaborador> getColaborador() throws Exception;

    /**
         * Save an new Colaborador entity
         */
    public void saveColaborador(Colaborador entity) throws Exception;

    /**
         * Delete an existing Colaborador entity
         *
         */
    public void deleteColaborador(Colaborador entity) throws Exception;

    /**
        * Update an existing Colaborador entity
        *
        */
    public void updateColaborador(Colaborador entity) throws Exception;

    /**
         * Load an existing Colaborador entity
         *
         */
    public Colaborador getColaborador(Integer colaboradorId)
        throws Exception;

    public List<Colaborador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Colaborador> findPageColaborador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberColaborador() throws Exception;

    public List<ColaboradorDTO> getDataColaborador() throws Exception;
}
