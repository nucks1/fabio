package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.MiembroDTO;

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
public class MiembroView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MiembroView.class);
    private InputText txtMiembroApellido;
    private InputText txtMiembroBarrio;
    private InputText txtMiembroCorreoElctronico;
    private InputText txtMiembroDireccion;
    private InputText txtMiembroNombre;
    private InputText txtMiembroNumeroCelular;
    private InputText txtMiembroNumeroIdentificacion;
    private InputText txtMiembroNumeroTelefono;
    private InputText txtUsuarioId_Usuario;
    private InputText txtMiembroId;
    private Calendar txtMiembroFechaCreacion;
    private Calendar txtMiembroFechaModificacion;
    private Calendar txtMiembroFechaNacimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MiembroDTO> data;
    private MiembroDTO selectedMiembro;
    private Miembro entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public MiembroView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            MiembroDTO miembroDTO = (MiembroDTO) e.getObject();

            if (txtMiembroApellido == null) {
                txtMiembroApellido = new InputText();
            }

            txtMiembroApellido.setValue(miembroDTO.getMiembroApellido());

            if (txtMiembroBarrio == null) {
                txtMiembroBarrio = new InputText();
            }

            txtMiembroBarrio.setValue(miembroDTO.getMiembroBarrio());

            if (txtMiembroCorreoElctronico == null) {
                txtMiembroCorreoElctronico = new InputText();
            }

            txtMiembroCorreoElctronico.setValue(miembroDTO.getMiembroCorreoElctronico());

            if (txtMiembroDireccion == null) {
                txtMiembroDireccion = new InputText();
            }

            txtMiembroDireccion.setValue(miembroDTO.getMiembroDireccion());

            if (txtMiembroNombre == null) {
                txtMiembroNombre = new InputText();
            }

            txtMiembroNombre.setValue(miembroDTO.getMiembroNombre());

            if (txtMiembroNumeroCelular == null) {
                txtMiembroNumeroCelular = new InputText();
            }

            txtMiembroNumeroCelular.setValue(miembroDTO.getMiembroNumeroCelular());

            if (txtMiembroNumeroIdentificacion == null) {
                txtMiembroNumeroIdentificacion = new InputText();
            }

            txtMiembroNumeroIdentificacion.setValue(miembroDTO.getMiembroNumeroIdentificacion());

            if (txtMiembroNumeroTelefono == null) {
                txtMiembroNumeroTelefono = new InputText();
            }

            txtMiembroNumeroTelefono.setValue(miembroDTO.getMiembroNumeroTelefono());

            if (txtUsuarioId_Usuario == null) {
                txtUsuarioId_Usuario = new InputText();
            }

            txtUsuarioId_Usuario.setValue(miembroDTO.getUsuarioId_Usuario());

            if (txtMiembroId == null) {
                txtMiembroId = new InputText();
            }

            txtMiembroId.setValue(miembroDTO.getMiembroId());

            if (txtMiembroFechaCreacion == null) {
                txtMiembroFechaCreacion = new Calendar();
            }

            txtMiembroFechaCreacion.setValue(miembroDTO.getMiembroFechaCreacion());

            if (txtMiembroFechaModificacion == null) {
                txtMiembroFechaModificacion = new Calendar();
            }

            txtMiembroFechaModificacion.setValue(miembroDTO.getMiembroFechaModificacion());

            if (txtMiembroFechaNacimiento == null) {
                txtMiembroFechaNacimiento = new Calendar();
            }

            txtMiembroFechaNacimiento.setValue(miembroDTO.getMiembroFechaNacimiento());

            Integer miembroId = FacesUtils.checkInteger(txtMiembroId);
            entity = businessDelegatorView.getMiembro(miembroId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedMiembro = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedMiembro = null;

        if (txtMiembroApellido != null) {
            txtMiembroApellido.setValue(null);
            txtMiembroApellido.setDisabled(true);
        }

        if (txtMiembroBarrio != null) {
            txtMiembroBarrio.setValue(null);
            txtMiembroBarrio.setDisabled(true);
        }

        if (txtMiembroCorreoElctronico != null) {
            txtMiembroCorreoElctronico.setValue(null);
            txtMiembroCorreoElctronico.setDisabled(true);
        }

        if (txtMiembroDireccion != null) {
            txtMiembroDireccion.setValue(null);
            txtMiembroDireccion.setDisabled(true);
        }

        if (txtMiembroNombre != null) {
            txtMiembroNombre.setValue(null);
            txtMiembroNombre.setDisabled(true);
        }

        if (txtMiembroNumeroCelular != null) {
            txtMiembroNumeroCelular.setValue(null);
            txtMiembroNumeroCelular.setDisabled(true);
        }

        if (txtMiembroNumeroIdentificacion != null) {
            txtMiembroNumeroIdentificacion.setValue(null);
            txtMiembroNumeroIdentificacion.setDisabled(true);
        }

        if (txtMiembroNumeroTelefono != null) {
            txtMiembroNumeroTelefono.setValue(null);
            txtMiembroNumeroTelefono.setDisabled(true);
        }

        if (txtUsuarioId_Usuario != null) {
            txtUsuarioId_Usuario.setValue(null);
            txtUsuarioId_Usuario.setDisabled(true);
        }

        if (txtMiembroFechaCreacion != null) {
            txtMiembroFechaCreacion.setValue(null);
            txtMiembroFechaCreacion.setDisabled(true);
        }

        if (txtMiembroFechaModificacion != null) {
            txtMiembroFechaModificacion.setValue(null);
            txtMiembroFechaModificacion.setDisabled(true);
        }

        if (txtMiembroFechaNacimiento != null) {
            txtMiembroFechaNacimiento.setValue(null);
            txtMiembroFechaNacimiento.setDisabled(true);
        }

        if (txtMiembroId != null) {
            txtMiembroId.setValue(null);
            txtMiembroId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtMiembroFechaCreacion() {
        Date inputDate = (Date) txtMiembroFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtMiembroFechaModificacion() {
        Date inputDate = (Date) txtMiembroFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtMiembroFechaNacimiento() {
        Date inputDate = (Date) txtMiembroFechaNacimiento.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer miembroId = FacesUtils.checkInteger(txtMiembroId);
            entity = (miembroId != null)
                ? businessDelegatorView.getMiembro(miembroId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtMiembroApellido.setDisabled(false);
            txtMiembroBarrio.setDisabled(false);
            txtMiembroCorreoElctronico.setDisabled(false);
            txtMiembroDireccion.setDisabled(false);
            txtMiembroNombre.setDisabled(false);
            txtMiembroNumeroCelular.setDisabled(false);
            txtMiembroNumeroIdentificacion.setDisabled(false);
            txtMiembroNumeroTelefono.setDisabled(false);
            txtUsuarioId_Usuario.setDisabled(false);
            txtMiembroFechaCreacion.setDisabled(false);
            txtMiembroFechaModificacion.setDisabled(false);
            txtMiembroFechaNacimiento.setDisabled(false);
            txtMiembroId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtMiembroApellido.setValue(entity.getMiembroApellido());
            txtMiembroApellido.setDisabled(false);
            txtMiembroBarrio.setValue(entity.getMiembroBarrio());
            txtMiembroBarrio.setDisabled(false);
            txtMiembroCorreoElctronico.setValue(entity.getMiembroCorreoElctronico());
            txtMiembroCorreoElctronico.setDisabled(false);
            txtMiembroDireccion.setValue(entity.getMiembroDireccion());
            txtMiembroDireccion.setDisabled(false);
            txtMiembroFechaCreacion.setValue(entity.getMiembroFechaCreacion());
            txtMiembroFechaCreacion.setDisabled(false);
            txtMiembroFechaModificacion.setValue(entity.getMiembroFechaModificacion());
            txtMiembroFechaModificacion.setDisabled(false);
            txtMiembroFechaNacimiento.setValue(entity.getMiembroFechaNacimiento());
            txtMiembroFechaNacimiento.setDisabled(false);
            txtMiembroNombre.setValue(entity.getMiembroNombre());
            txtMiembroNombre.setDisabled(false);
            txtMiembroNumeroCelular.setValue(entity.getMiembroNumeroCelular());
            txtMiembroNumeroCelular.setDisabled(false);
            txtMiembroNumeroIdentificacion.setValue(entity.getMiembroNumeroIdentificacion());
            txtMiembroNumeroIdentificacion.setDisabled(false);
            txtMiembroNumeroTelefono.setValue(entity.getMiembroNumeroTelefono());
            txtMiembroNumeroTelefono.setDisabled(false);
            txtUsuarioId_Usuario.setValue(entity.getUsuario().getUsuarioId());
            txtUsuarioId_Usuario.setDisabled(false);
            txtMiembroId.setValue(entity.getMiembroId());
            txtMiembroId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedMiembro = (MiembroDTO) (evt.getComponent().getAttributes()
                                           .get("selectedMiembro"));
        txtMiembroApellido.setValue(selectedMiembro.getMiembroApellido());
        txtMiembroApellido.setDisabled(false);
        txtMiembroBarrio.setValue(selectedMiembro.getMiembroBarrio());
        txtMiembroBarrio.setDisabled(false);
        txtMiembroCorreoElctronico.setValue(selectedMiembro.getMiembroCorreoElctronico());
        txtMiembroCorreoElctronico.setDisabled(false);
        txtMiembroDireccion.setValue(selectedMiembro.getMiembroDireccion());
        txtMiembroDireccion.setDisabled(false);
        txtMiembroFechaCreacion.setValue(selectedMiembro.getMiembroFechaCreacion());
        txtMiembroFechaCreacion.setDisabled(false);
        txtMiembroFechaModificacion.setValue(selectedMiembro.getMiembroFechaModificacion());
        txtMiembroFechaModificacion.setDisabled(false);
        txtMiembroFechaNacimiento.setValue(selectedMiembro.getMiembroFechaNacimiento());
        txtMiembroFechaNacimiento.setDisabled(false);
        txtMiembroNombre.setValue(selectedMiembro.getMiembroNombre());
        txtMiembroNombre.setDisabled(false);
        txtMiembroNumeroCelular.setValue(selectedMiembro.getMiembroNumeroCelular());
        txtMiembroNumeroCelular.setDisabled(false);
        txtMiembroNumeroIdentificacion.setValue(selectedMiembro.getMiembroNumeroIdentificacion());
        txtMiembroNumeroIdentificacion.setDisabled(false);
        txtMiembroNumeroTelefono.setValue(selectedMiembro.getMiembroNumeroTelefono());
        txtMiembroNumeroTelefono.setDisabled(false);
        txtUsuarioId_Usuario.setValue(selectedMiembro.getUsuarioId_Usuario());
        txtUsuarioId_Usuario.setDisabled(false);
        txtMiembroId.setValue(selectedMiembro.getMiembroId());
        txtMiembroId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedMiembro == null) && (entity == null)) {
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
            entity = new Miembro();

            Integer miembroId = FacesUtils.checkInteger(txtMiembroId);

            entity.setMiembroApellido(FacesUtils.checkString(txtMiembroApellido));
            entity.setMiembroBarrio(FacesUtils.checkString(txtMiembroBarrio));
            entity.setMiembroCorreoElctronico(FacesUtils.checkString(
                    txtMiembroCorreoElctronico));
            entity.setMiembroDireccion(FacesUtils.checkString(
                    txtMiembroDireccion));
            entity.setMiembroFechaCreacion(FacesUtils.checkDate(
                    txtMiembroFechaCreacion));
            entity.setMiembroFechaModificacion(FacesUtils.checkDate(
                    txtMiembroFechaModificacion));
            entity.setMiembroFechaNacimiento(FacesUtils.checkDate(
                    txtMiembroFechaNacimiento));
            entity.setMiembroId(miembroId);
            entity.setMiembroNombre(FacesUtils.checkString(txtMiembroNombre));
            entity.setMiembroNumeroCelular(FacesUtils.checkString(
                    txtMiembroNumeroCelular));
            entity.setMiembroNumeroIdentificacion(FacesUtils.checkString(
                    txtMiembroNumeroIdentificacion));
            entity.setMiembroNumeroTelefono(FacesUtils.checkString(
                    txtMiembroNumeroTelefono));
            entity.setUsuario((FacesUtils.checkInteger(txtUsuarioId_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkInteger(
                        txtUsuarioId_Usuario)) : null);
            businessDelegatorView.saveMiembro(entity);
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
                Integer miembroId = new Integer(selectedMiembro.getMiembroId());
                entity = businessDelegatorView.getMiembro(miembroId);
            }

            entity.setMiembroApellido(FacesUtils.checkString(txtMiembroApellido));
            entity.setMiembroBarrio(FacesUtils.checkString(txtMiembroBarrio));
            entity.setMiembroCorreoElctronico(FacesUtils.checkString(
                    txtMiembroCorreoElctronico));
            entity.setMiembroDireccion(FacesUtils.checkString(
                    txtMiembroDireccion));
            entity.setMiembroFechaCreacion(FacesUtils.checkDate(
                    txtMiembroFechaCreacion));
            entity.setMiembroFechaModificacion(FacesUtils.checkDate(
                    txtMiembroFechaModificacion));
            entity.setMiembroFechaNacimiento(FacesUtils.checkDate(
                    txtMiembroFechaNacimiento));
            entity.setMiembroNombre(FacesUtils.checkString(txtMiembroNombre));
            entity.setMiembroNumeroCelular(FacesUtils.checkString(
                    txtMiembroNumeroCelular));
            entity.setMiembroNumeroIdentificacion(FacesUtils.checkString(
                    txtMiembroNumeroIdentificacion));
            entity.setMiembroNumeroTelefono(FacesUtils.checkString(
                    txtMiembroNumeroTelefono));
            entity.setUsuario((FacesUtils.checkInteger(txtUsuarioId_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkInteger(
                        txtUsuarioId_Usuario)) : null);
            businessDelegatorView.updateMiembro(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedMiembro = (MiembroDTO) (evt.getComponent().getAttributes()
                                               .get("selectedMiembro"));

            Integer miembroId = new Integer(selectedMiembro.getMiembroId());
            entity = businessDelegatorView.getMiembro(miembroId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer miembroId = FacesUtils.checkInteger(txtMiembroId);
            entity = businessDelegatorView.getMiembro(miembroId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteMiembro(entity);
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
            selectedMiembro = (MiembroDTO) (evt.getComponent().getAttributes()
                                               .get("selectedMiembro"));

            Integer miembroId = new Integer(selectedMiembro.getMiembroId());
            entity = businessDelegatorView.getMiembro(miembroId);
            businessDelegatorView.deleteMiembro(entity);
            data.remove(selectedMiembro);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String miembroApellido,
        String miembroBarrio, String miembroCorreoElctronico,
        String miembroDireccion, Date miembroFechaCreacion,
        Date miembroFechaModificacion, Date miembroFechaNacimiento,
        Integer miembroId, String miembroNombre, String miembroNumeroCelular,
        String miembroNumeroIdentificacion, String miembroNumeroTelefono,
        Integer usuarioId_Usuario) throws Exception {
        try {
            entity.setMiembroApellido(FacesUtils.checkString(miembroApellido));
            entity.setMiembroBarrio(FacesUtils.checkString(miembroBarrio));
            entity.setMiembroCorreoElctronico(FacesUtils.checkString(
                    miembroCorreoElctronico));
            entity.setMiembroDireccion(FacesUtils.checkString(miembroDireccion));
            entity.setMiembroFechaCreacion(FacesUtils.checkDate(
                    miembroFechaCreacion));
            entity.setMiembroFechaModificacion(FacesUtils.checkDate(
                    miembroFechaModificacion));
            entity.setMiembroFechaNacimiento(FacesUtils.checkDate(
                    miembroFechaNacimiento));
            entity.setMiembroNombre(FacesUtils.checkString(miembroNombre));
            entity.setMiembroNumeroCelular(FacesUtils.checkString(
                    miembroNumeroCelular));
            entity.setMiembroNumeroIdentificacion(FacesUtils.checkString(
                    miembroNumeroIdentificacion));
            entity.setMiembroNumeroTelefono(FacesUtils.checkString(
                    miembroNumeroTelefono));
            businessDelegatorView.updateMiembro(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MiembroView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtMiembroApellido() {
        return txtMiembroApellido;
    }

    public void setTxtMiembroApellido(InputText txtMiembroApellido) {
        this.txtMiembroApellido = txtMiembroApellido;
    }

    public InputText getTxtMiembroBarrio() {
        return txtMiembroBarrio;
    }

    public void setTxtMiembroBarrio(InputText txtMiembroBarrio) {
        this.txtMiembroBarrio = txtMiembroBarrio;
    }

    public InputText getTxtMiembroCorreoElctronico() {
        return txtMiembroCorreoElctronico;
    }

    public void setTxtMiembroCorreoElctronico(
        InputText txtMiembroCorreoElctronico) {
        this.txtMiembroCorreoElctronico = txtMiembroCorreoElctronico;
    }

    public InputText getTxtMiembroDireccion() {
        return txtMiembroDireccion;
    }

    public void setTxtMiembroDireccion(InputText txtMiembroDireccion) {
        this.txtMiembroDireccion = txtMiembroDireccion;
    }

    public InputText getTxtMiembroNombre() {
        return txtMiembroNombre;
    }

    public void setTxtMiembroNombre(InputText txtMiembroNombre) {
        this.txtMiembroNombre = txtMiembroNombre;
    }

    public InputText getTxtMiembroNumeroCelular() {
        return txtMiembroNumeroCelular;
    }

    public void setTxtMiembroNumeroCelular(InputText txtMiembroNumeroCelular) {
        this.txtMiembroNumeroCelular = txtMiembroNumeroCelular;
    }

    public InputText getTxtMiembroNumeroIdentificacion() {
        return txtMiembroNumeroIdentificacion;
    }

    public void setTxtMiembroNumeroIdentificacion(
        InputText txtMiembroNumeroIdentificacion) {
        this.txtMiembroNumeroIdentificacion = txtMiembroNumeroIdentificacion;
    }

    public InputText getTxtMiembroNumeroTelefono() {
        return txtMiembroNumeroTelefono;
    }

    public void setTxtMiembroNumeroTelefono(InputText txtMiembroNumeroTelefono) {
        this.txtMiembroNumeroTelefono = txtMiembroNumeroTelefono;
    }

    public InputText getTxtUsuarioId_Usuario() {
        return txtUsuarioId_Usuario;
    }

    public void setTxtUsuarioId_Usuario(InputText txtUsuarioId_Usuario) {
        this.txtUsuarioId_Usuario = txtUsuarioId_Usuario;
    }

    public Calendar getTxtMiembroFechaCreacion() {
        return txtMiembroFechaCreacion;
    }

    public void setTxtMiembroFechaCreacion(Calendar txtMiembroFechaCreacion) {
        this.txtMiembroFechaCreacion = txtMiembroFechaCreacion;
    }

    public Calendar getTxtMiembroFechaModificacion() {
        return txtMiembroFechaModificacion;
    }

    public void setTxtMiembroFechaModificacion(
        Calendar txtMiembroFechaModificacion) {
        this.txtMiembroFechaModificacion = txtMiembroFechaModificacion;
    }

    public Calendar getTxtMiembroFechaNacimiento() {
        return txtMiembroFechaNacimiento;
    }

    public void setTxtMiembroFechaNacimiento(Calendar txtMiembroFechaNacimiento) {
        this.txtMiembroFechaNacimiento = txtMiembroFechaNacimiento;
    }

    public InputText getTxtMiembroId() {
        return txtMiembroId;
    }

    public void setTxtMiembroId(InputText txtMiembroId) {
        this.txtMiembroId = txtMiembroId;
    }

    public List<MiembroDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMiembro();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<MiembroDTO> miembroDTO) {
        this.data = miembroDTO;
    }

    public MiembroDTO getSelectedMiembro() {
        return selectedMiembro;
    }

    public void setSelectedMiembro(MiembroDTO miembro) {
        this.selectedMiembro = miembro;
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
