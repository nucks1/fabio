package com.nuck.modelo.control;

import com.nuck.modelo.Entrada;
import com.nuck.modelo.dto.EntradaDTO;

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
public interface IEntradaLogic {
    public List<Entrada> getEntrada() throws Exception;

    /**
         * Save an new Entrada entity
         */
    public void saveEntrada(Entrada entity) throws Exception;

    /**
         * Delete an existing Entrada entity
         *
         */
    public void deleteEntrada(Entrada entity) throws Exception;

    /**
        * Update an existing Entrada entity
        *
        */
    public void updateEntrada(Entrada entity) throws Exception;

    /**
         * Load an existing Entrada entity
         *
         */
    public Entrada getEntrada(Integer entradaId) throws Exception;

    public List<Entrada> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Entrada> findPageEntrada(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEntrada() throws Exception;

    public List<EntradaDTO> getDataEntrada() throws Exception;
}
