package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.UsuarioDTO;

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
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
    private InputText txtUsuarioAdmin;
    private InputText txtUsuarioImagen;
    private InputText txtUsuarioNombre;
    private InputText txtUsuarioPasswd;
    private InputText txtUsuarioId;
    private Calendar txtUsuarioFechaCreacion;
    private Calendar txtUsuarioFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UsuarioView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            UsuarioDTO usuarioDTO = (UsuarioDTO) e.getObject();

            if (txtUsuarioAdmin == null) {
                txtUsuarioAdmin = new InputText();
            }

            txtUsuarioAdmin.setValue(usuarioDTO.getUsuarioAdmin());

            if (txtUsuarioImagen == null) {
                txtUsuarioImagen = new InputText();
            }

            txtUsuarioImagen.setValue(usuarioDTO.getUsuarioImagen());

            if (txtUsuarioNombre == null) {
                txtUsuarioNombre = new InputText();
            }

            txtUsuarioNombre.setValue(usuarioDTO.getUsuarioNombre());

            if (txtUsuarioPasswd == null) {
                txtUsuarioPasswd = new InputText();
            }

            txtUsuarioPasswd.setValue(usuarioDTO.getUsuarioPasswd());

            if (txtUsuarioId == null) {
                txtUsuarioId = new InputText();
            }

            txtUsuarioId.setValue(usuarioDTO.getUsuarioId());

            if (txtUsuarioFechaCreacion == null) {
                txtUsuarioFechaCreacion = new Calendar();
            }

            txtUsuarioFechaCreacion.setValue(usuarioDTO.getUsuarioFechaCreacion());

            if (txtUsuarioFechaModificacion == null) {
                txtUsuarioFechaModificacion = new Calendar();
            }

            txtUsuarioFechaModificacion.setValue(usuarioDTO.getUsuarioFechaModificacion());

            Integer usuarioId = FacesUtils.checkInteger(txtUsuarioId);
            entity = businessDelegatorView.getUsuario(usuarioId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuario = null;

        if (txtUsuarioAdmin != null) {
            txtUsuarioAdmin.setValue(null);
            txtUsuarioAdmin.setDisabled(true);
        }

        if (txtUsuarioImagen != null) {
            txtUsuarioImagen.setValue(null);
            txtUsuarioImagen.setDisabled(true);
        }

        if (txtUsuarioNombre != null) {
            txtUsuarioNombre.setValue(null);
            txtUsuarioNombre.setDisabled(true);
        }

        if (txtUsuarioPasswd != null) {
            txtUsuarioPasswd.setValue(null);
            txtUsuarioPasswd.setDisabled(true);
        }

        if (txtUsuarioFechaCreacion != null) {
            txtUsuarioFechaCreacion.setValue(null);
            txtUsuarioFechaCreacion.setDisabled(true);
        }

        if (txtUsuarioFechaModificacion != null) {
            txtUsuarioFechaModificacion.setValue(null);
            txtUsuarioFechaModificacion.setDisabled(true);
        }

        if (txtUsuarioId != null) {
            txtUsuarioId.setValue(null);
            txtUsuarioId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtUsuarioFechaCreacion() {
        Date inputDate = (Date) txtUsuarioFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtUsuarioFechaModificacion() {
        Date inputDate = (Date) txtUsuarioFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer usuarioId = FacesUtils.checkInteger(txtUsuarioId);
            entity = (usuarioId != null)
                ? businessDelegatorView.getUsuario(usuarioId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUsuarioAdmin.setDisabled(false);
            txtUsuarioImagen.setDisabled(false);
            txtUsuarioNombre.setDisabled(false);
            txtUsuarioPasswd.setDisabled(false);
            txtUsuarioFechaCreacion.setDisabled(false);
            txtUsuarioFechaModificacion.setDisabled(false);
            txtUsuarioId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtUsuarioAdmin.setValue(entity.getUsuarioAdmin());
            txtUsuarioAdmin.setDisabled(false);
            txtUsuarioFechaCreacion.setValue(entity.getUsuarioFechaCreacion());
            txtUsuarioFechaCreacion.setDisabled(false);
            txtUsuarioFechaModificacion.setValue(entity.getUsuarioFechaModificacion());
            txtUsuarioFechaModificacion.setDisabled(false);
            txtUsuarioImagen.setValue(entity.getUsuarioImagen());
            txtUsuarioImagen.setDisabled(false);
            txtUsuarioNombre.setValue(entity.getUsuarioNombre());
            txtUsuarioNombre.setDisabled(false);
            txtUsuarioPasswd.setValue(entity.getUsuarioPasswd());
            txtUsuarioPasswd.setDisabled(false);
            txtUsuarioId.setValue(entity.getUsuarioId());
            txtUsuarioId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                           .get("selectedUsuario"));
        txtUsuarioAdmin.setValue(selectedUsuario.getUsuarioAdmin());
        txtUsuarioAdmin.setDisabled(false);
        txtUsuarioFechaCreacion.setValue(selectedUsuario.getUsuarioFechaCreacion());
        txtUsuarioFechaCreacion.setDisabled(false);
        txtUsuarioFechaModificacion.setValue(selectedUsuario.getUsuarioFechaModificacion());
        txtUsuarioFechaModificacion.setDisabled(false);
        txtUsuarioImagen.setValue(selectedUsuario.getUsuarioImagen());
        txtUsuarioImagen.setDisabled(false);
        txtUsuarioNombre.setValue(selectedUsuario.getUsuarioNombre());
        txtUsuarioNombre.setDisabled(false);
        txtUsuarioPasswd.setValue(selectedUsuario.getUsuarioPasswd());
        txtUsuarioPasswd.setDisabled(false);
        txtUsuarioId.setValue(selectedUsuario.getUsuarioId());
        txtUsuarioId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuario == null) && (entity == null)) {
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
            entity = new Usuario();

            Integer usuarioId = FacesUtils.checkInteger(txtUsuarioId);

            entity.setUsuarioAdmin(FacesUtils.checkString(txtUsuarioAdmin));
            entity.setUsuarioFechaCreacion(FacesUtils.checkDate(
                    txtUsuarioFechaCreacion));
            entity.setUsuarioFechaModificacion(FacesUtils.checkDate(
                    txtUsuarioFechaModificacion));
            entity.setUsuarioId(usuarioId);
            entity.setUsuarioImagen(FacesUtils.checkString(txtUsuarioImagen));
            entity.setUsuarioNombre(FacesUtils.checkString(txtUsuarioNombre));
            entity.setUsuarioPasswd(FacesUtils.checkString(txtUsuarioPasswd));
            businessDelegatorView.saveUsuario(entity);
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
                Integer usuarioId = new Integer(selectedUsuario.getUsuarioId());
                entity = businessDelegatorView.getUsuario(usuarioId);
            }

            entity.setUsuarioAdmin(FacesUtils.checkString(txtUsuarioAdmin));
            entity.setUsuarioFechaCreacion(FacesUtils.checkDate(
                    txtUsuarioFechaCreacion));
            entity.setUsuarioFechaModificacion(FacesUtils.checkDate(
                    txtUsuarioFechaModificacion));
            entity.setUsuarioImagen(FacesUtils.checkString(txtUsuarioImagen));
            entity.setUsuarioNombre(FacesUtils.checkString(txtUsuarioNombre));
            entity.setUsuarioPasswd(FacesUtils.checkString(txtUsuarioPasswd));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Integer usuarioId = new Integer(selectedUsuario.getUsuarioId());
            entity = businessDelegatorView.getUsuario(usuarioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer usuarioId = FacesUtils.checkInteger(txtUsuarioId);
            entity = businessDelegatorView.getUsuario(usuarioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuario(entity);
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
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            Integer usuarioId = new Integer(selectedUsuario.getUsuarioId());
            entity = businessDelegatorView.getUsuario(usuarioId);
            businessDelegatorView.deleteUsuario(entity);
            data.remove(selectedUsuario);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String usuarioAdmin,
        Date usuarioFechaCreacion, Date usuarioFechaModificacion,
        Integer usuarioId, String usuarioImagen, String usuarioNombre,
        String usuarioPasswd) throws Exception {
        try {
            entity.setUsuarioAdmin(FacesUtils.checkString(usuarioAdmin));
            entity.setUsuarioFechaCreacion(FacesUtils.checkDate(
                    usuarioFechaCreacion));
            entity.setUsuarioFechaModificacion(FacesUtils.checkDate(
                    usuarioFechaModificacion));
            entity.setUsuarioImagen(FacesUtils.checkString(usuarioImagen));
            entity.setUsuarioNombre(FacesUtils.checkString(usuarioNombre));
            entity.setUsuarioPasswd(FacesUtils.checkString(usuarioPasswd));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtUsuarioAdmin() {
        return txtUsuarioAdmin;
    }

    public void setTxtUsuarioAdmin(InputText txtUsuarioAdmin) {
        this.txtUsuarioAdmin = txtUsuarioAdmin;
    }

    public InputText getTxtUsuarioImagen() {
        return txtUsuarioImagen;
    }

    public void setTxtUsuarioImagen(InputText txtUsuarioImagen) {
        this.txtUsuarioImagen = txtUsuarioImagen;
    }

    public InputText getTxtUsuarioNombre() {
        return txtUsuarioNombre;
    }

    public void setTxtUsuarioNombre(InputText txtUsuarioNombre) {
        this.txtUsuarioNombre = txtUsuarioNombre;
    }

    public InputText getTxtUsuarioPasswd() {
        return txtUsuarioPasswd;
    }

    public void setTxtUsuarioPasswd(InputText txtUsuarioPasswd) {
        this.txtUsuarioPasswd = txtUsuarioPasswd;
    }

    public Calendar getTxtUsuarioFechaCreacion() {
        return txtUsuarioFechaCreacion;
    }

    public void setTxtUsuarioFechaCreacion(Calendar txtUsuarioFechaCreacion) {
        this.txtUsuarioFechaCreacion = txtUsuarioFechaCreacion;
    }

    public Calendar getTxtUsuarioFechaModificacion() {
        return txtUsuarioFechaModificacion;
    }

    public void setTxtUsuarioFechaModificacion(
        Calendar txtUsuarioFechaModificacion) {
        this.txtUsuarioFechaModificacion = txtUsuarioFechaModificacion;
    }

    public InputText getTxtUsuarioId() {
        return txtUsuarioId;
    }

    public void setTxtUsuarioId(InputText txtUsuarioId) {
        this.txtUsuarioId = txtUsuarioId;
    }

    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
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
