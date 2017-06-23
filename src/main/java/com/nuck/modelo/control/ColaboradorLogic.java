package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ColaboradorDTO;

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
@Service("ColaboradorLogic")
public class ColaboradorLogic implements IColaboradorLogic {
    private static final Logger log = LoggerFactory.getLogger(ColaboradorLogic.class);

    /**
     * DAO injected by Spring that manages Colaborador entities
     *
     */
    @Autowired
    private IColaboradorDAO colaboradorDAO;

    /**
    * DAO injected by Spring that manages ColaboradorServicio entities
    *
    */
    @Autowired
    private IColaboradorServicioDAO colaboradorServicioDAO;

    /**
    * DAO injected by Spring that manages Entrada entities
    *
    */
    @Autowired
    private IEntradaDAO entradaDAO;

    /**
    * DAO injected by Spring that manages Salida entities
    *
    */
    @Autowired
    private ISalidaDAO salidaDAO;

    /**
    * Logic injected by Spring that manages Usuario entities
    *
    */
    @Autowired
    IUsuarioLogic logicUsuario1;

    @Transactional(readOnly = true)
    public List<Colaborador> getColaborador() throws Exception {
        log.debug("finding all Colaborador instances");

        List<Colaborador> list = new ArrayList<Colaborador>();

        try {
            list = colaboradorDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Colaborador failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Colaborador");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveColaborador(Colaborador entity) throws Exception {
        log.debug("saving Colaborador instance");

        try {
            if (entity.getUsuario() == null) {
                throw new ZMessManager().new ForeignException("usuario");
            }

            if (entity.getColaboradorApellido() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorApellido");
            }

            if ((entity.getColaboradorApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorApellido");
            }

            if (entity.getColaboradorBarrio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorBarrio");
            }

            if ((entity.getColaboradorBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorBarrio(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorBarrio");
            }

            if ((entity.getColaboradorCorreoElctronico() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorCorreoElctronico(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorCorreoElctronico");
            }

            if (entity.getColaboradorDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorDireccion");
            }

            if ((entity.getColaboradorDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorDireccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorDireccion");
            }

            if (entity.getColaboradorId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorId");
            }

            if (entity.getColaboradorNombre() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorNombre");
            }

            if ((entity.getColaboradorNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNombre(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNombre");
            }

            if (entity.getColaboradorNumeroCelular() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorNumeroCelular");
            }

            if ((entity.getColaboradorNumeroCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNumeroCelular(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNumeroCelular");
            }

            if (entity.getColaboradorNumeroIdentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorNumeroIdentificacion");
            }

            if ((entity.getColaboradorNumeroIdentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNumeroIdentificacion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNumeroIdentificacion");
            }

            if ((entity.getColaboradorNumeroTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNumeroTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNumeroTelefono");
            }

            if (entity.getUsuario().getUsuarioId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "usuarioId_Usuario");
            }

            if (getColaborador(entity.getColaboradorId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            colaboradorDAO.save(entity);

            log.debug("save Colaborador successful");
        } catch (Exception e) {
            log.error("save Colaborador failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteColaborador(Colaborador entity) throws Exception {
        log.debug("deleting Colaborador instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Colaborador");
        }

        if (entity.getColaboradorId() == null) {
            throw new ZMessManager().new EmptyFieldException("colaboradorId");
        }

        List<ColaboradorServicio> colaboradorServicios = null;
        List<Entrada> entradas = null;
        List<Salida> salidas = null;

        try {
            colaboradorServicios = colaboradorServicioDAO.findByProperty("colaborador.colaboradorId",
                    entity.getColaboradorId());

            if (Utilities.validationsList(colaboradorServicios) == true) {
                throw new ZMessManager().new DeletingException(
                    "colaboradorServicios");
            }

            entradas = entradaDAO.findByProperty("colaborador.colaboradorId",
                    entity.getColaboradorId());

            if (Utilities.validationsList(entradas) == true) {
                throw new ZMessManager().new DeletingException("entradas");
            }

            salidas = salidaDAO.findByProperty("colaborador.colaboradorId",
                    entity.getColaboradorId());

            if (Utilities.validationsList(salidas) == true) {
                throw new ZMessManager().new DeletingException("salidas");
            }

            colaboradorDAO.delete(entity);

            log.debug("delete Colaborador successful");
        } catch (Exception e) {
            log.error("delete Colaborador failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateColaborador(Colaborador entity) throws Exception {
        log.debug("updating Colaborador instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Colaborador");
            }

            if (entity.getUsuario() == null) {
                throw new ZMessManager().new ForeignException("usuario");
            }

            if (entity.getColaboradorApellido() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorApellido");
            }

            if ((entity.getColaboradorApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorApellido");
            }

            if (entity.getColaboradorBarrio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorBarrio");
            }

            if ((entity.getColaboradorBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorBarrio(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorBarrio");
            }

            if ((entity.getColaboradorCorreoElctronico() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorCorreoElctronico(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorCorreoElctronico");
            }

            if (entity.getColaboradorDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorDireccion");
            }

            if ((entity.getColaboradorDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorDireccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorDireccion");
            }

            if (entity.getColaboradorId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorId");
            }

            if (entity.getColaboradorNombre() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorNombre");
            }

            if ((entity.getColaboradorNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNombre(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNombre");
            }

            if (entity.getColaboradorNumeroCelular() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorNumeroCelular");
            }

            if ((entity.getColaboradorNumeroCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNumeroCelular(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNumeroCelular");
            }

            if (entity.getColaboradorNumeroIdentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "colaboradorNumeroIdentificacion");
            }

            if ((entity.getColaboradorNumeroIdentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNumeroIdentificacion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNumeroIdentificacion");
            }

            if ((entity.getColaboradorNumeroTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getColaboradorNumeroTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "colaboradorNumeroTelefono");
            }

            if (entity.getUsuario().getUsuarioId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "usuarioId_Usuario");
            }

            colaboradorDAO.update(entity);

            log.debug("update Colaborador successful");
        } catch (Exception e) {
            log.error("update Colaborador failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ColaboradorDTO> getDataColaborador() throws Exception {
        try {
            List<Colaborador> colaborador = colaboradorDAO.findAll();

            List<ColaboradorDTO> colaboradorDTO = new ArrayList<ColaboradorDTO>();

            for (Colaborador colaboradorTmp : colaborador) {
                ColaboradorDTO colaboradorDTO2 = new ColaboradorDTO();

                colaboradorDTO2.setColaboradorId(colaboradorTmp.getColaboradorId());
                colaboradorDTO2.setColaboradorApellido((colaboradorTmp.getColaboradorApellido() != null)
                    ? colaboradorTmp.getColaboradorApellido() : null);
                colaboradorDTO2.setColaboradorBarrio((colaboradorTmp.getColaboradorBarrio() != null)
                    ? colaboradorTmp.getColaboradorBarrio() : null);
                colaboradorDTO2.setColaboradorCorreoElctronico((colaboradorTmp.getColaboradorCorreoElctronico() != null)
                    ? colaboradorTmp.getColaboradorCorreoElctronico() : null);
                colaboradorDTO2.setColaboradorDireccion((colaboradorTmp.getColaboradorDireccion() != null)
                    ? colaboradorTmp.getColaboradorDireccion() : null);
                colaboradorDTO2.setColaboradorFechaCreacion(colaboradorTmp.getColaboradorFechaCreacion());
                colaboradorDTO2.setColaboradorFechaModificacion(colaboradorTmp.getColaboradorFechaModificacion());
                colaboradorDTO2.setColaboradorFechaNacimiento(colaboradorTmp.getColaboradorFechaNacimiento());
                colaboradorDTO2.setColaboradorNombre((colaboradorTmp.getColaboradorNombre() != null)
                    ? colaboradorTmp.getColaboradorNombre() : null);
                colaboradorDTO2.setColaboradorNumeroCelular((colaboradorTmp.getColaboradorNumeroCelular() != null)
                    ? colaboradorTmp.getColaboradorNumeroCelular() : null);
                colaboradorDTO2.setColaboradorNumeroIdentificacion((colaboradorTmp.getColaboradorNumeroIdentificacion() != null)
                    ? colaboradorTmp.getColaboradorNumeroIdentificacion() : null);
                colaboradorDTO2.setColaboradorNumeroTelefono((colaboradorTmp.getColaboradorNumeroTelefono() != null)
                    ? colaboradorTmp.getColaboradorNumeroTelefono() : null);

                if (colaboradorTmp.getUsuario() != null) {
                    colaboradorDTO2.setUsuarioId_Usuario(colaboradorTmp.getUsuario()
                                                                       .getUsuarioId());
                } else {
                    colaboradorDTO2.setUsuarioId_Usuario(null);
                }

                colaboradorDTO.add(colaboradorDTO2);
            }

            return colaboradorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Colaborador getColaborador(Integer colaboradorId)
        throws Exception {
        log.debug("getting Colaborador instance");

        Colaborador entity = null;

        try {
            entity = colaboradorDAO.findById(colaboradorId);
        } catch (Exception e) {
            log.error("get Colaborador failed", e);
            throw new ZMessManager().new FindingException("Colaborador");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Colaborador> findPageColaborador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Colaborador> entity = null;

        try {
            entity = colaboradorDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Colaborador Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberColaborador() throws Exception {
        Long entity = null;

        try {
            entity = colaboradorDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Colaborador Count");
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
    public List<Colaborador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Colaborador> list = new ArrayList<Colaborador>();
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
            list = colaboradorDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
