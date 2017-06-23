package com.nuck.modelo.control;

import com.nuck.modelo.PgStatStatements;
import com.nuck.modelo.PgStatStatementsId;
import com.nuck.modelo.dto.PgStatStatementsDTO;

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
public interface IPgStatStatementsLogic {
    public List<PgStatStatements> getPgStatStatements()
        throws Exception;

    /**
         * Save an new PgStatStatements entity
         */
    public void savePgStatStatements(PgStatStatements entity)
        throws Exception;

    /**
         * Delete an existing PgStatStatements entity
         *
         */
    public void deletePgStatStatements(PgStatStatements entity)
        throws Exception;

    /**
        * Update an existing PgStatStatements entity
        *
        */
    public void updatePgStatStatements(PgStatStatements entity)
        throws Exception;

    /**
         * Load an existing PgStatStatements entity
         *
         */
    public PgStatStatements getPgStatStatements(PgStatStatementsId id)
        throws Exception;

    public List<PgStatStatements> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<PgStatStatements> findPagePgStatStatements(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPgStatStatements() throws Exception;

    public List<PgStatStatementsDTO> getDataPgStatStatements()
        throws Exception;
}
