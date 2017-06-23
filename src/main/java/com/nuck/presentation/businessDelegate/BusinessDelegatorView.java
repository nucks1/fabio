package com.nuck.presentation.businessDelegate;

import com.nuck.modelo.ClaseTipo;
import com.nuck.modelo.Cliente;
import com.nuck.modelo.Colaborador;
import com.nuck.modelo.ColaboradorServicio;
import com.nuck.modelo.ColaboradorServicioId;
import com.nuck.modelo.Consumo;
import com.nuck.modelo.Egreso;
import com.nuck.modelo.Entrada;
import com.nuck.modelo.Ingreso;
import com.nuck.modelo.Membresia;
import com.nuck.modelo.Miembro;
import com.nuck.modelo.PgStatStatements;
import com.nuck.modelo.PgStatStatementsId;
import com.nuck.modelo.Producto;
import com.nuck.modelo.Puntos;
import com.nuck.modelo.Salida;
import com.nuck.modelo.Servicio;
import com.nuck.modelo.Tipo;
import com.nuck.modelo.Usuario;
import com.nuck.modelo.control.ClaseTipoLogic;
import com.nuck.modelo.control.ClienteLogic;
import com.nuck.modelo.control.ColaboradorLogic;
import com.nuck.modelo.control.ColaboradorServicioLogic;
import com.nuck.modelo.control.ConsumoLogic;
import com.nuck.modelo.control.EgresoLogic;
import com.nuck.modelo.control.EntradaLogic;
import com.nuck.modelo.control.IClaseTipoLogic;
import com.nuck.modelo.control.IClienteLogic;
import com.nuck.modelo.control.IColaboradorLogic;
import com.nuck.modelo.control.IColaboradorServicioLogic;
import com.nuck.modelo.control.IConsumoLogic;
import com.nuck.modelo.control.IEgresoLogic;
import com.nuck.modelo.control.IEntradaLogic;
import com.nuck.modelo.control.IIngresoLogic;
import com.nuck.modelo.control.IMembresiaLogic;
import com.nuck.modelo.control.IMiembroLogic;
import com.nuck.modelo.control.IPgStatStatementsLogic;
import com.nuck.modelo.control.IProductoLogic;
import com.nuck.modelo.control.IPuntosLogic;
import com.nuck.modelo.control.ISalidaLogic;
import com.nuck.modelo.control.IServicioLogic;
import com.nuck.modelo.control.ITipoLogic;
import com.nuck.modelo.control.IUsuarioLogic;
import com.nuck.modelo.control.IngresoLogic;
import com.nuck.modelo.control.MembresiaLogic;
import com.nuck.modelo.control.MiembroLogic;
import com.nuck.modelo.control.PgStatStatementsLogic;
import com.nuck.modelo.control.ProductoLogic;
import com.nuck.modelo.control.PuntosLogic;
import com.nuck.modelo.control.SalidaLogic;
import com.nuck.modelo.control.ServicioLogic;
import com.nuck.modelo.control.TipoLogic;
import com.nuck.modelo.control.UsuarioLogic;
import com.nuck.modelo.dto.ClaseTipoDTO;
import com.nuck.modelo.dto.ClienteDTO;
import com.nuck.modelo.dto.ColaboradorDTO;
import com.nuck.modelo.dto.ColaboradorServicioDTO;
import com.nuck.modelo.dto.ConsumoDTO;
import com.nuck.modelo.dto.EgresoDTO;
import com.nuck.modelo.dto.EntradaDTO;
import com.nuck.modelo.dto.IngresoDTO;
import com.nuck.modelo.dto.MembresiaDTO;
import com.nuck.modelo.dto.MiembroDTO;
import com.nuck.modelo.dto.PgStatStatementsDTO;
import com.nuck.modelo.dto.ProductoDTO;
import com.nuck.modelo.dto.PuntosDTO;
import com.nuck.modelo.dto.SalidaDTO;
import com.nuck.modelo.dto.ServicioDTO;
import com.nuck.modelo.dto.TipoDTO;
import com.nuck.modelo.dto.UsuarioDTO;

import com.nuck.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.sql.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private IClaseTipoLogic claseTipoLogic;
    @Autowired
    private IClienteLogic clienteLogic;
    @Autowired
    private IColaboradorLogic colaboradorLogic;
    @Autowired
    private IColaboradorServicioLogic colaboradorServicioLogic;
    @Autowired
    private IConsumoLogic consumoLogic;
    @Autowired
    private IEgresoLogic egresoLogic;
    @Autowired
    private IEntradaLogic entradaLogic;
    @Autowired
    private IIngresoLogic ingresoLogic;
    @Autowired
    private IMembresiaLogic membresiaLogic;
    @Autowired
    private IMiembroLogic miembroLogic;
    @Autowired
    private IPgStatStatementsLogic pgStatStatementsLogic;
    @Autowired
    private IProductoLogic productoLogic;
    @Autowired
    private IPuntosLogic puntosLogic;
    @Autowired
    private ISalidaLogic salidaLogic;
    @Autowired
    private IServicioLogic servicioLogic;
    @Autowired
    private ITipoLogic tipoLogic;
    @Autowired
    private IUsuarioLogic usuarioLogic;

    public List<ClaseTipo> getClaseTipo() throws Exception {
        return claseTipoLogic.getClaseTipo();
    }

    public void saveClaseTipo(ClaseTipo entity) throws Exception {
        claseTipoLogic.saveClaseTipo(entity);
    }

    public void deleteClaseTipo(ClaseTipo entity) throws Exception {
        claseTipoLogic.deleteClaseTipo(entity);
    }

    public void updateClaseTipo(ClaseTipo entity) throws Exception {
        claseTipoLogic.updateClaseTipo(entity);
    }

    public ClaseTipo getClaseTipo(Integer claseTipoId)
        throws Exception {
        ClaseTipo claseTipo = null;

        try {
            claseTipo = claseTipoLogic.getClaseTipo(claseTipoId);
        } catch (Exception e) {
            throw e;
        }

        return claseTipo;
    }

    public List<ClaseTipo> findByCriteriaInClaseTipo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return claseTipoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<ClaseTipo> findPageClaseTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return claseTipoLogic.findPageClaseTipo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberClaseTipo() throws Exception {
        return claseTipoLogic.findTotalNumberClaseTipo();
    }

    public List<ClaseTipoDTO> getDataClaseTipo() throws Exception {
        return claseTipoLogic.getDataClaseTipo();
    }

    public List<Cliente> getCliente() throws Exception {
        return clienteLogic.getCliente();
    }

    public void saveCliente(Cliente entity) throws Exception {
        clienteLogic.saveCliente(entity);
    }

    public void deleteCliente(Cliente entity) throws Exception {
        clienteLogic.deleteCliente(entity);
    }

    public void updateCliente(Cliente entity) throws Exception {
        clienteLogic.updateCliente(entity);
    }

    public Cliente getCliente(Integer clienteId) throws Exception {
        Cliente cliente = null;

        try {
            cliente = clienteLogic.getCliente(clienteId);
        } catch (Exception e) {
            throw e;
        }

        return cliente;
    }

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return clienteLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return clienteLogic.findPageCliente(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCliente() throws Exception {
        return clienteLogic.findTotalNumberCliente();
    }

    public List<ClienteDTO> getDataCliente() throws Exception {
        return clienteLogic.getDataCliente();
    }

    public List<Colaborador> getColaborador() throws Exception {
        return colaboradorLogic.getColaborador();
    }

    public void saveColaborador(Colaborador entity) throws Exception {
        colaboradorLogic.saveColaborador(entity);
    }

    public void deleteColaborador(Colaborador entity) throws Exception {
        colaboradorLogic.deleteColaborador(entity);
    }

    public void updateColaborador(Colaborador entity) throws Exception {
        colaboradorLogic.updateColaborador(entity);
    }

    public Colaborador getColaborador(Integer colaboradorId)
        throws Exception {
        Colaborador colaborador = null;

        try {
            colaborador = colaboradorLogic.getColaborador(colaboradorId);
        } catch (Exception e) {
            throw e;
        }

        return colaborador;
    }

    public List<Colaborador> findByCriteriaInColaborador(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return colaboradorLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Colaborador> findPageColaborador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return colaboradorLogic.findPageColaborador(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberColaborador() throws Exception {
        return colaboradorLogic.findTotalNumberColaborador();
    }

    public List<ColaboradorDTO> getDataColaborador() throws Exception {
        return colaboradorLogic.getDataColaborador();
    }

    public List<ColaboradorServicio> getColaboradorServicio()
        throws Exception {
        return colaboradorServicioLogic.getColaboradorServicio();
    }

    public void saveColaboradorServicio(ColaboradorServicio entity)
        throws Exception {
        colaboradorServicioLogic.saveColaboradorServicio(entity);
    }

    public void deleteColaboradorServicio(ColaboradorServicio entity)
        throws Exception {
        colaboradorServicioLogic.deleteColaboradorServicio(entity);
    }

    public void updateColaboradorServicio(ColaboradorServicio entity)
        throws Exception {
        colaboradorServicioLogic.updateColaboradorServicio(entity);
    }

    public ColaboradorServicio getColaboradorServicio(ColaboradorServicioId id)
        throws Exception {
        ColaboradorServicio colaboradorServicio = null;

        try {
            colaboradorServicio = colaboradorServicioLogic.getColaboradorServicio(id);
        } catch (Exception e) {
            throw e;
        }

        return colaboradorServicio;
    }

    public List<ColaboradorServicio> findByCriteriaInColaboradorServicio(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return colaboradorServicioLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<ColaboradorServicio> findPageColaboradorServicio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return colaboradorServicioLogic.findPageColaboradorServicio(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberColaboradorServicio() throws Exception {
        return colaboradorServicioLogic.findTotalNumberColaboradorServicio();
    }

    public List<ColaboradorServicioDTO> getDataColaboradorServicio()
        throws Exception {
        return colaboradorServicioLogic.getDataColaboradorServicio();
    }

    public List<Consumo> getConsumo() throws Exception {
        return consumoLogic.getConsumo();
    }

    public void saveConsumo(Consumo entity) throws Exception {
        consumoLogic.saveConsumo(entity);
    }

    public void deleteConsumo(Consumo entity) throws Exception {
        consumoLogic.deleteConsumo(entity);
    }

    public void updateConsumo(Consumo entity) throws Exception {
        consumoLogic.updateConsumo(entity);
    }

    public Consumo getConsumo(Integer consumoId) throws Exception {
        Consumo consumo = null;

        try {
            consumo = consumoLogic.getConsumo(consumoId);
        } catch (Exception e) {
            throw e;
        }

        return consumo;
    }

    public List<Consumo> findByCriteriaInConsumo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return consumoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Consumo> findPageConsumo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return consumoLogic.findPageConsumo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberConsumo() throws Exception {
        return consumoLogic.findTotalNumberConsumo();
    }

    public List<ConsumoDTO> getDataConsumo() throws Exception {
        return consumoLogic.getDataConsumo();
    }

    public List<Egreso> getEgreso() throws Exception {
        return egresoLogic.getEgreso();
    }

    public void saveEgreso(Egreso entity) throws Exception {
        egresoLogic.saveEgreso(entity);
    }

    public void deleteEgreso(Egreso entity) throws Exception {
        egresoLogic.deleteEgreso(entity);
    }

    public void updateEgreso(Egreso entity) throws Exception {
        egresoLogic.updateEgreso(entity);
    }

    public Egreso getEgreso(Integer egresoId) throws Exception {
        Egreso egreso = null;

        try {
            egreso = egresoLogic.getEgreso(egresoId);
        } catch (Exception e) {
            throw e;
        }

        return egreso;
    }

    public List<Egreso> findByCriteriaInEgreso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return egresoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Egreso> findPageEgreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return egresoLogic.findPageEgreso(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEgreso() throws Exception {
        return egresoLogic.findTotalNumberEgreso();
    }

    public List<EgresoDTO> getDataEgreso() throws Exception {
        return egresoLogic.getDataEgreso();
    }

    public List<Entrada> getEntrada() throws Exception {
        return entradaLogic.getEntrada();
    }

    public void saveEntrada(Entrada entity) throws Exception {
        entradaLogic.saveEntrada(entity);
    }

    public void deleteEntrada(Entrada entity) throws Exception {
        entradaLogic.deleteEntrada(entity);
    }

    public void updateEntrada(Entrada entity) throws Exception {
        entradaLogic.updateEntrada(entity);
    }

    public Entrada getEntrada(Integer entradaId) throws Exception {
        Entrada entrada = null;

        try {
            entrada = entradaLogic.getEntrada(entradaId);
        } catch (Exception e) {
            throw e;
        }

        return entrada;
    }

    public List<Entrada> findByCriteriaInEntrada(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return entradaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Entrada> findPageEntrada(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return entradaLogic.findPageEntrada(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEntrada() throws Exception {
        return entradaLogic.findTotalNumberEntrada();
    }

    public List<EntradaDTO> getDataEntrada() throws Exception {
        return entradaLogic.getDataEntrada();
    }

    public List<Ingreso> getIngreso() throws Exception {
        return ingresoLogic.getIngreso();
    }

    public void saveIngreso(Ingreso entity) throws Exception {
        ingresoLogic.saveIngreso(entity);
    }

    public void deleteIngreso(Ingreso entity) throws Exception {
        ingresoLogic.deleteIngreso(entity);
    }

    public void updateIngreso(Ingreso entity) throws Exception {
        ingresoLogic.updateIngreso(entity);
    }

    public Ingreso getIngreso(Integer ingresoId) throws Exception {
        Ingreso ingreso = null;

        try {
            ingreso = ingresoLogic.getIngreso(ingresoId);
        } catch (Exception e) {
            throw e;
        }

        return ingreso;
    }

    public List<Ingreso> findByCriteriaInIngreso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return ingresoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Ingreso> findPageIngreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return ingresoLogic.findPageIngreso(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberIngreso() throws Exception {
        return ingresoLogic.findTotalNumberIngreso();
    }

    public List<IngresoDTO> getDataIngreso() throws Exception {
        return ingresoLogic.getDataIngreso();
    }

    public List<Membresia> getMembresia() throws Exception {
        return membresiaLogic.getMembresia();
    }

    public void saveMembresia(Membresia entity) throws Exception {
        membresiaLogic.saveMembresia(entity);
    }

    public void deleteMembresia(Membresia entity) throws Exception {
        membresiaLogic.deleteMembresia(entity);
    }

    public void updateMembresia(Membresia entity) throws Exception {
        membresiaLogic.updateMembresia(entity);
    }

    public Membresia getMembresia(Integer membresiaId)
        throws Exception {
        Membresia membresia = null;

        try {
            membresia = membresiaLogic.getMembresia(membresiaId);
        } catch (Exception e) {
            throw e;
        }

        return membresia;
    }

    public List<Membresia> findByCriteriaInMembresia(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return membresiaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Membresia> findPageMembresia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return membresiaLogic.findPageMembresia(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberMembresia() throws Exception {
        return membresiaLogic.findTotalNumberMembresia();
    }

    public List<MembresiaDTO> getDataMembresia() throws Exception {
        return membresiaLogic.getDataMembresia();
    }

    public List<Miembro> getMiembro() throws Exception {
        return miembroLogic.getMiembro();
    }

    public void saveMiembro(Miembro entity) throws Exception {
        miembroLogic.saveMiembro(entity);
    }

    public void deleteMiembro(Miembro entity) throws Exception {
        miembroLogic.deleteMiembro(entity);
    }

    public void updateMiembro(Miembro entity) throws Exception {
        miembroLogic.updateMiembro(entity);
    }

    public Miembro getMiembro(Integer miembroId) throws Exception {
        Miembro miembro = null;

        try {
            miembro = miembroLogic.getMiembro(miembroId);
        } catch (Exception e) {
            throw e;
        }

        return miembro;
    }

    public List<Miembro> findByCriteriaInMiembro(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return miembroLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Miembro> findPageMiembro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return miembroLogic.findPageMiembro(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberMiembro() throws Exception {
        return miembroLogic.findTotalNumberMiembro();
    }

    public List<MiembroDTO> getDataMiembro() throws Exception {
        return miembroLogic.getDataMiembro();
    }

    public List<PgStatStatements> getPgStatStatements()
        throws Exception {
        return pgStatStatementsLogic.getPgStatStatements();
    }

    public void savePgStatStatements(PgStatStatements entity)
        throws Exception {
        pgStatStatementsLogic.savePgStatStatements(entity);
    }

    public void deletePgStatStatements(PgStatStatements entity)
        throws Exception {
        pgStatStatementsLogic.deletePgStatStatements(entity);
    }

    public void updatePgStatStatements(PgStatStatements entity)
        throws Exception {
        pgStatStatementsLogic.updatePgStatStatements(entity);
    }

    public PgStatStatements getPgStatStatements(PgStatStatementsId id)
        throws Exception {
        PgStatStatements pgStatStatements = null;

        try {
            pgStatStatements = pgStatStatementsLogic.getPgStatStatements(id);
        } catch (Exception e) {
            throw e;
        }

        return pgStatStatements;
    }

    public List<PgStatStatements> findByCriteriaInPgStatStatements(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return pgStatStatementsLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public List<PgStatStatements> findPagePgStatStatements(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        return pgStatStatementsLogic.findPagePgStatStatements(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberPgStatStatements() throws Exception {
        return pgStatStatementsLogic.findTotalNumberPgStatStatements();
    }

    public List<PgStatStatementsDTO> getDataPgStatStatements()
        throws Exception {
        return pgStatStatementsLogic.getDataPgStatStatements();
    }

    public List<Producto> getProducto() throws Exception {
        return productoLogic.getProducto();
    }

    public void saveProducto(Producto entity) throws Exception {
        productoLogic.saveProducto(entity);
    }

    public void deleteProducto(Producto entity) throws Exception {
        productoLogic.deleteProducto(entity);
    }

    public void updateProducto(Producto entity) throws Exception {
        productoLogic.updateProducto(entity);
    }

    public Producto getProducto(Integer productoId) throws Exception {
        Producto producto = null;

        try {
            producto = productoLogic.getProducto(productoId);
        } catch (Exception e) {
            throw e;
        }

        return producto;
    }

    public List<Producto> findByCriteriaInProducto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return productoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Producto> findPageProducto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return productoLogic.findPageProducto(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberProducto() throws Exception {
        return productoLogic.findTotalNumberProducto();
    }

    public List<ProductoDTO> getDataProducto() throws Exception {
        return productoLogic.getDataProducto();
    }

    public List<Puntos> getPuntos() throws Exception {
        return puntosLogic.getPuntos();
    }

    public void savePuntos(Puntos entity) throws Exception {
        puntosLogic.savePuntos(entity);
    }

    public void deletePuntos(Puntos entity) throws Exception {
        puntosLogic.deletePuntos(entity);
    }

    public void updatePuntos(Puntos entity) throws Exception {
        puntosLogic.updatePuntos(entity);
    }

    public Puntos getPuntos(Integer puntosId) throws Exception {
        Puntos puntos = null;

        try {
            puntos = puntosLogic.getPuntos(puntosId);
        } catch (Exception e) {
            throw e;
        }

        return puntos;
    }

    public List<Puntos> findByCriteriaInPuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return puntosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Puntos> findPagePuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return puntosLogic.findPagePuntos(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPuntos() throws Exception {
        return puntosLogic.findTotalNumberPuntos();
    }

    public List<PuntosDTO> getDataPuntos() throws Exception {
        return puntosLogic.getDataPuntos();
    }

    public List<Salida> getSalida() throws Exception {
        return salidaLogic.getSalida();
    }

    public void saveSalida(Salida entity) throws Exception {
        salidaLogic.saveSalida(entity);
    }

    public void deleteSalida(Salida entity) throws Exception {
        salidaLogic.deleteSalida(entity);
    }

    public void updateSalida(Salida entity) throws Exception {
        salidaLogic.updateSalida(entity);
    }

    public Salida getSalida(Integer salidaId) throws Exception {
        Salida salida = null;

        try {
            salida = salidaLogic.getSalida(salidaId);
        } catch (Exception e) {
            throw e;
        }

        return salida;
    }

    public List<Salida> findByCriteriaInSalida(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return salidaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Salida> findPageSalida(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return salidaLogic.findPageSalida(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberSalida() throws Exception {
        return salidaLogic.findTotalNumberSalida();
    }

    public List<SalidaDTO> getDataSalida() throws Exception {
        return salidaLogic.getDataSalida();
    }

    public List<Servicio> getServicio() throws Exception {
        return servicioLogic.getServicio();
    }

    public void saveServicio(Servicio entity) throws Exception {
        servicioLogic.saveServicio(entity);
    }

    public void deleteServicio(Servicio entity) throws Exception {
        servicioLogic.deleteServicio(entity);
    }

    public void updateServicio(Servicio entity) throws Exception {
        servicioLogic.updateServicio(entity);
    }

    public Servicio getServicio(Integer servicioId) throws Exception {
        Servicio servicio = null;

        try {
            servicio = servicioLogic.getServicio(servicioId);
        } catch (Exception e) {
            throw e;
        }

        return servicio;
    }

    public List<Servicio> findByCriteriaInServicio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return servicioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Servicio> findPageServicio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return servicioLogic.findPageServicio(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberServicio() throws Exception {
        return servicioLogic.findTotalNumberServicio();
    }

    public List<ServicioDTO> getDataServicio() throws Exception {
        return servicioLogic.getDataServicio();
    }

    public List<Tipo> getTipo() throws Exception {
        return tipoLogic.getTipo();
    }

    public void saveTipo(Tipo entity) throws Exception {
        tipoLogic.saveTipo(entity);
    }

    public void deleteTipo(Tipo entity) throws Exception {
        tipoLogic.deleteTipo(entity);
    }

    public void updateTipo(Tipo entity) throws Exception {
        tipoLogic.updateTipo(entity);
    }

    public Tipo getTipo(Integer tipoId) throws Exception {
        Tipo tipo = null;

        try {
            tipo = tipoLogic.getTipo(tipoId);
        } catch (Exception e) {
            throw e;
        }

        return tipo;
    }

    public List<Tipo> findByCriteriaInTipo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return tipoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Tipo> findPageTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return tipoLogic.findPageTipo(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberTipo() throws Exception {
        return tipoLogic.findTotalNumberTipo();
    }

    public List<TipoDTO> getDataTipo() throws Exception {
        return tipoLogic.getDataTipo();
    }

    public List<Usuario> getUsuario() throws Exception {
        return usuarioLogic.getUsuario();
    }

    public void saveUsuario(Usuario entity) throws Exception {
        usuarioLogic.saveUsuario(entity);
    }

    public void deleteUsuario(Usuario entity) throws Exception {
        usuarioLogic.deleteUsuario(entity);
    }

    public void updateUsuario(Usuario entity) throws Exception {
        usuarioLogic.updateUsuario(entity);
    }

    public Usuario getUsuario(Integer usuarioId) throws Exception {
        Usuario usuario = null;

        try {
            usuario = usuarioLogic.getUsuario(usuarioId);
        } catch (Exception e) {
            throw e;
        }

        return usuario;
    }

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return usuarioLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return usuarioLogic.findPageUsuario(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberUsuario() throws Exception {
        return usuarioLogic.findTotalNumberUsuario();
    }

    public List<UsuarioDTO> getDataUsuario() throws Exception {
        return usuarioLogic.getDataUsuario();
    }
}
