package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.EgresoDTO;

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
public class EgresoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EgresoView.class);
    private InputText txtEgresoValor;
    private InputText txtClaseTipoId_ClaseTipo;
    private InputText txtEgresoId;
    private Calendar txtEgresoFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EgresoDTO> data;
    private EgresoDTO selectedEgreso;
    private Egreso entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public EgresoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            EgresoDTO egresoDTO = (EgresoDTO) e.getObject();

            if (txtEgresoValor == null) {
                txtEgresoValor = new InputText();
            }

            txtEgresoValor.setValue(egresoDTO.getEgresoValor());

            if (txtClaseTipoId_ClaseTipo == null) {
                txtClaseTipoId_ClaseTipo = new InputText();
            }

            txtClaseTipoId_ClaseTipo.setValue(egresoDTO.getClaseTipoId_ClaseTipo());

            if (txtEgresoId == null) {
                txtEgresoId = new InputText();
            }

            txtEgresoId.setValue(egresoDTO.getEgresoId());

            if (txtEgresoFecha == null) {
                txtEgresoFecha = new Calendar();
            }

            txtEgresoFecha.setValue(egresoDTO.getEgresoFecha());

            Integer egresoId = FacesUtils.checkInteger(txtEgresoId);
            entity = businessDelegatorView.getEgreso(egresoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedEgreso = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedEgreso = null;

        if (txtEgresoValor != null) {
            txtEgresoValor.setValue(null);
            txtEgresoValor.setDisabled(true);
        }

        if (txtClaseTipoId_ClaseTipo != null) {
            txtClaseTipoId_ClaseTipo.setValue(null);
            txtClaseTipoId_ClaseTipo.setDisabled(true);
        }

        if (txtEgresoFecha != null) {
            txtEgresoFecha.setValue(null);
            txtEgresoFecha.setDisabled(true);
        }

        if (txtEgresoId != null) {
            txtEgresoId.setValue(null);
            txtEgresoId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtEgresoFecha() {
        Date inputDate = (Date) txtEgresoFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer egresoId = FacesUtils.checkInteger(txtEgresoId);
            entity = (egresoId != null)
                ? businessDelegatorView.getEgreso(egresoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEgresoValor.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtEgresoFecha.setDisabled(false);
            txtEgresoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEgresoFecha.setValue(entity.getEgresoFecha());
            txtEgresoFecha.setDisabled(false);
            txtEgresoValor.setValue(entity.getEgresoValor());
            txtEgresoValor.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setValue(entity.getClaseTipo()
                                                    .getClaseTipoId());
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtEgresoId.setValue(entity.getEgresoId());
            txtEgresoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedEgreso = (EgresoDTO) (evt.getComponent().getAttributes()
                                         .get("selectedEgreso"));
        txtEgresoFecha.setValue(selectedEgreso.getEgresoFecha());
        txtEgresoFecha.setDisabled(false);
        txtEgresoValor.setValue(selectedEgreso.getEgresoValor());
        txtEgresoValor.setDisabled(false);
        txtClaseTipoId_ClaseTipo.setValue(selectedEgreso.getClaseTipoId_ClaseTipo());
        txtClaseTipoId_ClaseTipo.setDisabled(false);
        txtEgresoId.setValue(selectedEgreso.getEgresoId());
        txtEgresoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedEgreso == null) && (entity == null)) {
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
            entity = new Egreso();

            Integer egresoId = FacesUtils.checkInteger(txtEgresoId);

            entity.setEgresoFecha(FacesUtils.checkDate(txtEgresoFecha));
            entity.setEgresoId(egresoId);
            entity.setEgresoValor(FacesUtils.checkDouble(txtEgresoValor));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            businessDelegatorView.saveEgreso(entity);
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
                Integer egresoId = new Integer(selectedEgreso.getEgresoId());
                entity = businessDelegatorView.getEgreso(egresoId);
            }

            entity.setEgresoFecha(FacesUtils.checkDate(txtEgresoFecha));
            entity.setEgresoValor(FacesUtils.checkDouble(txtEgresoValor));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            businessDelegatorView.updateEgreso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedEgreso = (EgresoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedEgreso"));

            Integer egresoId = new Integer(selectedEgreso.getEgresoId());
            entity = businessDelegatorView.getEgreso(egresoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer egresoId = FacesUtils.checkInteger(txtEgresoId);
            entity = businessDelegatorView.getEgreso(egresoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteEgreso(entity);
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
            selectedEgreso = (EgresoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedEgreso"));

            Integer egresoId = new Integer(selectedEgreso.getEgresoId());
            entity = businessDelegatorView.getEgreso(egresoId);
            businessDelegatorView.deleteEgreso(entity);
            data.remove(selectedEgreso);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Date egresoFecha, Integer egresoId,
        Double egresoValor, Integer claseTipoId_ClaseTipo)
        throws Exception {
        try {
            entity.setEgresoFecha(FacesUtils.checkDate(egresoFecha));
            entity.setEgresoValor(FacesUtils.checkDouble(egresoValor));
            businessDelegatorView.updateEgreso(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EgresoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEgresoValor() {
        return txtEgresoValor;
    }

    public void setTxtEgresoValor(InputText txtEgresoValor) {
        this.txtEgresoValor = txtEgresoValor;
    }

    public InputText getTxtClaseTipoId_ClaseTipo() {
        return txtClaseTipoId_ClaseTipo;
    }

    public void setTxtClaseTipoId_ClaseTipo(InputText txtClaseTipoId_ClaseTipo) {
        this.txtClaseTipoId_ClaseTipo = txtClaseTipoId_ClaseTipo;
    }

    public Calendar getTxtEgresoFecha() {
        return txtEgresoFecha;
    }

    public void setTxtEgresoFecha(Calendar txtEgresoFecha) {
        this.txtEgresoFecha = txtEgresoFecha;
    }

    public InputText getTxtEgresoId() {
        return txtEgresoId;
    }

    public void setTxtEgresoId(InputText txtEgresoId) {
        this.txtEgresoId = txtEgresoId;
    }

    public List<EgresoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEgreso();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EgresoDTO> egresoDTO) {
        this.data = egresoDTO;
    }

    public EgresoDTO getSelectedEgreso() {
        return selectedEgreso;
    }

    public void setSelectedEgreso(EgresoDTO egreso) {
        this.selectedEgreso = egreso;
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
