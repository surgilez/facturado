/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Tipoadentificacion;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Transportista;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioTipoIdentificacion;
import com.ec.servicio.ServicioTransportista;
import com.ec.untilitario.AduanaJson;
import com.ec.untilitario.ArchivoUtils;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class NuevoConductor {

    ServicioTipoIdentificacion servicioTipoIdentificacionCompra = new ServicioTipoIdentificacion();
    private List<Tipoadentificacion> listaIdentificacionCompras = new ArrayList<Tipoadentificacion>();
    private Tipoadentificacion identificacionCompra = null;

    private Transportista transportista = new Transportista();
    ServicioTransportista servicioTransportista = new ServicioTransportista();
    private String accion = "create";
    @Wire
    Window windowCliente;

    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("valor") Transportista valor, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        if (valor != null) {
            this.transportista = valor;
            accion = "update";
            identificacionCompra = transportista.getIdTipoIdentificacion();
        } else {
            this.transportista = new Transportista();
            this.transportista.setTrpMovil("0999999999");
            this.transportista.setTrpTelefono("0999999999");
            accion = "create";
            identificacionCompra = null;
        }
        cargarTipoIdentificacion();

    }

    public NuevoConductor() {

       

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());

    }

    private void cargarTipoIdentificacion() {
        listaIdentificacionCompras = servicioTipoIdentificacionCompra.FindALlTipoadentificacion();
    }

    @Command
    @NotifyChange({"transportista"})
    public void buscarAduana()throws URISyntaxException, IOException {
        if (transportista.getTrpCedula() != null) {
            if (!transportista.getTrpCedula().equals("")) {
                String cedulaBuscar = "";
                if (transportista.getTrpCedula().length() >= 10) {
                    cedulaBuscar = transportista.getTrpCedula().substring(0, 10);
                } else {
                    Clients.showNotification("Debe ingresar mas de 10 digitos",
                                Clients.NOTIFICATION_TYPE_ERROR, null, "middle_center", 2000, true);
                    return;
                }
                AduanaJson aduana = ArchivoUtils.obtenerdatoAduana(cedulaBuscar);
                if (aduana != null) {

                    String nombreApellido[] = aduana.getNombre().split(" ");
                    String nombrePersona = "";
                    String apellidoPersona = "";
                    switch (nombreApellido.length) {
                        case 1:
                            apellidoPersona = nombreApellido[0];
                            nombrePersona = "A";
                            break;
                        case 2:
                            apellidoPersona = nombreApellido[0];
                            nombrePersona = nombreApellido[1];
                            break;
                        case 3:
                            apellidoPersona = nombreApellido[0] + " " + nombreApellido[1];
                            nombrePersona = nombreApellido[2];
                            break;
                        case 4:
                            apellidoPersona = nombreApellido[0] + " " + nombreApellido[1];
                            nombrePersona = nombreApellido[2] + " " + nombreApellido[3];
                            break;
                        default:
                            break;
                    }
                    transportista.setTrpRazonSocial(nombrePersona + " " + apellidoPersona);
//                    transportista.setProvNomComercial(nombrePersona+" "+apellidoPersona);

                }
            }
        }

    }

    @Command
    public void guardar() {
        if (transportista.getTrpCedula() != null
                    && transportista.getTrpRazonSocial() != null
                    && transportista.getTrpDireccion() != null
                    && transportista.getTrpTelefono() != null
                    && identificacionCompra != null) {
            transportista.setIdTipoIdentificacion(identificacionCompra);
            transportista.setCodTipoambiente(amb);
            if (accion.equals("create")) {
                servicioTransportista.crear(transportista);
                //  Messagebox.show("Guardado con exito");

                windowCliente.detach();
            } else {
                servicioTransportista.modificar(transportista);
                // Messagebox.show("Guardado con exito");

                windowCliente.detach();
            }

        } else {
            Messagebox.show("Verifique la informacion requerida", "Atención", Messagebox.OK, Messagebox.ERROR);
        }
    }

    public List<Tipoadentificacion> getListaIdentificacionCompras() {
        return listaIdentificacionCompras;
    }

    public void setListaIdentificacionCompras(List<Tipoadentificacion> listaIdentificacionCompras) {
        this.listaIdentificacionCompras = listaIdentificacionCompras;
    }

    public Tipoadentificacion getIdentificacionCompra() {
        return identificacionCompra;
    }

    public void setIdentificacionCompra(Tipoadentificacion identificacionCompra) {
        this.identificacionCompra = identificacionCompra;
    }

    public Transportista getTransportista() {
        return transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

}
