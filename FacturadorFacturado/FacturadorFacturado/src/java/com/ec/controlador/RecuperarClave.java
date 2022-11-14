/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioUsuario;
import com.ec.untilitario.MailerClassSistema;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class RecuperarClave {

    @Wire
    Window wOlvideMiclave;

    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private Usuario usuarioSistema = new Usuario();
    private String usuCorreo = "";
    private String usuRuc = "";

    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
//    UserCredential credential = new UserCredential();
//    private String amRuc = "";
//    private Tipoambiente amb = new Tipoambiente();

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

    }

    public RecuperarClave() {
//        Session sess = Sessions.getCurrent();
//        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
//        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(amRuc);
    }

    @Command
    public void recuperar() {
        if (usuCorreo != null && !usuCorreo.equals("")
                    && usuRuc != null && !usuCorreo.equals("")) {
            usuarioSistema = servicioUsuario.findRecuperaPassword(usuRuc, usuCorreo);
            if (usuarioSistema != null) {

                Usuario usuario = servicioUsuario.findRecuperaPassword(usuRuc, usuCorreo);
                Tipoambiente amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(usuario);

                if (usuario != null) {
                    try {
                        MailerClassSistema mail = new MailerClassSistema();
                        mail.sendMailRecuperarPassword(usuCorreo, "Recuperar accesos DEFACT", usuario.getUsuLogin(), usuario.getUsuPassword(), amb);
                        Clients.showNotification("Los accesos se enviaron al correo electrónico",
                                    Clients.NOTIFICATION_TYPE_INFO, null, "end_center", 2000, true);
                    } catch (RemoteException ex) {
                        Clients.showNotification("Ocurrio un error al recuperar su password",
                                    Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                        Logger.getLogger(RecuperarClave.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                wOlvideMiclave.detach();
            } else {
                Clients.showNotification("Verifique su RUc o Correo electronico",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
            }

        } else {
            Clients.showNotification("Debe ingresar un correo.",
                        Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
        }
    }

    public String getUsuCorreo() {
        return usuCorreo;
    }

    public void setUsuCorreo(String usuCorreo) {
        this.usuCorreo = usuCorreo;
    }

    public String getUsuRuc() {
        return usuRuc;
    }

    public void setUsuRuc(String usuRuc) {
        this.usuRuc = usuRuc;
    }

}
