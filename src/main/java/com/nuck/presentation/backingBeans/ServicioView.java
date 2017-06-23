package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ServicioDTO;

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
public class ServicioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ServicioView.class);
    private InputText txtServicioBeneficios;
    private InputText txtServicioImagen;
    private InputText txtClaseTipoId_ClaseTipo;
    private InputText txtServicioId;
    private Calendar txtServicioFechaCreacion;
    private Calendar txtServicionFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ServicioDTO> data;
    private ServicioDTO selectedServicio;
    private Servicio entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ServicioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ServicioDTO servicioDTO = (ServicioDTO) e.getObject();

            if (txtServicioBeneficios == null) {
                txtServicioBeneficios = new InputText();
            }

            txtServicioBeneficios.setValue(servicioDTO.getServicioBeneficios());

            if (txtServicioImagen == null) {
                txtServicioImagen = new InputText();
            }

            txtServicioImagen.setValue(servicioDTO.getServicioImagen());

            if (txtClaseTipoId_ClaseTipo == null) {
                txtClaseTipoId_ClaseTipo = new InputText();
            }

            txtClaseTipoId_ClaseTipo.setValue(servicioDTO.getClaseTipoId_ClaseTipo());

            if (txtServicioId == null) {
                txtServicioId = new InputText();
            }

            txtServicioId.setValue(servicioDTO.getServicioId());

            if (txtServicioFechaCreacion == null) {
                txtServicioFechaCreacion = new Calendar();
            }

            txtServicioFechaCreacion.setValue(servicioDTO.getServicioFechaCreacion());

            if (txtServicionFechaModificacion == null) {
                txtServicionFechaModificacion = new Calendar();
            }

            txtServicionFechaModificacion.setValue(servicioDTO.getServicionFechaModificacion());

            Integer servicioId = FacesUtils.checkInteger(txtServicioId);
            entity = businessDelegatorView.getServicio(servicioId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedServicio = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedServicio = null;

        if (txtServicioBeneficios != null) {
            txtServicioBeneficios.setValue(null);
            txtServicioBeneficios.setDisabled(true);
        }

        if (txtServicioImagen != null) {
            txtServicioImagen.setValue(null);
            txtServicioImagen.setDisabled(true);
        }

        if (txtClaseTipoId_ClaseTipo != null) {
            txtClaseTipoId_ClaseTipo.setValue(null);
            txtClaseTipoId_ClaseTipo.setDisabled(true);
        }

        if (txtServicioFechaCreacion != null) {
            txtServicioFechaCreacion.setValue(null);
            txtServicioFechaCreacion.setDisabled(true);
        }

        if (txtServicionFechaModificacion != null) {
            txtServicionFechaModificacion.setValue(null);
            txtServicionFechaModificacion.setDisabled(true);
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

    public void listener_txtServicioFechaCreacion() {
        Date inputDate = (Date) txtServicioFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtServicionFechaModificacion() {
        Date inputDate = (Date) txtServicionFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer servicioId = FacesUtils.checkInteger(txtServicioId);
            entity = (servicioId != null)
                ? businessDelegatorView.getServicio(servicioId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtServicioBeneficios.setDisabled(false);
            txtServicioImagen.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtServicioFechaCreacion.setDisabled(false);
            txtServicionFechaModificacion.setDisabled(false);
            txtServicioId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtServicioBeneficios.setValue(entity.getServicioBeneficios());
            txtServicioBeneficios.setDisabled(false);
            txtServicioFechaCreacion.setValue(entity.getServicioFechaCreacion());
            txtServicioFechaCreacion.setDisabled(false);
            txtServicioImagen.setValue(entity.getServicioImagen());
            txtServicioImagen.setDisabled(false);
            txtServicionFechaModificacion.setValue(entity.getServicionFechaModificacion());
            txtServicionFechaModificacion.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setValue(entity.getClaseTipo()
                                                    .getClaseTipoId());
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtServicioId.setValue(entity.getServicioId());
            txtServicioId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedServicio = (ServicioDTO) (evt.getComponent().getAttributes()
                                             .get("selectedServicio"));
        txtServicioBeneficios.setValue(selectedServicio.getServicioBeneficios());
        txtServicioBeneficios.setDisabled(false);
        txtServicioFechaCreacion.setValue(selectedServicio.getServicioFechaCreacion());
        txtServicioFechaCreacion.setDisabled(false);
        txtServicioImagen.setValue(selectedServicio.getServicioImagen());
        txtServicioImagen.setDisabled(false);
        txtServicionFechaModificacion.setValue(selectedServicio.getServicionFechaModificacion());
        txtServicionFechaModificacion.setDisabled(false);
        txtClaseTipoId_ClaseTipo.setValue(selectedServicio.getClaseTipoId_ClaseTipo());
        txtClaseTipoId_ClaseTipo.setDisabled(false);
        txtServicioId.setValue(selectedServicio.getServicioId());
        txtServicioId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedServicio == null) && (entity == null)) {
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
            entity = new Servicio();

            Integer servicioId = FacesUtils.checkInteger(txtServicioId);

            entity.setServicioBeneficios(FacesUtils.checkString(
                    txtServicioBeneficios));
            entity.setServicioFechaCreacion(FacesUtils.checkDate(
                    txtServicioFechaCreacion));
            entity.setServicioId(servicioId);
            entity.setServicioImagen(FacesUtils.checkString(txtServicioImagen));
            entity.setServicionFechaModificacion(FacesUtils.checkDate(
                    txtServicionFechaModificacion));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            //entity.setProductos(FacesUtils.checkProducto(txtProductos));
            businessDelegatorView.saveServicio(entity);
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
                Integer servicioId = new Integer(selectedServicio.getServicioId());
                entity = businessDelegatorView.getServicio(servicioId);
            }

            entity.setServicioBeneficios(FacesUtils.checkString(
                    txtServicioBeneficios));
            entity.setServicioFechaCreacion(FacesUtils.checkDate(
                    txtServicioFechaCreacion));
            entity.setServicioImagen(FacesUtils.checkString(txtServicioImagen));
            entity.setServicionFechaModificacion(FacesUtils.checkDate(
                    txtServicionFechaModificacion));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            //entity.setProductos(FacesUtils.checkProducto(txtProductos));
            businessDelegatorView.updateServicio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedServicio = (ServicioDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedServicio"));

            Integer servicioId = new Integer(selectedServicio.getServicioId());
            entity = businessDelegatorView.getServicio(servicioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer servicioId = FacesUtils.checkInteger(txtServicioId);
            entity = businessDelegatorView.getServicio(servicioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteServicio(entity);
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
            selectedServicio = (ServicioDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedServicio"));

            Integer servicioId = new Integer(selectedServicio.getServicioId());
            entity = businessDelegatorView.getServicio(servicioId);
            businessDelegatorView.deleteServicio(entity);
            data.remove(selectedServicio);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String servicioBeneficios,
        Date servicioFechaCreacion, Integer servicioId, String servicioImagen,
        Date servicionFechaModificacion, Integer claseTipoId_ClaseTipo)
        throws Exception {
        try {
            entity.setServicioBeneficios(FacesUtils.checkString(
                    servicioBeneficios));
            entity.setServicioFechaCreacion(FacesUtils.checkDate(
                    servicioFechaCreacion));
            entity.setServicioImagen(FacesUtils.checkString(servicioImagen));
            entity.setServicionFechaModificacion(FacesUtils.checkDate(
                    servicionFechaModificacion));
            businessDelegatorView.updateServicio(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ServicioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtServicioBeneficios() {
        return txtServicioBeneficios;
    }

    public void setTxtServicioBeneficios(InputText txtServicioBeneficios) {
        this.txtServicioBeneficios = txtServicioBeneficios;
    }

    public InputText getTxtServicioImagen() {
        return txtServicioImagen;
    }

    public void setTxtServicioImagen(InputText txtServicioImagen) {
        this.txtServicioImagen = txtServicioImagen;
    }

    public InputText getTxtClaseTipoId_ClaseTipo() {
        return txtClaseTipoId_ClaseTipo;
    }

    public void setTxtClaseTipoId_ClaseTipo(InputText txtClaseTipoId_ClaseTipo) {
        this.txtClaseTipoId_ClaseTipo = txtClaseTipoId_ClaseTipo;
    }

    public Calendar getTxtServicioFechaCreacion() {
        return txtServicioFechaCreacion;
    }

    public void setTxtServicioFechaCreacion(Calendar txtServicioFechaCreacion) {
        this.txtServicioFechaCreacion = txtServicioFechaCreacion;
    }

    public Calendar getTxtServicionFechaModificacion() {
        return txtServicionFechaModificacion;
    }

    public void setTxtServicionFechaModificacion(
        Calendar txtServicionFechaModificacion) {
        this.txtServicionFechaModificacion = txtServicionFechaModificacion;
    }

    public InputText getTxtServicioId() {
        return txtServicioId;
    }

    public void setTxtServicioId(InputText txtServicioId) {
        this.txtServicioId = txtServicioId;
    }

    public List<ServicioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataServicio();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ServicioDTO> servicioDTO) {
        this.data = servicioDTO;
    }

    public ServicioDTO getSelectedServicio() {
        return selectedServicio;
    }

    public void setSelectedServicio(ServicioDTO servicio) {
        this.selectedServicio = servicio;
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
