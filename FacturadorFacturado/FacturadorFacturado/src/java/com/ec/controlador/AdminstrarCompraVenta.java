/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.Factura;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;

import com.ec.servicio.ServicioCompra;

import com.ec.servicio.ServicioFactura;
import com.ec.servicio.ServicioGeneral;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.untilitario.ResultadoCompraVenta;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author gato
 */
public class AdminstrarCompraVenta {

    ServicioCompra servicioCompra = new ServicioCompra();
    ServicioFactura servicioFactura = new ServicioFactura();
    ServicioGeneral servicioGeneral = new ServicioGeneral();
    private List<Factura> listaVentas = new ArrayList<Factura>();
    private List<CabeceraCompra> listaCompras = new ArrayList<CabeceraCompra>();
    private String buscar = "";
    private Date inicio = new Date();
    private Date fin = new Date();
    ResultadoCompraVenta compraVenta = new ResultadoCompraVenta();
    private String amRuc = "";
    UserCredential credential = new UserCredential();
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private Tipoambiente amb = new Tipoambiente();

    public AdminstrarCompraVenta() {

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
    }

    private void findByBetweenFecha() {
        listaCompras = servicioCompra.findByBetweenFecha(inicio, fin, amb);
        listaVentas = servicioFactura.findBetweenFecha(inicio, fin,amb);

        compraVenta = servicioGeneral.totalesCompraVenta(inicio, fin,amb);
    }

    @Command
    @NotifyChange({"listaCompras", "listaVentas", "inicio", "fin", "compraVenta"})
    public void buscarForFechas() {
        findByBetweenFecha();
    }



    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public List<Factura> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Factura> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public List<CabeceraCompra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<CabeceraCompra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public ResultadoCompraVenta getCompraVenta() {
        return compraVenta;
    }

    public void setCompraVenta(ResultadoCompraVenta compraVenta) {
        this.compraVenta = compraVenta;
    }

}
