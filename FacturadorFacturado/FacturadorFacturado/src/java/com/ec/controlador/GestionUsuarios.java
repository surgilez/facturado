/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioUsuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

/**
 *
 * @author gato
 */
public class GestionUsuarios {

    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();

    private String buscarAll="";
   
    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    private Boolean esVisisible = Boolean.FALSE;

    public GestionUsuarios() {

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
      
        cosultarUsuarios("");
    }

    public String getBuscarAll() {
        return buscarAll;
    }

    public void setBuscarAll(String buscarAll) {
        this.buscarAll = buscarAll;
    }

  
  
   

    /*ADMINISTRAR USUARIO*/
    private void cosultarUsuarios(String buscar) {
        listaUsuarios = servicioUsuario.FindALlUsuarioPorLikeNombre(buscar, credential.getUsuarioSistema());
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    
     @Command
    @NotifyChange("listaUsuarios")
    public void buscarCoincidencia() {
        
        consultarConicidencia();
    }
    
     private void consultarConicidencia() {
        listaUsuarios = servicioUsuario.findByCoincidencia(buscarAll);
    }
    //usuarios
    @Command
    @NotifyChange("listaUsuarios")
    public void agregarUsario() {
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/nuevo/usuario.zul", null, null);
        window.doModal();
        cosultarUsuarios("");
    }

    @Command
    @NotifyChange("listaUsuarios")
    public void modificarUsario(@BindingParam("valor") Usuario usuario) {
        final HashMap<String, Usuario> map = new HashMap<String, Usuario>();
        map.put("usuario", usuario);
        org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                    "/nuevoadmin/usuario.zul", null, map);
        window.doModal();
        cosultarUsuarios("");
    }

    public UserCredential getCredential() {
        return credential;
    }

    public void setCredential(UserCredential credential) {
        this.credential = credential;
    }

    public Boolean getEsVisisible() {
        return credential.getUsuarioSistema().getUsuNivel() == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setEsVisisible(Boolean esVisisible) {
        this.esVisisible = esVisisible;
    }

}
