package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.MembresiaDTO;

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
public class MembresiaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MembresiaView.class);
    private InputText txtMembresiaDerecha;
    private InputText txtMembresiaIzquierda;
    private InputText txtMembresiaNivel;
    private InputText txtMembresiaPorcentajeDescuento;
    private InputText txtMembresiaPuntos;
    private InputText txtConsumoId_Consumo;
    private InputText txtMiembroId_Miembro;
    private InputText txtMembresiaId;
    private Calendar txtMembresiaFecha;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<MembresiaDTO> data;
    private MembresiaDTO selectedMembresia;
    private Membresia entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public MembresiaView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            MembresiaDTO membresiaDTO = (MembresiaDTO) e.getObject();

            if (txtMembresiaDerecha == null) {
                txtMembresiaDerecha = new InputText();
            }

            txtMembresiaDerecha.setValue(membresiaDTO.getMembresiaDerecha());

            if (txtMembresiaIzquierda == null) {
                txtMembresiaIzquierda = new InputText();
            }

            txtMembresiaIzquierda.setValue(membresiaDTO.getMembresiaIzquierda());

            if (txtMembresiaNivel == null) {
                txtMembresiaNivel = new InputText();
            }

            txtMembresiaNivel.setValue(membresiaDTO.getMembresiaNivel());

            if (txtMembresiaPorcentajeDescuento == null) {
                txtMembresiaPorcentajeDescuento = new InputText();
            }

            txtMembresiaPorcentajeDescuento.setValue(membresiaDTO.getMembresiaPorcentajeDescuento());

            if (txtMembresiaPuntos == null) {
                txtMembresiaPuntos = new InputText();
            }

            txtMembresiaPuntos.setValue(membresiaDTO.getMembresiaPuntos());

            if (txtConsumoId_Consumo == null) {
                txtConsumoId_Consumo = new InputText();
            }

            txtConsumoId_Consumo.setValue(membresiaDTO.getConsumoId_Consumo());

            if (txtMiembroId_Miembro == null) {
                txtMiembroId_Miembro = new InputText();
            }

            txtMiembroId_Miembro.setValue(membresiaDTO.getMiembroId_Miembro());

            if (txtMembresiaId == null) {
                txtMembresiaId = new InputText();
            }

            txtMembresiaId.setValue(membresiaDTO.getMembresiaId());

            if (txtMembresiaFecha == null) {
                txtMembresiaFecha = new Calendar();
            }

            txtMembresiaFecha.setValue(membresiaDTO.getMembresiaFecha());

            Integer membresiaId = FacesUtils.checkInteger(txtMembresiaId);
            entity = businessDelegatorView.getMembresia(membresiaId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedMembresia = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedMembresia = null;

        if (txtMembresiaDerecha != null) {
            txtMembresiaDerecha.setValue(null);
            txtMembresiaDerecha.setDisabled(true);
        }

        if (txtMembresiaIzquierda != null) {
            txtMembresiaIzquierda.setValue(null);
            txtMembresiaIzquierda.setDisabled(true);
        }

        if (txtMembresiaNivel != null) {
            txtMembresiaNivel.setValue(null);
            txtMembresiaNivel.setDisabled(true);
        }

        if (txtMembresiaPorcentajeDescuento != null) {
            txtMembresiaPorcentajeDescuento.setValue(null);
            txtMembresiaPorcentajeDescuento.setDisabled(true);
        }

        if (txtMembresiaPuntos != null) {
            txtMembresiaPuntos.setValue(null);
            txtMembresiaPuntos.setDisabled(true);
        }

        if (txtConsumoId_Consumo != null) {
            txtConsumoId_Consumo.setValue(null);
            txtConsumoId_Consumo.setDisabled(true);
        }

        if (txtMiembroId_Miembro != null) {
            txtMiembroId_Miembro.setValue(null);
            txtMiembroId_Miembro.setDisabled(true);
        }

        if (txtMembresiaFecha != null) {
            txtMembresiaFecha.setValue(null);
            txtMembresiaFecha.setDisabled(true);
        }

        if (txtMembresiaId != null) {
            txtMembresiaId.setValue(null);
            txtMembresiaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtMembresiaFecha() {
        Date inputDate = (Date) txtMembresiaFecha.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer membresiaId = FacesUtils.checkInteger(txtMembresiaId);
            entity = (membresiaId != null)
                ? businessDelegatorView.getMembresia(membresiaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtMembresiaDerecha.setDisabled(false);
            txtMembresiaIzquierda.setDisabled(false);
            txtMembresiaNivel.setDisabled(false);
            txtMembresiaPorcentajeDescuento.setDisabled(false);
            txtMembresiaPuntos.setDisabled(false);
            txtConsumoId_Consumo.setDisabled(false);
            txtMiembroId_Miembro.setDisabled(false);
            txtMembresiaFecha.setDisabled(false);
            txtMembresiaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtMembresiaDerecha.setValue(entity.getMembresiaDerecha());
            txtMembresiaDerecha.setDisabled(false);
            txtMembresiaFecha.setValue(entity.getMembresiaFecha());
            txtMembresiaFecha.setDisabled(false);
            txtMembresiaIzquierda.setValue(entity.getMembresiaIzquierda());
            txtMembresiaIzquierda.setDisabled(false);
            txtMembresiaNivel.setValue(entity.getMembresiaNivel());
            txtMembresiaNivel.setDisabled(false);
            txtMembresiaPorcentajeDescuento.setValue(entity.getMembresiaPorcentajeDescuento());
            txtMembresiaPorcentajeDescuento.setDisabled(false);
            txtMembresiaPuntos.setValue(entity.getMembresiaPuntos());
            txtMembresiaPuntos.setDisabled(false);
            txtConsumoId_Consumo.setValue(entity.getConsumo().getConsumoId());
            txtConsumoId_Consumo.setDisabled(false);
            txtMiembroId_Miembro.setValue(entity.getMiembro().getMiembroId());
            txtMiembroId_Miembro.setDisabled(false);
            txtMembresiaId.setValue(entity.getMembresiaId());
            txtMembresiaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedMembresia = (MembresiaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedMembresia"));
        txtMembresiaDerecha.setValue(selectedMembresia.getMembresiaDerecha());
        txtMembresiaDerecha.setDisabled(false);
        txtMembresiaFecha.setValue(selectedMembresia.getMembresiaFecha());
        txtMembresiaFecha.setDisabled(false);
        txtMembresiaIzquierda.setValue(selectedMembresia.getMembresiaIzquierda());
        txtMembresiaIzquierda.setDisabled(false);
        txtMembresiaNivel.setValue(selectedMembresia.getMembresiaNivel());
        txtMembresiaNivel.setDisabled(false);
        txtMembresiaPorcentajeDescuento.setValue(selectedMembresia.getMembresiaPorcentajeDescuento());
        txtMembresiaPorcentajeDescuento.setDisabled(false);
        txtMembresiaPuntos.setValue(selectedMembresia.getMembresiaPuntos());
        txtMembresiaPuntos.setDisabled(false);
        txtConsumoId_Consumo.setValue(selectedMembresia.getConsumoId_Consumo());
        txtConsumoId_Consumo.setDisabled(false);
        txtMiembroId_Miembro.setValue(selectedMembresia.getMiembroId_Miembro());
        txtMiembroId_Miembro.setDisabled(false);
        txtMembresiaId.setValue(selectedMembresia.getMembresiaId());
        txtMembresiaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedMembresia == null) && (entity == null)) {
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
            entity = new Membresia();

            Integer membresiaId = FacesUtils.checkInteger(txtMembresiaId);

            entity.setMembresiaDerecha(FacesUtils.checkInteger(
                    txtMembresiaDerecha));
            entity.setMembresiaFecha(FacesUtils.checkDate(txtMembresiaFecha));
            entity.setMembresiaId(membresiaId);
            entity.setMembresiaIzquierda(FacesUtils.checkInteger(
                    txtMembresiaIzquierda));
            entity.setMembresiaNivel(FacesUtils.checkInteger(txtMembresiaNivel));
            entity.setMembresiaPorcentajeDescuento(FacesUtils.checkDouble(
                    txtMembresiaPorcentajeDescuento));
            entity.setMembresiaPuntos(FacesUtils.checkInteger(
                    txtMembresiaPuntos));
            entity.setConsumo((FacesUtils.checkInteger(txtConsumoId_Consumo) != null)
                ? businessDelegatorView.getConsumo(FacesUtils.checkInteger(
                        txtConsumoId_Consumo)) : null);
            entity.setMiembro((FacesUtils.checkInteger(txtMiembroId_Miembro) != null)
                ? businessDelegatorView.getMiembro(FacesUtils.checkInteger(
                        txtMiembroId_Miembro)) : null);
            businessDelegatorView.saveMembresia(entity);
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
                Integer membresiaId = new Integer(selectedMembresia.getMembresiaId());
                entity = businessDelegatorView.getMembresia(membresiaId);
            }

            entity.setMembresiaDerecha(FacesUtils.checkInteger(
                    txtMembresiaDerecha));
            entity.setMembresiaFecha(FacesUtils.checkDate(txtMembresiaFecha));
            entity.setMembresiaIzquierda(FacesUtils.checkInteger(
                    txtMembresiaIzquierda));
            entity.setMembresiaNivel(FacesUtils.checkInteger(txtMembresiaNivel));
            entity.setMembresiaPorcentajeDescuento(FacesUtils.checkDouble(
                    txtMembresiaPorcentajeDescuento));
            entity.setMembresiaPuntos(FacesUtils.checkInteger(
                    txtMembresiaPuntos));
            entity.setConsumo((FacesUtils.checkInteger(txtConsumoId_Consumo) != null)
                ? businessDelegatorView.getConsumo(FacesUtils.checkInteger(
                        txtConsumoId_Consumo)) : null);
            entity.setMiembro((FacesUtils.checkInteger(txtMiembroId_Miembro) != null)
                ? businessDelegatorView.getMiembro(FacesUtils.checkInteger(
                        txtMiembroId_Miembro)) : null);
            businessDelegatorView.updateMembresia(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedMembresia = (MembresiaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedMembresia"));

            Integer membresiaId = new Integer(selectedMembresia.getMembresiaId());
            entity = businessDelegatorView.getMembresia(membresiaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer membresiaId = FacesUtils.checkInteger(txtMembresiaId);
            entity = businessDelegatorView.getMembresia(membresiaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteMembresia(entity);
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
            selectedMembresia = (MembresiaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedMembresia"));

            Integer membresiaId = new Integer(selectedMembresia.getMembresiaId());
            entity = businessDelegatorView.getMembresia(membresiaId);
            businessDelegatorView.deleteMembresia(entity);
            data.remove(selectedMembresia);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Integer membresiaDerecha,
        Date membresiaFecha, Integer membresiaId, Integer membresiaIzquierda,
        Integer membresiaNivel, Double membresiaPorcentajeDescuento,
        Integer membresiaPuntos, Integer consumoId_Consumo,
        Integer miembroId_Miembro) throws Exception {
        try {
            entity.setMembresiaDerecha(FacesUtils.checkInteger(membresiaDerecha));
            entity.setMembresiaFecha(FacesUtils.checkDate(membresiaFecha));
            entity.setMembresiaIzquierda(FacesUtils.checkInteger(
                    membresiaIzquierda));
            entity.setMembresiaNivel(FacesUtils.checkInteger(membresiaNivel));
            entity.setMembresiaPorcentajeDescuento(FacesUtils.checkDouble(
                    membresiaPorcentajeDescuento));
            entity.setMembresiaPuntos(FacesUtils.checkInteger(membresiaPuntos));
            businessDelegatorView.updateMembresia(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("MembresiaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtMembresiaDerecha() {
        return txtMembresiaDerecha;
    }

    public void setTxtMembresiaDerecha(InputText txtMembresiaDerecha) {
        this.txtMembresiaDerecha = txtMembresiaDerecha;
    }

    public InputText getTxtMembresiaIzquierda() {
        return txtMembresiaIzquierda;
    }

    public void setTxtMembresiaIzquierda(InputText txtMembresiaIzquierda) {
        this.txtMembresiaIzquierda = txtMembresiaIzquierda;
    }

    public InputText getTxtMembresiaNivel() {
        return txtMembresiaNivel;
    }

    public void setTxtMembresiaNivel(InputText txtMembresiaNivel) {
        this.txtMembresiaNivel = txtMembresiaNivel;
    }

    public InputText getTxtMembresiaPorcentajeDescuento() {
        return txtMembresiaPorcentajeDescuento;
    }

    public void setTxtMembresiaPorcentajeDescuento(
        InputText txtMembresiaPorcentajeDescuento) {
        this.txtMembresiaPorcentajeDescuento = txtMembresiaPorcentajeDescuento;
    }

    public InputText getTxtMembresiaPuntos() {
        return txtMembresiaPuntos;
    }

    public void setTxtMembresiaPuntos(InputText txtMembresiaPuntos) {
        this.txtMembresiaPuntos = txtMembresiaPuntos;
    }

    public InputText getTxtConsumoId_Consumo() {
        return txtConsumoId_Consumo;
    }

    public void setTxtConsumoId_Consumo(InputText txtConsumoId_Consumo) {
        this.txtConsumoId_Consumo = txtConsumoId_Consumo;
    }

    public InputText getTxtMiembroId_Miembro() {
        return txtMiembroId_Miembro;
    }

    public void setTxtMiembroId_Miembro(InputText txtMiembroId_Miembro) {
        this.txtMiembroId_Miembro = txtMiembroId_Miembro;
    }

    public Calendar getTxtMembresiaFecha() {
        return txtMembresiaFecha;
    }

    public void setTxtMembresiaFecha(Calendar txtMembresiaFecha) {
        this.txtMembresiaFecha = txtMembresiaFecha;
    }

    public InputText getTxtMembresiaId() {
        return txtMembresiaId;
    }

    public void setTxtMembresiaId(InputText txtMembresiaId) {
        this.txtMembresiaId = txtMembresiaId;
    }

    public List<MembresiaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataMembresia();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<MembresiaDTO> membresiaDTO) {
        this.data = membresiaDTO;
    }

    public MembresiaDTO getSelectedMembresia() {
        return selectedMembresia;
    }

    public void setSelectedMembresia(MembresiaDTO membresia) {
        this.selectedMembresia = membresia;
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
