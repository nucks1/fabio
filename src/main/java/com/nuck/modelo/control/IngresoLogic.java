package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.IngresoDTO;

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
@Service("IngresoLogic")
public class IngresoLogic implements IIngresoLogic {
    private static final Logger log = LoggerFactory.getLogger(IngresoLogic.class);

    /**
     * DAO injected by Spring that manages Ingreso entities
     *
     */
    @Autowired
    private IIngresoDAO ingresoDAO;

    /**
    * Logic injected by Spring that manages Consumo entities
    *
    */
    @Autowired
    IConsumoLogic logicConsumo1;

    /**
    * Logic injected by Spring that manages Miembro entities
    *
    */
    @Autowired
    IMiembroLogic logicMiembro2;

    /**
    * Logic injected by Spring that manages Producto entities
    *
    */
    @Autowired
    IProductoLogic logicProducto3;

    /**
    * Logic injected by Spring that manages Servicio entities
    *
    */
    @Autowired
    IServicioLogic logicServicio4;

    @Transactional(readOnly = true)
    public List<Ingreso> getIngreso() throws Exception {
        log.debug("finding all Ingreso instances");

        List<Ingreso> list = new ArrayList<Ingreso>();

        try {
            list = ingresoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Ingreso failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Ingreso");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveIngreso(Ingreso entity) throws Exception {
        log.debug("saving Ingreso instance");

        try {
            if (entity.getConsumo() == null) {
                throw new ZMessManager().new ForeignException("consumo");
            }

            if (entity.getMiembro() == null) {
                throw new ZMessManager().new ForeignException("miembro");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getServicio() == null) {
                throw new ZMessManager().new ForeignException("servicio");
            }

            if (entity.getIngresoId() == null) {
                throw new ZMessManager().new EmptyFieldException("ingresoId");
            }

            if (entity.getConsumo().getConsumoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "consumoId_Consumo");
            }

            if (entity.getMiembro().getMiembroId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroId_Miembro");
            }

            if (entity.getProducto().getProductoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "productoId_Producto");
            }

            if (entity.getServicio().getServicioId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "servicioId_Servicio");
            }

            if (getIngreso(entity.getIngresoId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            ingresoDAO.save(entity);

            log.debug("save Ingreso successful");
        } catch (Exception e) {
            log.error("save Ingreso failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteIngreso(Ingreso entity) throws Exception {
        log.debug("deleting Ingreso instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Ingreso");
        }

        if (entity.getIngresoId() == null) {
            throw new ZMessManager().new EmptyFieldException("ingresoId");
        }

        try {
            ingresoDAO.delete(entity);

            log.debug("delete Ingreso successful");
        } catch (Exception e) {
            log.error("delete Ingreso failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateIngreso(Ingreso entity) throws Exception {
        log.debug("updating Ingreso instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Ingreso");
            }

            if (entity.getConsumo() == null) {
                throw new ZMessManager().new ForeignException("consumo");
            }

            if (entity.getMiembro() == null) {
                throw new ZMessManager().new ForeignException("miembro");
            }

            if (entity.getProducto() == null) {
                throw new ZMessManager().new ForeignException("producto");
            }

            if (entity.getServicio() == null) {
                throw new ZMessManager().new ForeignException("servicio");
            }

            if (entity.getIngresoId() == null) {
                throw new ZMessManager().new EmptyFieldException("ingresoId");
            }

            if (entity.getConsumo().getConsumoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "consumoId_Consumo");
            }

            if (entity.getMiembro().getMiembroId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroId_Miembro");
            }

            if (entity.getProducto().getProductoId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "productoId_Producto");
            }

            if (entity.getServicio().getServicioId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "servicioId_Servicio");
            }

            ingresoDAO.update(entity);

            log.debug("update Ingreso successful");
        } catch (Exception e) {
            log.error("update Ingreso failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<IngresoDTO> getDataIngreso() throws Exception {
        try {
            List<Ingreso> ingreso = ingresoDAO.findAll();

            List<IngresoDTO> ingresoDTO = new ArrayList<IngresoDTO>();

            for (Ingreso ingresoTmp : ingreso) {
                IngresoDTO ingresoDTO2 = new IngresoDTO();

                ingresoDTO2.setIngresoId(ingresoTmp.getIngresoId());
                ingresoDTO2.setIngresoFecha(ingresoTmp.getIngresoFecha());

                if (ingresoTmp.getConsumo() != null) {
                    ingresoDTO2.setConsumoId_Consumo(ingresoTmp.getConsumo()
                                                               .getConsumoId());
                } else {
                    ingresoDTO2.setConsumoId_Consumo(null);
                }

                if (ingresoTmp.getMiembro() != null) {
                    ingresoDTO2.setMiembroId_Miembro(ingresoTmp.getMiembro()
                                                               .getMiembroId());
                } else {
                    ingresoDTO2.setMiembroId_Miembro(null);
                }

                if (ingresoTmp.getProducto() != null) {
                    ingresoDTO2.setProductoId_Producto(ingresoTmp.getProducto()
                                                                 .getProductoId());
                } else {
                    ingresoDTO2.setProductoId_Producto(null);
                }

                if (ingresoTmp.getServicio() != null) {
                    ingresoDTO2.setServicioId_Servicio(ingresoTmp.getServicio()
                                                                 .getServicioId());
                } else {
                    ingresoDTO2.setServicioId_Servicio(null);
                }

                ingresoDTO.add(ingresoDTO2);
            }

            return ingresoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Ingreso getIngreso(Integer ingresoId) throws Exception {
        log.debug("getting Ingreso instance");

        Ingreso entity = null;

        try {
            entity = ingresoDAO.findById(ingresoId);
        } catch (Exception e) {
            log.error("get Ingreso failed", e);
            throw new ZMessManager().new FindingException("Ingreso");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Ingreso> findPageIngreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Ingreso> entity = null;

        try {
            entity = ingresoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Ingreso Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberIngreso() throws Exception {
        Long entity = null;

        try {
            entity = ingresoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Ingreso Count");
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
    public List<Ingreso> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Ingreso> list = new ArrayList<Ingreso>();
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
            list = ingresoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
