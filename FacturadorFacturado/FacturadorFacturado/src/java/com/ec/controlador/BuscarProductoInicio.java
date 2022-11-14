/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Producto;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioProducto;
import com.ec.servicio.ServicioTipoAmbiente;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author Darwin
 */
public class BuscarProductoInicio {

    ServicioProducto servicioProducto = new ServicioProducto();
    private List<Producto> listaProducto = new ArrayList<Producto>();
    private String buscarNombreProd = "";

    UserCredential credential = new UserCredential();
    private String amRuc = "";
    private Tipoambiente amb = null;
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    @Command
    @NotifyChange({"listaProducto", "buscarNombreProd"})
    public void buscarLikeNombreProd() {
        // buscarNombreProd = valor;
        findProductoLikeNombre();
    }

    public BuscarProductoInicio() {
        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
    }

    private void findProductoLikeNombre() {
        listaProducto = servicioProducto.findLikeProdNombre(buscarNombreProd, amb);
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public String getBuscarNombreProd() {
        return buscarNombreProd;
    }

    public void setBuscarNombreProd(String buscarNombreProd) {
        this.buscarNombreProd = buscarNombreProd;
    }

}
