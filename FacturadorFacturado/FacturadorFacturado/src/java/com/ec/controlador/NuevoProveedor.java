/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Proveedores;
import com.ec.entidad.TipoIdentificacionCompra;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioProveedor;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioTipoIdentificacionCompra;
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
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class NuevoProveedor {

    ServicioTipoIdentificacionCompra servicioTipoIdentificacionCompra = new ServicioTipoIdentificacionCompra();
    private List<TipoIdentificacionCompra> listaIdentificacionCompras = new ArrayList<TipoIdentificacionCompra>();
    private TipoIdentificacionCompra identificacionCompra = null;

    private Proveedores proveedor = new Proveedores();
    ServicioProveedor servicioProveedor = new ServicioProveedor();
    private String accion = "create";
    @Wire
    Window windowCliente;

    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("valor") Proveedores proveedor, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        if (proveedor != null) {
            this.proveedor = proveedor;
            accion = "update";
            identificacionCompra = proveedor.getIdTipoIdentificacionCompra();
        } else {
            this.proveedor = new Proveedores();
            this.proveedor.setProvMovil("0999999999");
            this.proveedor.setProvTelefono("099999999");
            accion = "create";
            identificacionCompra = null;
        }
        cargarTipoIdentificacion();

    }

    public NuevoProveedor() {
       

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());


    }

    private void cargarTipoIdentificacion() {
        listaIdentificacionCompras = servicioTipoIdentificacionCompra.findALlTipoIdentificacionCompra();
    }

    @Command
    @NotifyChange({"proveedor"})
    public void buscarAduana()throws URISyntaxException, IOException {
        if (proveedor.getProvCedula()!= null) {
            if (!proveedor.getProvCedula().equals("")) {
                String cedulaBuscar = "";
                if (proveedor.getProvCedula().length() > 10) {
                    cedulaBuscar = proveedor.getProvCedula().substring(0, 10);
                } else {
                    cedulaBuscar = proveedor.getProvCedula();
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
                    proveedor.setProvNombre(nombrePersona+" "+apellidoPersona);
                    proveedor.setProvNomComercial(nombrePersona+" "+apellidoPersona);
                  
                }
            }
        }

    }
    
    
    @Command
    public void guardar() {
        if (proveedor.getProvCedula() != null
                    && proveedor.getProvNombre() != null
                    && proveedor.getProvTelefono() != null
                    && proveedor.getProvDireccion() != null
                    && identificacionCompra != null) {
            proveedor.setIdTipoIdentificacionCompra(identificacionCompra);
            proveedor.setCodTipoambiente(amb);
            if (accion.equals("create")) {
                servicioProveedor.crear(proveedor);
                // Messagebox.show("Guardado con exito");

                windowCliente.detach();
            } else {
                servicioProveedor.modificar(proveedor);
                // Messagebox.show("Guardado con exito");

                windowCliente.detach();
            }

        } else {
            Messagebox.show("Verifique la informacion requerida", "Atención", Messagebox.OK, Messagebox.ERROR);
        }
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<TipoIdentificacionCompra> getListaIdentificacionCompras() {
        return listaIdentificacionCompras;
    }

    public void setListaIdentificacionCompras(List<TipoIdentificacionCompra> listaIdentificacionCompras) {
        this.listaIdentificacionCompras = listaIdentificacionCompras;
    }

    public TipoIdentificacionCompra getIdentificacionCompra() {
        return identificacionCompra;
    }

    public void setIdentificacionCompra(TipoIdentificacionCompra identificacionCompra) {
        this.identificacionCompra = identificacionCompra;
    }

}
