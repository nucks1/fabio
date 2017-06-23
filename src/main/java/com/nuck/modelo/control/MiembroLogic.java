package com.nuck.modelo.control;

import com.nuck.dataaccess.dao.*;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.MiembroDTO;

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
@Service("MiembroLogic")
public class MiembroLogic implements IMiembroLogic {
    private static final Logger log = LoggerFactory.getLogger(MiembroLogic.class);

    /**
     * DAO injected by Spring that manages Miembro entities
     *
     */
    @Autowired
    private IMiembroDAO miembroDAO;

    /**
    * DAO injected by Spring that manages Entrada entities
    *
    */
    @Autowired
    private IEntradaDAO entradaDAO;

    /**
    * DAO injected by Spring that manages Ingreso entities
    *
    */
    @Autowired
    private IIngresoDAO ingresoDAO;

    /**
    * DAO injected by Spring that manages Membresia entities
    *
    */
    @Autowired
    private IMembresiaDAO membresiaDAO;

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
    public List<Miembro> getMiembro() throws Exception {
        log.debug("finding all Miembro instances");

        List<Miembro> list = new ArrayList<Miembro>();

        try {
            list = miembroDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Miembro failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Miembro");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveMiembro(Miembro entity) throws Exception {
        log.debug("saving Miembro instance");

        try {
            if (entity.getUsuario() == null) {
                throw new ZMessManager().new ForeignException("usuario");
            }

            if (entity.getMiembroApellido() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroApellido");
            }

            if ((entity.getMiembroApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroApellido");
            }

            if (entity.getMiembroBarrio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroBarrio");
            }

            if ((entity.getMiembroBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroBarrio(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroBarrio");
            }

            if ((entity.getMiembroCorreoElctronico() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroCorreoElctronico(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroCorreoElctronico");
            }

            if (entity.getMiembroDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroDireccion");
            }

            if ((entity.getMiembroDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroDireccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroDireccion");
            }

            if (entity.getMiembroId() == null) {
                throw new ZMessManager().new EmptyFieldException("miembroId");
            }

            if (entity.getMiembroNombre() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroNombre");
            }

            if ((entity.getMiembroNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNombre(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNombre");
            }

            if (entity.getMiembroNumeroCelular() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroNumeroCelular");
            }

            if ((entity.getMiembroNumeroCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNumeroCelular(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNumeroCelular");
            }

            if (entity.getMiembroNumeroIdentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroNumeroIdentificacion");
            }

            if ((entity.getMiembroNumeroIdentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNumeroIdentificacion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNumeroIdentificacion");
            }

            if ((entity.getMiembroNumeroTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNumeroTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNumeroTelefono");
            }

            if (entity.getUsuario().getUsuarioId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "usuarioId_Usuario");
            }

            if (getMiembro(entity.getMiembroId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            miembroDAO.save(entity);

            log.debug("save Miembro successful");
        } catch (Exception e) {
            log.error("save Miembro failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteMiembro(Miembro entity) throws Exception {
        log.debug("deleting Miembro instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Miembro");
        }

        if (entity.getMiembroId() == null) {
            throw new ZMessManager().new EmptyFieldException("miembroId");
        }

        List<Entrada> entradas = null;
        List<Ingreso> ingresos = null;
        List<Membresia> membresias = null;
        List<Salida> salidas = null;

        try {
            entradas = entradaDAO.findByProperty("miembro.miembroId",
                    entity.getMiembroId());

            if (Utilities.validationsList(entradas) == true) {
                throw new ZMessManager().new DeletingException("entradas");
            }

            ingresos = ingresoDAO.findByProperty("miembro.miembroId",
                    entity.getMiembroId());

            if (Utilities.validationsList(ingresos) == true) {
                throw new ZMessManager().new DeletingException("ingresos");
            }

            membresias = membresiaDAO.findByProperty("miembro.miembroId",
                    entity.getMiembroId());

            if (Utilities.validationsList(membresias) == true) {
                throw new ZMessManager().new DeletingException("membresias");
            }

            salidas = salidaDAO.findByProperty("miembro.miembroId",
                    entity.getMiembroId());

            if (Utilities.validationsList(salidas) == true) {
                throw new ZMessManager().new DeletingException("salidas");
            }

            miembroDAO.delete(entity);

            log.debug("delete Miembro successful");
        } catch (Exception e) {
            log.error("delete Miembro failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateMiembro(Miembro entity) throws Exception {
        log.debug("updating Miembro instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Miembro");
            }

            if (entity.getUsuario() == null) {
                throw new ZMessManager().new ForeignException("usuario");
            }

            if (entity.getMiembroApellido() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroApellido");
            }

            if ((entity.getMiembroApellido() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroApellido(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroApellido");
            }

            if (entity.getMiembroBarrio() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroBarrio");
            }

            if ((entity.getMiembroBarrio() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroBarrio(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroBarrio");
            }

            if ((entity.getMiembroCorreoElctronico() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroCorreoElctronico(), 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroCorreoElctronico");
            }

            if (entity.getMiembroDireccion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroDireccion");
            }

            if ((entity.getMiembroDireccion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroDireccion(), 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroDireccion");
            }

            if (entity.getMiembroId() == null) {
                throw new ZMessManager().new EmptyFieldException("miembroId");
            }

            if (entity.getMiembroNombre() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroNombre");
            }

            if ((entity.getMiembroNombre() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNombre(), 45) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNombre");
            }

            if (entity.getMiembroNumeroCelular() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroNumeroCelular");
            }

            if ((entity.getMiembroNumeroCelular() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNumeroCelular(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNumeroCelular");
            }

            if (entity.getMiembroNumeroIdentificacion() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "miembroNumeroIdentificacion");
            }

            if ((entity.getMiembroNumeroIdentificacion() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNumeroIdentificacion(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNumeroIdentificacion");
            }

            if ((entity.getMiembroNumeroTelefono() != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        entity.getMiembroNumeroTelefono(), 20) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "miembroNumeroTelefono");
            }

            if (entity.getUsuario().getUsuarioId() == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "usuarioId_Usuario");
            }

            miembroDAO.update(entity);

            log.debug("update Miembro successful");
        } catch (Exception e) {
            log.error("update Miembro failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<MiembroDTO> getDataMiembro() throws Exception {
        try {
            List<Miembro> miembro = miembroDAO.findAll();

            List<MiembroDTO> miembroDTO = new ArrayList<MiembroDTO>();

            for (Miembro miembroTmp : miembro) {
                MiembroDTO miembroDTO2 = new MiembroDTO();

                miembroDTO2.setMiembroId(miembroTmp.getMiembroId());
                miembroDTO2.setMiembroApellido((miembroTmp.getMiembroApellido() != null)
                    ? miembroTmp.getMiembroApellido() : null);
                miembroDTO2.setMiembroBarrio((miembroTmp.getMiembroBarrio() != null)
                    ? miembroTmp.getMiembroBarrio() : null);
                miembroDTO2.setMiembroCorreoElctronico((miembroTmp.getMiembroCorreoElctronico() != null)
                    ? miembroTmp.getMiembroCorreoElctronico() : null);
                miembroDTO2.setMiembroDireccion((miembroTmp.getMiembroDireccion() != null)
                    ? miembroTmp.getMiembroDireccion() : null);
                miembroDTO2.setMiembroFechaCreacion(miembroTmp.getMiembroFechaCreacion());
                miembroDTO2.setMiembroFechaModificacion(miembroTmp.getMiembroFechaModificacion());
                miembroDTO2.setMiembroFechaNacimiento(miembroTmp.getMiembroFechaNacimiento());
                miembroDTO2.setMiembroNombre((miembroTmp.getMiembroNombre() != null)
                    ? miembroTmp.getMiembroNombre() : null);
                miembroDTO2.setMiembroNumeroCelular((miembroTmp.getMiembroNumeroCelular() != null)
                    ? miembroTmp.getMiembroNumeroCelular() : null);
                miembroDTO2.setMiembroNumeroIdentificacion((miembroTmp.getMiembroNumeroIdentificacion() != null)
                    ? miembroTmp.getMiembroNumeroIdentificacion() : null);
                miembroDTO2.setMiembroNumeroTelefono((miembroTmp.getMiembroNumeroTelefono() != null)
                    ? miembroTmp.getMiembroNumeroTelefono() : null);

                if (miembroTmp.getUsuario() != null) {
                    miembroDTO2.setUsuarioId_Usuario(miembroTmp.getUsuario()
                                                               .getUsuarioId());
                } else {
                    miembroDTO2.setUsuarioId_Usuario(null);
                }

                miembroDTO.add(miembroDTO2);
            }

            return miembroDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Miembro getMiembro(Integer miembroId) throws Exception {
        log.debug("getting Miembro instance");

        Miembro entity = null;

        try {
            entity = miembroDAO.findById(miembroId);
        } catch (Exception e) {
            log.error("get Miembro failed", e);
            throw new ZMessManager().new FindingException("Miembro");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Miembro> findPageMiembro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Miembro> entity = null;

        try {
            entity = miembroDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Miembro Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberMiembro() throws Exception {
        Long entity = null;

        try {
            entity = miembroDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Miembro Count");
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
    public List<Miembro> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Miembro> list = new ArrayList<Miembro>();
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
            list = miembroDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
