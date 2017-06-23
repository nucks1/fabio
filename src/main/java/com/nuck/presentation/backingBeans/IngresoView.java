package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.IngresoDTO;

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
public class IngresoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(IngresoView.class);
    private InputText txtConsumoId_Consumo;
    private InputText txtMiembroId_Miembro;
    private InputText txtProductoId_Producto;
    private InputText txtServicioId_Servicio;
    private InputText txtIngresoId;
    private Calendar txtIngresoFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<IngresoDTO> data;
    private IngresoDTO selectedIngreso;
    private Ingreso entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public IngresoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            IngresoDTO ingresoDTO = (IngresoDTO) e.getObject();

            if (txtConsumoId_Consumo == null) {
                txtConsumoId_Consumo = new InputText();
            }

            txtConsumoId_Consumo.setValue(ingresoDTO.getConsumoId_Consumo());

            if (txtMiembroId_Miembro == null) {
                txtMiembroId_Miembro = new InputText();
            }

            txtMiembroId_Miembro.setValue(ingresoDTO.getMiembroId_Miembro());

            if (txtProductoId_Producto == null) {
                txtProductoId_Producto = new InputText();
            }

            txtProductoId_Producto.setValue(ingresoDTO.getProductoId_Producto());

            if (txtServicioId_Servicio == null) {
                txtServicioId_Servicio = new InputText();
            }

            txtServicioId_Servicio.setValue(ingresoDTO.getServicioId_Servicio());

            if (txtIngresoId == null) {
                txtIngresoId = new InputText();
            }

            txtIngresoId.setValue(ingresoDTO.getIngresoId());

            if (txtIngresoFecha == null) {
                txtIngresoFecha = new Calendar();
            }

            txtIngresoFecha.setValue(ingresoDTO.getIngresoFecha());

            Integer ingresoId = FacesUtils.checkInteger(txtIngresoId);
            entity = businessDelegatorView.getIngreso(ingresoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedIngreso = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedIngreso = null;

        if (txtConsumoId_Consumo != null) {
            txtConsumoId_Consumo.setValue(null);
            txtConsumoId_Consumo.setDisabled(true);
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

        if (txtIngresoFecha != null) {
            txtIngresoFecha.setValue(null);
            txtIngresoFecha.setDisabled(true);
        }

        if (txtIngresoId != null) {
            txtIngresoId.setValue(null);
            txtIngresoId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtIngresoFecha() {
        Date inputDate = (Date) txtIngresoFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer ingresoId = FacesUtils.checkInteger(txtIngresoId);
            entity = (ingresoId != null)
                ? businessDelegatorView.getIngreso(ingresoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsumoId_Consumo.setDisabled(false);
            txtMiembroId_Miembro.setDisabled(false);
            txtProductoId_Producto.setDisabled(false);
            txtServicioId_Servicio.setDisabled(false);
            txtIngresoFecha.setDisabled(false);
            txtIngresoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtIngresoFecha.setValue(entity.getIngresoFecha());
            txtIngresoFecha.setDisabled(false);
            txtConsumoId_Consumo.setValue(entity.getConsumo().getConsumoId());
            txtConsumoId_Consumo.setDisabled(false);
            txtMiembroId_Miembro.setValue(entity.getMiembro().getMiembroId());
            txtMiembroId_Miembro.setDisabled(false);
            txtProductoId_Producto.setValue(entity.getProducto().getProductoId());
            txtProductoId_Producto.setDisabled(false);
            txtServicioId_Servicio.setValue(entity.getServicio().getServicioId());
            txtServicioId_Servicio.setDisabled(false);
            txtIngresoId.setValue(entity.getIngresoId());
            txtIngresoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedIngreso = (IngresoDTO) (evt.getComponent().getAttributes()
                                           .get("selectedIngreso"));
        txtIngresoFecha.setValue(selectedIngreso.getIngresoFecha());
        txtIngresoFecha.setDisabled(false);
        txtConsumoId_Consumo.setValue(selectedIngreso.getConsumoId_Consumo());
        txtConsumoId_Consumo.setDisabled(false);
        txtMiembroId_Miembro.setValue(selectedIngreso.getMiembroId_Miembro());
        txtMiembroId_Miembro.setDisabled(false);
        txtProductoId_Producto.setValue(selectedIngreso.getProductoId_Producto());
        txtProductoId_Producto.setDisabled(false);
        txtServicioId_Servicio.setValue(selectedIngreso.getServicioId_Servicio());
        txtServicioId_Servicio.setDisabled(false);
        txtIngresoId.setValue(selectedIngreso.getIngresoId());
        txtIngresoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedIngreso == null) && (entity == null)) {
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
            entity = new Ingreso();

            Integer ingresoId = FacesUtils.checkInteger(txtIngresoId);

            entity.setIngresoFecha(FacesUtils.checkDate(txtIngresoFecha));
            entity.setIngresoId(ingresoId);
            entity.setConsumo((FacesUtils.checkInteger(txtConsumoId_Consumo) != null)
                ? businessDelegatorView.getConsumo(FacesUtils.checkInteger(
                        txtConsumoId_Consumo)) : null);
            entity.setMiembro((FacesUtils.checkInteger(txtMiembroId_Miembro) != null)
                ? businessDelegatorView.getMiembro(FacesUtils.checkInteger(
                        txtMiembroId_Miembro)) : null);
            entity.setProducto((FacesUtils.checkInteger(txtProductoId_Producto) != null)
                ? businessDelegatorView.getProducto(FacesUtils.checkInteger(
                        txtProductoId_Producto)) : null);
            entity.setServicio((FacesUtils.checkInteger(txtServicioId_Servicio) != null)
                ? businessDelegatorView.getServicio(FacesUtils.checkInteger(
                        txtServicioId_Servicio)) : null);
            businessDelegatorView.saveIngreso(entity);
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
                Integer ingresoId = new Integer(selectedIngreso.getIngresoId());
                entity = businessDelegatorView.getIngreso(ingresoId);
            }

            entity.setIngresoFecha(FacesUtils.checkDate(txtIngresoFecha));
            entity.setConsumo((FacesUtils.checkInteger(txtConsumoId_Consumo) != null)
                ? businessDelegatorView.getConsumo(FacesUtils.checkInteger(
                        txtConsumoId_Consumo)) : null);
            entity.setMiembro((FacesUtils.checkInteger(txtMiembroId_Miembro) != null)
                ? businessDelegatorView.getMiembro(FacesUtils.checkInteger(
                        txtMiembroId_Miembro)) : null);
            entity.setProducto((FacesUtils.checkInteger(txtProductoId_Producto) != null)
                ? businessDelegatorView.getProducto(FacesUtils.checkInteger(
                        txtProductoId_Producto)) : null);
            entity.setServicio((FacesUtils.checkInteger(txtServicioId_Servicio) != null)
                ? businessDelegatorView.getServicio(FacesUtils.checkInteger(
                        txtServicioId_Servicio)) : null);
            businessDelegatorView.updateIngreso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedIngreso = (IngresoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedIngreso"));

            Integer ingresoId = new Integer(selectedIngreso.getIngresoId());
            entity = businessDelegatorView.getIngreso(ingresoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer ingresoId = FacesUtils.checkInteger(txtIngresoId);
            entity = businessDelegatorView.getIngreso(ingresoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteIngreso(entity);
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
            selectedIngreso = (IngresoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedIngreso"));

            Integer ingresoId = new Integer(selectedIngreso.getIngresoId());
            entity = businessDelegatorView.getIngreso(ingresoId);
            businessDelegatorView.deleteIngreso(entity);
            data.remove(selectedIngreso);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date ingresoFecha, Integer ingresoId,
        Integer consumoId_Consumo, Integer miembroId_Miembro,
        Integer productoId_Producto, Integer servicioId_Servicio)
        throws Exception {
        try {
            entity.setIngresoFecha(FacesUtils.checkDate(ingresoFecha));
            businessDelegatorView.updateIngreso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("IngresoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsumoId_Consumo() {
        return txtConsumoId_Consumo;
    }

    public void setTxtConsumoId_Consumo(InputText txtConsumoId_Consumo) {
        this.txtConsumoId_Consumo = txtConsumoId_Consumo;
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

    public Calendar getTxtIngresoFecha() {
        return txtIngresoFecha;
    }

    public void setTxtIngresoFecha(Calendar txtIngresoFecha) {
        this.txtIngresoFecha = txtIngresoFecha;
    }

    public InputText getTxtIngresoId() {
        return txtIngresoId;
    }

    public void setTxtIngresoId(InputText txtIngresoId) {
        this.txtIngresoId = txtIngresoId;
    }

    public List<IngresoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataIngreso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<IngresoDTO> ingresoDTO) {
        this.data = ingresoDTO;
    }

    public IngresoDTO getSelectedIngreso() {
        return selectedIngreso;
    }

    public void setSelectedIngreso(IngresoDTO ingreso) {
        this.selectedIngreso = ingreso;
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
