package com.nuck.presentation.backingBeans;

import com.nuck.exceptions.*;

import com.nuck.modelo.*;
import com.nuck.modelo.dto.PgStatStatementsDTO;

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
public class PgStatStatementsView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PgStatStatementsView.class);
    private InputText txtUserid;
    private InputText txtDbid;
    private InputText txtQueryid;
    private InputText txtQuery;
    private InputText txtCalls;
    private InputText txtTotalTime;
    private InputText txtMinTime;
    private InputText txtMaxTime;
    private InputText txtMeanTime;
    private InputText txtStddevTime;
    private InputText txtRows;
    private InputText txtSharedBlksHit;
    private InputText txtSharedBlksRead;
    private InputText txtSharedBlksDirtied;
    private InputText txtSharedBlksWritten;
    private InputText txtLocalBlksHit;
    private InputText txtLocalBlksRead;
    private InputText txtLocalBlksDirtied;
    private InputText txtLocalBlksWritten;
    private InputText txtTempBlksRead;
    private InputText txtTempBlksWritten;
    private InputText txtBlkReadTime;
    private InputText txtBlkWriteTime;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<PgStatStatementsDTO> data;
    private PgStatStatementsDTO selectedPgStatStatements;
    private PgStatStatements entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public PgStatStatementsView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            PgStatStatementsDTO pgStatStatementsDTO = (PgStatStatementsDTO) e.getObject();

            if (txtUserid == null) {
                txtUserid = new InputText();
            }

            txtUserid.setValue(pgStatStatementsDTO.getUserid());

            if (txtDbid == null) {
                txtDbid = new InputText();
            }

            txtDbid.setValue(pgStatStatementsDTO.getDbid());

            if (txtQueryid == null) {
                txtQueryid = new InputText();
            }

            txtQueryid.setValue(pgStatStatementsDTO.getQueryid());

            if (txtQuery == null) {
                txtQuery = new InputText();
            }

            txtQuery.setValue(pgStatStatementsDTO.getQuery());

            if (txtCalls == null) {
                txtCalls = new InputText();
            }

            txtCalls.setValue(pgStatStatementsDTO.getCalls());

            if (txtTotalTime == null) {
                txtTotalTime = new InputText();
            }

            txtTotalTime.setValue(pgStatStatementsDTO.getTotalTime());

            if (txtMinTime == null) {
                txtMinTime = new InputText();
            }

            txtMinTime.setValue(pgStatStatementsDTO.getMinTime());

            if (txtMaxTime == null) {
                txtMaxTime = new InputText();
            }

            txtMaxTime.setValue(pgStatStatementsDTO.getMaxTime());

            if (txtMeanTime == null) {
                txtMeanTime = new InputText();
            }

            txtMeanTime.setValue(pgStatStatementsDTO.getMeanTime());

            if (txtStddevTime == null) {
                txtStddevTime = new InputText();
            }

            txtStddevTime.setValue(pgStatStatementsDTO.getStddevTime());

            if (txtRows == null) {
                txtRows = new InputText();
            }

            txtRows.setValue(pgStatStatementsDTO.getRows());

            if (txtSharedBlksHit == null) {
                txtSharedBlksHit = new InputText();
            }

            txtSharedBlksHit.setValue(pgStatStatementsDTO.getSharedBlksHit());

            if (txtSharedBlksRead == null) {
                txtSharedBlksRead = new InputText();
            }

            txtSharedBlksRead.setValue(pgStatStatementsDTO.getSharedBlksRead());

            if (txtSharedBlksDirtied == null) {
                txtSharedBlksDirtied = new InputText();
            }

            txtSharedBlksDirtied.setValue(pgStatStatementsDTO.getSharedBlksDirtied());

            if (txtSharedBlksWritten == null) {
                txtSharedBlksWritten = new InputText();
            }

            txtSharedBlksWritten.setValue(pgStatStatementsDTO.getSharedBlksWritten());

            if (txtLocalBlksHit == null) {
                txtLocalBlksHit = new InputText();
            }

            txtLocalBlksHit.setValue(pgStatStatementsDTO.getLocalBlksHit());

            if (txtLocalBlksRead == null) {
                txtLocalBlksRead = new InputText();
            }

            txtLocalBlksRead.setValue(pgStatStatementsDTO.getLocalBlksRead());

            if (txtLocalBlksDirtied == null) {
                txtLocalBlksDirtied = new InputText();
            }

            txtLocalBlksDirtied.setValue(pgStatStatementsDTO.getLocalBlksDirtied());

            if (txtLocalBlksWritten == null) {
                txtLocalBlksWritten = new InputText();
            }

            txtLocalBlksWritten.setValue(pgStatStatementsDTO.getLocalBlksWritten());

            if (txtTempBlksRead == null) {
                txtTempBlksRead = new InputText();
            }

            txtTempBlksRead.setValue(pgStatStatementsDTO.getTempBlksRead());

            if (txtTempBlksWritten == null) {
                txtTempBlksWritten = new InputText();
            }

            txtTempBlksWritten.setValue(pgStatStatementsDTO.getTempBlksWritten());

            if (txtBlkReadTime == null) {
                txtBlkReadTime = new InputText();
            }

            txtBlkReadTime.setValue(pgStatStatementsDTO.getBlkReadTime());

            if (txtBlkWriteTime == null) {
                txtBlkWriteTime = new InputText();
            }

            txtBlkWriteTime.setValue(pgStatStatementsDTO.getBlkWriteTime());

            PgStatStatementsId id = new PgStatStatementsId();
            id.setUserid((((txtUserid.getValue()) == null) ||
                (txtUserid.getValue()).equals("")) ? null
                                                   : FacesUtils.checkLong(
                    txtUserid));
            id.setDbid((((txtDbid.getValue()) == null) ||
                (txtDbid.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtDbid));
            id.setQueryid((((txtQueryid.getValue()) == null) ||
                (txtQueryid.getValue()).equals("")) ? null
                                                    : FacesUtils.checkLong(
                    txtQueryid));
            id.setQuery((((txtQuery.getValue()) == null) ||
                (txtQuery.getValue()).equals("")) ? null
                                                  : FacesUtils.checkString(
                    txtQuery));
            id.setCalls((((txtCalls.getValue()) == null) ||
                (txtCalls.getValue()).equals("")) ? null
                                                  : FacesUtils.checkLong(
                    txtCalls));
            id.setTotalTime((((txtTotalTime.getValue()) == null) ||
                (txtTotalTime.getValue()).equals("")) ? null
                                                      : FacesUtils.checkDouble(
                    txtTotalTime));
            id.setMinTime((((txtMinTime.getValue()) == null) ||
                (txtMinTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMinTime));
            id.setMaxTime((((txtMaxTime.getValue()) == null) ||
                (txtMaxTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMaxTime));
            id.setMeanTime((((txtMeanTime.getValue()) == null) ||
                (txtMeanTime.getValue()).equals("")) ? null
                                                     : FacesUtils.checkDouble(
                    txtMeanTime));
            id.setStddevTime((((txtStddevTime.getValue()) == null) ||
                (txtStddevTime.getValue()).equals("")) ? null
                                                       : FacesUtils.checkDouble(
                    txtStddevTime));
            id.setRows((((txtRows.getValue()) == null) ||
                (txtRows.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtRows));
            id.setSharedBlksHit((((txtSharedBlksHit.getValue()) == null) ||
                (txtSharedBlksHit.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtSharedBlksHit));
            id.setSharedBlksRead((((txtSharedBlksRead.getValue()) == null) ||
                (txtSharedBlksRead.getValue()).equals("")) ? null
                                                           : FacesUtils.checkLong(
                    txtSharedBlksRead));
            id.setSharedBlksDirtied((((txtSharedBlksDirtied.getValue()) == null) ||
                (txtSharedBlksDirtied.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksDirtied));
            id.setSharedBlksWritten((((txtSharedBlksWritten.getValue()) == null) ||
                (txtSharedBlksWritten.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksWritten));
            id.setLocalBlksHit((((txtLocalBlksHit.getValue()) == null) ||
                (txtLocalBlksHit.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtLocalBlksHit));
            id.setLocalBlksRead((((txtLocalBlksRead.getValue()) == null) ||
                (txtLocalBlksRead.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtLocalBlksRead));
            id.setLocalBlksDirtied((((txtLocalBlksDirtied.getValue()) == null) ||
                (txtLocalBlksDirtied.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksDirtied));
            id.setLocalBlksWritten((((txtLocalBlksWritten.getValue()) == null) ||
                (txtLocalBlksWritten.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksWritten));
            id.setTempBlksRead((((txtTempBlksRead.getValue()) == null) ||
                (txtTempBlksRead.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtTempBlksRead));
            id.setTempBlksWritten((((txtTempBlksWritten.getValue()) == null) ||
                (txtTempBlksWritten.getValue()).equals("")) ? null
                                                            : FacesUtils.checkLong(
                    txtTempBlksWritten));
            id.setBlkReadTime((((txtBlkReadTime.getValue()) == null) ||
                (txtBlkReadTime.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDouble(
                    txtBlkReadTime));
            id.setBlkWriteTime((((txtBlkWriteTime.getValue()) == null) ||
                (txtBlkWriteTime.getValue()).equals("")) ? null
                                                         : FacesUtils.checkDouble(
                    txtBlkWriteTime));
            entity = businessDelegatorView.getPgStatStatements(id);

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_new() {
        action_clear();
        selectedPgStatStatements = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedPgStatStatements = null;

        if (txtUserid != null) {
            txtUserid.setValue(null);
            txtUserid.setDisabled(false);
        }

        if (txtDbid != null) {
            txtDbid.setValue(null);
            txtDbid.setDisabled(false);
        }

        if (txtQueryid != null) {
            txtQueryid.setValue(null);
            txtQueryid.setDisabled(false);
        }

        if (txtQuery != null) {
            txtQuery.setValue(null);
            txtQuery.setDisabled(false);
        }

        if (txtCalls != null) {
            txtCalls.setValue(null);
            txtCalls.setDisabled(false);
        }

        if (txtTotalTime != null) {
            txtTotalTime.setValue(null);
            txtTotalTime.setDisabled(false);
        }

        if (txtMinTime != null) {
            txtMinTime.setValue(null);
            txtMinTime.setDisabled(false);
        }

        if (txtMaxTime != null) {
            txtMaxTime.setValue(null);
            txtMaxTime.setDisabled(false);
        }

        if (txtMeanTime != null) {
            txtMeanTime.setValue(null);
            txtMeanTime.setDisabled(false);
        }

        if (txtStddevTime != null) {
            txtStddevTime.setValue(null);
            txtStddevTime.setDisabled(false);
        }

        if (txtRows != null) {
            txtRows.setValue(null);
            txtRows.setDisabled(false);
        }

        if (txtSharedBlksHit != null) {
            txtSharedBlksHit.setValue(null);
            txtSharedBlksHit.setDisabled(false);
        }

        if (txtSharedBlksRead != null) {
            txtSharedBlksRead.setValue(null);
            txtSharedBlksRead.setDisabled(false);
        }

        if (txtSharedBlksDirtied != null) {
            txtSharedBlksDirtied.setValue(null);
            txtSharedBlksDirtied.setDisabled(false);
        }

        if (txtSharedBlksWritten != null) {
            txtSharedBlksWritten.setValue(null);
            txtSharedBlksWritten.setDisabled(false);
        }

        if (txtLocalBlksHit != null) {
            txtLocalBlksHit.setValue(null);
            txtLocalBlksHit.setDisabled(false);
        }

        if (txtLocalBlksRead != null) {
            txtLocalBlksRead.setValue(null);
            txtLocalBlksRead.setDisabled(false);
        }

        if (txtLocalBlksDirtied != null) {
            txtLocalBlksDirtied.setValue(null);
            txtLocalBlksDirtied.setDisabled(false);
        }

        if (txtLocalBlksWritten != null) {
            txtLocalBlksWritten.setValue(null);
            txtLocalBlksWritten.setDisabled(false);
        }

        if (txtTempBlksRead != null) {
            txtTempBlksRead.setValue(null);
            txtTempBlksRead.setDisabled(false);
        }

        if (txtTempBlksWritten != null) {
            txtTempBlksWritten.setValue(null);
            txtTempBlksWritten.setDisabled(false);
        }

        if (txtBlkReadTime != null) {
            txtBlkReadTime.setValue(null);
            txtBlkReadTime.setDisabled(false);
        }

        if (txtBlkWriteTime != null) {
            txtBlkWriteTime.setValue(null);
            txtBlkWriteTime.setDisabled(false);
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
            PgStatStatementsId id = new PgStatStatementsId();
            id.setUserid((((txtUserid.getValue()) == null) ||
                (txtUserid.getValue()).equals("")) ? null
                                                   : FacesUtils.checkLong(
                    txtUserid));
            id.setDbid((((txtDbid.getValue()) == null) ||
                (txtDbid.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtDbid));
            id.setQueryid((((txtQueryid.getValue()) == null) ||
                (txtQueryid.getValue()).equals("")) ? null
                                                    : FacesUtils.checkLong(
                    txtQueryid));
            id.setQuery((((txtQuery.getValue()) == null) ||
                (txtQuery.getValue()).equals("")) ? null
                                                  : FacesUtils.checkString(
                    txtQuery));
            id.setCalls((((txtCalls.getValue()) == null) ||
                (txtCalls.getValue()).equals("")) ? null
                                                  : FacesUtils.checkLong(
                    txtCalls));
            id.setTotalTime((((txtTotalTime.getValue()) == null) ||
                (txtTotalTime.getValue()).equals("")) ? null
                                                      : FacesUtils.checkDouble(
                    txtTotalTime));
            id.setMinTime((((txtMinTime.getValue()) == null) ||
                (txtMinTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMinTime));
            id.setMaxTime((((txtMaxTime.getValue()) == null) ||
                (txtMaxTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMaxTime));
            id.setMeanTime((((txtMeanTime.getValue()) == null) ||
                (txtMeanTime.getValue()).equals("")) ? null
                                                     : FacesUtils.checkDouble(
                    txtMeanTime));
            id.setStddevTime((((txtStddevTime.getValue()) == null) ||
                (txtStddevTime.getValue()).equals("")) ? null
                                                       : FacesUtils.checkDouble(
                    txtStddevTime));
            id.setRows((((txtRows.getValue()) == null) ||
                (txtRows.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtRows));
            id.setSharedBlksHit((((txtSharedBlksHit.getValue()) == null) ||
                (txtSharedBlksHit.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtSharedBlksHit));
            id.setSharedBlksRead((((txtSharedBlksRead.getValue()) == null) ||
                (txtSharedBlksRead.getValue()).equals("")) ? null
                                                           : FacesUtils.checkLong(
                    txtSharedBlksRead));
            id.setSharedBlksDirtied((((txtSharedBlksDirtied.getValue()) == null) ||
                (txtSharedBlksDirtied.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksDirtied));
            id.setSharedBlksWritten((((txtSharedBlksWritten.getValue()) == null) ||
                (txtSharedBlksWritten.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksWritten));
            id.setLocalBlksHit((((txtLocalBlksHit.getValue()) == null) ||
                (txtLocalBlksHit.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtLocalBlksHit));
            id.setLocalBlksRead((((txtLocalBlksRead.getValue()) == null) ||
                (txtLocalBlksRead.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtLocalBlksRead));
            id.setLocalBlksDirtied((((txtLocalBlksDirtied.getValue()) == null) ||
                (txtLocalBlksDirtied.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksDirtied));
            id.setLocalBlksWritten((((txtLocalBlksWritten.getValue()) == null) ||
                (txtLocalBlksWritten.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksWritten));
            id.setTempBlksRead((((txtTempBlksRead.getValue()) == null) ||
                (txtTempBlksRead.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtTempBlksRead));
            id.setTempBlksWritten((((txtTempBlksWritten.getValue()) == null) ||
                (txtTempBlksWritten.getValue()).equals("")) ? null
                                                            : FacesUtils.checkLong(
                    txtTempBlksWritten));
            id.setBlkReadTime((((txtBlkReadTime.getValue()) == null) ||
                (txtBlkReadTime.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDouble(
                    txtBlkReadTime));
            id.setBlkWriteTime((((txtBlkWriteTime.getValue()) == null) ||
                (txtBlkWriteTime.getValue()).equals("")) ? null
                                                         : FacesUtils.checkDouble(
                    txtBlkWriteTime));
            entity = (id != null)
                ? businessDelegatorView.getPgStatStatements(id) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtUserid.setDisabled(false);
            txtDbid.setDisabled(false);
            txtQueryid.setDisabled(false);
            txtQuery.setDisabled(false);
            txtCalls.setDisabled(false);
            txtTotalTime.setDisabled(false);
            txtMinTime.setDisabled(false);
            txtMaxTime.setDisabled(false);
            txtMeanTime.setDisabled(false);
            txtStddevTime.setDisabled(false);
            txtRows.setDisabled(false);
            txtSharedBlksHit.setDisabled(false);
            txtSharedBlksRead.setDisabled(false);
            txtSharedBlksDirtied.setDisabled(false);
            txtSharedBlksWritten.setDisabled(false);
            txtLocalBlksHit.setDisabled(false);
            txtLocalBlksRead.setDisabled(false);
            txtLocalBlksDirtied.setDisabled(false);
            txtLocalBlksWritten.setDisabled(false);
            txtTempBlksRead.setDisabled(false);
            txtTempBlksWritten.setDisabled(false);
            txtBlkReadTime.setDisabled(false);
            txtBlkWriteTime.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtUserid.setValue(entity.getId().getUserid());
            txtUserid.setDisabled(true);
            txtDbid.setValue(entity.getId().getDbid());
            txtDbid.setDisabled(true);
            txtQueryid.setValue(entity.getId().getQueryid());
            txtQueryid.setDisabled(true);
            txtQuery.setValue(entity.getId().getQuery());
            txtQuery.setDisabled(true);
            txtCalls.setValue(entity.getId().getCalls());
            txtCalls.setDisabled(true);
            txtTotalTime.setValue(entity.getId().getTotalTime());
            txtTotalTime.setDisabled(true);
            txtMinTime.setValue(entity.getId().getMinTime());
            txtMinTime.setDisabled(true);
            txtMaxTime.setValue(entity.getId().getMaxTime());
            txtMaxTime.setDisabled(true);
            txtMeanTime.setValue(entity.getId().getMeanTime());
            txtMeanTime.setDisabled(true);
            txtStddevTime.setValue(entity.getId().getStddevTime());
            txtStddevTime.setDisabled(true);
            txtRows.setValue(entity.getId().getRows());
            txtRows.setDisabled(true);
            txtSharedBlksHit.setValue(entity.getId().getSharedBlksHit());
            txtSharedBlksHit.setDisabled(true);
            txtSharedBlksRead.setValue(entity.getId().getSharedBlksRead());
            txtSharedBlksRead.setDisabled(true);
            txtSharedBlksDirtied.setValue(entity.getId().getSharedBlksDirtied());
            txtSharedBlksDirtied.setDisabled(true);
            txtSharedBlksWritten.setValue(entity.getId().getSharedBlksWritten());
            txtSharedBlksWritten.setDisabled(true);
            txtLocalBlksHit.setValue(entity.getId().getLocalBlksHit());
            txtLocalBlksHit.setDisabled(true);
            txtLocalBlksRead.setValue(entity.getId().getLocalBlksRead());
            txtLocalBlksRead.setDisabled(true);
            txtLocalBlksDirtied.setValue(entity.getId().getLocalBlksDirtied());
            txtLocalBlksDirtied.setDisabled(true);
            txtLocalBlksWritten.setValue(entity.getId().getLocalBlksWritten());
            txtLocalBlksWritten.setDisabled(true);
            txtTempBlksRead.setValue(entity.getId().getTempBlksRead());
            txtTempBlksRead.setDisabled(true);
            txtTempBlksWritten.setValue(entity.getId().getTempBlksWritten());
            txtTempBlksWritten.setDisabled(true);
            txtBlkReadTime.setValue(entity.getId().getBlkReadTime());
            txtBlkReadTime.setDisabled(true);
            txtBlkWriteTime.setValue(entity.getId().getBlkWriteTime());
            txtBlkWriteTime.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedPgStatStatements = (PgStatStatementsDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedPgStatStatements"));
        txtUserid.setValue(selectedPgStatStatements.getUserid());
        txtUserid.setDisabled(true);
        txtDbid.setValue(selectedPgStatStatements.getDbid());
        txtDbid.setDisabled(true);
        txtQueryid.setValue(selectedPgStatStatements.getQueryid());
        txtQueryid.setDisabled(true);
        txtQuery.setValue(selectedPgStatStatements.getQuery());
        txtQuery.setDisabled(true);
        txtCalls.setValue(selectedPgStatStatements.getCalls());
        txtCalls.setDisabled(true);
        txtTotalTime.setValue(selectedPgStatStatements.getTotalTime());
        txtTotalTime.setDisabled(true);
        txtMinTime.setValue(selectedPgStatStatements.getMinTime());
        txtMinTime.setDisabled(true);
        txtMaxTime.setValue(selectedPgStatStatements.getMaxTime());
        txtMaxTime.setDisabled(true);
        txtMeanTime.setValue(selectedPgStatStatements.getMeanTime());
        txtMeanTime.setDisabled(true);
        txtStddevTime.setValue(selectedPgStatStatements.getStddevTime());
        txtStddevTime.setDisabled(true);
        txtRows.setValue(selectedPgStatStatements.getRows());
        txtRows.setDisabled(true);
        txtSharedBlksHit.setValue(selectedPgStatStatements.getSharedBlksHit());
        txtSharedBlksHit.setDisabled(true);
        txtSharedBlksRead.setValue(selectedPgStatStatements.getSharedBlksRead());
        txtSharedBlksRead.setDisabled(true);
        txtSharedBlksDirtied.setValue(selectedPgStatStatements.getSharedBlksDirtied());
        txtSharedBlksDirtied.setDisabled(true);
        txtSharedBlksWritten.setValue(selectedPgStatStatements.getSharedBlksWritten());
        txtSharedBlksWritten.setDisabled(true);
        txtLocalBlksHit.setValue(selectedPgStatStatements.getLocalBlksHit());
        txtLocalBlksHit.setDisabled(true);
        txtLocalBlksRead.setValue(selectedPgStatStatements.getLocalBlksRead());
        txtLocalBlksRead.setDisabled(true);
        txtLocalBlksDirtied.setValue(selectedPgStatStatements.getLocalBlksDirtied());
        txtLocalBlksDirtied.setDisabled(true);
        txtLocalBlksWritten.setValue(selectedPgStatStatements.getLocalBlksWritten());
        txtLocalBlksWritten.setDisabled(true);
        txtTempBlksRead.setValue(selectedPgStatStatements.getTempBlksRead());
        txtTempBlksRead.setDisabled(true);
        txtTempBlksWritten.setValue(selectedPgStatStatements.getTempBlksWritten());
        txtTempBlksWritten.setDisabled(true);
        txtBlkReadTime.setValue(selectedPgStatStatements.getBlkReadTime());
        txtBlkReadTime.setDisabled(true);
        txtBlkWriteTime.setValue(selectedPgStatStatements.getBlkWriteTime());
        txtBlkWriteTime.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedPgStatStatements == null) && (entity == null)) {
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
            entity = new PgStatStatements();

            PgStatStatementsId id = new PgStatStatementsId();
            id.setUserid((((txtUserid.getValue()) == null) ||
                (txtUserid.getValue()).equals("")) ? null
                                                   : FacesUtils.checkLong(
                    txtUserid));
            id.setDbid((((txtDbid.getValue()) == null) ||
                (txtDbid.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtDbid));
            id.setQueryid((((txtQueryid.getValue()) == null) ||
                (txtQueryid.getValue()).equals("")) ? null
                                                    : FacesUtils.checkLong(
                    txtQueryid));
            id.setQuery((((txtQuery.getValue()) == null) ||
                (txtQuery.getValue()).equals("")) ? null
                                                  : FacesUtils.checkString(
                    txtQuery));
            id.setCalls((((txtCalls.getValue()) == null) ||
                (txtCalls.getValue()).equals("")) ? null
                                                  : FacesUtils.checkLong(
                    txtCalls));
            id.setTotalTime((((txtTotalTime.getValue()) == null) ||
                (txtTotalTime.getValue()).equals("")) ? null
                                                      : FacesUtils.checkDouble(
                    txtTotalTime));
            id.setMinTime((((txtMinTime.getValue()) == null) ||
                (txtMinTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMinTime));
            id.setMaxTime((((txtMaxTime.getValue()) == null) ||
                (txtMaxTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMaxTime));
            id.setMeanTime((((txtMeanTime.getValue()) == null) ||
                (txtMeanTime.getValue()).equals("")) ? null
                                                     : FacesUtils.checkDouble(
                    txtMeanTime));
            id.setStddevTime((((txtStddevTime.getValue()) == null) ||
                (txtStddevTime.getValue()).equals("")) ? null
                                                       : FacesUtils.checkDouble(
                    txtStddevTime));
            id.setRows((((txtRows.getValue()) == null) ||
                (txtRows.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtRows));
            id.setSharedBlksHit((((txtSharedBlksHit.getValue()) == null) ||
                (txtSharedBlksHit.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtSharedBlksHit));
            id.setSharedBlksRead((((txtSharedBlksRead.getValue()) == null) ||
                (txtSharedBlksRead.getValue()).equals("")) ? null
                                                           : FacesUtils.checkLong(
                    txtSharedBlksRead));
            id.setSharedBlksDirtied((((txtSharedBlksDirtied.getValue()) == null) ||
                (txtSharedBlksDirtied.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksDirtied));
            id.setSharedBlksWritten((((txtSharedBlksWritten.getValue()) == null) ||
                (txtSharedBlksWritten.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksWritten));
            id.setLocalBlksHit((((txtLocalBlksHit.getValue()) == null) ||
                (txtLocalBlksHit.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtLocalBlksHit));
            id.setLocalBlksRead((((txtLocalBlksRead.getValue()) == null) ||
                (txtLocalBlksRead.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtLocalBlksRead));
            id.setLocalBlksDirtied((((txtLocalBlksDirtied.getValue()) == null) ||
                (txtLocalBlksDirtied.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksDirtied));
            id.setLocalBlksWritten((((txtLocalBlksWritten.getValue()) == null) ||
                (txtLocalBlksWritten.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksWritten));
            id.setTempBlksRead((((txtTempBlksRead.getValue()) == null) ||
                (txtTempBlksRead.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtTempBlksRead));
            id.setTempBlksWritten((((txtTempBlksWritten.getValue()) == null) ||
                (txtTempBlksWritten.getValue()).equals("")) ? null
                                                            : FacesUtils.checkLong(
                    txtTempBlksWritten));
            id.setBlkReadTime((((txtBlkReadTime.getValue()) == null) ||
                (txtBlkReadTime.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDouble(
                    txtBlkReadTime));
            id.setBlkWriteTime((((txtBlkWriteTime.getValue()) == null) ||
                (txtBlkWriteTime.getValue()).equals("")) ? null
                                                         : FacesUtils.checkDouble(
                    txtBlkWriteTime));

            entity.setId(id);
            businessDelegatorView.savePgStatStatements(entity);
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
                PgStatStatementsId id = new PgStatStatementsId();
                id.setUserid(selectedPgStatStatements.getUserid());
                id.setDbid(selectedPgStatStatements.getDbid());
                id.setQueryid(selectedPgStatStatements.getQueryid());
                id.setQuery(selectedPgStatStatements.getQuery());
                id.setCalls(selectedPgStatStatements.getCalls());
                id.setTotalTime(selectedPgStatStatements.getTotalTime());
                id.setMinTime(selectedPgStatStatements.getMinTime());
                id.setMaxTime(selectedPgStatStatements.getMaxTime());
                id.setMeanTime(selectedPgStatStatements.getMeanTime());
                id.setStddevTime(selectedPgStatStatements.getStddevTime());
                id.setRows(selectedPgStatStatements.getRows());
                id.setSharedBlksHit(selectedPgStatStatements.getSharedBlksHit());
                id.setSharedBlksRead(selectedPgStatStatements.getSharedBlksRead());
                id.setSharedBlksDirtied(selectedPgStatStatements.getSharedBlksDirtied());
                id.setSharedBlksWritten(selectedPgStatStatements.getSharedBlksWritten());
                id.setLocalBlksHit(selectedPgStatStatements.getLocalBlksHit());
                id.setLocalBlksRead(selectedPgStatStatements.getLocalBlksRead());
                id.setLocalBlksDirtied(selectedPgStatStatements.getLocalBlksDirtied());
                id.setLocalBlksWritten(selectedPgStatStatements.getLocalBlksWritten());
                id.setTempBlksRead(selectedPgStatStatements.getTempBlksRead());
                id.setTempBlksWritten(selectedPgStatStatements.getTempBlksWritten());
                id.setBlkReadTime(selectedPgStatStatements.getBlkReadTime());
                id.setBlkWriteTime(selectedPgStatStatements.getBlkWriteTime());
                entity = businessDelegatorView.getPgStatStatements(id);
            }

            businessDelegatorView.updatePgStatStatements(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedPgStatStatements = (PgStatStatementsDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedPgStatStatements"));

            PgStatStatementsId id = new PgStatStatementsId();
            id.setUserid(selectedPgStatStatements.getUserid());
            id.setDbid(selectedPgStatStatements.getDbid());
            id.setQueryid(selectedPgStatStatements.getQueryid());
            id.setQuery(selectedPgStatStatements.getQuery());
            id.setCalls(selectedPgStatStatements.getCalls());
            id.setTotalTime(selectedPgStatStatements.getTotalTime());
            id.setMinTime(selectedPgStatStatements.getMinTime());
            id.setMaxTime(selectedPgStatStatements.getMaxTime());
            id.setMeanTime(selectedPgStatStatements.getMeanTime());
            id.setStddevTime(selectedPgStatStatements.getStddevTime());
            id.setRows(selectedPgStatStatements.getRows());
            id.setSharedBlksHit(selectedPgStatStatements.getSharedBlksHit());
            id.setSharedBlksRead(selectedPgStatStatements.getSharedBlksRead());
            id.setSharedBlksDirtied(selectedPgStatStatements.getSharedBlksDirtied());
            id.setSharedBlksWritten(selectedPgStatStatements.getSharedBlksWritten());
            id.setLocalBlksHit(selectedPgStatStatements.getLocalBlksHit());
            id.setLocalBlksRead(selectedPgStatStatements.getLocalBlksRead());
            id.setLocalBlksDirtied(selectedPgStatStatements.getLocalBlksDirtied());
            id.setLocalBlksWritten(selectedPgStatStatements.getLocalBlksWritten());
            id.setTempBlksRead(selectedPgStatStatements.getTempBlksRead());
            id.setTempBlksWritten(selectedPgStatStatements.getTempBlksWritten());
            id.setBlkReadTime(selectedPgStatStatements.getBlkReadTime());
            id.setBlkWriteTime(selectedPgStatStatements.getBlkWriteTime());
            entity = businessDelegatorView.getPgStatStatements(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            PgStatStatementsId id = new PgStatStatementsId();
            id.setUserid((((txtUserid.getValue()) == null) ||
                (txtUserid.getValue()).equals("")) ? null
                                                   : FacesUtils.checkLong(
                    txtUserid));
            id.setDbid((((txtDbid.getValue()) == null) ||
                (txtDbid.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtDbid));
            id.setQueryid((((txtQueryid.getValue()) == null) ||
                (txtQueryid.getValue()).equals("")) ? null
                                                    : FacesUtils.checkLong(
                    txtQueryid));
            id.setQuery((((txtQuery.getValue()) == null) ||
                (txtQuery.getValue()).equals("")) ? null
                                                  : FacesUtils.checkString(
                    txtQuery));
            id.setCalls((((txtCalls.getValue()) == null) ||
                (txtCalls.getValue()).equals("")) ? null
                                                  : FacesUtils.checkLong(
                    txtCalls));
            id.setTotalTime((((txtTotalTime.getValue()) == null) ||
                (txtTotalTime.getValue()).equals("")) ? null
                                                      : FacesUtils.checkDouble(
                    txtTotalTime));
            id.setMinTime((((txtMinTime.getValue()) == null) ||
                (txtMinTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMinTime));
            id.setMaxTime((((txtMaxTime.getValue()) == null) ||
                (txtMaxTime.getValue()).equals("")) ? null
                                                    : FacesUtils.checkDouble(
                    txtMaxTime));
            id.setMeanTime((((txtMeanTime.getValue()) == null) ||
                (txtMeanTime.getValue()).equals("")) ? null
                                                     : FacesUtils.checkDouble(
                    txtMeanTime));
            id.setStddevTime((((txtStddevTime.getValue()) == null) ||
                (txtStddevTime.getValue()).equals("")) ? null
                                                       : FacesUtils.checkDouble(
                    txtStddevTime));
            id.setRows((((txtRows.getValue()) == null) ||
                (txtRows.getValue()).equals("")) ? null
                                                 : FacesUtils.checkLong(txtRows));
            id.setSharedBlksHit((((txtSharedBlksHit.getValue()) == null) ||
                (txtSharedBlksHit.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtSharedBlksHit));
            id.setSharedBlksRead((((txtSharedBlksRead.getValue()) == null) ||
                (txtSharedBlksRead.getValue()).equals("")) ? null
                                                           : FacesUtils.checkLong(
                    txtSharedBlksRead));
            id.setSharedBlksDirtied((((txtSharedBlksDirtied.getValue()) == null) ||
                (txtSharedBlksDirtied.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksDirtied));
            id.setSharedBlksWritten((((txtSharedBlksWritten.getValue()) == null) ||
                (txtSharedBlksWritten.getValue()).equals("")) ? null
                                                              : FacesUtils.checkLong(
                    txtSharedBlksWritten));
            id.setLocalBlksHit((((txtLocalBlksHit.getValue()) == null) ||
                (txtLocalBlksHit.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtLocalBlksHit));
            id.setLocalBlksRead((((txtLocalBlksRead.getValue()) == null) ||
                (txtLocalBlksRead.getValue()).equals("")) ? null
                                                          : FacesUtils.checkLong(
                    txtLocalBlksRead));
            id.setLocalBlksDirtied((((txtLocalBlksDirtied.getValue()) == null) ||
                (txtLocalBlksDirtied.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksDirtied));
            id.setLocalBlksWritten((((txtLocalBlksWritten.getValue()) == null) ||
                (txtLocalBlksWritten.getValue()).equals("")) ? null
                                                             : FacesUtils.checkLong(
                    txtLocalBlksWritten));
            id.setTempBlksRead((((txtTempBlksRead.getValue()) == null) ||
                (txtTempBlksRead.getValue()).equals("")) ? null
                                                         : FacesUtils.checkLong(
                    txtTempBlksRead));
            id.setTempBlksWritten((((txtTempBlksWritten.getValue()) == null) ||
                (txtTempBlksWritten.getValue()).equals("")) ? null
                                                            : FacesUtils.checkLong(
                    txtTempBlksWritten));
            id.setBlkReadTime((((txtBlkReadTime.getValue()) == null) ||
                (txtBlkReadTime.getValue()).equals("")) ? null
                                                        : FacesUtils.checkDouble(
                    txtBlkReadTime));
            id.setBlkWriteTime((((txtBlkWriteTime.getValue()) == null) ||
                (txtBlkWriteTime.getValue()).equals("")) ? null
                                                         : FacesUtils.checkDouble(
                    txtBlkWriteTime));
            entity = businessDelegatorView.getPgStatStatements(id);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deletePgStatStatements(entity);
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
            selectedPgStatStatements = (PgStatStatementsDTO) (evt.getComponent()
                                                                 .getAttributes()
                                                                 .get("selectedPgStatStatements"));

            PgStatStatementsId id = new PgStatStatementsId();
            id.setUserid(selectedPgStatStatements.getUserid());
            id.setDbid(selectedPgStatStatements.getDbid());
            id.setQueryid(selectedPgStatStatements.getQueryid());
            id.setQuery(selectedPgStatStatements.getQuery());
            id.setCalls(selectedPgStatStatements.getCalls());
            id.setTotalTime(selectedPgStatStatements.getTotalTime());
            id.setMinTime(selectedPgStatStatements.getMinTime());
            id.setMaxTime(selectedPgStatStatements.getMaxTime());
            id.setMeanTime(selectedPgStatStatements.getMeanTime());
            id.setStddevTime(selectedPgStatStatements.getStddevTime());
            id.setRows(selectedPgStatStatements.getRows());
            id.setSharedBlksHit(selectedPgStatStatements.getSharedBlksHit());
            id.setSharedBlksRead(selectedPgStatStatements.getSharedBlksRead());
            id.setSharedBlksDirtied(selectedPgStatStatements.getSharedBlksDirtied());
            id.setSharedBlksWritten(selectedPgStatStatements.getSharedBlksWritten());
            id.setLocalBlksHit(selectedPgStatStatements.getLocalBlksHit());
            id.setLocalBlksRead(selectedPgStatStatements.getLocalBlksRead());
            id.setLocalBlksDirtied(selectedPgStatStatements.getLocalBlksDirtied());
            id.setLocalBlksWritten(selectedPgStatStatements.getLocalBlksWritten());
            id.setTempBlksRead(selectedPgStatStatements.getTempBlksRead());
            id.setTempBlksWritten(selectedPgStatStatements.getTempBlksWritten());
            id.setBlkReadTime(selectedPgStatStatements.getBlkReadTime());
            id.setBlkWriteTime(selectedPgStatStatements.getBlkWriteTime());
            entity = businessDelegatorView.getPgStatStatements(id);
            businessDelegatorView.deletePgStatStatements(entity);
            data.remove(selectedPgStatStatements);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long userid, Long dbid, Long queryid,
        String query, Long calls, Double totalTime, Double minTime,
        Double maxTime, Double meanTime, Double stddevTime, Long rows,
        Long sharedBlksHit, Long sharedBlksRead, Long sharedBlksDirtied,
        Long sharedBlksWritten, Long localBlksHit, Long localBlksRead,
        Long localBlksDirtied, Long localBlksWritten, Long tempBlksRead,
        Long tempBlksWritten, Double blkReadTime, Double blkWriteTime)
        throws Exception {
        try {
            businessDelegatorView.updatePgStatStatements(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("PgStatStatementsView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtUserid() {
        return txtUserid;
    }

    public void setTxtUserid(InputText txtUserid) {
        this.txtUserid = txtUserid;
    }

    public InputText getTxtDbid() {
        return txtDbid;
    }

    public void setTxtDbid(InputText txtDbid) {
        this.txtDbid = txtDbid;
    }

    public InputText getTxtQueryid() {
        return txtQueryid;
    }

    public void setTxtQueryid(InputText txtQueryid) {
        this.txtQueryid = txtQueryid;
    }

    public InputText getTxtQuery() {
        return txtQuery;
    }

    public void setTxtQuery(InputText txtQuery) {
        this.txtQuery = txtQuery;
    }

    public InputText getTxtCalls() {
        return txtCalls;
    }

    public void setTxtCalls(InputText txtCalls) {
        this.txtCalls = txtCalls;
    }

    public InputText getTxtTotalTime() {
        return txtTotalTime;
    }

    public void setTxtTotalTime(InputText txtTotalTime) {
        this.txtTotalTime = txtTotalTime;
    }

    public InputText getTxtMinTime() {
        return txtMinTime;
    }

    public void setTxtMinTime(InputText txtMinTime) {
        this.txtMinTime = txtMinTime;
    }

    public InputText getTxtMaxTime() {
        return txtMaxTime;
    }

    public void setTxtMaxTime(InputText txtMaxTime) {
        this.txtMaxTime = txtMaxTime;
    }

    public InputText getTxtMeanTime() {
        return txtMeanTime;
    }

    public void setTxtMeanTime(InputText txtMeanTime) {
        this.txtMeanTime = txtMeanTime;
    }

    public InputText getTxtStddevTime() {
        return txtStddevTime;
    }

    public void setTxtStddevTime(InputText txtStddevTime) {
        this.txtStddevTime = txtStddevTime;
    }

    public InputText getTxtRows() {
        return txtRows;
    }

    public void setTxtRows(InputText txtRows) {
        this.txtRows = txtRows;
    }

    public InputText getTxtSharedBlksHit() {
        return txtSharedBlksHit;
    }

    public void setTxtSharedBlksHit(InputText txtSharedBlksHit) {
        this.txtSharedBlksHit = txtSharedBlksHit;
    }

    public InputText getTxtSharedBlksRead() {
        return txtSharedBlksRead;
    }

    public void setTxtSharedBlksRead(InputText txtSharedBlksRead) {
        this.txtSharedBlksRead = txtSharedBlksRead;
    }

    public InputText getTxtSharedBlksDirtied() {
        return txtSharedBlksDirtied;
    }

    public void setTxtSharedBlksDirtied(InputText txtSharedBlksDirtied) {
        this.txtSharedBlksDirtied = txtSharedBlksDirtied;
    }

    public InputText getTxtSharedBlksWritten() {
        return txtSharedBlksWritten;
    }

    public void setTxtSharedBlksWritten(InputText txtSharedBlksWritten) {
        this.txtSharedBlksWritten = txtSharedBlksWritten;
    }

    public InputText getTxtLocalBlksHit() {
        return txtLocalBlksHit;
    }

    public void setTxtLocalBlksHit(InputText txtLocalBlksHit) {
        this.txtLocalBlksHit = txtLocalBlksHit;
    }

    public InputText getTxtLocalBlksRead() {
        return txtLocalBlksRead;
    }

    public void setTxtLocalBlksRead(InputText txtLocalBlksRead) {
        this.txtLocalBlksRead = txtLocalBlksRead;
    }

    public InputText getTxtLocalBlksDirtied() {
        return txtLocalBlksDirtied;
    }

    public void setTxtLocalBlksDirtied(InputText txtLocalBlksDirtied) {
        this.txtLocalBlksDirtied = txtLocalBlksDirtied;
    }

    public InputText getTxtLocalBlksWritten() {
        return txtLocalBlksWritten;
    }

    public void setTxtLocalBlksWritten(InputText txtLocalBlksWritten) {
        this.txtLocalBlksWritten = txtLocalBlksWritten;
    }

    public InputText getTxtTempBlksRead() {
        return txtTempBlksRead;
    }

    public void setTxtTempBlksRead(InputText txtTempBlksRead) {
        this.txtTempBlksRead = txtTempBlksRead;
    }

    public InputText getTxtTempBlksWritten() {
        return txtTempBlksWritten;
    }

    public void setTxtTempBlksWritten(InputText txtTempBlksWritten) {
        this.txtTempBlksWritten = txtTempBlksWritten;
    }

    public InputText getTxtBlkReadTime() {
        return txtBlkReadTime;
    }

    public void setTxtBlkReadTime(InputText txtBlkReadTime) {
        this.txtBlkReadTime = txtBlkReadTime;
    }

    public InputText getTxtBlkWriteTime() {
        return txtBlkWriteTime;
    }

    public void setTxtBlkWriteTime(InputText txtBlkWriteTime) {
        this.txtBlkWriteTime = txtBlkWriteTime;
    }

    public List<PgStatStatementsDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataPgStatStatements();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<PgStatStatementsDTO> pgStatStatementsDTO) {
        this.data = pgStatStatementsDTO;
    }

    public PgStatStatementsDTO getSelectedPgStatStatements() {
        return selectedPgStatStatements;
    }

    public void setSelectedPgStatStatements(
        PgStatStatementsDTO pgStatStatements) {
        this.selectedPgStatStatements = pgStatStatements;
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
