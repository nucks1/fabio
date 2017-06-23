package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.SalidaDTO;

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
@Service("SalidaLogic")
public class SalidaLogic implements ISalidaLogic {
    private static final Logger log = LoggerFactory.getLogger(SalidaLogic.class);

    /**
     * DAO injected by Spring that manages Salida entities
     *
     */
    @Autowired
    private ISalidaDAO salidaDAO;

    /**
    * Logic injected by Spring that manages Cliente entities
    *
    */
    @Autowired
    IClienteLogic logicCliente1;

    /**
    * Logic injected by Spring that manages Colaborador entities
    *
    */
    @Autowired
    IColaboradorLogic logicColaborador2;

    /**
    * Logic injected by Spring that manages Miembro entities
    *
    */
    @Autowired
    IMiembroLogic logicMiembro3;

    /**
    * Logic injected by Spring that manages Producto entities
    *
    */
    @Autowired
    IProductoLogic logicProducto4;

    /**
    * Logic injected by Spring that manages Servicio entities
    *
    */
    @Autowired
    IServicioLogic logicServicio5;

    @Transactional(readOnly = true)
    public List<Salida> getSalida() throws Exception {
        log.debug("finding all Salida instances");

        List<Salida> list = new ArrayList<Salida>();

        try {
            list = salidaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Salida failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Salida");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveSalida(Salida entity) throws Exception {
        log.debug("saving Salida instance");

        try {
            if (entity.getCliente() == null) {
                throw new ZMessManager().new ForeignException("cliente");
            }

            if (entity.getColaborador() == null) {
                throw new ZMessManager().new ForeignException("colaborador");
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

            if (entity.getSalidaId() == null) {
                throw new ZMessManager().new EmptyFieldException("salidaId");
            }

            if (entity.getCliente().getClienteId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteId_Cliente");
            }

            if (entity.getColaborador().getColaboradorId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorId_Colaborador");
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

            if (getSalida(entity.getSalidaId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            salidaDAO.save(entity);

            log.debug("save Salida successful");
        } catch (Exception e) {
            log.error("save Salida failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteSalida(Salida entity) throws Exception {
        log.debug("deleting Salida instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Salida");
        }

        if (entity.getSalidaId() == null) {
            throw new ZMessManager().new EmptyFieldException("salidaId");
        }

        try {
            salidaDAO.delete(entity);

            log.debug("delete Salida successful");
        } catch (Exception e) {
            log.error("delete Salida failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateSalida(Salida entity) throws Exception {
        log.debug("updating Salida instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Salida");
            }

            if (entity.getCliente() == null) {
                throw new ZMessManager().new ForeignException("cliente");
            }

            if (entity.getColaborador() == null) {
                throw new ZMessManager().new ForeignException("colaborador");
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

            if (entity.getSalidaId() == null) {
                throw new ZMessManager().new EmptyFieldException("salidaId");
            }

            if (entity.getCliente().getClienteId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteId_Cliente");
            }

            if (entity.getColaborador().getColaboradorId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorId_Colaborador");
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

            salidaDAO.update(entity);

            log.debug("update Salida successful");
        } catch (Exception e) {
            log.error("update Salida failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<SalidaDTO> getDataSalida() throws Exception {
        try {
            List<Salida> salida = salidaDAO.findAll();

            List<SalidaDTO> salidaDTO = new ArrayList<SalidaDTO>();

            for (Salida salidaTmp : salida) {
                SalidaDTO salidaDTO2 = new SalidaDTO();

                salidaDTO2.setSalidaId(salidaTmp.getSalidaId());
                salidaDTO2.setSalidaFechaCreacion(salidaTmp.getSalidaFechaCreacion());

                if (salidaTmp.getCliente() != null) {
                    salidaDTO2.setClienteId_Cliente(salidaTmp.getCliente()
                                                             .getClienteId());
                } else {
                    salidaDTO2.setClienteId_Cliente(null);
                }

                if (salidaTmp.getColaborador() != null) {
                    salidaDTO2.setColaboradorId_Colaborador(salidaTmp.getColaborador()
                                                                     .getColaboradorId());
                } else {
                    salidaDTO2.setColaboradorId_Colaborador(null);
                }

                if (salidaTmp.getMiembro() != null) {
                    salidaDTO2.setMiembroId_Miembro(salidaTmp.getMiembro()
                                                             .getMiembroId());
                } else {
                    salidaDTO2.setMiembroId_Miembro(null);
                }

                if (salidaTmp.getProducto() != null) {
                    salidaDTO2.setProductoId_Producto(salidaTmp.getProducto()
                                                               .getProductoId());
                } else {
                    salidaDTO2.setProductoId_Producto(null);
                }

                if (salidaTmp.getServicio() != null) {
                    salidaDTO2.setServicioId_Servicio(salidaTmp.getServicio()
                                                               .getServicioId());
                } else {
                    salidaDTO2.setServicioId_Servicio(null);
                }

                salidaDTO.add(salidaDTO2);
            }

            return salidaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Salida getSalida(Integer salidaId) throws Exception {
        log.debug("getting Salida instance");

        Salida entity = null;

        try {
            entity = salidaDAO.findById(salidaId);
        } catch (Exception e) {
            log.error("get Salida failed", e);
            throw new ZMessManager().new FindingException("Salida");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Salida> findPageSalida(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Salida> entity = null;

        try {
            entity = salidaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Salida Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberSalida() throws Exception {
        Long entity = null;

        try {
            entity = salidaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Salida Count");
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
    public List<Salida> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Salida> list = new ArrayList<Salida>();
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
            list = salidaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
