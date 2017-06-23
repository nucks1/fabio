package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.TipoDTO;

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
public class TipoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoView.class);
    private InputText txtTipoClase;
    private InputText txtTipoDescripcion;
    private InputText txtTipoRef;
    private InputText txtTipoId;
    private Calendar txtTipoFechaCreacrion;
    private Calendar txtTipoFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoDTO> data;
    private TipoDTO selectedTipo;
    private Tipo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public TipoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            TipoDTO tipoDTO = (TipoDTO) e.getObject();

            if (txtTipoClase == null) {
                txtTipoClase = new InputText();
            }

            txtTipoClase.setValue(tipoDTO.getTipoClase());

            if (txtTipoDescripcion == null) {
                txtTipoDescripcion = new InputText();
            }

            txtTipoDescripcion.setValue(tipoDTO.getTipoDescripcion());

            if (txtTipoRef == null) {
                txtTipoRef = new InputText();
            }

            txtTipoRef.setValue(tipoDTO.getTipoRef());

            if (txtTipoId == null) {
                txtTipoId = new InputText();
            }

            txtTipoId.setValue(tipoDTO.getTipoId());

            if (txtTipoFechaCreacrion == null) {
                txtTipoFechaCreacrion = new Calendar();
            }

            txtTipoFechaCreacrion.setValue(tipoDTO.getTipoFechaCreacrion());

            if (txtTipoFechaModificacion == null) {
                txtTipoFechaModificacion = new Calendar();
            }

            txtTipoFechaModificacion.setValue(tipoDTO.getTipoFechaModificacion());

            Integer tipoId = FacesUtils.checkInteger(txtTipoId);
            entity = businessDelegatorView.getTipo(tipoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedTipo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipo = null;

        if (txtTipoClase != null) {
            txtTipoClase.setValue(null);
            txtTipoClase.setDisabled(true);
        }

        if (txtTipoDescripcion != null) {
            txtTipoDescripcion.setValue(null);
            txtTipoDescripcion.setDisabled(true);
        }

        if (txtTipoRef != null) {
            txtTipoRef.setValue(null);
            txtTipoRef.setDisabled(true);
        }

        if (txtTipoFechaCreacrion != null) {
            txtTipoFechaCreacrion.setValue(null);
            txtTipoFechaCreacrion.setDisabled(true);
        }

        if (txtTipoFechaModificacion != null) {
            txtTipoFechaModificacion.setValue(null);
            txtTipoFechaModificacion.setDisabled(true);
        }

        if (txtTipoId != null) {
            txtTipoId.setValue(null);
            txtTipoId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtTipoFechaCreacrion() {
        Date inputDate = (Date) txtTipoFechaCreacrion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtTipoFechaModificacion() {
        Date inputDate = (Date) txtTipoFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer tipoId = FacesUtils.checkInteger(txtTipoId);
            entity = (tipoId != null) ? businessDelegatorView.getTipo(tipoId)
                                      : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtTipoClase.setDisabled(false);
            txtTipoDescripcion.setDisabled(false);
            txtTipoRef.setDisabled(false);
            txtTipoFechaCreacrion.setDisabled(false);
            txtTipoFechaModificacion.setDisabled(false);
            txtTipoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtTipoClase.setValue(entity.getTipoClase());
            txtTipoClase.setDisabled(false);
            txtTipoDescripcion.setValue(entity.getTipoDescripcion());
            txtTipoDescripcion.setDisabled(false);
            txtTipoFechaCreacrion.setValue(entity.getTipoFechaCreacrion());
            txtTipoFechaCreacrion.setDisabled(false);
            txtTipoFechaModificacion.setValue(entity.getTipoFechaModificacion());
            txtTipoFechaModificacion.setDisabled(false);
            txtTipoRef.setValue(entity.getTipoRef());
            txtTipoRef.setDisabled(false);
            txtTipoId.setValue(entity.getTipoId());
            txtTipoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipo = (TipoDTO) (evt.getComponent().getAttributes()
                                     .get("selectedTipo"));
        txtTipoClase.setValue(selectedTipo.getTipoClase());
        txtTipoClase.setDisabled(false);
        txtTipoDescripcion.setValue(selectedTipo.getTipoDescripcion());
        txtTipoDescripcion.setDisabled(false);
        txtTipoFechaCreacrion.setValue(selectedTipo.getTipoFechaCreacrion());
        txtTipoFechaCreacrion.setDisabled(false);
        txtTipoFechaModificacion.setValue(selectedTipo.getTipoFechaModificacion());
        txtTipoFechaModificacion.setDisabled(false);
        txtTipoRef.setValue(selectedTipo.getTipoRef());
        txtTipoRef.setDisabled(false);
        txtTipoId.setValue(selectedTipo.getTipoId());
        txtTipoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipo == null) && (entity == null)) {
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
            entity = new Tipo();

            Integer tipoId = FacesUtils.checkInteger(txtTipoId);

            entity.setTipoClase(FacesUtils.checkString(txtTipoClase));
            entity.setTipoDescripcion(FacesUtils.checkString(txtTipoDescripcion));
            entity.setTipoFechaCreacrion(FacesUtils.checkDate(
                    txtTipoFechaCreacrion));
            entity.setTipoFechaModificacion(FacesUtils.checkDate(
                    txtTipoFechaModificacion));
            entity.setTipoId(tipoId);
            entity.setTipoRef(FacesUtils.checkString(txtTipoRef));
            businessDelegatorView.saveTipo(entity);
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
                Integer tipoId = new Integer(selectedTipo.getTipoId());
                entity = businessDelegatorView.getTipo(tipoId);
            }

            entity.setTipoClase(FacesUtils.checkString(txtTipoClase));
            entity.setTipoDescripcion(FacesUtils.checkString(txtTipoDescripcion));
            entity.setTipoFechaCreacrion(FacesUtils.checkDate(
                    txtTipoFechaCreacrion));
            entity.setTipoFechaModificacion(FacesUtils.checkDate(
                    txtTipoFechaModificacion));
            entity.setTipoRef(FacesUtils.checkString(txtTipoRef));
            businessDelegatorView.updateTipo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipo = (TipoDTO) (evt.getComponent().getAttributes()
                                         .get("selectedTipo"));

            Integer tipoId = new Integer(selectedTipo.getTipoId());
            entity = businessDelegatorView.getTipo(tipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoId = FacesUtils.checkInteger(txtTipoId);
            entity = businessDelegatorView.getTipo(tipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipo(entity);
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
            selectedTipo = (TipoDTO) (evt.getComponent().getAttributes()
                                         .get("selectedTipo"));

            Integer tipoId = new Integer(selectedTipo.getTipoId());
            entity = businessDelegatorView.getTipo(tipoId);
            businessDelegatorView.deleteTipo(entity);
            data.remove(selectedTipo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String tipoClase, String tipoDescripcion,
        Date tipoFechaCreacrion, Date tipoFechaModificacion, Integer tipoId,
        String tipoRef) throws Exception {
        try {
            entity.setTipoClase(FacesUtils.checkString(tipoClase));
            entity.setTipoDescripcion(FacesUtils.checkString(tipoDescripcion));
            entity.setTipoFechaCreacrion(FacesUtils.checkDate(
                    tipoFechaCreacrion));
            entity.setTipoFechaModificacion(FacesUtils.checkDate(
                    tipoFechaModificacion));
            entity.setTipoRef(FacesUtils.checkString(tipoRef));
            businessDelegatorView.updateTipo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtTipoClase() {
        return txtTipoClase;
    }

    public void setTxtTipoClase(InputText txtTipoClase) {
        this.txtTipoClase = txtTipoClase;
    }

    public InputText getTxtTipoDescripcion() {
        return txtTipoDescripcion;
    }

    public void setTxtTipoDescripcion(InputText txtTipoDescripcion) {
        this.txtTipoDescripcion = txtTipoDescripcion;
    }

    public InputText getTxtTipoRef() {
        return txtTipoRef;
    }

    public void setTxtTipoRef(InputText txtTipoRef) {
        this.txtTipoRef = txtTipoRef;
    }

    public Calendar getTxtTipoFechaCreacrion() {
        return txtTipoFechaCreacrion;
    }

    public void setTxtTipoFechaCreacrion(Calendar txtTipoFechaCreacrion) {
        this.txtTipoFechaCreacrion = txtTipoFechaCreacrion;
    }

    public Calendar getTxtTipoFechaModificacion() {
        return txtTipoFechaModificacion;
    }

    public void setTxtTipoFechaModificacion(Calendar txtTipoFechaModificacion) {
        this.txtTipoFechaModificacion = txtTipoFechaModificacion;
    }

    public InputText getTxtTipoId() {
        return txtTipoId;
    }

    public void setTxtTipoId(InputText txtTipoId) {
        this.txtTipoId = txtTipoId;
    }

    public List<TipoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoDTO> tipoDTO) {
        this.data = tipoDTO;
    }

    public TipoDTO getSelectedTipo() {
        return selectedTipo;
    }

    public void setSelectedTipo(TipoDTO tipo) {
        this.selectedTipo = tipo;
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
