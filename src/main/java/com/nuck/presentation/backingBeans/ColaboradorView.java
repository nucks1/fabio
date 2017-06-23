package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ColaboradorDTO;

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
public class ColaboradorView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ColaboradorView.class);
    private InputText txtColaboradorApellido;
    private InputText txtColaboradorBarrio;
    private InputText txtColaboradorCorreoElctronico;
    private InputText txtColaboradorDireccion;
    private InputText txtColaboradorNombre;
    private InputText txtColaboradorNumeroCelular;
    private InputText txtColaboradorNumeroIdentificacion;
    private InputText txtColaboradorNumeroTelefono;
    private InputText txtUsuarioId_Usuario;
    private InputText txtColaboradorId;
    private Calendar txtColaboradorFechaCreacion;
    private Calendar txtColaboradorFechaModificacion;
    private Calendar txtColaboradorFechaNacimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ColaboradorDTO> data;
    private ColaboradorDTO selectedColaborador;
    private Colaborador entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ColaboradorView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ColaboradorDTO colaboradorDTO = (ColaboradorDTO) e.getObject();

            if (txtColaboradorApellido == null) {
                txtColaboradorApellido = new InputText();
            }

            txtColaboradorApellido.setValue(colaboradorDTO.getColaboradorApellido());

            if (txtColaboradorBarrio == null) {
                txtColaboradorBarrio = new InputText();
            }

            txtColaboradorBarrio.setValue(colaboradorDTO.getColaboradorBarrio());

            if (txtColaboradorCorreoElctronico == null) {
                txtColaboradorCorreoElctronico = new InputText();
            }

            txtColaboradorCorreoElctronico.setValue(colaboradorDTO.getColaboradorCorreoElctronico());

            if (txtColaboradorDireccion == null) {
                txtColaboradorDireccion = new InputText();
            }

            txtColaboradorDireccion.setValue(colaboradorDTO.getColaboradorDireccion());

            if (txtColaboradorNombre == null) {
                txtColaboradorNombre = new InputText();
            }

            txtColaboradorNombre.setValue(colaboradorDTO.getColaboradorNombre());

            if (txtColaboradorNumeroCelular == null) {
                txtColaboradorNumeroCelular = new InputText();
            }

            txtColaboradorNumeroCelular.setValue(colaboradorDTO.getColaboradorNumeroCelular());

            if (txtColaboradorNumeroIdentificacion == null) {
                txtColaboradorNumeroIdentificacion = new InputText();
            }

            txtColaboradorNumeroIdentificacion.setValue(colaboradorDTO.getColaboradorNumeroIdentificacion());

            if (txtColaboradorNumeroTelefono == null) {
                txtColaboradorNumeroTelefono = new InputText();
            }

            txtColaboradorNumeroTelefono.setValue(colaboradorDTO.getColaboradorNumeroTelefono());

            if (txtUsuarioId_Usuario == null) {
                txtUsuarioId_Usuario = new InputText();
            }

            txtUsuarioId_Usuario.setValue(colaboradorDTO.getUsuarioId_Usuario());

            if (txtColaboradorId == null) {
                txtColaboradorId = new InputText();
            }

            txtColaboradorId.setValue(colaboradorDTO.getColaboradorId());

            if (txtColaboradorFechaCreacion == null) {
                txtColaboradorFechaCreacion = new Calendar();
            }

            txtColaboradorFechaCreacion.setValue(colaboradorDTO.getColaboradorFechaCreacion());

            if (txtColaboradorFechaModificacion == null) {
                txtColaboradorFechaModificacion = new Calendar();
            }

            txtColaboradorFechaModificacion.setValue(colaboradorDTO.getColaboradorFechaModificacion());

            if (txtColaboradorFechaNacimiento == null) {
                txtColaboradorFechaNacimiento = new Calendar();
            }

            txtColaboradorFechaNacimiento.setValue(colaboradorDTO.getColaboradorFechaNacimiento());

            Integer colaboradorId = FacesUtils.checkInteger(txtColaboradorId);
            entity = businessDelegatorView.getColaborador(colaboradorId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedColaborador = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedColaborador = null;

        if (txtColaboradorApellido != null) {
            txtColaboradorApellido.setValue(null);
            txtColaboradorApellido.setDisabled(true);
        }

        if (txtColaboradorBarrio != null) {
            txtColaboradorBarrio.setValue(null);
            txtColaboradorBarrio.setDisabled(true);
        }

        if (txtColaboradorCorreoElctronico != null) {
            txtColaboradorCorreoElctronico.setValue(null);
            txtColaboradorCorreoElctronico.setDisabled(true);
        }

        if (txtColaboradorDireccion != null) {
            txtColaboradorDireccion.setValue(null);
            txtColaboradorDireccion.setDisabled(true);
        }

        if (txtColaboradorNombre != null) {
            txtColaboradorNombre.setValue(null);
            txtColaboradorNombre.setDisabled(true);
        }

        if (txtColaboradorNumeroCelular != null) {
            txtColaboradorNumeroCelular.setValue(null);
            txtColaboradorNumeroCelular.setDisabled(true);
        }

        if (txtColaboradorNumeroIdentificacion != null) {
            txtColaboradorNumeroIdentificacion.setValue(null);
            txtColaboradorNumeroIdentificacion.setDisabled(true);
        }

        if (txtColaboradorNumeroTelefono != null) {
            txtColaboradorNumeroTelefono.setValue(null);
            txtColaboradorNumeroTelefono.setDisabled(true);
        }

        if (txtUsuarioId_Usuario != null) {
            txtUsuarioId_Usuario.setValue(null);
            txtUsuarioId_Usuario.setDisabled(true);
        }

        if (txtColaboradorFechaCreacion != null) {
            txtColaboradorFechaCreacion.setValue(null);
            txtColaboradorFechaCreacion.setDisabled(true);
        }

        if (txtColaboradorFechaModificacion != null) {
            txtColaboradorFechaModificacion.setValue(null);
            txtColaboradorFechaModificacion.setDisabled(true);
        }

        if (txtColaboradorFechaNacimiento != null) {
            txtColaboradorFechaNacimiento.setValue(null);
            txtColaboradorFechaNacimiento.setDisabled(true);
        }

        if (txtColaboradorId != null) {
            txtColaboradorId.setValue(null);
            txtColaboradorId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtColaboradorFechaCreacion() {
        Date inputDate = (Date) txtColaboradorFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtColaboradorFechaModificacion() {
        Date inputDate = (Date) txtColaboradorFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtColaboradorFechaNacimiento() {
        Date inputDate = (Date) txtColaboradorFechaNacimiento.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer colaboradorId = FacesUtils.checkInteger(txtColaboradorId);
            entity = (colaboradorId != null)
                ? businessDelegatorView.getColaborador(colaboradorId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtColaboradorApellido.setDisabled(false);
            txtColaboradorBarrio.setDisabled(false);
            txtColaboradorCorreoElctronico.setDisabled(false);
            txtColaboradorDireccion.setDisabled(false);
            txtColaboradorNombre.setDisabled(false);
            txtColaboradorNumeroCelular.setDisabled(false);
            txtColaboradorNumeroIdentificacion.setDisabled(false);
            txtColaboradorNumeroTelefono.setDisabled(false);
            txtUsuarioId_Usuario.setDisabled(false);
            txtColaboradorFechaCreacion.setDisabled(false);
            txtColaboradorFechaModificacion.setDisabled(false);
            txtColaboradorFechaNacimiento.setDisabled(false);
            txtColaboradorId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtColaboradorApellido.setValue(entity.getColaboradorApellido());
            txtColaboradorApellido.setDisabled(false);
            txtColaboradorBarrio.setValue(entity.getColaboradorBarrio());
            txtColaboradorBarrio.setDisabled(false);
            txtColaboradorCorreoElctronico.setValue(entity.getColaboradorCorreoElctronico());
            txtColaboradorCorreoElctronico.setDisabled(false);
            txtColaboradorDireccion.setValue(entity.getColaboradorDireccion());
            txtColaboradorDireccion.setDisabled(false);
            txtColaboradorFechaCreacion.setValue(entity.getColaboradorFechaCreacion());
            txtColaboradorFechaCreacion.setDisabled(false);
            txtColaboradorFechaModificacion.setValue(entity.getColaboradorFechaModificacion());
            txtColaboradorFechaModificacion.setDisabled(false);
            txtColaboradorFechaNacimiento.setValue(entity.getColaboradorFechaNacimiento());
            txtColaboradorFechaNacimiento.setDisabled(false);
            txtColaboradorNombre.setValue(entity.getColaboradorNombre());
            txtColaboradorNombre.setDisabled(false);
            txtColaboradorNumeroCelular.setValue(entity.getColaboradorNumeroCelular());
            txtColaboradorNumeroCelular.setDisabled(false);
            txtColaboradorNumeroIdentificacion.setValue(entity.getColaboradorNumeroIdentificacion());
            txtColaboradorNumeroIdentificacion.setDisabled(false);
            txtColaboradorNumeroTelefono.setValue(entity.getColaboradorNumeroTelefono());
            txtColaboradorNumeroTelefono.setDisabled(false);
            txtUsuarioId_Usuario.setValue(entity.getUsuario().getUsuarioId());
            txtUsuarioId_Usuario.setDisabled(false);
            txtColaboradorId.setValue(entity.getColaboradorId());
            txtColaboradorId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedColaborador = (ColaboradorDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedColaborador"));
        txtColaboradorApellido.setValue(selectedColaborador.getColaboradorApellido());
        txtColaboradorApellido.setDisabled(false);
        txtColaboradorBarrio.setValue(selectedColaborador.getColaboradorBarrio());
        txtColaboradorBarrio.setDisabled(false);
        txtColaboradorCorreoElctronico.setValue(selectedColaborador.getColaboradorCorreoElctronico());
        txtColaboradorCorreoElctronico.setDisabled(false);
        txtColaboradorDireccion.setValue(selectedColaborador.getColaboradorDireccion());
        txtColaboradorDireccion.setDisabled(false);
        txtColaboradorFechaCreacion.setValue(selectedColaborador.getColaboradorFechaCreacion());
        txtColaboradorFechaCreacion.setDisabled(false);
        txtColaboradorFechaModificacion.setValue(selectedColaborador.getColaboradorFechaModificacion());
        txtColaboradorFechaModificacion.setDisabled(false);
        txtColaboradorFechaNacimiento.setValue(selectedColaborador.getColaboradorFechaNacimiento());
        txtColaboradorFechaNacimiento.setDisabled(false);
        txtColaboradorNombre.setValue(selectedColaborador.getColaboradorNombre());
        txtColaboradorNombre.setDisabled(false);
        txtColaboradorNumeroCelular.setValue(selectedColaborador.getColaboradorNumeroCelular());
        txtColaboradorNumeroCelular.setDisabled(false);
        txtColaboradorNumeroIdentificacion.setValue(selectedColaborador.getColaboradorNumeroIdentificacion());
        txtColaboradorNumeroIdentificacion.setDisabled(false);
        txtColaboradorNumeroTelefono.setValue(selectedColaborador.getColaboradorNumeroTelefono());
        txtColaboradorNumeroTelefono.setDisabled(false);
        txtUsuarioId_Usuario.setValue(selectedColaborador.getUsuarioId_Usuario());
        txtUsuarioId_Usuario.setDisabled(false);
        txtColaboradorId.setValue(selectedColaborador.getColaboradorId());
        txtColaboradorId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedColaborador == null) && (entity == null)) {
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
            entity = new Colaborador();

            Integer colaboradorId = FacesUtils.checkInteger(txtColaboradorId);

            entity.setColaboradorApellido(FacesUtils.checkString(
                    txtColaboradorApellido));
            entity.setColaboradorBarrio(FacesUtils.checkString(
                    txtColaboradorBarrio));
            entity.setColaboradorCorreoElctronico(FacesUtils.checkString(
                    txtColaboradorCorreoElctronico));
            entity.setColaboradorDireccion(FacesUtils.checkString(
                    txtColaboradorDireccion));
            entity.setColaboradorFechaCreacion(FacesUtils.checkDate(
                    txtColaboradorFechaCreacion));
            entity.setColaboradorFechaModificacion(FacesUtils.checkDate(
                    txtColaboradorFechaModificacion));
            entity.setColaboradorFechaNacimiento(FacesUtils.checkDate(
                    txtColaboradorFechaNacimiento));
            entity.setColaboradorId(colaboradorId);
            entity.setColaboradorNombre(FacesUtils.checkString(
                    txtColaboradorNombre));
            entity.setColaboradorNumeroCelular(FacesUtils.checkString(
                    txtColaboradorNumeroCelular));
            entity.setColaboradorNumeroIdentificacion(FacesUtils.checkString(
                    txtColaboradorNumeroIdentificacion));
            entity.setColaboradorNumeroTelefono(FacesUtils.checkString(
                    txtColaboradorNumeroTelefono));
            entity.setUsuario((FacesUtils.checkInteger(txtUsuarioId_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkInteger(
                        txtUsuarioId_Usuario)) : null);
            businessDelegatorView.saveColaborador(entity);
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
                Integer colaboradorId = new Integer(selectedColaborador.getColaboradorId());
                entity = businessDelegatorView.getColaborador(colaboradorId);
            }

            entity.setColaboradorApellido(FacesUtils.checkString(
                    txtColaboradorApellido));
            entity.setColaboradorBarrio(FacesUtils.checkString(
                    txtColaboradorBarrio));
            entity.setColaboradorCorreoElctronico(FacesUtils.checkString(
                    txtColaboradorCorreoElctronico));
            entity.setColaboradorDireccion(FacesUtils.checkString(
                    txtColaboradorDireccion));
            entity.setColaboradorFechaCreacion(FacesUtils.checkDate(
                    txtColaboradorFechaCreacion));
            entity.setColaboradorFechaModificacion(FacesUtils.checkDate(
                    txtColaboradorFechaModificacion));
            entity.setColaboradorFechaNacimiento(FacesUtils.checkDate(
                    txtColaboradorFechaNacimiento));
            entity.setColaboradorNombre(FacesUtils.checkString(
                    txtColaboradorNombre));
            entity.setColaboradorNumeroCelular(FacesUtils.checkString(
                    txtColaboradorNumeroCelular));
            entity.setColaboradorNumeroIdentificacion(FacesUtils.checkString(
                    txtColaboradorNumeroIdentificacion));
            entity.setColaboradorNumeroTelefono(FacesUtils.checkString(
                    txtColaboradorNumeroTelefono));
            entity.setUsuario((FacesUtils.checkInteger(txtUsuarioId_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkInteger(
                        txtUsuarioId_Usuario)) : null);
            businessDelegatorView.updateColaborador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedColaborador = (ColaboradorDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedColaborador"));

            Integer colaboradorId = new Integer(selectedColaborador.getColaboradorId());
            entity = businessDelegatorView.getColaborador(colaboradorId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer colaboradorId = FacesUtils.checkInteger(txtColaboradorId);
            entity = businessDelegatorView.getColaborador(colaboradorId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteColaborador(entity);
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
            selectedColaborador = (ColaboradorDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedColaborador"));

            Integer colaboradorId = new Integer(selectedColaborador.getColaboradorId());
            entity = businessDelegatorView.getColaborador(colaboradorId);
            businessDelegatorView.deleteColaborador(entity);
            data.remove(selectedColaborador);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String colaboradorApellido,
        String colaboradorBarrio, String colaboradorCorreoElctronico,
        String colaboradorDireccion, Date colaboradorFechaCreacion,
        Date colaboradorFechaModificacion, Date colaboradorFechaNacimiento,
        Integer colaboradorId, String colaboradorNombre,
        String colaboradorNumeroCelular,
        String colaboradorNumeroIdentificacion,
        String colaboradorNumeroTelefono, Integer usuarioId_Usuario)
        throws Exception {
        try {
            entity.setColaboradorApellido(FacesUtils.checkString(
                    colaboradorApellido));
            entity.setColaboradorBarrio(FacesUtils.checkString(
                    colaboradorBarrio));
            entity.setColaboradorCorreoElctronico(FacesUtils.checkString(
                    colaboradorCorreoElctronico));
            entity.setColaboradorDireccion(FacesUtils.checkString(
                    colaboradorDireccion));
            entity.setColaboradorFechaCreacion(FacesUtils.checkDate(
                    colaboradorFechaCreacion));
            entity.setColaboradorFechaModificacion(FacesUtils.checkDate(
                    colaboradorFechaModificacion));
            entity.setColaboradorFechaNacimiento(FacesUtils.checkDate(
                    colaboradorFechaNacimiento));
            entity.setColaboradorNombre(FacesUtils.checkString(
                    colaboradorNombre));
            entity.setColaboradorNumeroCelular(FacesUtils.checkString(
                    colaboradorNumeroCelular));
            entity.setColaboradorNumeroIdentificacion(FacesUtils.checkString(
                    colaboradorNumeroIdentificacion));
            entity.setColaboradorNumeroTelefono(FacesUtils.checkString(
                    colaboradorNumeroTelefono));
            businessDelegatorView.updateColaborador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ColaboradorView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtColaboradorApellido() {
        return txtColaboradorApellido;
    }

    public void setTxtColaboradorApellido(InputText txtColaboradorApellido) {
        this.txtColaboradorApellido = txtColaboradorApellido;
    }

    public InputText getTxtColaboradorBarrio() {
        return txtColaboradorBarrio;
    }

    public void setTxtColaboradorBarrio(InputText txtColaboradorBarrio) {
        this.txtColaboradorBarrio = txtColaboradorBarrio;
    }

    public InputText getTxtColaboradorCorreoElctronico() {
        return txtColaboradorCorreoElctronico;
    }

    public void setTxtColaboradorCorreoElctronico(
        InputText txtColaboradorCorreoElctronico) {
        this.txtColaboradorCorreoElctronico = txtColaboradorCorreoElctronico;
    }

    public InputText getTxtColaboradorDireccion() {
        return txtColaboradorDireccion;
    }

    public void setTxtColaboradorDireccion(InputText txtColaboradorDireccion) {
        this.txtColaboradorDireccion = txtColaboradorDireccion;
    }

    public InputText getTxtColaboradorNombre() {
        return txtColaboradorNombre;
    }

    public void setTxtColaboradorNombre(InputText txtColaboradorNombre) {
        this.txtColaboradorNombre = txtColaboradorNombre;
    }

    public InputText getTxtColaboradorNumeroCelular() {
        return txtColaboradorNumeroCelular;
    }

    public void setTxtColaboradorNumeroCelular(
        InputText txtColaboradorNumeroCelular) {
        this.txtColaboradorNumeroCelular = txtColaboradorNumeroCelular;
    }

    public InputText getTxtColaboradorNumeroIdentificacion() {
        return txtColaboradorNumeroIdentificacion;
    }

    public void setTxtColaboradorNumeroIdentificacion(
        InputText txtColaboradorNumeroIdentificacion) {
        this.txtColaboradorNumeroIdentificacion = txtColaboradorNumeroIdentificacion;
    }

    public InputText getTxtColaboradorNumeroTelefono() {
        return txtColaboradorNumeroTelefono;
    }

    public void setTxtColaboradorNumeroTelefono(
        InputText txtColaboradorNumeroTelefono) {
        this.txtColaboradorNumeroTelefono = txtColaboradorNumeroTelefono;
    }

    public InputText getTxtUsuarioId_Usuario() {
        return txtUsuarioId_Usuario;
    }

    public void setTxtUsuarioId_Usuario(InputText txtUsuarioId_Usuario) {
        this.txtUsuarioId_Usuario = txtUsuarioId_Usuario;
    }

    public Calendar getTxtColaboradorFechaCreacion() {
        return txtColaboradorFechaCreacion;
    }

    public void setTxtColaboradorFechaCreacion(
        Calendar txtColaboradorFechaCreacion) {
        this.txtColaboradorFechaCreacion = txtColaboradorFechaCreacion;
    }

    public Calendar getTxtColaboradorFechaModificacion() {
        return txtColaboradorFechaModificacion;
    }

    public void setTxtColaboradorFechaModificacion(
        Calendar txtColaboradorFechaModificacion) {
        this.txtColaboradorFechaModificacion = txtColaboradorFechaModificacion;
    }

    public Calendar getTxtColaboradorFechaNacimiento() {
        return txtColaboradorFechaNacimiento;
    }

    public void setTxtColaboradorFechaNacimiento(
        Calendar txtColaboradorFechaNacimiento) {
        this.txtColaboradorFechaNacimiento = txtColaboradorFechaNacimiento;
    }

    public InputText getTxtColaboradorId() {
        return txtColaboradorId;
    }

    public void setTxtColaboradorId(InputText txtColaboradorId) {
        this.txtColaboradorId = txtColaboradorId;
    }

    public List<ColaboradorDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataColaborador();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ColaboradorDTO> colaboradorDTO) {
        this.data = colaboradorDTO;
    }

    public ColaboradorDTO getSelectedColaborador() {
        return selectedColaborador;
    }

    public void setSelectedColaborador(ColaboradorDTO colaborador) {
        this.selectedColaborador = colaborador;
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
