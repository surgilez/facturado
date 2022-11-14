/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.HistorialDeclaraciones;
import com.ec.entidad.Producto;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioHistorialDeclaraciones;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.untilitario.ArchivoUtils;
import com.ec.untilitario.ParamHistorialDeclaracion;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Clients;

/**
 *
 * @author gato
 */
public class AdministracionEmpresas {

    private List<Tipoambiente> listaEmpresas = new ArrayList<Tipoambiente>();
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private String amCodigo = "2";
    private String amDescripcion = "PRODUCCION";
    private String amNombreComercial = "";
    private String link = "";

    ServicioHistorialDeclaraciones servicioHistorialDeclaraciones = new ServicioHistorialDeclaraciones();
    private List<HistorialDeclaraciones> listaDatos = new ArrayList<HistorialDeclaraciones>();
    //reporte
    AMedia fileContent = null;
    Connection con = null;
    private String buscar = "";
//    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private String amRuc = "";
    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private Tipoambiente ambSelected = null;
    private static String PATH_BASE = "";

    public AdministracionEmpresas() {
//         Session sess = Sessions.getCurrent();
//        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
////        amRuc = credential.getUsuarioSistema().getUsuRuc();
//        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
        //OBTIENE LAS RUTAS DE ACCESO A LOS DIRECTORIOS DE LA TABLA TIPOAMBIENTE
        PATH_BASE = amb.getAmDirBaseArchivos() + File.separator
                    + amb.getAmDirXml();
        consultarEmpresas();
        consultarHistorial();

    }

    private void consultarEmpresas() {
        listaEmpresas = servicioTipoAmbiente.findEmpresas(amCodigo, amDescripcion, amNombreComercial);
    }

    private void consultarHistorial() {
        listaDatos = servicioHistorialDeclaraciones.findByTipoAmbiente(ambSelected);
    }

    @Command
    @NotifyChange({"listaEmpresas", "amCodigo", "amDescripcion"})
    public void buscarEmpresas() {

        consultarEmpresas();

    }

    @Command
    @NotifyChange({"ambSelected", "listaDatos"})
    public void seleccionarEmpresa(@BindingParam("valor") Tipoambiente valor) {
        ambSelected = valor;
        consultarHistorial();

    }

    @Command
    @NotifyChange({"listaDatos"})
    public void registrarDeclaracion() {
        if (ambSelected != null) {
            ParamHistorialDeclaracion param = new ParamHistorialDeclaracion("create");
//        param.setDeclaraciones(valor);
            param.setTipoambiente(ambSelected);
            final HashMap<String, ParamHistorialDeclaracion> map = new HashMap<String, ParamHistorialDeclaracion>();
            map.put("valor", param);
            org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                        "/nuevoadmin/historial.zul", null, map);
            window.doModal();
            consultarHistorial();
        } else {
            Clients.showNotification("Seleccione una empresa...! ", Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);
        }
    }

    @Command
    @NotifyChange({"listaDatos"})
    public void modificarDeclaracion(@BindingParam("valor") HistorialDeclaraciones valor) {
        ParamHistorialDeclaracion param = new ParamHistorialDeclaracion("update");
        param.setDeclaraciones(valor);
        param.setTipoambiente(ambSelected);
        final HashMap<String, ParamHistorialDeclaracion> map = new HashMap<String, ParamHistorialDeclaracion>();
        map.put("valor", param);
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/nuevoadmin/historial.zul", null, map);
        window.doModal();
        consultarHistorial();
    }

    public List<Tipoambiente> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Tipoambiente> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public String getAmCodigo() {
        return amCodigo;
    }

    public void setAmCodigo(String amCodigo) {
        this.amCodigo = amCodigo;
    }

    public String getAmDescripcion() {
        return amDescripcion;
    }

    public void setAmDescripcion(String amDescripcion) {
        this.amDescripcion = amDescripcion;
    }

    public String getAmNombreComercial() {
        return amNombreComercial;
    }

    public void setAmNombreComercial(String amNombreComercial) {
        this.amNombreComercial = amNombreComercial;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<HistorialDeclaraciones> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<HistorialDeclaraciones> listaDatos) {
        this.listaDatos = listaDatos;
    }

    public Tipoambiente getAmbSelected() {
        return ambSelected;
    }

    public void setAmbSelected(Tipoambiente ambSelected) {
        this.ambSelected = ambSelected;
    }

    @Command
    public void verDeclaraciones(@BindingParam("valor") HistorialDeclaraciones valor) {
        try {
            fileContent = new AMedia("Visor", "pdf", "application/pdf", ArchivoUtils.Imagen_A_Bytes(valor.getHisPathDeclaracion()));
            final HashMap<String, AMedia> map = new HashMap<String, AMedia>();
//para pasar al visor
            map.put("pdf", fileContent);
            org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                        "/venta/contenedorReporte.zul", null, map);
            window.doModal();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistorialDeclaraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Command
    public void verPago(@BindingParam("valor") HistorialDeclaraciones valor) {
        try {
            fileContent = new AMedia("Visor", "pdf", "application/pdf", ArchivoUtils.Imagen_A_Bytes(valor.getHisPathPago()));
            final HashMap<String, AMedia> map = new HashMap<String, AMedia>();
//para pasar al visor
            map.put("pdf", fileContent);
            org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                        "/venta/contenedorReporte.zul", null, map);
            window.doModal();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistorialDeclaraciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
