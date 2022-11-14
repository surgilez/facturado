/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Parametrizar;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioParametrizar;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioUsuario;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class AgregarUsuarioAdm {

    @Wire
    Window windowIdUsuario;
    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private Usuario usuarioSistema = new Usuario();
    private String tipoUSuario = "2";
    private String accion = "create";

    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    UserCredential credential = new UserCredential();
    private String amRuc = "";
    private Tipoambiente amb = new Tipoambiente();
    ServicioParametrizar servicioParametrizar = new ServicioParametrizar();
    private Boolean readOnly = true;
    private Boolean visualizarNumDoc = true;
    private String tipoLicencia = "IL";

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("usuario") Usuario usuarioSistema, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        if (usuarioSistema != null) {
            this.usuarioSistema = usuarioSistema;
            tipoUSuario = this.usuarioSistema.getUsuNivel().toString();
            tipoLicencia = this.usuarioSistema.getUsuIlimitado() ? "IL" : "ND";
            accion = "update";

        } else {
            this.usuarioSistema = new Usuario();
            accion = "create";

        }
        verificarTipo();
    }

    public AgregarUsuarioAdm() {

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
        readOnly = credential.getUsuarioSistema().getUsuNivel() == 1 ? Boolean.FALSE : Boolean.TRUE;
    }

    public Usuario getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(Usuario usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public String getTipoUSuario() {
        return tipoUSuario;
    }

    public void setTipoUSuario(String tipoUSuario) {
        this.tipoUSuario = tipoUSuario;
    }

    @Command
    @NotifyChange("visualizarNumDoc")
    public void verificarTipo() {
        if (tipoLicencia.equals("IL")) {
            visualizarNumDoc = Boolean.FALSE;
        } else {
            visualizarNumDoc = Boolean.TRUE;
        }
    }

    @Command
    @NotifyChange("usuarioSistema")
    public void incrementarPlan() {
        if (Messagebox.show("Esta seguro de incrementar " + usuarioSistema.getUsuNumDocumentos() + " documentos al plan", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION) == Messagebox.OK) {
            usuarioSistema.setUsuTotalContratado(usuarioSistema.getUsuTotalContratado() + usuarioSistema.getUsuNumDocumentos());
        }
    }

    @Command
    @NotifyChange("usuarioSistema")
    public void incrementarPlanIlimitado() {
        if (Messagebox.show("Esta seguro de incrementar  un mes  al plan", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION) == Messagebox.OK) {
            Date fecha = null;
            if (usuarioSistema.getUsuFechaPago() == null) {
                fecha = new Date();
            } else {
                fecha = usuarioSistema.getUsuFechaPago();
            }

            Calendar c = Calendar.getInstance();
            c.setTime(fecha);
            c.add(Calendar.DATE, 30);
            usuarioSistema.setUsuFechaPago(c.getTime());
        }
    }

    @Command
    @NotifyChange("usuarioSistema")
    public void verificaIniciaPlan() {

        if (usuarioSistema.getUsuFechaPago() == null) {
            Date fecha = usuarioSistema.getUsuFechaPago();
            Calendar c = Calendar.getInstance();
            c.setTime(fecha);
            c.add(Calendar.DATE, 30);
            usuarioSistema.setUsuFechaPago(c.getTime());
        }

    }

    @Command
    @NotifyChange("usuarioSistema")
    public void guardar() {
        if (usuarioSistema != null && !usuarioSistema.getUsuNombre().equals("")
                    && !usuarioSistema.getUsuLogin().equals("")
                    && !tipoUSuario.equals("")) {
            usuarioSistema.setUsuNivel(Integer.valueOf(tipoUSuario));
            /*verifica si tiene tipo ambiente*/

            usuarioSistema.setUsuIlimitado(tipoLicencia.equals("IL") ? Boolean.TRUE : Boolean.FALSE);
            if (accion.contains("create")) {
                if (Integer.valueOf(tipoUSuario) == 1) {
                    usuarioSistema.setUsuTipoUsuario("ADMINISTRADOR");
                } else if (Integer.valueOf(tipoUSuario) == 2) {
                    usuarioSistema.setUsuTipoUsuario("VENTAS");
                }
                servicioUsuario.crear(usuarioSistema);
            } else {
                if (Integer.valueOf(tipoUSuario) == 1) {
                    usuarioSistema.setUsuTipoUsuario("ADMINISTRADOR");
                } else if (Integer.valueOf(tipoUSuario) == 2) {
                    usuarioSistema.setUsuTipoUsuario("VENTAS");
                }
                servicioUsuario.modificar(usuarioSistema);
            }

//            usuarioSistema = new Usuario();
            windowIdUsuario.detach();

        } else {
            Messagebox.show("Verifique la informacion ingresada", "Atención", Messagebox.OK, Messagebox.ERROR);
        }
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAmRuc() {
        return amRuc;
    }

    public void setAmRuc(String amRuc) {
        this.amRuc = amRuc;
    }

    public Boolean getVisualizarNumDoc() {
        return visualizarNumDoc;
    }

    public void setVisualizarNumDoc(Boolean visualizarNumDoc) {
        this.visualizarNumDoc = visualizarNumDoc;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

}
