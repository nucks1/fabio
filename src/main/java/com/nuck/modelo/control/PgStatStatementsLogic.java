package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.PgStatStatementsDTO;

import com.nuck.utilities.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("PgStatStatementsLogic")
public class PgStatStatementsLogic implements IPgStatStatementsLogic {
    private static final Logger log = LoggerFactory.getLogger(PgStatStatementsLogic.class);

    /**
     * DAO injected by Spring that manages PgStatStatements entities
     *
     */
    @Autowired
    private IPgStatStatementsDAO pgStatStatementsDAO;

    @Transactional(readOnly = true)
    public List<PgStatStatements> getPgStatStatements()
        throws Exception {
        log.debug("finding all PgStatStatements instances");

        List<PgStatStatements> list = new ArrayList<PgStatStatements>();

        try {
            list = pgStatStatementsDAO.findAll();
        } catch (Exception e) {
            log.error("finding all PgStatStatements failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "PgStatStatements");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePgStatStatements(PgStatStatements entity)
        throws Exception {
        log.debug("saving PgStatStatements instance");

        try {
            if (entity.getId().getUserid() == null) {
                throw new ZMessManager().new EmptyFieldException("userid");
            }

            if ((entity.getId().getUserid() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getUserid(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("userid");
            }

            if (entity.getId().getDbid() == null) {
                throw new ZMessManager().new EmptyFieldException("dbid");
            }

            if ((entity.getId().getDbid() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getDbid(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("dbid");
            }

            if (entity.getId().getQueryid() == null) {
                throw new ZMessManager().new EmptyFieldException("queryid");
            }

            if ((entity.getId().getQueryid() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getQueryid(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("queryid");
            }

            if (entity.getId().getQuery() == null) {
                throw new ZMessManager().new EmptyFieldException("query");
            }

            if ((entity.getId().getQuery() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getId().getQuery(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException("query");
            }

            if (entity.getId().getCalls() == null) {
                throw new ZMessManager().new EmptyFieldException("calls");
            }

            if ((entity.getId().getCalls() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getCalls(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("calls");
            }

            if (entity.getId().getTotalTime() == null) {
                throw new ZMessManager().new EmptyFieldException("totalTime");
            }

            if ((entity.getId().getTotalTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getTotalTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "totalTime");
            }

            if (entity.getId().getMinTime() == null) {
                throw new ZMessManager().new EmptyFieldException("minTime");
            }

            if ((entity.getId().getMinTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getMinTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException("minTime");
            }

            if (entity.getId().getMaxTime() == null) {
                throw new ZMessManager().new EmptyFieldException("maxTime");
            }

            if ((entity.getId().getMaxTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getMaxTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException("maxTime");
            }

            if (entity.getId().getMeanTime() == null) {
                throw new ZMessManager().new EmptyFieldException("meanTime");
            }

            if ((entity.getId().getMeanTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getMeanTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException("meanTime");
            }

            if (entity.getId().getStddevTime() == null) {
                throw new ZMessManager().new EmptyFieldException("stddevTime");
            }

            if ((entity.getId().getStddevTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getStddevTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "stddevTime");
            }

            if (entity.getId().getRows() == null) {
                throw new ZMessManager().new EmptyFieldException("rows");
            }

            if ((entity.getId().getRows() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getRows(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("rows");
            }

            if (entity.getId().getSharedBlksHit() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksHit");
            }

            if ((entity.getId().getSharedBlksHit() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksHit(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksHit");
            }

            if (entity.getId().getSharedBlksRead() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksRead");
            }

            if ((entity.getId().getSharedBlksRead() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksRead(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksRead");
            }

            if (entity.getId().getSharedBlksDirtied() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksDirtied");
            }

            if ((entity.getId().getSharedBlksDirtied() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksDirtied(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksDirtied");
            }

            if (entity.getId().getSharedBlksWritten() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksWritten");
            }

            if ((entity.getId().getSharedBlksWritten() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksWritten(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksWritten");
            }

            if (entity.getId().getLocalBlksHit() == null) {
                throw new ZMessManager().new EmptyFieldException("localBlksHit");
            }

            if ((entity.getId().getLocalBlksHit() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksHit(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksHit");
            }

            if (entity.getId().getLocalBlksRead() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "localBlksRead");
            }

            if ((entity.getId().getLocalBlksRead() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksRead(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksRead");
            }

            if (entity.getId().getLocalBlksDirtied() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "localBlksDirtied");
            }

            if ((entity.getId().getLocalBlksDirtied() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksDirtied(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksDirtied");
            }

            if (entity.getId().getLocalBlksWritten() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "localBlksWritten");
            }

            if ((entity.getId().getLocalBlksWritten() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksWritten(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksWritten");
            }

            if (entity.getId().getTempBlksRead() == null) {
                throw new ZMessManager().new EmptyFieldException("tempBlksRead");
            }

            if ((entity.getId().getTempBlksRead() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getTempBlksRead(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tempBlksRead");
            }

            if (entity.getId().getTempBlksWritten() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "tempBlksWritten");
            }

            if ((entity.getId().getTempBlksWritten() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getTempBlksWritten(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tempBlksWritten");
            }

            if (entity.getId().getBlkReadTime() == null) {
                throw new ZMessManager().new EmptyFieldException("blkReadTime");
            }

            if ((entity.getId().getBlkReadTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getBlkReadTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "blkReadTime");
            }

            if (entity.getId().getBlkWriteTime() == null) {
                throw new ZMessManager().new EmptyFieldException("blkWriteTime");
            }

            if ((entity.getId().getBlkWriteTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getBlkWriteTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "blkWriteTime");
            }

            if (getPgStatStatements(entity.getId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            pgStatStatementsDAO.save(entity);

            log.debug("save PgStatStatements successful");
        } catch (Exception e) {
            log.error("save PgStatStatements failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePgStatStatements(PgStatStatements entity)
        throws Exception {
        log.debug("deleting PgStatStatements instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("PgStatStatements");
        }

        if (entity.getId().getUserid() == null) {
            throw new ZMessManager().new EmptyFieldException("userid");
        }

        if (entity.getId().getDbid() == null) {
            throw new ZMessManager().new EmptyFieldException("dbid");
        }

        if (entity.getId().getQueryid() == null) {
            throw new ZMessManager().new EmptyFieldException("queryid");
        }

        if (entity.getId().getQuery() == null) {
            throw new ZMessManager().new EmptyFieldException("query");
        }

        if (entity.getId().getCalls() == null) {
            throw new ZMessManager().new EmptyFieldException("calls");
        }

        if (entity.getId().getTotalTime() == null) {
            throw new ZMessManager().new EmptyFieldException("totalTime");
        }

        if (entity.getId().getMinTime() == null) {
            throw new ZMessManager().new EmptyFieldException("minTime");
        }

        if (entity.getId().getMaxTime() == null) {
            throw new ZMessManager().new EmptyFieldException("maxTime");
        }

        if (entity.getId().getMeanTime() == null) {
            throw new ZMessManager().new EmptyFieldException("meanTime");
        }

        if (entity.getId().getStddevTime() == null) {
            throw new ZMessManager().new EmptyFieldException("stddevTime");
        }

        if (entity.getId().getRows() == null) {
            throw new ZMessManager().new EmptyFieldException("rows");
        }

        if (entity.getId().getSharedBlksHit() == null) {
            throw new ZMessManager().new EmptyFieldException("sharedBlksHit");
        }

        if (entity.getId().getSharedBlksRead() == null) {
            throw new ZMessManager().new EmptyFieldException("sharedBlksRead");
        }

        if (entity.getId().getSharedBlksDirtied() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "sharedBlksDirtied");
        }

        if (entity.getId().getSharedBlksWritten() == null) {
            throw new ZMessManager().new EmptyFieldException(
                "sharedBlksWritten");
        }

        if (entity.getId().getLocalBlksHit() == null) {
            throw new ZMessManager().new EmptyFieldException("localBlksHit");
        }

        if (entity.getId().getLocalBlksRead() == null) {
            throw new ZMessManager().new EmptyFieldException("localBlksRead");
        }

        if (entity.getId().getLocalBlksDirtied() == null) {
            throw new ZMessManager().new EmptyFieldException("localBlksDirtied");
        }

        if (entity.getId().getLocalBlksWritten() == null) {
            throw new ZMessManager().new EmptyFieldException("localBlksWritten");
        }

        if (entity.getId().getTempBlksRead() == null) {
            throw new ZMessManager().new EmptyFieldException("tempBlksRead");
        }

        if (entity.getId().getTempBlksWritten() == null) {
            throw new ZMessManager().new EmptyFieldException("tempBlksWritten");
        }

        if (entity.getId().getBlkReadTime() == null) {
            throw new ZMessManager().new EmptyFieldException("blkReadTime");
        }

        if (entity.getId().getBlkWriteTime() == null) {
            throw new ZMessManager().new EmptyFieldException("blkWriteTime");
        }

        try {
            pgStatStatementsDAO.delete(entity);

            log.debug("delete PgStatStatements successful");
        } catch (Exception e) {
            log.error("delete PgStatStatements failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePgStatStatements(PgStatStatements entity)
        throws Exception {
        log.debug("updating PgStatStatements instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "PgStatStatements");
            }

            if (entity.getId().getUserid() == null) {
                throw new ZMessManager().new EmptyFieldException("userid");
            }

            if ((entity.getId().getUserid() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getUserid(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("userid");
            }

            if (entity.getId().getDbid() == null) {
                throw new ZMessManager().new EmptyFieldException("dbid");
            }

            if ((entity.getId().getDbid() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getDbid(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("dbid");
            }

            if (entity.getId().getQueryid() == null) {
                throw new ZMessManager().new EmptyFieldException("queryid");
            }

            if ((entity.getId().getQueryid() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getQueryid(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("queryid");
            }

            if (entity.getId().getQuery() == null) {
                throw new ZMessManager().new EmptyFieldException("query");
            }

            if ((entity.getId().getQuery() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getId().getQuery(), 255) == false)) {
                throw new ZMessManager().new NotValidFormatException("query");
            }

            if (entity.getId().getCalls() == null) {
                throw new ZMessManager().new EmptyFieldException("calls");
            }

            if ((entity.getId().getCalls() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getCalls(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("calls");
            }

            if (entity.getId().getTotalTime() == null) {
                throw new ZMessManager().new EmptyFieldException("totalTime");
            }

            if ((entity.getId().getTotalTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getTotalTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "totalTime");
            }

            if (entity.getId().getMinTime() == null) {
                throw new ZMessManager().new EmptyFieldException("minTime");
            }

            if ((entity.getId().getMinTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getMinTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException("minTime");
            }

            if (entity.getId().getMaxTime() == null) {
                throw new ZMessManager().new EmptyFieldException("maxTime");
            }

            if ((entity.getId().getMaxTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getMaxTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException("maxTime");
            }

            if (entity.getId().getMeanTime() == null) {
                throw new ZMessManager().new EmptyFieldException("meanTime");
            }

            if ((entity.getId().getMeanTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getMeanTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException("meanTime");
            }

            if (entity.getId().getStddevTime() == null) {
                throw new ZMessManager().new EmptyFieldException("stddevTime");
            }

            if ((entity.getId().getStddevTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getStddevTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "stddevTime");
            }

            if (entity.getId().getRows() == null) {
                throw new ZMessManager().new EmptyFieldException("rows");
            }

            if ((entity.getId().getRows() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getRows(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("rows");
            }

            if (entity.getId().getSharedBlksHit() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksHit");
            }

            if ((entity.getId().getSharedBlksHit() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksHit(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksHit");
            }

            if (entity.getId().getSharedBlksRead() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksRead");
            }

            if ((entity.getId().getSharedBlksRead() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksRead(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksRead");
            }

            if (entity.getId().getSharedBlksDirtied() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksDirtied");
            }

            if ((entity.getId().getSharedBlksDirtied() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksDirtied(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksDirtied");
            }

            if (entity.getId().getSharedBlksWritten() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "sharedBlksWritten");
            }

            if ((entity.getId().getSharedBlksWritten() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getSharedBlksWritten(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "sharedBlksWritten");
            }

            if (entity.getId().getLocalBlksHit() == null) {
                throw new ZMessManager().new EmptyFieldException("localBlksHit");
            }

            if ((entity.getId().getLocalBlksHit() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksHit(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksHit");
            }

            if (entity.getId().getLocalBlksRead() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "localBlksRead");
            }

            if ((entity.getId().getLocalBlksRead() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksRead(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksRead");
            }

            if (entity.getId().getLocalBlksDirtied() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "localBlksDirtied");
            }

            if ((entity.getId().getLocalBlksDirtied() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksDirtied(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksDirtied");
            }

            if (entity.getId().getLocalBlksWritten() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "localBlksWritten");
            }

            if ((entity.getId().getLocalBlksWritten() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getLocalBlksWritten(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "localBlksWritten");
            }

            if (entity.getId().getTempBlksRead() == null) {
                throw new ZMessManager().new EmptyFieldException("tempBlksRead");
            }

            if ((entity.getId().getTempBlksRead() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getTempBlksRead(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tempBlksRead");
            }

            if (entity.getId().getTempBlksWritten() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "tempBlksWritten");
            }

            if ((entity.getId().getTempBlksWritten() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getTempBlksWritten(), 0, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tempBlksWritten");
            }

            if (entity.getId().getBlkReadTime() == null) {
                throw new ZMessManager().new EmptyFieldException("blkReadTime");
            }

            if ((entity.getId().getBlkReadTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getBlkReadTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "blkReadTime");
            }

            if (entity.getId().getBlkWriteTime() == null) {
                throw new ZMessManager().new EmptyFieldException("blkWriteTime");
            }

            if ((entity.getId().getBlkWriteTime() != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        entity.getId().getBlkWriteTime(), 17, 17) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "blkWriteTime");
            }

            pgStatStatementsDAO.update(entity);

            log.debug("update PgStatStatements successful");
        } catch (Exception e) {
            log.error("update PgStatStatements failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PgStatStatementsDTO> getDataPgStatStatements()
        throws Exception {
        try {
            List<PgStatStatements> pgStatStatements = pgStatStatementsDAO.findAll();

            List<PgStatStatementsDTO> pgStatStatementsDTO = new ArrayList<PgStatStatementsDTO>();

            for (PgStatStatements pgStatStatementsTmp : pgStatStatements) {
                PgStatStatementsDTO pgStatStatementsDTO2 = new PgStatStatementsDTO();

                pgStatStatementsDTO2.setUserid(pgStatStatementsTmp.getId()
                                                                  .getUserid());
                pgStatStatementsDTO2.setDbid(pgStatStatementsTmp.getId()
                                                                .getDbid());
                pgStatStatementsDTO2.setQueryid(pgStatStatementsTmp.getId()
                                                                   .getQueryid());
                pgStatStatementsDTO2.setQuery(pgStatStatementsTmp.getId()
                                                                 .getQuery());
                pgStatStatementsDTO2.setCalls(pgStatStatementsTmp.getId()
                                                                 .getCalls());
                pgStatStatementsDTO2.setTotalTime(pgStatStatementsTmp.getId()
                                                                     .getTotalTime());
                pgStatStatementsDTO2.setMinTime(pgStatStatementsTmp.getId()
                                                                   .getMinTime());
                pgStatStatementsDTO2.setMaxTime(pgStatStatementsTmp.getId()
                                                                   .getMaxTime());
                pgStatStatementsDTO2.setMeanTime(pgStatStatementsTmp.getId()
                                                                    .getMeanTime());
                pgStatStatementsDTO2.setStddevTime(pgStatStatementsTmp.getId()
                                                                      .getStddevTime());
                pgStatStatementsDTO2.setRows(pgStatStatementsTmp.getId()
                                                                .getRows());
                pgStatStatementsDTO2.setSharedBlksHit(pgStatStatementsTmp.getId()
                                                                         .getSharedBlksHit());
                pgStatStatementsDTO2.setSharedBlksRead(pgStatStatementsTmp.getId()
                                                                          .getSharedBlksRead());
                pgStatStatementsDTO2.setSharedBlksDirtied(pgStatStatementsTmp.getId()
                                                                             .getSharedBlksDirtied());
                pgStatStatementsDTO2.setSharedBlksWritten(pgStatStatementsTmp.getId()
                                                                             .getSharedBlksWritten());
                pgStatStatementsDTO2.setLocalBlksHit(pgStatStatementsTmp.getId()
                                                                        .getLocalBlksHit());
                pgStatStatementsDTO2.setLocalBlksRead(pgStatStatementsTmp.getId()
                                                                         .getLocalBlksRead());
                pgStatStatementsDTO2.setLocalBlksDirtied(pgStatStatementsTmp.getId()
                                                                            .getLocalBlksDirtied());
                pgStatStatementsDTO2.setLocalBlksWritten(pgStatStatementsTmp.getId()
                                                                            .getLocalBlksWritten());
                pgStatStatementsDTO2.setTempBlksRead(pgStatStatementsTmp.getId()
                                                                        .getTempBlksRead());
                pgStatStatementsDTO2.setTempBlksWritten(pgStatStatementsTmp.getId()
                                                                           .getTempBlksWritten());
                pgStatStatementsDTO2.setBlkReadTime(pgStatStatementsTmp.getId()
                                                                       .getBlkReadTime());
                pgStatStatementsDTO2.setBlkWriteTime(pgStatStatementsTmp.getId()
                                                                        .getBlkWriteTime());
                pgStatStatementsDTO.add(pgStatStatementsDTO2);
            }

            return pgStatStatementsDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public PgStatStatements getPgStatStatements(PgStatStatementsId id)
        throws Exception {
        log.debug("getting PgStatStatements instance");

        PgStatStatements entity = null;

        try {
            entity = pgStatStatementsDAO.findById(id);
        } catch (Exception e) {
            log.error("get PgStatStatements failed", e);
            throw new ZMessManager().new FindingException("PgStatStatements");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<PgStatStatements> findPagePgStatStatements(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<PgStatStatements> entity = null;

        try {
            entity = pgStatStatementsDAO.findPage(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PgStatStatements Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPgStatStatements() throws Exception {
        Long entity = null;

        try {
            entity = pgStatStatementsDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "PgStatStatements Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<PgStatStatements> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<PgStatStatements> list = new ArrayList<PgStatStatements>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = pgStatStatementsDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
