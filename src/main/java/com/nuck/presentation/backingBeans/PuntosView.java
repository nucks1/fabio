package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.PuntosDTO;

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
public class PuntosView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PuntosView.class);
    private InputText txtPuntosPuntos;
    private InputText txtClaseTipoId_ClaseTipo;
    private InputText txtPuntosId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PuntosDTO> data;
    private PuntosDTO selectedPuntos;
    private Puntos entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PuntosView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PuntosDTO puntosDTO = (PuntosDTO) e.getObject();

            if (txtPuntosPuntos == null) {
                txtPuntosPuntos = new InputText();
            }

            txtPuntosPuntos.setValue(puntosDTO.getPuntosPuntos());

            if (txtClaseTipoId_ClaseTipo == null) {
                txtClaseTipoId_ClaseTipo = new InputText();
            }

            txtClaseTipoId_ClaseTipo.setValue(puntosDTO.getClaseTipoId_ClaseTipo());

            if (txtPuntosId == null) {
                txtPuntosId = new InputText();
            }

            txtPuntosId.setValue(puntosDTO.getPuntosId());

            Integer puntosId = FacesUtils.checkInteger(txtPuntosId);
            entity = businessDelegatorView.getPuntos(puntosId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedPuntos = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPuntos = null;

        if (txtPuntosPuntos != null) {
            txtPuntosPuntos.setValue(null);
            txtPuntosPuntos.setDisabled(true);
        }

        if (txtClaseTipoId_ClaseTipo != null) {
            txtClaseTipoId_ClaseTipo.setValue(null);
            txtClaseTipoId_ClaseTipo.setDisabled(true);
        }

        if (txtPuntosId != null) {
            txtPuntosId.setValue(null);
            txtPuntosId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer puntosId = FacesUtils.checkInteger(txtPuntosId);
            entity = (puntosId != null)
                ? businessDelegatorView.getPuntos(puntosId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtPuntosPuntos.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtPuntosId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtPuntosPuntos.setValue(entity.getPuntosPuntos());
            txtPuntosPuntos.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setValue(entity.getClaseTipo()
                                                    .getClaseTipoId());
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtPuntosId.setValue(entity.getPuntosId());
            txtPuntosId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPuntos = (PuntosDTO) (evt.getComponent().getAttributes()
                                         .get("selectedPuntos"));
        txtPuntosPuntos.setValue(selectedPuntos.getPuntosPuntos());
        txtPuntosPuntos.setDisabled(false);
        txtClaseTipoId_ClaseTipo.setValue(selectedPuntos.getClaseTipoId_ClaseTipo());
        txtClaseTipoId_ClaseTipo.setDisabled(false);
        txtPuntosId.setValue(selectedPuntos.getPuntosId());
        txtPuntosId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPuntos == null) && (entity == null)) {
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
            entity = new Puntos();

            Integer puntosId = FacesUtils.checkInteger(txtPuntosId);

            entity.setPuntosId(puntosId);
            entity.setPuntosPuntos(FacesUtils.checkInteger(txtPuntosPuntos));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            businessDelegatorView.savePuntos(entity);
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
                Integer puntosId = new Integer(selectedPuntos.getPuntosId());
                entity = businessDelegatorView.getPuntos(puntosId);
            }

            entity.setPuntosPuntos(FacesUtils.checkInteger(txtPuntosPuntos));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            businessDelegatorView.updatePuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPuntos = (PuntosDTO) (evt.getComponent().getAttributes()
                                             .get("selectedPuntos"));

            Integer puntosId = new Integer(selectedPuntos.getPuntosId());
            entity = businessDelegatorView.getPuntos(puntosId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer puntosId = FacesUtils.checkInteger(txtPuntosId);
            entity = businessDelegatorView.getPuntos(puntosId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePuntos(entity);
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
            selectedPuntos = (PuntosDTO) (evt.getComponent().getAttributes()
                                             .get("selectedPuntos"));

            Integer puntosId = new Integer(selectedPuntos.getPuntosId());
            entity = businessDelegatorView.getPuntos(puntosId);
            businessDelegatorView.deletePuntos(entity);
            data.remove(selectedPuntos);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer puntosId, Integer puntosPuntos,
        Integer claseTipoId_ClaseTipo) throws Exception {
        try {
            entity.setPuntosPuntos(FacesUtils.checkInteger(puntosPuntos));
            businessDelegatorView.updatePuntos(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PuntosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtPuntosPuntos() {
        return txtPuntosPuntos;
    }

    public void setTxtPuntosPuntos(InputText txtPuntosPuntos) {
        this.txtPuntosPuntos = txtPuntosPuntos;
    }

    public InputText getTxtClaseTipoId_ClaseTipo() {
        return txtClaseTipoId_ClaseTipo;
    }

    public void setTxtClaseTipoId_ClaseTipo(InputText txtClaseTipoId_ClaseTipo) {
        this.txtClaseTipoId_ClaseTipo = txtClaseTipoId_ClaseTipo;
    }

    public InputText getTxtPuntosId() {
        return txtPuntosId;
    }

    public void setTxtPuntosId(InputText txtPuntosId) {
        this.txtPuntosId = txtPuntosId;
    }

    public List<PuntosDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPuntos();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PuntosDTO> puntosDTO) {
        this.data = puntosDTO;
    }

    public PuntosDTO getSelectedPuntos() {
        return selectedPuntos;
    }

    public void setSelectedPuntos(PuntosDTO puntos) {
        this.selectedPuntos = puntos;
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
