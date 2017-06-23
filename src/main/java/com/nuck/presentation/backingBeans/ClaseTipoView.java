package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ClaseTipoDTO;

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
public class ClaseTipoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClaseTipoView.class);
    private InputText txtClaseTipoCostoEgreso;
    private InputText txtClaseTipoCostoIngreso;
    private InputText txtClaseTipoDescripcion;
    private InputText txtClaseTipoPuntos;
    private InputText txtClaseTipoRef;
    private InputText txtTipoId_Tipo;
    private InputText txtClaseTipoId;
    private Calendar txtClaseTipoFechaCreacion;
    private Calendar txtClaseTipoFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ClaseTipoDTO> data;
    private ClaseTipoDTO selectedClaseTipo;
    private ClaseTipo entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ClaseTipoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ClaseTipoDTO claseTipoDTO = (ClaseTipoDTO) e.getObject();

            if (txtClaseTipoCostoEgreso == null) {
                txtClaseTipoCostoEgreso = new InputText();
            }

            txtClaseTipoCostoEgreso.setValue(claseTipoDTO.getClaseTipoCostoEgreso());

            if (txtClaseTipoCostoIngreso == null) {
                txtClaseTipoCostoIngreso = new InputText();
            }

            txtClaseTipoCostoIngreso.setValue(claseTipoDTO.getClaseTipoCostoIngreso());

            if (txtClaseTipoDescripcion == null) {
                txtClaseTipoDescripcion = new InputText();
            }

            txtClaseTipoDescripcion.setValue(claseTipoDTO.getClaseTipoDescripcion());

            if (txtClaseTipoPuntos == null) {
                txtClaseTipoPuntos = new InputText();
            }

            txtClaseTipoPuntos.setValue(claseTipoDTO.getClaseTipoPuntos());

            if (txtClaseTipoRef == null) {
                txtClaseTipoRef = new InputText();
            }

            txtClaseTipoRef.setValue(claseTipoDTO.getClaseTipoRef());

            if (txtTipoId_Tipo == null) {
                txtTipoId_Tipo = new InputText();
            }

            txtTipoId_Tipo.setValue(claseTipoDTO.getTipoId_Tipo());

            if (txtClaseTipoId == null) {
                txtClaseTipoId = new InputText();
            }

            txtClaseTipoId.setValue(claseTipoDTO.getClaseTipoId());

            if (txtClaseTipoFechaCreacion == null) {
                txtClaseTipoFechaCreacion = new Calendar();
            }

            txtClaseTipoFechaCreacion.setValue(claseTipoDTO.getClaseTipoFechaCreacion());

            if (txtClaseTipoFechaModificacion == null) {
                txtClaseTipoFechaModificacion = new Calendar();
            }

            txtClaseTipoFechaModificacion.setValue(claseTipoDTO.getClaseTipoFechaModificacion());

            Integer claseTipoId = FacesUtils.checkInteger(txtClaseTipoId);
            entity = businessDelegatorView.getClaseTipo(claseTipoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedClaseTipo = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedClaseTipo = null;

        if (txtClaseTipoCostoEgreso != null) {
            txtClaseTipoCostoEgreso.setValue(null);
            txtClaseTipoCostoEgreso.setDisabled(true);
        }

        if (txtClaseTipoCostoIngreso != null) {
            txtClaseTipoCostoIngreso.setValue(null);
            txtClaseTipoCostoIngreso.setDisabled(true);
        }

        if (txtClaseTipoDescripcion != null) {
            txtClaseTipoDescripcion.setValue(null);
            txtClaseTipoDescripcion.setDisabled(true);
        }

        if (txtClaseTipoPuntos != null) {
            txtClaseTipoPuntos.setValue(null);
            txtClaseTipoPuntos.setDisabled(true);
        }

        if (txtClaseTipoRef != null) {
            txtClaseTipoRef.setValue(null);
            txtClaseTipoRef.setDisabled(true);
        }

        if (txtTipoId_Tipo != null) {
            txtTipoId_Tipo.setValue(null);
            txtTipoId_Tipo.setDisabled(true);
        }

        if (txtClaseTipoFechaCreacion != null) {
            txtClaseTipoFechaCreacion.setValue(null);
            txtClaseTipoFechaCreacion.setDisabled(true);
        }

        if (txtClaseTipoFechaModificacion != null) {
            txtClaseTipoFechaModificacion.setValue(null);
            txtClaseTipoFechaModificacion.setDisabled(true);
        }

        if (txtClaseTipoId != null) {
            txtClaseTipoId.setValue(null);
            txtClaseTipoId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtClaseTipoFechaCreacion() {
        Date inputDate = (Date) txtClaseTipoFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtClaseTipoFechaModificacion() {
        Date inputDate = (Date) txtClaseTipoFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer claseTipoId = FacesUtils.checkInteger(txtClaseTipoId);
            entity = (claseTipoId != null)
                ? businessDelegatorView.getClaseTipo(claseTipoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtClaseTipoCostoEgreso.setDisabled(false);
            txtClaseTipoCostoIngreso.setDisabled(false);
            txtClaseTipoDescripcion.setDisabled(false);
            txtClaseTipoPuntos.setDisabled(false);
            txtClaseTipoRef.setDisabled(false);
            txtTipoId_Tipo.setDisabled(false);
            txtClaseTipoFechaCreacion.setDisabled(false);
            txtClaseTipoFechaModificacion.setDisabled(false);
            txtClaseTipoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtClaseTipoCostoEgreso.setValue(entity.getClaseTipoCostoEgreso());
            txtClaseTipoCostoEgreso.setDisabled(false);
            txtClaseTipoCostoIngreso.setValue(entity.getClaseTipoCostoIngreso());
            txtClaseTipoCostoIngreso.setDisabled(false);
            txtClaseTipoDescripcion.setValue(entity.getClaseTipoDescripcion());
            txtClaseTipoDescripcion.setDisabled(false);
            txtClaseTipoFechaCreacion.setValue(entity.getClaseTipoFechaCreacion());
            txtClaseTipoFechaCreacion.setDisabled(false);
            txtClaseTipoFechaModificacion.setValue(entity.getClaseTipoFechaModificacion());
            txtClaseTipoFechaModificacion.setDisabled(false);
            txtClaseTipoPuntos.setValue(entity.getClaseTipoPuntos());
            txtClaseTipoPuntos.setDisabled(false);
            txtClaseTipoRef.setValue(entity.getClaseTipoRef());
            txtClaseTipoRef.setDisabled(false);
            txtTipoId_Tipo.setValue(entity.getTipo().getTipoId());
            txtTipoId_Tipo.setDisabled(false);
            txtClaseTipoId.setValue(entity.getClaseTipoId());
            txtClaseTipoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedClaseTipo = (ClaseTipoDTO) (evt.getComponent().getAttributes()
                                               .get("selectedClaseTipo"));
        txtClaseTipoCostoEgreso.setValue(selectedClaseTipo.getClaseTipoCostoEgreso());
        txtClaseTipoCostoEgreso.setDisabled(false);
        txtClaseTipoCostoIngreso.setValue(selectedClaseTipo.getClaseTipoCostoIngreso());
        txtClaseTipoCostoIngreso.setDisabled(false);
        txtClaseTipoDescripcion.setValue(selectedClaseTipo.getClaseTipoDescripcion());
        txtClaseTipoDescripcion.setDisabled(false);
        txtClaseTipoFechaCreacion.setValue(selectedClaseTipo.getClaseTipoFechaCreacion());
        txtClaseTipoFechaCreacion.setDisabled(false);
        txtClaseTipoFechaModificacion.setValue(selectedClaseTipo.getClaseTipoFechaModificacion());
        txtClaseTipoFechaModificacion.setDisabled(false);
        txtClaseTipoPuntos.setValue(selectedClaseTipo.getClaseTipoPuntos());
        txtClaseTipoPuntos.setDisabled(false);
        txtClaseTipoRef.setValue(selectedClaseTipo.getClaseTipoRef());
        txtClaseTipoRef.setDisabled(false);
        txtTipoId_Tipo.setValue(selectedClaseTipo.getTipoId_Tipo());
        txtTipoId_Tipo.setDisabled(false);
        txtClaseTipoId.setValue(selectedClaseTipo.getClaseTipoId());
        txtClaseTipoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedClaseTipo == null) && (entity == null)) {
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
            entity = new ClaseTipo();

            Integer claseTipoId = FacesUtils.checkInteger(txtClaseTipoId);

            entity.setClaseTipoCostoEgreso(FacesUtils.checkDouble(
                    txtClaseTipoCostoEgreso));
            entity.setClaseTipoCostoIngreso(FacesUtils.checkDouble(
                    txtClaseTipoCostoIngreso));
            entity.setClaseTipoDescripcion(FacesUtils.checkString(
                    txtClaseTipoDescripcion));
            entity.setClaseTipoFechaCreacion(FacesUtils.checkDate(
                    txtClaseTipoFechaCreacion));
            entity.setClaseTipoFechaModificacion(FacesUtils.checkDate(
                    txtClaseTipoFechaModificacion));
            entity.setClaseTipoId(claseTipoId);
            entity.setClaseTipoPuntos(FacesUtils.checkInteger(
                    txtClaseTipoPuntos));
            entity.setClaseTipoRef(FacesUtils.checkString(txtClaseTipoRef));
            entity.setTipo((FacesUtils.checkInteger(txtTipoId_Tipo) != null)
                ? businessDelegatorView.getTipo(FacesUtils.checkInteger(
                        txtTipoId_Tipo)) : null);
            businessDelegatorView.saveClaseTipo(entity);
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
                Integer claseTipoId = new Integer(selectedClaseTipo.getClaseTipoId());
                entity = businessDelegatorView.getClaseTipo(claseTipoId);
            }

            entity.setClaseTipoCostoEgreso(FacesUtils.checkDouble(
                    txtClaseTipoCostoEgreso));
            entity.setClaseTipoCostoIngreso(FacesUtils.checkDouble(
                    txtClaseTipoCostoIngreso));
            entity.setClaseTipoDescripcion(FacesUtils.checkString(
                    txtClaseTipoDescripcion));
            entity.setClaseTipoFechaCreacion(FacesUtils.checkDate(
                    txtClaseTipoFechaCreacion));
            entity.setClaseTipoFechaModificacion(FacesUtils.checkDate(
                    txtClaseTipoFechaModificacion));
            entity.setClaseTipoPuntos(FacesUtils.checkInteger(
                    txtClaseTipoPuntos));
            entity.setClaseTipoRef(FacesUtils.checkString(txtClaseTipoRef));
            entity.setTipo((FacesUtils.checkInteger(txtTipoId_Tipo) != null)
                ? businessDelegatorView.getTipo(FacesUtils.checkInteger(
                        txtTipoId_Tipo)) : null);
            businessDelegatorView.updateClaseTipo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedClaseTipo = (ClaseTipoDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedClaseTipo"));

            Integer claseTipoId = new Integer(selectedClaseTipo.getClaseTipoId());
            entity = businessDelegatorView.getClaseTipo(claseTipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer claseTipoId = FacesUtils.checkInteger(txtClaseTipoId);
            entity = businessDelegatorView.getClaseTipo(claseTipoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteClaseTipo(entity);
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
            selectedClaseTipo = (ClaseTipoDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedClaseTipo"));

            Integer claseTipoId = new Integer(selectedClaseTipo.getClaseTipoId());
            entity = businessDelegatorView.getClaseTipo(claseTipoId);
            businessDelegatorView.deleteClaseTipo(entity);
            data.remove(selectedClaseTipo);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Double claseTipoCostoEgreso,
        Double claseTipoCostoIngreso, String claseTipoDescripcion,
        Date claseTipoFechaCreacion, Date claseTipoFechaModificacion,
        Integer claseTipoId, Integer claseTipoPuntos, String claseTipoRef,
        Integer tipoId_Tipo) throws Exception {
        try {
            entity.setClaseTipoCostoEgreso(FacesUtils.checkDouble(
                    claseTipoCostoEgreso));
            entity.setClaseTipoCostoIngreso(FacesUtils.checkDouble(
                    claseTipoCostoIngreso));
            entity.setClaseTipoDescripcion(FacesUtils.checkString(
                    claseTipoDescripcion));
            entity.setClaseTipoFechaCreacion(FacesUtils.checkDate(
                    claseTipoFechaCreacion));
            entity.setClaseTipoFechaModificacion(FacesUtils.checkDate(
                    claseTipoFechaModificacion));
            entity.setClaseTipoPuntos(FacesUtils.checkInteger(claseTipoPuntos));
            entity.setClaseTipoRef(FacesUtils.checkString(claseTipoRef));
            businessDelegatorView.updateClaseTipo(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ClaseTipoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtClaseTipoCostoEgreso() {
        return txtClaseTipoCostoEgreso;
    }

    public void setTxtClaseTipoCostoEgreso(InputText txtClaseTipoCostoEgreso) {
        this.txtClaseTipoCostoEgreso = txtClaseTipoCostoEgreso;
    }

    public InputText getTxtClaseTipoCostoIngreso() {
        return txtClaseTipoCostoIngreso;
    }

    public void setTxtClaseTipoCostoIngreso(InputText txtClaseTipoCostoIngreso) {
        this.txtClaseTipoCostoIngreso = txtClaseTipoCostoIngreso;
    }

    public InputText getTxtClaseTipoDescripcion() {
        return txtClaseTipoDescripcion;
    }

    public void setTxtClaseTipoDescripcion(InputText txtClaseTipoDescripcion) {
        this.txtClaseTipoDescripcion = txtClaseTipoDescripcion;
    }

    public InputText getTxtClaseTipoPuntos() {
        return txtClaseTipoPuntos;
    }

    public void setTxtClaseTipoPuntos(InputText txtClaseTipoPuntos) {
        this.txtClaseTipoPuntos = txtClaseTipoPuntos;
    }

    public InputText getTxtClaseTipoRef() {
        return txtClaseTipoRef;
    }

    public void setTxtClaseTipoRef(InputText txtClaseTipoRef) {
        this.txtClaseTipoRef = txtClaseTipoRef;
    }

    public InputText getTxtTipoId_Tipo() {
        return txtTipoId_Tipo;
    }

    public void setTxtTipoId_Tipo(InputText txtTipoId_Tipo) {
        this.txtTipoId_Tipo = txtTipoId_Tipo;
    }

    public Calendar getTxtClaseTipoFechaCreacion() {
        return txtClaseTipoFechaCreacion;
    }

    public void setTxtClaseTipoFechaCreacion(Calendar txtClaseTipoFechaCreacion) {
        this.txtClaseTipoFechaCreacion = txtClaseTipoFechaCreacion;
    }

    public Calendar getTxtClaseTipoFechaModificacion() {
        return txtClaseTipoFechaModificacion;
    }

    public void setTxtClaseTipoFechaModificacion(
        Calendar txtClaseTipoFechaModificacion) {
        this.txtClaseTipoFechaModificacion = txtClaseTipoFechaModificacion;
    }

    public InputText getTxtClaseTipoId() {
        return txtClaseTipoId;
    }

    public void setTxtClaseTipoId(InputText txtClaseTipoId) {
        this.txtClaseTipoId = txtClaseTipoId;
    }

    public List<ClaseTipoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataClaseTipo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ClaseTipoDTO> claseTipoDTO) {
        this.data = claseTipoDTO;
    }

    public ClaseTipoDTO getSelectedClaseTipo() {
        return selectedClaseTipo;
    }

    public void setSelectedClaseTipo(ClaseTipoDTO claseTipo) {
        this.selectedClaseTipo = claseTipo;
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
