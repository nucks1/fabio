package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ClienteDTO;

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
public class ClienteView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ClienteView.class);
    private InputText txtClienteApellido;
    private InputText txtClienteBarrio;
    private InputText txtClienteCorreoElctronico;
    private InputText txtClienteDireccion;
    private InputText txtClienteNombre;
    private InputText txtClienteNumeroCelular;
    private InputText txtClienteNumeroIdentificacion;
    private InputText txtClienteNumeroTelefono;
    private InputText txtClienteId;
    private Calendar txtClienteFechaCreacion;
    private Calendar txtClienteFechaModificacion;
    private Calendar txtClienteFechaNacimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ClienteDTO> data;
    private ClienteDTO selectedCliente;
    private Cliente entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ClienteView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ClienteDTO clienteDTO = (ClienteDTO) e.getObject();

            if (txtClienteApellido == null) {
                txtClienteApellido = new InputText();
            }

            txtClienteApellido.setValue(clienteDTO.getClienteApellido());

            if (txtClienteBarrio == null) {
                txtClienteBarrio = new InputText();
            }

            txtClienteBarrio.setValue(clienteDTO.getClienteBarrio());

            if (txtClienteCorreoElctronico == null) {
                txtClienteCorreoElctronico = new InputText();
            }

            txtClienteCorreoElctronico.setValue(clienteDTO.getClienteCorreoElctronico());

            if (txtClienteDireccion == null) {
                txtClienteDireccion = new InputText();
            }

            txtClienteDireccion.setValue(clienteDTO.getClienteDireccion());

            if (txtClienteNombre == null) {
                txtClienteNombre = new InputText();
            }

            txtClienteNombre.setValue(clienteDTO.getClienteNombre());

            if (txtClienteNumeroCelular == null) {
                txtClienteNumeroCelular = new InputText();
            }

            txtClienteNumeroCelular.setValue(clienteDTO.getClienteNumeroCelular());

            if (txtClienteNumeroIdentificacion == null) {
                txtClienteNumeroIdentificacion = new InputText();
            }

            txtClienteNumeroIdentificacion.setValue(clienteDTO.getClienteNumeroIdentificacion());

            if (txtClienteNumeroTelefono == null) {
                txtClienteNumeroTelefono = new InputText();
            }

            txtClienteNumeroTelefono.setValue(clienteDTO.getClienteNumeroTelefono());

            if (txtClienteId == null) {
                txtClienteId = new InputText();
            }

            txtClienteId.setValue(clienteDTO.getClienteId());

            if (txtClienteFechaCreacion == null) {
                txtClienteFechaCreacion = new Calendar();
            }

            txtClienteFechaCreacion.setValue(clienteDTO.getClienteFechaCreacion());

            if (txtClienteFechaModificacion == null) {
                txtClienteFechaModificacion = new Calendar();
            }

            txtClienteFechaModificacion.setValue(clienteDTO.getClienteFechaModificacion());

            if (txtClienteFechaNacimiento == null) {
                txtClienteFechaNacimiento = new Calendar();
            }

            txtClienteFechaNacimiento.setValue(clienteDTO.getClienteFechaNacimiento());

            Integer clienteId = FacesUtils.checkInteger(txtClienteId);
            entity = businessDelegatorView.getCliente(clienteId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedCliente = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCliente = null;

        if (txtClienteApellido != null) {
            txtClienteApellido.setValue(null);
            txtClienteApellido.setDisabled(true);
        }

        if (txtClienteBarrio != null) {
            txtClienteBarrio.setValue(null);
            txtClienteBarrio.setDisabled(true);
        }

        if (txtClienteCorreoElctronico != null) {
            txtClienteCorreoElctronico.setValue(null);
            txtClienteCorreoElctronico.setDisabled(true);
        }

        if (txtClienteDireccion != null) {
            txtClienteDireccion.setValue(null);
            txtClienteDireccion.setDisabled(true);
        }

        if (txtClienteNombre != null) {
            txtClienteNombre.setValue(null);
            txtClienteNombre.setDisabled(true);
        }

        if (txtClienteNumeroCelular != null) {
            txtClienteNumeroCelular.setValue(null);
            txtClienteNumeroCelular.setDisabled(true);
        }

        if (txtClienteNumeroIdentificacion != null) {
            txtClienteNumeroIdentificacion.setValue(null);
            txtClienteNumeroIdentificacion.setDisabled(true);
        }

        if (txtClienteNumeroTelefono != null) {
            txtClienteNumeroTelefono.setValue(null);
            txtClienteNumeroTelefono.setDisabled(true);
        }

        if (txtClienteFechaCreacion != null) {
            txtClienteFechaCreacion.setValue(null);
            txtClienteFechaCreacion.setDisabled(true);
        }

        if (txtClienteFechaModificacion != null) {
            txtClienteFechaModificacion.setValue(null);
            txtClienteFechaModificacion.setDisabled(true);
        }

        if (txtClienteFechaNacimiento != null) {
            txtClienteFechaNacimiento.setValue(null);
            txtClienteFechaNacimiento.setDisabled(true);
        }

        if (txtClienteId != null) {
            txtClienteId.setValue(null);
            txtClienteId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtClienteFechaCreacion() {
        Date inputDate = (Date) txtClienteFechaCreacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtClienteFechaModificacion() {
        Date inputDate = (Date) txtClienteFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtClienteFechaNacimiento() {
        Date inputDate = (Date) txtClienteFechaNacimiento.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer clienteId = FacesUtils.checkInteger(txtClienteId);
            entity = (clienteId != null)
                ? businessDelegatorView.getCliente(clienteId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtClienteApellido.setDisabled(false);
            txtClienteBarrio.setDisabled(false);
            txtClienteCorreoElctronico.setDisabled(false);
            txtClienteDireccion.setDisabled(false);
            txtClienteNombre.setDisabled(false);
            txtClienteNumeroCelular.setDisabled(false);
            txtClienteNumeroIdentificacion.setDisabled(false);
            txtClienteNumeroTelefono.setDisabled(false);
            txtClienteFechaCreacion.setDisabled(false);
            txtClienteFechaModificacion.setDisabled(false);
            txtClienteFechaNacimiento.setDisabled(false);
            txtClienteId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtClienteApellido.setValue(entity.getClienteApellido());
            txtClienteApellido.setDisabled(false);
            txtClienteBarrio.setValue(entity.getClienteBarrio());
            txtClienteBarrio.setDisabled(false);
            txtClienteCorreoElctronico.setValue(entity.getClienteCorreoElctronico());
            txtClienteCorreoElctronico.setDisabled(false);
            txtClienteDireccion.setValue(entity.getClienteDireccion());
            txtClienteDireccion.setDisabled(false);
            txtClienteFechaCreacion.setValue(entity.getClienteFechaCreacion());
            txtClienteFechaCreacion.setDisabled(false);
            txtClienteFechaModificacion.setValue(entity.getClienteFechaModificacion());
            txtClienteFechaModificacion.setDisabled(false);
            txtClienteFechaNacimiento.setValue(entity.getClienteFechaNacimiento());
            txtClienteFechaNacimiento.setDisabled(false);
            txtClienteNombre.setValue(entity.getClienteNombre());
            txtClienteNombre.setDisabled(false);
            txtClienteNumeroCelular.setValue(entity.getClienteNumeroCelular());
            txtClienteNumeroCelular.setDisabled(false);
            txtClienteNumeroIdentificacion.setValue(entity.getClienteNumeroIdentificacion());
            txtClienteNumeroIdentificacion.setDisabled(false);
            txtClienteNumeroTelefono.setValue(entity.getClienteNumeroTelefono());
            txtClienteNumeroTelefono.setDisabled(false);
            txtClienteId.setValue(entity.getClienteId());
            txtClienteId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCliente = (ClienteDTO) (evt.getComponent().getAttributes()
                                           .get("selectedCliente"));
        txtClienteApellido.setValue(selectedCliente.getClienteApellido());
        txtClienteApellido.setDisabled(false);
        txtClienteBarrio.setValue(selectedCliente.getClienteBarrio());
        txtClienteBarrio.setDisabled(false);
        txtClienteCorreoElctronico.setValue(selectedCliente.getClienteCorreoElctronico());
        txtClienteCorreoElctronico.setDisabled(false);
        txtClienteDireccion.setValue(selectedCliente.getClienteDireccion());
        txtClienteDireccion.setDisabled(false);
        txtClienteFechaCreacion.setValue(selectedCliente.getClienteFechaCreacion());
        txtClienteFechaCreacion.setDisabled(false);
        txtClienteFechaModificacion.setValue(selectedCliente.getClienteFechaModificacion());
        txtClienteFechaModificacion.setDisabled(false);
        txtClienteFechaNacimiento.setValue(selectedCliente.getClienteFechaNacimiento());
        txtClienteFechaNacimiento.setDisabled(false);
        txtClienteNombre.setValue(selectedCliente.getClienteNombre());
        txtClienteNombre.setDisabled(false);
        txtClienteNumeroCelular.setValue(selectedCliente.getClienteNumeroCelular());
        txtClienteNumeroCelular.setDisabled(false);
        txtClienteNumeroIdentificacion.setValue(selectedCliente.getClienteNumeroIdentificacion());
        txtClienteNumeroIdentificacion.setDisabled(false);
        txtClienteNumeroTelefono.setValue(selectedCliente.getClienteNumeroTelefono());
        txtClienteNumeroTelefono.setDisabled(false);
        txtClienteId.setValue(selectedCliente.getClienteId());
        txtClienteId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCliente == null) && (entity == null)) {
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
            entity = new Cliente();

            Integer clienteId = FacesUtils.checkInteger(txtClienteId);

            entity.setClienteApellido(FacesUtils.checkString(txtClienteApellido));
            entity.setClienteBarrio(FacesUtils.checkString(txtClienteBarrio));
            entity.setClienteCorreoElctronico(FacesUtils.checkString(
                    txtClienteCorreoElctronico));
            entity.setClienteDireccion(FacesUtils.checkString(
                    txtClienteDireccion));
            entity.setClienteFechaCreacion(FacesUtils.checkDate(
                    txtClienteFechaCreacion));
            entity.setClienteFechaModificacion(FacesUtils.checkDate(
                    txtClienteFechaModificacion));
            entity.setClienteFechaNacimiento(FacesUtils.checkDate(
                    txtClienteFechaNacimiento));
            entity.setClienteId(clienteId);
            entity.setClienteNombre(FacesUtils.checkString(txtClienteNombre));
            entity.setClienteNumeroCelular(FacesUtils.checkString(
                    txtClienteNumeroCelular));
            entity.setClienteNumeroIdentificacion(FacesUtils.checkString(
                    txtClienteNumeroIdentificacion));
            entity.setClienteNumeroTelefono(FacesUtils.checkString(
                    txtClienteNumeroTelefono));
            businessDelegatorView.saveCliente(entity);
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
                Integer clienteId = new Integer(selectedCliente.getClienteId());
                entity = businessDelegatorView.getCliente(clienteId);
            }

            entity.setClienteApellido(FacesUtils.checkString(txtClienteApellido));
            entity.setClienteBarrio(FacesUtils.checkString(txtClienteBarrio));
            entity.setClienteCorreoElctronico(FacesUtils.checkString(
                    txtClienteCorreoElctronico));
            entity.setClienteDireccion(FacesUtils.checkString(
                    txtClienteDireccion));
            entity.setClienteFechaCreacion(FacesUtils.checkDate(
                    txtClienteFechaCreacion));
            entity.setClienteFechaModificacion(FacesUtils.checkDate(
                    txtClienteFechaModificacion));
            entity.setClienteFechaNacimiento(FacesUtils.checkDate(
                    txtClienteFechaNacimiento));
            entity.setClienteNombre(FacesUtils.checkString(txtClienteNombre));
            entity.setClienteNumeroCelular(FacesUtils.checkString(
                    txtClienteNumeroCelular));
            entity.setClienteNumeroIdentificacion(FacesUtils.checkString(
                    txtClienteNumeroIdentificacion));
            entity.setClienteNumeroTelefono(FacesUtils.checkString(
                    txtClienteNumeroTelefono));
            businessDelegatorView.updateCliente(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCliente = (ClienteDTO) (evt.getComponent().getAttributes()
                                               .get("selectedCliente"));

            Integer clienteId = new Integer(selectedCliente.getClienteId());
            entity = businessDelegatorView.getCliente(clienteId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer clienteId = FacesUtils.checkInteger(txtClienteId);
            entity = businessDelegatorView.getCliente(clienteId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCliente(entity);
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
            selectedCliente = (ClienteDTO) (evt.getComponent().getAttributes()
                                               .get("selectedCliente"));

            Integer clienteId = new Integer(selectedCliente.getClienteId());
            entity = businessDelegatorView.getCliente(clienteId);
            businessDelegatorView.deleteCliente(entity);
            data.remove(selectedCliente);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String clienteApellido,
        String clienteBarrio, String clienteCorreoElctronico,
        String clienteDireccion, Date clienteFechaCreacion,
        Date clienteFechaModificacion, Date clienteFechaNacimiento,
        Integer clienteId, String clienteNombre, String clienteNumeroCelular,
        String clienteNumeroIdentificacion, String clienteNumeroTelefono)
        throws Exception {
        try {
            entity.setClienteApellido(FacesUtils.checkString(clienteApellido));
            entity.setClienteBarrio(FacesUtils.checkString(clienteBarrio));
            entity.setClienteCorreoElctronico(FacesUtils.checkString(
                    clienteCorreoElctronico));
            entity.setClienteDireccion(FacesUtils.checkString(clienteDireccion));
            entity.setClienteFechaCreacion(FacesUtils.checkDate(
                    clienteFechaCreacion));
            entity.setClienteFechaModificacion(FacesUtils.checkDate(
                    clienteFechaModificacion));
            entity.setClienteFechaNacimiento(FacesUtils.checkDate(
                    clienteFechaNacimiento));
            entity.setClienteNombre(FacesUtils.checkString(clienteNombre));
            entity.setClienteNumeroCelular(FacesUtils.checkString(
                    clienteNumeroCelular));
            entity.setClienteNumeroIdentificacion(FacesUtils.checkString(
                    clienteNumeroIdentificacion));
            entity.setClienteNumeroTelefono(FacesUtils.checkString(
                    clienteNumeroTelefono));
            businessDelegatorView.updateCliente(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ClienteView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtClienteApellido() {
        return txtClienteApellido;
    }

    public void setTxtClienteApellido(InputText txtClienteApellido) {
        this.txtClienteApellido = txtClienteApellido;
    }

    public InputText getTxtClienteBarrio() {
        return txtClienteBarrio;
    }

    public void setTxtClienteBarrio(InputText txtClienteBarrio) {
        this.txtClienteBarrio = txtClienteBarrio;
    }

    public InputText getTxtClienteCorreoElctronico() {
        return txtClienteCorreoElctronico;
    }

    public void setTxtClienteCorreoElctronico(
        InputText txtClienteCorreoElctronico) {
        this.txtClienteCorreoElctronico = txtClienteCorreoElctronico;
    }

    public InputText getTxtClienteDireccion() {
        return txtClienteDireccion;
    }

    public void setTxtClienteDireccion(InputText txtClienteDireccion) {
        this.txtClienteDireccion = txtClienteDireccion;
    }

    public InputText getTxtClienteNombre() {
        return txtClienteNombre;
    }

    public void setTxtClienteNombre(InputText txtClienteNombre) {
        this.txtClienteNombre = txtClienteNombre;
    }

    public InputText getTxtClienteNumeroCelular() {
        return txtClienteNumeroCelular;
    }

    public void setTxtClienteNumeroCelular(InputText txtClienteNumeroCelular) {
        this.txtClienteNumeroCelular = txtClienteNumeroCelular;
    }

    public InputText getTxtClienteNumeroIdentificacion() {
        return txtClienteNumeroIdentificacion;
    }

    public void setTxtClienteNumeroIdentificacion(
        InputText txtClienteNumeroIdentificacion) {
        this.txtClienteNumeroIdentificacion = txtClienteNumeroIdentificacion;
    }

    public InputText getTxtClienteNumeroTelefono() {
        return txtClienteNumeroTelefono;
    }

    public void setTxtClienteNumeroTelefono(InputText txtClienteNumeroTelefono) {
        this.txtClienteNumeroTelefono = txtClienteNumeroTelefono;
    }

    public Calendar getTxtClienteFechaCreacion() {
        return txtClienteFechaCreacion;
    }

    public void setTxtClienteFechaCreacion(Calendar txtClienteFechaCreacion) {
        this.txtClienteFechaCreacion = txtClienteFechaCreacion;
    }

    public Calendar getTxtClienteFechaModificacion() {
        return txtClienteFechaModificacion;
    }

    public void setTxtClienteFechaModificacion(
        Calendar txtClienteFechaModificacion) {
        this.txtClienteFechaModificacion = txtClienteFechaModificacion;
    }

    public Calendar getTxtClienteFechaNacimiento() {
        return txtClienteFechaNacimiento;
    }

    public void setTxtClienteFechaNacimiento(Calendar txtClienteFechaNacimiento) {
        this.txtClienteFechaNacimiento = txtClienteFechaNacimiento;
    }

    public InputText getTxtClienteId() {
        return txtClienteId;
    }

    public void setTxtClienteId(InputText txtClienteId) {
        this.txtClienteId = txtClienteId;
    }

    public List<ClienteDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCliente();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ClienteDTO> clienteDTO) {
        this.data = clienteDTO;
    }

    public ClienteDTO getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(ClienteDTO cliente) {
        this.selectedCliente = cliente;
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
