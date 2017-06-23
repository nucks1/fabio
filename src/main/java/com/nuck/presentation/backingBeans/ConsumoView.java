package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ConsumoDTO;

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
public class ConsumoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ConsumoView.class);
    private InputText txtConsumoTotalIngreso;
    private InputText txtConsumoId;
    private Calendar txtConsumoFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ConsumoDTO> data;
    private ConsumoDTO selectedConsumo;
    private Consumo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ConsumoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ConsumoDTO consumoDTO = (ConsumoDTO) e.getObject();

            if (txtConsumoTotalIngreso == null) {
                txtConsumoTotalIngreso = new InputText();
            }

            txtConsumoTotalIngreso.setValue(consumoDTO.getConsumoTotalIngreso());

            if (txtConsumoId == null) {
                txtConsumoId = new InputText();
            }

            txtConsumoId.setValue(consumoDTO.getConsumoId());

            if (txtConsumoFecha == null) {
                txtConsumoFecha = new Calendar();
            }

            txtConsumoFecha.setValue(consumoDTO.getConsumoFecha());

            Integer consumoId = FacesUtils.checkInteger(txtConsumoId);
            entity = businessDelegatorView.getConsumo(consumoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedConsumo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedConsumo = null;

        if (txtConsumoTotalIngreso != null) {
            txtConsumoTotalIngreso.setValue(null);
            txtConsumoTotalIngreso.setDisabled(true);
        }

        if (txtConsumoFecha != null) {
            txtConsumoFecha.setValue(null);
            txtConsumoFecha.setDisabled(true);
        }

        if (txtConsumoId != null) {
            txtConsumoId.setValue(null);
            txtConsumoId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtConsumoFecha() {
        Date inputDate = (Date) txtConsumoFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer consumoId = FacesUtils.checkInteger(txtConsumoId);
            entity = (consumoId != null)
                ? businessDelegatorView.getConsumo(consumoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtConsumoTotalIngreso.setDisabled(false);
            txtConsumoFecha.setDisabled(false);
            txtConsumoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtConsumoFecha.setValue(entity.getConsumoFecha());
            txtConsumoFecha.setDisabled(false);
            txtConsumoTotalIngreso.setValue(entity.getConsumoTotalIngreso());
            txtConsumoTotalIngreso.setDisabled(false);
            txtConsumoId.setValue(entity.getConsumoId());
            txtConsumoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedConsumo = (ConsumoDTO) (evt.getComponent().getAttributes()
                                           .get("selectedConsumo"));
        txtConsumoFecha.setValue(selectedConsumo.getConsumoFecha());
        txtConsumoFecha.setDisabled(false);
        txtConsumoTotalIngreso.setValue(selectedConsumo.getConsumoTotalIngreso());
        txtConsumoTotalIngreso.setDisabled(false);
        txtConsumoId.setValue(selectedConsumo.getConsumoId());
        txtConsumoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedConsumo == null) && (entity == null)) {
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
            entity = new Consumo();

            Integer consumoId = FacesUtils.checkInteger(txtConsumoId);

            entity.setConsumoFecha(FacesUtils.checkDate(txtConsumoFecha));
            entity.setConsumoId(consumoId);
            entity.setConsumoTotalIngreso(FacesUtils.checkDouble(
                    txtConsumoTotalIngreso));
            businessDelegatorView.saveConsumo(entity);
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
                Integer consumoId = new Integer(selectedConsumo.getConsumoId());
                entity = businessDelegatorView.getConsumo(consumoId);
            }

            entity.setConsumoFecha(FacesUtils.checkDate(txtConsumoFecha));
            entity.setConsumoTotalIngreso(FacesUtils.checkDouble(
                    txtConsumoTotalIngreso));
            businessDelegatorView.updateConsumo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedConsumo = (ConsumoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedConsumo"));

            Integer consumoId = new Integer(selectedConsumo.getConsumoId());
            entity = businessDelegatorView.getConsumo(consumoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer consumoId = FacesUtils.checkInteger(txtConsumoId);
            entity = businessDelegatorView.getConsumo(consumoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteConsumo(entity);
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
            selectedConsumo = (ConsumoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedConsumo"));

            Integer consumoId = new Integer(selectedConsumo.getConsumoId());
            entity = businessDelegatorView.getConsumo(consumoId);
            businessDelegatorView.deleteConsumo(entity);
            data.remove(selectedConsumo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date consumoFecha, Integer consumoId,
        Double consumoTotalIngreso) throws Exception {
        try {
            entity.setConsumoFecha(FacesUtils.checkDate(consumoFecha));
            entity.setConsumoTotalIngreso(FacesUtils.checkDouble(
                    consumoTotalIngreso));
            businessDelegatorView.updateConsumo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ConsumoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtConsumoTotalIngreso() {
        return txtConsumoTotalIngreso;
    }

    public void setTxtConsumoTotalIngreso(InputText txtConsumoTotalIngreso) {
        this.txtConsumoTotalIngreso = txtConsumoTotalIngreso;
    }

    public Calendar getTxtConsumoFecha() {
        return txtConsumoFecha;
    }

    public void setTxtConsumoFecha(Calendar txtConsumoFecha) {
        this.txtConsumoFecha = txtConsumoFecha;
    }

    public InputText getTxtConsumoId() {
        return txtConsumoId;
    }

    public void setTxtConsumoId(InputText txtConsumoId) {
        this.txtConsumoId = txtConsumoId;
    }

    public List<ConsumoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataConsumo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ConsumoDTO> consumoDTO) {
        this.data = consumoDTO;
    }

    public ConsumoDTO getSelectedConsumo() {
        return selectedConsumo;
    }

    public void setSelectedConsumo(ConsumoDTO consumo) {
        this.selectedConsumo = consumo;
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
