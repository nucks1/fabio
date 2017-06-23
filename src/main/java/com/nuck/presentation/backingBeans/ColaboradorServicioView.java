package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ColaboradorServicioDTO;

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
public class ColaboradorServicioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ColaboradorServicioView.class);
    private InputText txtColaboradorId_Colaborador;
    private InputText txtServicioId_Servicio;
    private InputText txtColaboradorId;
    private InputText txtServicioId;
    private Calendar txtColaboradorServicioFechaFin;
    private Calendar txtColaboradorServicioFechaIni;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ColaboradorServicioDTO> data;
    private ColaboradorServicioDTO selectedColaboradorServicio;
    private ColaboradorServicio entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ColaboradorServicioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ColaboradorServicioDTO colaboradorServicioDTO = (ColaboradorServicioDTO) e.getObject();

            if (txtColaboradorId_Colaborador == null) {
                txtColaboradorId_Colaborador = new InputText();
            }

            txtColaboradorId_Colaborador.setValue(colaboradorServicioDTO.getColaboradorId_Colaborador());

            if (txtServicioId_Servicio == null) {
                txtServicioId_Servicio = new InputText();
            }

            txtServicioId_Servicio.setValue(colaboradorServicioDTO.getServicioId_Servicio());

            if (txtColaboradorId == null) {
                txtColaboradorId = new InputText();
            }

            txtColaboradorId.setValue(colaboradorServicioDTO.getColaboradorId());

            if (txtServicioId == null) {
                txtServicioId = new InputText();
            }

            txtServicioId.setValue(colaboradorServicioDTO.getServicioId());

            if (txtColaboradorServicioFechaFin == null) {
                txtColaboradorServicioFechaFin = new Calendar();
            }

            txtColaboradorServicioFechaFin.setValue(colaboradorServicioDTO.getColaboradorServicioFechaFin());

            if (txtColaboradorServicioFechaIni == null) {
                txtColaboradorServicioFechaIni = new Calendar();
            }

            txtColaboradorServicioFechaIni.setValue(colaboradorServicioDTO.getColaboradorServicioFechaIni());

            ColaboradorServicioId id = new ColaboradorServicioId();
            id.setColaboradorId((((txtColaboradorId.getValue()) == null) ||
                (txtColaboradorId.getValue()).equals("")) ? null
                                                          : FacesUtils.checkInteger(
                    txtColaboradorId));
            id.setServicioId((((txtServicioId.getValue()) == null) ||
                (txtServicioId.getValue()).equals("")) ? null
                                                       : FacesUtils.checkInteger(
                    txtServicioId));
            entity = businessDelegatorView.getColaboradorServicio(id);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedColaboradorServicio = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedColaboradorServicio = null;

        if (txtColaboradorId_Colaborador != null) {
            txtColaboradorId_Colaborador.setValue(null);
            txtColaboradorId_Colaborador.setDisabled(true);
        }

        if (txtServicioId_Servicio != null) {
            txtServicioId_Servicio.setValue(null);
            txtServicioId_Servicio.setDisabled(true);
        }

        if (txtColaboradorServicioFechaFin != null) {
            txtColaboradorServicioFechaFin.setValue(null);
            txtColaboradorServicioFechaFin.setDisabled(true);
        }

        if (txtColaboradorServicioFechaIni != null) {
            txtColaboradorServicioFechaIni.setValue(null);
            txtColaboradorServicioFechaIni.setDisabled(true);
        }

        if (txtColaboradorId != null) {
            txtColaboradorId.setValue(null);
            txtColaboradorId.setDisabled(false);
        }

        if (txtServicioId != null) {
            txtServicioId.setValue(null);
            txtServicioId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtColaboradorServicioFechaFin() {
        Date inputDate = (Date) txtColaboradorServicioFechaFin.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtColaboradorServicioFechaIni() {
        Date inputDate = (Date) txtColaboradorServicioFechaIni.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            ColaboradorServicioId id = new ColaboradorServicioId();
            id.setColaboradorId((((txtColaboradorId.getValue()) == null) ||
                (txtColaboradorId.getValue()).equals("")) ? null
                                                          : FacesUtils.checkInteger(
                    txtColaboradorId));
            id.setServicioId((((txtServicioId.getValue()) == null) ||
                (txtServicioId.getValue()).equals("")) ? null
                                                       : FacesUtils.checkInteger(
                    txtServicioId));
            entity = (id != null)
                ? businessDelegatorView.getColaboradorServicio(id) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtColaboradorId_Colaborador.setDisabled(false);
            txtServicioId_Servicio.setDisabled(false);
            txtColaboradorServicioFechaFin.setDisabled(false);
            txtColaboradorServicioFechaIni.setDisabled(false);
            txtColaboradorId.setDisabled(false);
            txtServicioId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtColaboradorServicioFechaFin.setValue(entity.getColaboradorServicioFechaFin());
            txtColaboradorServicioFechaFin.setDisabled(false);
            txtColaboradorServicioFechaIni.setValue(entity.getColaboradorServicioFechaIni());
            txtColaboradorServicioFechaIni.setDisabled(false);
            txtColaboradorId_Colaborador.setValue(entity.getColaborador()
                                                        .getColaboradorId());
            txtColaboradorId_Colaborador.setDisabled(false);
            txtServicioId_Servicio.setValue(entity.getServicio().getServicioId());
            txtServicioId_Servicio.setDisabled(false);
            txtColaboradorId.setValue(entity.getId().getColaboradorId());
            txtColaboradorId.setDisabled(true);
            txtServicioId.setValue(entity.getId().getServicioId());
            txtServicioId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedColaboradorServicio = (ColaboradorServicioDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedColaboradorServicio"));
        txtColaboradorServicioFechaFin.setValue(selectedColaboradorServicio.getColaboradorServicioFechaFin());
        txtColaboradorServicioFechaFin.setDisabled(false);
        txtColaboradorServicioFechaIni.setValue(selectedColaboradorServicio.getColaboradorServicioFechaIni());
        txtColaboradorServicioFechaIni.setDisabled(false);
        txtColaboradorId_Colaborador.setValue(selectedColaboradorServicio.getColaboradorId_Colaborador());
        txtColaboradorId_Colaborador.setDisabled(false);
        txtServicioId_Servicio.setValue(selectedColaboradorServicio.getServicioId_Servicio());
        txtServicioId_Servicio.setDisabled(false);
        txtColaboradorId.setValue(selectedColaboradorServicio.getColaboradorId());
        txtColaboradorId.setDisabled(true);
        txtServicioId.setValue(selectedColaboradorServicio.getServicioId());
        txtServicioId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedColaboradorServicio == null) && (entity == null)) {
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
            entity = new ColaboradorServicio();

            ColaboradorServicioId id = new ColaboradorServicioId();
            id.setColaboradorId((((txtColaboradorId.getValue()) == null) ||
                (txtColaboradorId.getValue()).equals("")) ? null
                                                          : FacesUtils.checkInteger(
                    txtColaboradorId));
            id.setServicioId((((txtServicioId.getValue()) == null) ||
                (txtServicioId.getValue()).equals("")) ? null
                                                       : FacesUtils.checkInteger(
                    txtServicioId));

            entity.setColaboradorServicioFechaFin(FacesUtils.checkDate(
                    txtColaboradorServicioFechaFin));
            entity.setColaboradorServicioFechaIni(FacesUtils.checkDate(
                    txtColaboradorServicioFechaIni));
            entity.setId(id);
            entity.setColaborador(businessDelegatorView.getColaborador(
                    entity.getId().getColaboradorId()));
            entity.setServicio(businessDelegatorView.getServicio(
                    entity.getId().getServicioId()));
            businessDelegatorView.saveColaboradorServicio(entity);
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
                ColaboradorServicioId id = new ColaboradorServicioId();
                id.setColaboradorId(selectedColaboradorServicio.getColaboradorId());
                id.setServicioId(selectedColaboradorServicio.getServicioId());
                entity = businessDelegatorView.getColaboradorServicio(id);
            }

            entity.setColaboradorServicioFechaFin(FacesUtils.checkDate(
                    txtColaboradorServicioFechaFin));
            entity.setColaboradorServicioFechaIni(FacesUtils.checkDate(
                    txtColaboradorServicioFechaIni));
            businessDelegatorView.updateColaboradorServicio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedColaboradorServicio = (ColaboradorServicioDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedColaboradorServicio"));

            ColaboradorServicioId id = new ColaboradorServicioId();
            id.setColaboradorId(selectedColaboradorServicio.getColaboradorId());
            id.setServicioId(selectedColaboradorServicio.getServicioId());
            entity = businessDelegatorView.getColaboradorServicio(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            ColaboradorServicioId id = new ColaboradorServicioId();
            id.setColaboradorId((((txtColaboradorId.getValue()) == null) ||
                (txtColaboradorId.getValue()).equals("")) ? null
                                                          : FacesUtils.checkInteger(
                    txtColaboradorId));
            id.setServicioId((((txtServicioId.getValue()) == null) ||
                (txtServicioId.getValue()).equals("")) ? null
                                                       : FacesUtils.checkInteger(
                    txtServicioId));
            entity = businessDelegatorView.getColaboradorServicio(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteColaboradorServicio(entity);
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
            selectedColaboradorServicio = (ColaboradorServicioDTO) (evt.getComponent()
                                                                       .getAttributes()
                                                                       .get("selectedColaboradorServicio"));

            ColaboradorServicioId id = new ColaboradorServicioId();
            id.setColaboradorId(selectedColaboradorServicio.getColaboradorId());
            id.setServicioId(selectedColaboradorServicio.getServicioId());
            entity = businessDelegatorView.getColaboradorServicio(id);
            businessDelegatorView.deleteColaboradorServicio(entity);
            data.remove(selectedColaboradorServicio);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer colaboradorId,
        Integer servicioId, Date colaboradorServicioFechaFin,
        Date colaboradorServicioFechaIni, Integer colaboradorId_Colaborador,
        Integer servicioId_Servicio) throws Exception {
        try {
            entity.setColaboradorServicioFechaFin(FacesUtils.checkDate(
                    colaboradorServicioFechaFin));
            entity.setColaboradorServicioFechaIni(FacesUtils.checkDate(
                    colaboradorServicioFechaIni));
            businessDelegatorView.updateColaboradorServicio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ColaboradorServicioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtColaboradorId_Colaborador() {
        return txtColaboradorId_Colaborador;
    }

    public void setTxtColaboradorId_Colaborador(
        InputText txtColaboradorId_Colaborador) {
        this.txtColaboradorId_Colaborador = txtColaboradorId_Colaborador;
    }

    public InputText getTxtServicioId_Servicio() {
        return txtServicioId_Servicio;
    }

    public void setTxtServicioId_Servicio(InputText txtServicioId_Servicio) {
        this.txtServicioId_Servicio = txtServicioId_Servicio;
    }

    public Calendar getTxtColaboradorServicioFechaFin() {
        return txtColaboradorServicioFechaFin;
    }

    public void setTxtColaboradorServicioFechaFin(
        Calendar txtColaboradorServicioFechaFin) {
        this.txtColaboradorServicioFechaFin = txtColaboradorServicioFechaFin;
    }

    public Calendar getTxtColaboradorServicioFechaIni() {
        return txtColaboradorServicioFechaIni;
    }

    public void setTxtColaboradorServicioFechaIni(
        Calendar txtColaboradorServicioFechaIni) {
        this.txtColaboradorServicioFechaIni = txtColaboradorServicioFechaIni;
    }

    public InputText getTxtColaboradorId() {
        return txtColaboradorId;
    }

    public void setTxtColaboradorId(InputText txtColaboradorId) {
        this.txtColaboradorId = txtColaboradorId;
    }

    public InputText getTxtServicioId() {
        return txtServicioId;
    }

    public void setTxtServicioId(InputText txtServicioId) {
        this.txtServicioId = txtServicioId;
    }

    public List<ColaboradorServicioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataColaboradorServicio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ColaboradorServicioDTO> colaboradorServicioDTO) {
        this.data = colaboradorServicioDTO;
    }

    public ColaboradorServicioDTO getSelectedColaboradorServicio() {
        return selectedColaboradorServicio;
    }

    public void setSelectedColaboradorServicio(
        ColaboradorServicioDTO colaboradorServicio) {
        this.selectedColaboradorServicio = colaboradorServicio;
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
