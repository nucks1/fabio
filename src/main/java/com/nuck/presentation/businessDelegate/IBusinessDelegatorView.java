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

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<ClaseTipo> getClaseTipo() throws Exception;

    public void saveClaseTipo(ClaseTipo entity) throws Exception;

    public void deleteClaseTipo(ClaseTipo entity) throws Exception;

    public void updateClaseTipo(ClaseTipo entity) throws Exception;

    public ClaseTipo getClaseTipo(Integer claseTipoId)
        throws Exception;

    public List<ClaseTipo> findByCriteriaInClaseTipo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ClaseTipo> findPageClaseTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberClaseTipo() throws Exception;

    public List<ClaseTipoDTO> getDataClaseTipo() throws Exception;

    public List<Cliente> getCliente() throws Exception;

    public void saveCliente(Cliente entity) throws Exception;

    public void deleteCliente(Cliente entity) throws Exception;

    public void updateCliente(Cliente entity) throws Exception;

    public Cliente getCliente(Integer clienteId) throws Exception;

    public List<Cliente> findByCriteriaInCliente(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cliente> findPageCliente(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCliente() throws Exception;

    public List<ClienteDTO> getDataCliente() throws Exception;

    public List<Colaborador> getColaborador() throws Exception;

    public void saveColaborador(Colaborador entity) throws Exception;

    public void deleteColaborador(Colaborador entity) throws Exception;

    public void updateColaborador(Colaborador entity) throws Exception;

    public Colaborador getColaborador(Integer colaboradorId)
        throws Exception;

    public List<Colaborador> findByCriteriaInColaborador(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Colaborador> findPageColaborador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberColaborador() throws Exception;

    public List<ColaboradorDTO> getDataColaborador() throws Exception;

    public List<ColaboradorServicio> getColaboradorServicio()
        throws Exception;

    public void saveColaboradorServicio(ColaboradorServicio entity)
        throws Exception;

    public void deleteColaboradorServicio(ColaboradorServicio entity)
        throws Exception;

    public void updateColaboradorServicio(ColaboradorServicio entity)
        throws Exception;

    public ColaboradorServicio getColaboradorServicio(ColaboradorServicioId id)
        throws Exception;

    public List<ColaboradorServicio> findByCriteriaInColaboradorServicio(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<ColaboradorServicio> findPageColaboradorServicio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberColaboradorServicio() throws Exception;

    public List<ColaboradorServicioDTO> getDataColaboradorServicio()
        throws Exception;

    public List<Consumo> getConsumo() throws Exception;

    public void saveConsumo(Consumo entity) throws Exception;

    public void deleteConsumo(Consumo entity) throws Exception;

    public void updateConsumo(Consumo entity) throws Exception;

    public Consumo getConsumo(Integer consumoId) throws Exception;

    public List<Consumo> findByCriteriaInConsumo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Consumo> findPageConsumo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberConsumo() throws Exception;

    public List<ConsumoDTO> getDataConsumo() throws Exception;

    public List<Egreso> getEgreso() throws Exception;

    public void saveEgreso(Egreso entity) throws Exception;

    public void deleteEgreso(Egreso entity) throws Exception;

    public void updateEgreso(Egreso entity) throws Exception;

    public Egreso getEgreso(Integer egresoId) throws Exception;

    public List<Egreso> findByCriteriaInEgreso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Egreso> findPageEgreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEgreso() throws Exception;

    public List<EgresoDTO> getDataEgreso() throws Exception;

    public List<Entrada> getEntrada() throws Exception;

    public void saveEntrada(Entrada entity) throws Exception;

    public void deleteEntrada(Entrada entity) throws Exception;

    public void updateEntrada(Entrada entity) throws Exception;

    public Entrada getEntrada(Integer entradaId) throws Exception;

    public List<Entrada> findByCriteriaInEntrada(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Entrada> findPageEntrada(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEntrada() throws Exception;

    public List<EntradaDTO> getDataEntrada() throws Exception;

    public List<Ingreso> getIngreso() throws Exception;

    public void saveIngreso(Ingreso entity) throws Exception;

    public void deleteIngreso(Ingreso entity) throws Exception;

    public void updateIngreso(Ingreso entity) throws Exception;

    public Ingreso getIngreso(Integer ingresoId) throws Exception;

    public List<Ingreso> findByCriteriaInIngreso(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Ingreso> findPageIngreso(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberIngreso() throws Exception;

    public List<IngresoDTO> getDataIngreso() throws Exception;

    public List<Membresia> getMembresia() throws Exception;

    public void saveMembresia(Membresia entity) throws Exception;

    public void deleteMembresia(Membresia entity) throws Exception;

    public void updateMembresia(Membresia entity) throws Exception;

    public Membresia getMembresia(Integer membresiaId)
        throws Exception;

    public List<Membresia> findByCriteriaInMembresia(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Membresia> findPageMembresia(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMembresia() throws Exception;

    public List<MembresiaDTO> getDataMembresia() throws Exception;

    public List<Miembro> getMiembro() throws Exception;

    public void saveMiembro(Miembro entity) throws Exception;

    public void deleteMiembro(Miembro entity) throws Exception;

    public void updateMiembro(Miembro entity) throws Exception;

    public Miembro getMiembro(Integer miembroId) throws Exception;

    public List<Miembro> findByCriteriaInMiembro(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Miembro> findPageMiembro(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberMiembro() throws Exception;

    public List<MiembroDTO> getDataMiembro() throws Exception;

    public List<PgStatStatements> getPgStatStatements()
        throws Exception;

    public void savePgStatStatements(PgStatStatements entity)
        throws Exception;

    public void deletePgStatStatements(PgStatStatements entity)
        throws Exception;

    public void updatePgStatStatements(PgStatStatements entity)
        throws Exception;

    public PgStatStatements getPgStatStatements(PgStatStatementsId id)
        throws Exception;

    public List<PgStatStatements> findByCriteriaInPgStatStatements(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<PgStatStatements> findPagePgStatStatements(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberPgStatStatements() throws Exception;

    public List<PgStatStatementsDTO> getDataPgStatStatements()
        throws Exception;

    public List<Producto> getProducto() throws Exception;

    public void saveProducto(Producto entity) throws Exception;

    public void deleteProducto(Producto entity) throws Exception;

    public void updateProducto(Producto entity) throws Exception;

    public Producto getProducto(Integer productoId) throws Exception;

    public List<Producto> findByCriteriaInProducto(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Producto> findPageProducto(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberProducto() throws Exception;

    public List<ProductoDTO> getDataProducto() throws Exception;

    public List<Puntos> getPuntos() throws Exception;

    public void savePuntos(Puntos entity) throws Exception;

    public void deletePuntos(Puntos entity) throws Exception;

    public void updatePuntos(Puntos entity) throws Exception;

    public Puntos getPuntos(Integer puntosId) throws Exception;

    public List<Puntos> findByCriteriaInPuntos(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Puntos> findPagePuntos(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPuntos() throws Exception;

    public List<PuntosDTO> getDataPuntos() throws Exception;

    public List<Salida> getSalida() throws Exception;

    public void saveSalida(Salida entity) throws Exception;

    public void deleteSalida(Salida entity) throws Exception;

    public void updateSalida(Salida entity) throws Exception;

    public Salida getSalida(Integer salidaId) throws Exception;

    public List<Salida> findByCriteriaInSalida(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Salida> findPageSalida(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberSalida() throws Exception;

    public List<SalidaDTO> getDataSalida() throws Exception;

    public List<Servicio> getServicio() throws Exception;

    public void saveServicio(Servicio entity) throws Exception;

    public void deleteServicio(Servicio entity) throws Exception;

    public void updateServicio(Servicio entity) throws Exception;

    public Servicio getServicio(Integer servicioId) throws Exception;

    public List<Servicio> findByCriteriaInServicio(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Servicio> findPageServicio(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberServicio() throws Exception;

    public List<ServicioDTO> getDataServicio() throws Exception;

    public List<Tipo> getTipo() throws Exception;

    public void saveTipo(Tipo entity) throws Exception;

    public void deleteTipo(Tipo entity) throws Exception;

    public void updateTipo(Tipo entity) throws Exception;

    public Tipo getTipo(Integer tipoId) throws Exception;

    public List<Tipo> findByCriteriaInTipo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tipo> findPageTipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipo() throws Exception;

    public List<TipoDTO> getDataTipo() throws Exception;

    public List<Usuario> getUsuario() throws Exception;

    public void saveUsuario(Usuario entity) throws Exception;

    public void deleteUsuario(Usuario entity) throws Exception;

    public void updateUsuario(Usuario entity) throws Exception;

    public Usuario getUsuario(Integer usuarioId) throws Exception;

    public List<Usuario> findByCriteriaInUsuario(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Usuario> findPageUsuario(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberUsuario() throws Exception;

    public List<UsuarioDTO> getDataUsuario() throws Exception;
}
