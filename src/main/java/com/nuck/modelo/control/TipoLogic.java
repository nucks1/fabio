package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.TipoDTO;

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
@Service("TipoLogic")
public class TipoLogic implements ITipoLogic {
    private static final Logger log = LoggerFactory.getLogger(TipoLogic.class);

    /**
     * DAO injected by Spring that manages Tipo entities
     *
     */
    @Autowired
    private ITipoDAO tipoDAO;

    /**
    * DAO injected by Spring that manages ClaseTipo entities
    *
    */
    @Autowired
    private IClaseTipoDAO claseTipoDAO;

    @Transactional(readOnly = true)
    public List<Tipo> getTipo() throws Exception {
        log.debug("finding all Tipo instances");

        List<Tipo> list = new ArrayList<Tipo>();

        try {
            list = tipoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Tipo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Tipo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTipo(Tipo entity) throws Exception {
        log.debug("saving Tipo instance");

        try {
            if ((entity.getTipoClase() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoClase(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoClase");
            }

            if ((entity.getTipoDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoDescripcion(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoDescripcion");
            }

            if (entity.getTipoId() == null) {
                throw new ZMessManager().new EmptyFieldException("tipoId");
            }

            if ((entity.getTipoRef() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoRef(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("tipoRef");
            }

            if (getTipo(entity.getTipoId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            tipoDAO.save(entity);

            log.debug("save Tipo successful");
        } catch (Exception e) {
            log.error("save Tipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTipo(Tipo entity) throws Exception {
        log.debug("deleting Tipo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Tipo");
        }

        if (entity.getTipoId() == null) {
            throw new ZMessManager().new EmptyFieldException("tipoId");
        }

        List<ClaseTipo> claseTipos = null;

        try {
            claseTipos = claseTipoDAO.findByProperty("tipo.tipoId",
                    entity.getTipoId());

            if (Utilities.validationsList(claseTipos) == true) {
                throw new ZMessManager().new DeletingException("claseTipos");
            }

            tipoDAO.delete(entity);

            log.debug("delete Tipo successful");
        } catch (Exception e) {
            log.error("delete Tipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTipo(Tipo entity) throws Exception {
        log.debug("updating Tipo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Tipo");
            }

            if ((entity.getTipoClase() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoClase(), 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoClase");
            }

            if ((entity.getTipoDescripcion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoDescripcion(), 200) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "tipoDescripcion");
            }

            if (entity.getTipoId() == null) {
                throw new ZMessManager().new EmptyFieldException("tipoId");
            }

            if ((entity.getTipoRef() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getTipoRef(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException("tipoRef");
            }

            tipoDAO.update(entity);

            log.debug("update Tipo successful");
        } catch (Exception e) {
            log.error("update Tipo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TipoDTO> getDataTipo() throws Exception {
        try {
            List<Tipo> tipo = tipoDAO.findAll();

            List<TipoDTO> tipoDTO = new ArrayList<TipoDTO>();

            for (Tipo tipoTmp : tipo) {
                TipoDTO tipoDTO2 = new TipoDTO();

                tipoDTO2.setTipoId(tipoTmp.getTipoId());
                tipoDTO2.setTipoClase((tipoTmp.getTipoClase() != null)
                    ? tipoTmp.getTipoClase() : null);
                tipoDTO2.setTipoDescripcion((tipoTmp.getTipoDescripcion() != null)
                    ? tipoTmp.getTipoDescripcion() : null);
                tipoDTO2.setTipoFechaCreacrion(tipoTmp.getTipoFechaCreacrion());
                tipoDTO2.setTipoFechaModificacion(tipoTmp.getTipoFechaModificacion());
                tipoDTO2.setTipoRef((tipoTmp.getTipoRef() != null)
                    ? tipoTmp.getTipoRef() : null);
                tipoDTO.add(tipoDTO2);
            }

            return tipoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Tipo getTipo(Integer tipoId) throws Exception {
        log.debug("getting Tipo instance");

        Tipo entity = null;

        try {
            entity = tipoDAO.findById(tipoId);
        } catch (Exception e) {
            log.error("get Tipo failed", e);
            throw new ZMessManager().new FindingException("Tipo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Tipo> findPageTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Tipo> entity = null;

        try {
            entity = tipoDAO.findPage(sortColumnName, sortAscending, startRow,
                    maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Tipo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTipo() throws Exception {
        Long entity = null;

        try {
            entity = tipoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Tipo Count");
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
    public List<Tipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Tipo> list = new ArrayList<Tipo>();
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
            list = tipoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
