/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.HistorialDeclaraciones;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioHistorialDeclaraciones;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.untilitario.ParamHistorialDeclaracion;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.Image;
import org.zkoss.io.Files;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class NuevoHistorial {

    @Wire
    Window windowHistorial;

    private HistorialDeclaraciones entidad = new HistorialDeclaraciones();
    ServicioHistorialDeclaraciones servicio = new ServicioHistorialDeclaraciones();

    private String accion = "create";

    UserCredential credential = new UserCredential();
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";
    private String hisMes = "1";
    private String hisAnio = "2022";

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("valor") ParamHistorialDeclaracion valor, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);

        if (valor.getAccion().equals("update")) {
            this.entidad = valor.getDeclaraciones();
            hisMes = String.valueOf(valor.getDeclaraciones().getHisMes());
            hisAnio = String.valueOf(valor.getDeclaraciones().getHisAnio());
            amb = valor.getTipoambiente();
            accion = "update";
        } else {
            this.entidad = new HistorialDeclaraciones();

            this.entidad.setHisFecha(new Date());
            amb = valor.getTipoambiente();
            accion = "create";
        }

    }

    public NuevoHistorial() {
//        Session sess = Sessions.getCurrent();
//        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
//        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(amRuc);
    }

    @Command
    public void guardar() {
        if (entidad.getHisDescripcion() != null
                    && entidad.getHisPathDeclaracion() != null
                    && entidad.getHisPathPago() != null) {

            if (accion.equals("create")) {
                entidad.setCodTipoambiente(amb);
                entidad.setHisAnio(Integer.valueOf(hisAnio));
                entidad.setHisMes(Integer.valueOf(hisMes));
                servicio.crear(entidad);

                windowHistorial.detach();
            } else {
               
                entidad.setHisAnio(Integer.valueOf(hisAnio));
                entidad.setHisMes(Integer.valueOf(hisMes));
                 servicio.modificar(entidad);
                windowHistorial.detach();
            }

        } else {
            Clients.showNotification("Verifique la informacion...! ", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);
        }
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public HistorialDeclaraciones getEntidad() {
        return entidad;
    }

    public void setEntidad(HistorialDeclaraciones entidad) {
        this.entidad = entidad;
    }

    public String getHisMes() {
        return hisMes;
    }

    public void setHisMes(String hisMes) {
        this.hisMes = hisMes;
    }

    public String getHisAnio() {
        return hisAnio;
    }

    public void setHisAnio(String hisAnio) {
        this.hisAnio = hisAnio;
    }

    //Imagen ruta 
    private String filePathDeclaracion;

    @Command
    @NotifyChange({"entidad"})
    public void subirDeclaracion() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.util.media.AMedia) {
            String nombre = media.getName();
            if (nombre.contains(".pdf")) {
                if (media.getByteData().length > 10 * 1024 * 1024) {
                   Clients.showNotification("El archivo seleccionado es muy pesado...! ", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);

                    return;
                }
                filePathDeclaracion = amb.getAmDirBaseArchivos() + File.separator + amb.getAmFolderFirma() + File.separator;

                File baseDir = new File(filePathDeclaracion);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePathDeclaracion + media.getName()),
                            media.getStreamData());
                entidad.setHisPathDeclaracion(filePathDeclaracion + media.getName());

            } else {
                Clients.showNotification("Debe cargar un archivo PDF...! ", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);
            }
        }
    }
    //Imagen ruta 
    private String filePathPago;

    @Command
    @NotifyChange({"entidad"})
    public void subirPathPago() throws InterruptedException, IOException {

        org.zkoss.util.media.Media media = Fileupload.get();
        if (media instanceof org.zkoss.util.media.AMedia) {
            String nombre = media.getName();
            if (nombre.contains(".pdf")) {

                if (media.getByteData().length > 10 * 1024 * 1024) {
                   Clients.showNotification("El archivo seleccionado es muy pesado...! ", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);

                    return;
                }
                filePathPago = amb.getAmDirBaseArchivos() + File.separator + amb.getAmFolderFirma() + File.separator;

                File baseDir = new File(filePathPago);
                if (!baseDir.exists()) {
                    baseDir.mkdirs();
                }
                Files.copy(new File(filePathPago + media.getName()),
                            media.getStreamData());
                entidad.setHisPathPago(filePathPago + media.getName());

            } else {
                Clients.showNotification("Debe cargar un archivo PDF...! ", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);
            }
        }
    }
}
