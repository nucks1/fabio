package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ClienteDTO;

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
@Service("ClienteLogic")
public class ClienteLogic implements IClienteLogic {
    private static final Logger log = LoggerFactory.getLogger(ClienteLogic.class);

    /**
     * DAO injected by Spring that manages Cliente entities
     *
     */
    @Autowired
    private IClienteDAO clienteDAO;

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

    @Transactional(readOnly = true)
    public List<Cliente> getCliente() throws Exception {
        log.debug("finding all Cliente instances");

        List<Cliente> list = new ArrayList<Cliente>();

        try {
            list = clienteDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Cliente failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Cliente");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveCliente(Cliente entity) throws Exception {
        log.debug("saving Cliente instance");

        try {
            if (entity.getClienteApellido() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteApellido");
            }

            if ((entity.getClienteApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteApellido");
            }

            if (entity.getClienteBarrio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteBarrio");
            }

            if ((entity.getClienteBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteBarrio(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteBarrio");
            }

            if ((entity.getClienteCorreoElctronico() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteCorreoElctronico(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteCorreoElctronico");
            }

            if (entity.getClienteDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteDireccion");
            }

            if ((entity.getClienteDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteDireccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteDireccion");
            }

            if (entity.getClienteId() == null) {
                throw new ZMessManager().new EmptyFieldException("clienteId");
            }

            if (entity.getClienteNombre() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteNombre");
            }

            if ((entity.getClienteNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNombre(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNombre");
            }

            if (entity.getClienteNumeroCelular() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteNumeroCelular");
            }

            if ((entity.getClienteNumeroCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNumeroCelular(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNumeroCelular");
            }

            if (entity.getClienteNumeroIdentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteNumeroIdentificacion");
            }

            if ((entity.getClienteNumeroIdentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNumeroIdentificacion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNumeroIdentificacion");
            }

            if ((entity.getClienteNumeroTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNumeroTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNumeroTelefono");
            }

            if (getCliente(entity.getClienteId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            clienteDAO.save(entity);

            log.debug("save Cliente successful");
        } catch (Exception e) {
            log.error("save Cliente failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteCliente(Cliente entity) throws Exception {
        log.debug("deleting Cliente instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Cliente");
        }

        if (entity.getClienteId() == null) {
            throw new ZMessManager().new EmptyFieldException("clienteId");
        }

        List<Entrada> entradas = null;
        List<Salida> salidas = null;

        try {
            entradas = entradaDAO.findByProperty("cliente.clienteId",
                    entity.getClienteId());

            if (Utilities.validationsList(entradas) == true) {
                throw new ZMessManager().new DeletingException("entradas");
            }

            salidas = salidaDAO.findByProperty("cliente.clienteId",
                    entity.getClienteId());

            if (Utilities.validationsList(salidas) == true) {
                throw new ZMessManager().new DeletingException("salidas");
            }

            clienteDAO.delete(entity);

            log.debug("delete Cliente successful");
        } catch (Exception e) {
            log.error("delete Cliente failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateCliente(Cliente entity) throws Exception {
        log.debug("updating Cliente instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Cliente");
            }

            if (entity.getClienteApellido() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteApellido");
            }

            if ((entity.getClienteApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteApellido");
            }

            if (entity.getClienteBarrio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteBarrio");
            }

            if ((entity.getClienteBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteBarrio(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteBarrio");
            }

            if ((entity.getClienteCorreoElctronico() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteCorreoElctronico(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteCorreoElctronico");
            }

            if (entity.getClienteDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteDireccion");
            }

            if ((entity.getClienteDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteDireccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteDireccion");
            }

            if (entity.getClienteId() == null) {
                throw new ZMessManager().new EmptyFieldException("clienteId");
            }

            if (entity.getClienteNombre() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteNombre");
            }

            if ((entity.getClienteNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNombre(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNombre");
            }

            if (entity.getClienteNumeroCelular() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteNumeroCelular");
            }

            if ((entity.getClienteNumeroCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNumeroCelular(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNumeroCelular");
            }

            if (entity.getClienteNumeroIdentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "clienteNumeroIdentificacion");
            }

            if ((entity.getClienteNumeroIdentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNumeroIdentificacion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNumeroIdentificacion");
            }

            if ((entity.getClienteNumeroTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getClienteNumeroTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "clienteNumeroTelefono");
            }

            clienteDAO.update(entity);

            log.debug("update Cliente successful");
        } catch (Exception e) {
            log.error("update Cliente failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<ClienteDTO> getDataCliente() throws Exception {
        try {
            List<Cliente> cliente = clienteDAO.findAll();

            List<ClienteDTO> clienteDTO = new ArrayList<ClienteDTO>();

            for (Cliente clienteTmp : cliente) {
                ClienteDTO clienteDTO2 = new ClienteDTO();

                clienteDTO2.setClienteId(clienteTmp.getClienteId());
                clienteDTO2.setClienteApellido((clienteTmp.getClienteApellido() != null)
                    ? clienteTmp.getClienteApellido() : null);
                clienteDTO2.setClienteBarrio((clienteTmp.getClienteBarrio() != null)
                    ? clienteTmp.getClienteBarrio() : null);
                clienteDTO2.setClienteCorreoElctronico((clienteTmp.getClienteCorreoElctronico() != null)
                    ? clienteTmp.getClienteCorreoElctronico() : null);
                clienteDTO2.setClienteDireccion((clienteTmp.getClienteDireccion() != null)
                    ? clienteTmp.getClienteDireccion() : null);
                clienteDTO2.setClienteFechaCreacion(clienteTmp.getClienteFechaCreacion());
                clienteDTO2.setClienteFechaModificacion(clienteTmp.getClienteFechaModificacion());
                clienteDTO2.setClienteFechaNacimiento(clienteTmp.getClienteFechaNacimiento());
                clienteDTO2.setClienteNombre((clienteTmp.getClienteNombre() != null)
                    ? clienteTmp.getClienteNombre() : null);
                clienteDTO2.setClienteNumeroCelular((clienteTmp.getClienteNumeroCelular() != null)
                    ? clienteTmp.getClienteNumeroCelular() : null);
                clienteDTO2.setClienteNumeroIdentificacion((clienteTmp.getClienteNumeroIdentificacion() != null)
                    ? clienteTmp.getClienteNumeroIdentificacion() : null);
                clienteDTO2.setClienteNumeroTelefono((clienteTmp.getClienteNumeroTelefono() != null)
                    ? clienteTmp.getClienteNumeroTelefono() : null);
                clienteDTO.add(clienteDTO2);
            }

            return clienteDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Cliente getCliente(Integer clienteId) throws Exception {
        log.debug("getting Cliente instance");

        Cliente entity = null;

        try {
            entity = clienteDAO.findById(clienteId);
        } catch (Exception e) {
            log.error("get Cliente failed", e);
            throw new ZMessManager().new FindingException("Cliente");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Cliente> entity = null;

        try {
            entity = clienteDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Cliente Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberCliente() throws Exception {
        Long entity = null;

        try {
            entity = clienteDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Cliente Count");
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
    public List<Cliente> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Cliente> list = new ArrayList<Cliente>();
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
            list = clienteDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
