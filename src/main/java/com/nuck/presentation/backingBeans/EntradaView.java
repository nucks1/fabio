package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.EntradaDTO;

import com.nuck.presentation.businessDelegate.*;

import com.nuck.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class EntradaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EntradaView.class);
    private InputText txtEntradaActivo;
    private InputText txtEntradaFinalizado;
    private InputText txtClienteId_Cliente;
    private InputText txtColaboradorId_Colaborador;
    private InputText txtMiembroId_Miembro;
    private InputText txtProductoId_Producto;
    private InputText txtServicioId_Servicio;
    private InputText txtEntradaId;
    private Calendar txtEntradaFechaCreacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EntradaDTO> data;
    private EntradaDTO selectedEntrada;
    private Entrada entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public EntradaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            EntradaDTO entradaDTO = (EntradaDTO) e.getObject();

            if (txtEntradaActivo == null) {
                txtEntradaActivo = new InputText();
            }

            txtEntradaActivo.setValue(entradaDTO.getEntradaActivo());

            if (txtEntradaFinalizado == null) {
                txtEntradaFinalizado = new InputText();
            }

            txtEntradaFinalizado.setValue(entradaDTO.getEntradaFinalizado());

            if (txtClienteId_Cliente == null) {
                txtClienteId_Cliente = new InputText();
            }

            txtClienteId_Cliente.setValue(entradaDTO.getClienteId_Cliente());

            if (txtColaboradorId_Colaborador == null) {
                txtColaboradorId_Colaborador = new InputText();
            }

            txtColaboradorId_Colaborador.setValue(entradaDTO.getColaboradorId_Colaborador());

            if (txtMiembroId_Miembro == null) {
                txtMiembroId_Miembro = new InputText();
            }

            txtMiembroId_Miembro.setValue(entradaDTO.getMiembroId_Miembro());

            if (txtProductoId_Producto == null) {
                txtProductoId_Producto = new InputText();
            }

            txtProductoId_Producto.setValue(entradaDTO.getProductoId_Producto());

            if (txtServicioId_Servicio == null) {
                txtServicioId_Servicio = new InputText();
            }

            txtServicioId_Servicio.setValue(entradaDTO.getServicioId_Servicio());

            if (txtEntradaId == null) {
                txtEntradaId = new InputText();
            }

            txtEntradaId.setValue(entradaDTO.getEntradaId());

            if (txtEntradaFechaCreacion == null) {
                txtEntradaFechaCreacion = new Calendar();
            }

            txtEntradaFechaCreacion.setValue(entradaDTO.getEntradaFechaCreacion());

            Integer entradaId = FacesUtils.checkInteger(txtEntradaId);
            entity = businessDelegatorView.getEntrada(entradaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedEntrada = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedEntrada = null;

        if (txtEntradaActivo != null) {
            txtEntradaActivo.setValue(null);
            txtEntradaActivo.setDisabled(true);
        }

        if (txtEntradaFinalizado != null) {
            txtEntradaFinalizado.setValue(null);
            txtEntradaFinalizado.setDisabled(true);
        }

        if (txtClienteId_Cliente != null) {
            txtClienteId_Cliente.setValue(null);
            txtClienteId_Cliente.setDisabled(true);
        }

        if (txtColaboradorId_Colaborador != null) {
            txtColaboradorId_Colaborador.setValue(null);
            txtColaboradorId_Colaborador.setDisabled(true);
        }

        if (txtMiembroId_Miembro != null) {
            txtMiembroId_Miembro.setValue(null);
            txtMiembroId_Miembro.setDisabled(true);
        }

        if (txtProductoId_Producto != null) {
            txtProductoId_Producto.setValue(null);
            txtProductoId_Producto.setDisabled(true);
        }

        if (txtServicioId_Servicio != null) {
            txtServicioId_Servicio.setValue(null);
            txtServicioId_Servicio.setDisabled(true);
        }

        if (txtEntradaFechaCreacion != null) {
            txtEntradaFechaCreacion.setValue(null);
            txtEntradaFechaCreacion.setDisabled(true);
        }

        if (txtEntradaId != null) {
            txtEntradaId.setValue(null);
            txtEntradaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtEntradaFechaCreacion() {
        Date inputDate = (Date) txtEntradaFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer entradaId = FacesUtils.checkInteger(txtEntradaId);
            entity = (entradaId != null)
                ? businessDelegatorView.getEntrada(entradaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEntradaActivo.setDisabled(false);
            txtEntradaFinalizado.setDisabled(false);
            txtClienteId_Cliente.setDisabled(false);
            txtColaboradorId_Colaborador.setDisabled(false);
            txtMiembroId_Miembro.setDisabled(false);
            txtProductoId_Producto.setDisabled(false);
            txtServicioId_Servicio.setDisabled(false);
            txtEntradaFechaCreacion.setDisabled(false);
            txtEntradaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEntradaActivo.setValue(entity.getEntradaActivo());
            txtEntradaActivo.setDisabled(false);
            txtEntradaFechaCreacion.setValue(entity.getEntradaFechaCreacion());
            txtEntradaFechaCreacion.setDisabled(false);
            txtEntradaFinalizado.setValue(entity.getEntradaFinalizado());
            txtEntradaFinalizado.setDisabled(false);
            txtClienteId_Cliente.setValue(entity.getCliente().getClienteId());
            txtClienteId_Cliente.setDisabled(false);
            txtColaboradorId_Colaborador.setValue(entity.getColaborador()
                                                        .getColaboradorId());
            txtColaboradorId_Colaborador.setDisabled(false);
            txtMiembroId_Miembro.setValue(entity.getMiembro().getMiembroId());
            txtMiembroId_Miembro.setDisabled(false);
            txtProductoId_Producto.setValue(entity.getProducto().getProductoId());
            txtProductoId_Producto.setDisabled(false);
            txtServicioId_Servicio.setValue(entity.getServicio().getServicioId());
            txtServicioId_Servicio.setDisabled(false);
            txtEntradaId.setValue(entity.getEntradaId());
            txtEntradaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedEntrada = (EntradaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedEntrada"));
        txtEntradaActivo.setValue(selectedEntrada.getEntradaActivo());
        txtEntradaActivo.setDisabled(false);
        txtEntradaFechaCreacion.setValue(selectedEntrada.getEntradaFechaCreacion());
        txtEntradaFechaCreacion.setDisabled(false);
        txtEntradaFinalizado.setValue(selectedEntrada.getEntradaFinalizado());
        txtEntradaFinalizado.setDisabled(false);
        txtClienteId_Cliente.setValue(selectedEntrada.getClienteId_Cliente());
        txtClienteId_Cliente.setDisabled(false);
        txtColaboradorId_Colaborador.setValue(selectedEntrada.getColaboradorId_Colaborador());
        txtColaboradorId_Colaborador.setDisabled(false);
        txtMiembroId_Miembro.setValue(selectedEntrada.getMiembroId_Miembro());
        txtMiembroId_Miembro.setDisabled(false);
        txtProductoId_Producto.setValue(selectedEntrada.getProductoId_Producto());
        txtProductoId_Producto.setDisabled(false);
        txtServicioId_Servicio.setValue(selectedEntrada.getServicioId_Servicio());
        txtServicioId_Servicio.setDisabled(false);
        txtEntradaId.setValue(selectedEntrada.getEntradaId());
        txtEntradaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedEntrada == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new Entrada();

            Integer entradaId = FacesUtils.checkInteger(txtEntradaId);

            entity.setEntradaActivo(FacesUtils.checkString(txtEntradaActivo));
            entity.setEntradaFechaCreacion(FacesUtils.checkDate(
                    txtEntradaFechaCreacion));
            entity.setEntradaFinalizado(FacesUtils.checkString(
                    txtEntradaFinalizado));
            entity.setEntradaId(entradaId);
            entity.setCliente((FacesUtils.checkInteger(txtClienteId_Cliente) != null)
                ? businessDelegatorView.getCliente(FacesUtils.checkInteger(
                        txtClienteId_Cliente)) : null);
            entity.setColaborador((FacesUtils.checkInteger(
                    txtColaboradorId_Colaborador) != null)
                ? businessDelegatorView.getColaborador(FacesUtils.checkInteger(
                        txtColaboradorId_Colaborador)) : null);
            entity.setMiembro((FacesUtils.checkInteger(txtMiembroId_Miembro) != null)
                ? businessDelegatorView.getMiembro(FacesUtils.checkInteger(
                        txtMiembroId_Miembro)) : null);
            entity.setProducto((FacesUtils.checkInteger(txtProductoId_Producto) != null)
                ? businessDelegatorView.getProducto(FacesUtils.checkInteger(
                        txtProductoId_Producto)) : null);
            entity.setServicio((FacesUtils.checkInteger(txtServicioId_Servicio) != null)
                ? businessDelegatorView.getServicio(FacesUtils.checkInteger(
                        txtServicioId_Servicio)) : null);
            businessDelegatorView.saveEntrada(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer entradaId = new Integer(selectedEntrada.getEntradaId());
                entity = businessDelegatorView.getEntrada(entradaId);
            }

            entity.setEntradaActivo(FacesUtils.checkString(txtEntradaActivo));
            entity.setEntradaFechaCreacion(FacesUtils.checkDate(
                    txtEntradaFechaCreacion));
            entity.setEntradaFinalizado(FacesUtils.checkString(
                    txtEntradaFinalizado));
            entity.setCliente((FacesUtils.checkInteger(txtClienteId_Cliente) != null)
                ? businessDelegatorView.getCliente(FacesUtils.checkInteger(
                        txtClienteId_Cliente)) : null);
            entity.setColaborador((FacesUtils.checkInteger(
                    txtColaboradorId_Colaborador) != null)
                ? businessDelegatorView.getColaborador(FacesUtils.checkInteger(
                        txtColaboradorId_Colaborador)) : null);
            entity.setMiembro((FacesUtils.checkInteger(txtMiembroId_Miembro) != null)
                ? businessDelegatorView.getMiembro(FacesUtils.checkInteger(
                        txtMiembroId_Miembro)) : null);
            entity.setProducto((FacesUtils.checkInteger(txtProductoId_Producto) != null)
                ? businessDelegatorView.getProducto(FacesUtils.checkInteger(
                        txtProductoId_Producto)) : null);
            entity.setServicio((FacesUtils.checkInteger(txtServicioId_Servicio) != null)
                ? businessDelegatorView.getServicio(FacesUtils.checkInteger(
                        txtServicioId_Servicio)) : null);
            businessDelegatorView.updateEntrada(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedEntrada = (EntradaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedEntrada"));

            Integer entradaId = new Integer(selectedEntrada.getEntradaId());
            entity = businessDelegatorView.getEntrada(entradaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer entradaId = FacesUtils.checkInteger(txtEntradaId);
            entity = businessDelegatorView.getEntrada(entradaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteEntrada(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String actionDeleteDataTableEditable(ActionEvent evt) {
        try {
            selectedEntrada = (EntradaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedEntrada"));

            Integer entradaId = new Integer(selectedEntrada.getEntradaId());
            entity = businessDelegatorView.getEntrada(entradaId);
            businessDelegatorView.deleteEntrada(entity);
            data.remove(selectedEntrada);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String entradaActivo,
        Date entradaFechaCreacion, String entradaFinalizado, Integer entradaId,
        Integer clienteId_Cliente, Integer colaboradorId_Colaborador,
        Integer miembroId_Miembro, Integer productoId_Producto,
        Integer servicioId_Servicio) throws Exception {
        try {
            entity.setEntradaActivo(FacesUtils.checkString(entradaActivo));
            entity.setEntradaFechaCreacion(FacesUtils.checkDate(
                    entradaFechaCreacion));
            entity.setEntradaFinalizado(FacesUtils.checkString(
                    entradaFinalizado));
            businessDelegatorView.updateEntrada(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EntradaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEntradaActivo() {
        return txtEntradaActivo;
    }

    public void setTxtEntradaActivo(InputText txtEntradaActivo) {
        this.txtEntradaActivo = txtEntradaActivo;
    }

    public InputText getTxtEntradaFinalizado() {
        return txtEntradaFinalizado;
    }

    public void setTxtEntradaFinalizado(InputText txtEntradaFinalizado) {
        this.txtEntradaFinalizado = txtEntradaFinalizado;
    }

    public InputText getTxtClienteId_Cliente() {
        return txtClienteId_Cliente;
    }

    public void setTxtClienteId_Cliente(InputText txtClienteId_Cliente) {
        this.txtClienteId_Cliente = txtClienteId_Cliente;
    }

    public InputText getTxtColaboradorId_Colaborador() {
        return txtColaboradorId_Colaborador;
    }

    public void setTxtColaboradorId_Colaborador(
        InputText txtColaboradorId_Colaborador) {
        this.txtColaboradorId_Colaborador = txtColaboradorId_Colaborador;
    }

    public InputText getTxtMiembroId_Miembro() {
        return txtMiembroId_Miembro;
    }

    public void setTxtMiembroId_Miembro(InputText txtMiembroId_Miembro) {
        this.txtMiembroId_Miembro = txtMiembroId_Miembro;
    }

    public InputText getTxtProductoId_Producto() {
        return txtProductoId_Producto;
    }

    public void setTxtProductoId_Producto(InputText txtProductoId_Producto) {
        this.txtProductoId_Producto = txtProductoId_Producto;
    }

    public InputText getTxtServicioId_Servicio() {
        return txtServicioId_Servicio;
    }

    public void setTxtServicioId_Servicio(InputText txtServicioId_Servicio) {
        this.txtServicioId_Servicio = txtServicioId_Servicio;
    }

    public Calendar getTxtEntradaFechaCreacion() {
        return txtEntradaFechaCreacion;
    }

    public void setTxtEntradaFechaCreacion(Calendar txtEntradaFechaCreacion) {
        this.txtEntradaFechaCreacion = txtEntradaFechaCreacion;
    }

    public InputText getTxtEntradaId() {
        return txtEntradaId;
    }

    public void setTxtEntradaId(InputText txtEntradaId) {
        this.txtEntradaId = txtEntradaId;
    }

    public List<EntradaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEntrada();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EntradaDTO> entradaDTO) {
        this.data = entradaDTO;
    }

    public EntradaDTO getSelectedEntrada() {
        return selectedEntrada;
    }

    public void setSelectedEntrada(EntradaDTO entrada) {
        this.selectedEntrada = entrada;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public IBusinessDelegatorView getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        IBusinessDelegatorView businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
