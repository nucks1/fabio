package com.nuck.modelo.control;

import com.nuck.modelo.Consumo;
import com.nuck.modelo.dto.ConsumoDTO;

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
public interface IConsumoLogic {
    public List<Consumo> getConsumo() throws Exception;

    /**
         * Save an new Consumo entity
         */
    public void saveConsumo(Consumo entity) throws Exception;

    /**
         * Delete an existing Consumo entity
         *
         */
    public void deleteConsumo(Consumo entity) throws Exception;

    /**
        * Update an existing Consumo entity
        *
        */
    public void updateConsumo(Consumo entity) throws Exception;

    /**
         * Load an existing Consumo entity
         *
         */
    public Consumo getConsumo(Integer consumoId) throws Exception;

    public List<Consumo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Consumo> findPageConsumo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberConsumo() throws Exception;

    public List<ConsumoDTO> getDataConsumo() throws Exception;
}
