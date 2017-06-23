package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.ProductoDTO;

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
public class ProductoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ProductoView.class);
    private InputText txtProductoBeneficios;
    private InputText txtProductoCantidad;
    private InputText txtProductoImagen;
    private InputText txtClaseTipoId_ClaseTipo;
    private InputText txtProductoId;
    private Calendar txtProductoFechaCrecaion;
    private Calendar txtProductoFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<ProductoDTO> data;
    private ProductoDTO selectedProducto;
    private Producto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public ProductoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            ProductoDTO productoDTO = (ProductoDTO) e.getObject();

            if (txtProductoBeneficios == null) {
                txtProductoBeneficios = new InputText();
            }

            txtProductoBeneficios.setValue(productoDTO.getProductoBeneficios());

            if (txtProductoCantidad == null) {
                txtProductoCantidad = new InputText();
            }

            txtProductoCantidad.setValue(productoDTO.getProductoCantidad());

            if (txtProductoImagen == null) {
                txtProductoImagen = new InputText();
            }

            txtProductoImagen.setValue(productoDTO.getProductoImagen());

            if (txtClaseTipoId_ClaseTipo == null) {
                txtClaseTipoId_ClaseTipo = new InputText();
            }

            txtClaseTipoId_ClaseTipo.setValue(productoDTO.getClaseTipoId_ClaseTipo());

            if (txtProductoId == null) {
                txtProductoId = new InputText();
            }

            txtProductoId.setValue(productoDTO.getProductoId());

            if (txtProductoFechaCrecaion == null) {
                txtProductoFechaCrecaion = new Calendar();
            }

            txtProductoFechaCrecaion.setValue(productoDTO.getProductoFechaCrecaion());

            if (txtProductoFechaModificacion == null) {
                txtProductoFechaModificacion = new Calendar();
            }

            txtProductoFechaModificacion.setValue(productoDTO.getProductoFechaModificacion());

            Integer productoId = FacesUtils.checkInteger(txtProductoId);
            entity = businessDelegatorView.getProducto(productoId);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedProducto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedProducto = null;

        if (txtProductoBeneficios != null) {
            txtProductoBeneficios.setValue(null);
            txtProductoBeneficios.setDisabled(true);
        }

        if (txtProductoCantidad != null) {
            txtProductoCantidad.setValue(null);
            txtProductoCantidad.setDisabled(true);
        }

        if (txtProductoImagen != null) {
            txtProductoImagen.setValue(null);
            txtProductoImagen.setDisabled(true);
        }

        if (txtClaseTipoId_ClaseTipo != null) {
            txtClaseTipoId_ClaseTipo.setValue(null);
            txtClaseTipoId_ClaseTipo.setDisabled(true);
        }

        if (txtProductoFechaCrecaion != null) {
            txtProductoFechaCrecaion.setValue(null);
            txtProductoFechaCrecaion.setDisabled(true);
        }

        if (txtProductoFechaModificacion != null) {
            txtProductoFechaModificacion.setValue(null);
            txtProductoFechaModificacion.setDisabled(true);
        }

        if (txtProductoId != null) {
            txtProductoId.setValue(null);
            txtProductoId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtProductoFechaCrecaion() {
        Date inputDate = (Date) txtProductoFechaCrecaion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtProductoFechaModificacion() {
        Date inputDate = (Date) txtProductoFechaModificacion.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer productoId = FacesUtils.checkInteger(txtProductoId);
            entity = (productoId != null)
                ? businessDelegatorView.getProducto(productoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtProductoBeneficios.setDisabled(false);
            txtProductoCantidad.setDisabled(false);
            txtProductoImagen.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtProductoFechaCrecaion.setDisabled(false);
            txtProductoFechaModificacion.setDisabled(false);
            txtProductoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtProductoBeneficios.setValue(entity.getProductoBeneficios());
            txtProductoBeneficios.setDisabled(false);
            txtProductoCantidad.setValue(entity.getProductoCantidad());
            txtProductoCantidad.setDisabled(false);
            txtProductoFechaCrecaion.setValue(entity.getProductoFechaCrecaion());
            txtProductoFechaCrecaion.setDisabled(false);
            txtProductoFechaModificacion.setValue(entity.getProductoFechaModificacion());
            txtProductoFechaModificacion.setDisabled(false);
            txtProductoImagen.setValue(entity.getProductoImagen());
            txtProductoImagen.setDisabled(false);
            txtClaseTipoId_ClaseTipo.setValue(entity.getClaseTipo()
                                                    .getClaseTipoId());
            txtClaseTipoId_ClaseTipo.setDisabled(false);
            txtProductoId.setValue(entity.getProductoId());
            txtProductoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedProducto"));
        txtProductoBeneficios.setValue(selectedProducto.getProductoBeneficios());
        txtProductoBeneficios.setDisabled(false);
        txtProductoCantidad.setValue(selectedProducto.getProductoCantidad());
        txtProductoCantidad.setDisabled(false);
        txtProductoFechaCrecaion.setValue(selectedProducto.getProductoFechaCrecaion());
        txtProductoFechaCrecaion.setDisabled(false);
        txtProductoFechaModificacion.setValue(selectedProducto.getProductoFechaModificacion());
        txtProductoFechaModificacion.setDisabled(false);
        txtProductoImagen.setValue(selectedProducto.getProductoImagen());
        txtProductoImagen.setDisabled(false);
        txtClaseTipoId_ClaseTipo.setValue(selectedProducto.getClaseTipoId_ClaseTipo());
        txtClaseTipoId_ClaseTipo.setDisabled(false);
        txtProductoId.setValue(selectedProducto.getProductoId());
        txtProductoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedProducto == null) && (entity == null)) {
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
            entity = new Producto();

            Integer productoId = FacesUtils.checkInteger(txtProductoId);

            entity.setProductoBeneficios(FacesUtils.checkString(
                    txtProductoBeneficios));
            entity.setProductoCantidad(FacesUtils.checkInteger(
                    txtProductoCantidad));
            entity.setProductoFechaCrecaion(FacesUtils.checkDate(
                    txtProductoFechaCrecaion));
            entity.setProductoFechaModificacion(FacesUtils.checkDate(
                    txtProductoFechaModificacion));
            entity.setProductoId(productoId);
            entity.setProductoImagen(FacesUtils.checkString(txtProductoImagen));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            //entity.setServicios(FacesUtils.checkServicio(txtServicios));
            businessDelegatorView.saveProducto(entity);
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
                Integer productoId = new Integer(selectedProducto.getProductoId());
                entity = businessDelegatorView.getProducto(productoId);
            }

            entity.setProductoBeneficios(FacesUtils.checkString(
                    txtProductoBeneficios));
            entity.setProductoCantidad(FacesUtils.checkInteger(
                    txtProductoCantidad));
            entity.setProductoFechaCrecaion(FacesUtils.checkDate(
                    txtProductoFechaCrecaion));
            entity.setProductoFechaModificacion(FacesUtils.checkDate(
                    txtProductoFechaModificacion));
            entity.setProductoImagen(FacesUtils.checkString(txtProductoImagen));
            entity.setClaseTipo((FacesUtils.checkInteger(
                    txtClaseTipoId_ClaseTipo) != null)
                ? businessDelegatorView.getClaseTipo(FacesUtils.checkInteger(
                        txtClaseTipoId_ClaseTipo)) : null);
            //entity.setServicios(FacesUtils.checkServicio(txtServicios));
            businessDelegatorView.updateProducto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedProducto"));

            Integer productoId = new Integer(selectedProducto.getProductoId());
            entity = businessDelegatorView.getProducto(productoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer productoId = FacesUtils.checkInteger(txtProductoId);
            entity = businessDelegatorView.getProducto(productoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteProducto(entity);
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
            selectedProducto = (ProductoDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedProducto"));

            Integer productoId = new Integer(selectedProducto.getProductoId());
            entity = businessDelegatorView.getProducto(productoId);
            businessDelegatorView.deleteProducto(entity);
            data.remove(selectedProducto);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String productoBeneficios,
        Integer productoCantidad, Date productoFechaCrecaion,
        Date productoFechaModificacion, Integer productoId,
        String productoImagen, Integer claseTipoId_ClaseTipo)
        throws Exception {
        try {
            entity.setProductoBeneficios(FacesUtils.checkString(
                    productoBeneficios));
            entity.setProductoCantidad(FacesUtils.checkInteger(productoCantidad));
            entity.setProductoFechaCrecaion(FacesUtils.checkDate(
                    productoFechaCrecaion));
            entity.setProductoFechaModificacion(FacesUtils.checkDate(
                    productoFechaModificacion));
            entity.setProductoImagen(FacesUtils.checkString(productoImagen));
            businessDelegatorView.updateProducto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("ProductoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtProductoBeneficios() {
        return txtProductoBeneficios;
    }

    public void setTxtProductoBeneficios(InputText txtProductoBeneficios) {
        this.txtProductoBeneficios = txtProductoBeneficios;
    }

    public InputText getTxtProductoCantidad() {
        return txtProductoCantidad;
    }

    public void setTxtProductoCantidad(InputText txtProductoCantidad) {
        this.txtProductoCantidad = txtProductoCantidad;
    }

    public InputText getTxtProductoImagen() {
        return txtProductoImagen;
    }

    public void setTxtProductoImagen(InputText txtProductoImagen) {
        this.txtProductoImagen = txtProductoImagen;
    }

    public InputText getTxtClaseTipoId_ClaseTipo() {
        return txtClaseTipoId_ClaseTipo;
    }

    public void setTxtClaseTipoId_ClaseTipo(InputText txtClaseTipoId_ClaseTipo) {
        this.txtClaseTipoId_ClaseTipo = txtClaseTipoId_ClaseTipo;
    }

    public Calendar getTxtProductoFechaCrecaion() {
        return txtProductoFechaCrecaion;
    }

    public void setTxtProductoFechaCrecaion(Calendar txtProductoFechaCrecaion) {
        this.txtProductoFechaCrecaion = txtProductoFechaCrecaion;
    }

    public Calendar getTxtProductoFechaModificacion() {
        return txtProductoFechaModificacion;
    }

    public void setTxtProductoFechaModificacion(
        Calendar txtProductoFechaModificacion) {
        this.txtProductoFechaModificacion = txtProductoFechaModificacion;
    }

    public InputText getTxtProductoId() {
        return txtProductoId;
    }

    public void setTxtProductoId(InputText txtProductoId) {
        this.txtProductoId = txtProductoId;
    }

    public List<ProductoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataProducto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<ProductoDTO> productoDTO) {
        this.data = productoDTO;
    }

    public ProductoDTO getSelectedProducto() {
        return selectedProducto;
    }

    public void setSelectedProducto(ProductoDTO producto) {
        this.selectedProducto = producto;
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
