package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.SalidaDTO;

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
public class SalidaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SalidaView.class);
    private InputText txtClienteId_Cliente;
    private InputText txtColaboradorId_Colaborador;
    private InputText txtMiembroId_Miembro;
    private InputText txtProductoId_Producto;
    private InputText txtServicioId_Servicio;
    private InputText txtSalidaId;
    private Calendar txtSalidaFechaCreacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SalidaDTO> data;
    private SalidaDTO selectedSalida;
    private Salida entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public SalidaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            SalidaDTO salidaDTO = (SalidaDTO) e.getObject();

            if (txtClienteId_Cliente == null) {
                txtClienteId_Cliente = new InputText();
            }

            txtClienteId_Cliente.setValue(salidaDTO.getClienteId_Cliente());

            if (txtColaboradorId_Colaborador == null) {
                txtColaboradorId_Colaborador = new InputText();
            }

            txtColaboradorId_Colaborador.setValue(salidaDTO.getColaboradorId_Colaborador());

            if (txtMiembroId_Miembro == null) {
                txtMiembroId_Miembro = new InputText();
            }

            txtMiembroId_Miembro.setValue(salidaDTO.getMiembroId_Miembro());

            if (txtProductoId_Producto == null) {
                txtProductoId_Producto = new InputText();
            }

            txtProductoId_Producto.setValue(salidaDTO.getProductoId_Producto());

            if (txtServicioId_Servicio == null) {
                txtServicioId_Servicio = new InputText();
            }

            txtServicioId_Servicio.setValue(salidaDTO.getServicioId_Servicio());

            if (txtSalidaId == null) {
                txtSalidaId = new InputText();
            }

            txtSalidaId.setValue(salidaDTO.getSalidaId());

            if (txtSalidaFechaCreacion == null) {
                txtSalidaFechaCreacion = new Calendar();
            }

            txtSalidaFechaCreacion.setValue(salidaDTO.getSalidaFechaCreacion());

            Integer salidaId = FacesUtils.checkInteger(txtSalidaId);
            entity = businessDelegatorView.getSalida(salidaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedSalida = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSalida = null;

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

        if (txtSalidaFechaCreacion != null) {
            txtSalidaFechaCreacion.setValue(null);
            txtSalidaFechaCreacion.setDisabled(true);
        }

        if (txtSalidaId != null) {
            txtSalidaId.setValue(null);
            txtSalidaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtSalidaFechaCreacion() {
        Date inputDate = (Date) txtSalidaFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer salidaId = FacesUtils.checkInteger(txtSalidaId);
            entity = (salidaId != null)
                ? businessDelegatorView.getSalida(salidaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtClienteId_Cliente.setDisabled(false);
            txtColaboradorId_Colaborador.setDisabled(false);
            txtMiembroId_Miembro.setDisabled(false);
            txtProductoId_Producto.setDisabled(false);
            txtServicioId_Servicio.setDisabled(false);
            txtSalidaFechaCreacion.setDisabled(false);
            txtSalidaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtSalidaFechaCreacion.setValue(entity.getSalidaFechaCreacion());
            txtSalidaFechaCreacion.setDisabled(false);
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
            txtSalidaId.setValue(entity.getSalidaId());
            txtSalidaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSalida = (SalidaDTO) (evt.getComponent().getAttributes()
                                         .get("selectedSalida"));
        txtSalidaFechaCreacion.setValue(selectedSalida.getSalidaFechaCreacion());
        txtSalidaFechaCreacion.setDisabled(false);
        txtClienteId_Cliente.setValue(selectedSalida.getClienteId_Cliente());
        txtClienteId_Cliente.setDisabled(false);
        txtColaboradorId_Colaborador.setValue(selectedSalida.getColaboradorId_Colaborador());
        txtColaboradorId_Colaborador.setDisabled(false);
        txtMiembroId_Miembro.setValue(selectedSalida.getMiembroId_Miembro());
        txtMiembroId_Miembro.setDisabled(false);
        txtProductoId_Producto.setValue(selectedSalida.getProductoId_Producto());
        txtProductoId_Producto.setDisabled(false);
        txtServicioId_Servicio.setValue(selectedSalida.getServicioId_Servicio());
        txtServicioId_Servicio.setDisabled(false);
        txtSalidaId.setValue(selectedSalida.getSalidaId());
        txtSalidaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSalida == null) && (entity == null)) {
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
            entity = new Salida();

            Integer salidaId = FacesUtils.checkInteger(txtSalidaId);

            entity.setSalidaFechaCreacion(FacesUtils.checkDate(
                    txtSalidaFechaCreacion));
            entity.setSalidaId(salidaId);
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
            businessDelegatorView.saveSalida(entity);
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
                Integer salidaId = new Integer(selectedSalida.getSalidaId());
                entity = businessDelegatorView.getSalida(salidaId);
            }

            entity.setSalidaFechaCreacion(FacesUtils.checkDate(
                    txtSalidaFechaCreacion));
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
            businessDelegatorView.updateSalida(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSalida = (SalidaDTO) (evt.getComponent().getAttributes()
                                             .get("selectedSalida"));

            Integer salidaId = new Integer(selectedSalida.getSalidaId());
            entity = businessDelegatorView.getSalida(salidaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer salidaId = FacesUtils.checkInteger(txtSalidaId);
            entity = businessDelegatorView.getSalida(salidaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSalida(entity);
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
            selectedSalida = (SalidaDTO) (evt.getComponent().getAttributes()
                                             .get("selectedSalida"));

            Integer salidaId = new Integer(selectedSalida.getSalidaId());
            entity = businessDelegatorView.getSalida(salidaId);
            businessDelegatorView.deleteSalida(entity);
            data.remove(selectedSalida);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date salidaFechaCreacion,
        Integer salidaId, Integer clienteId_Cliente,
        Integer colaboradorId_Colaborador, Integer miembroId_Miembro,
        Integer productoId_Producto, Integer servicioId_Servicio)
        throws Exception {
        try {
            entity.setSalidaFechaCreacion(FacesUtils.checkDate(
                    salidaFechaCreacion));
            businessDelegatorView.updateSalida(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SalidaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
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

    public Calendar getTxtSalidaFechaCreacion() {
        return txtSalidaFechaCreacion;
    }

    public void setTxtSalidaFechaCreacion(Calendar txtSalidaFechaCreacion) {
        this.txtSalidaFechaCreacion = txtSalidaFechaCreacion;
    }

    public InputText getTxtSalidaId() {
        return txtSalidaId;
    }

    public void setTxtSalidaId(InputText txtSalidaId) {
        this.txtSalidaId = txtSalidaId;
    }

    public List<SalidaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSalida();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SalidaDTO> salidaDTO) {
        this.data = salidaDTO;
    }

    public SalidaDTO getSelectedSalida() {
        return selectedSalida;
    }

    public void setSelectedSalida(SalidaDTO salida) {
        this.selectedSalida = salida;
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
