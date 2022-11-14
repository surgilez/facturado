/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Parametrizar;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import com.ec.servicio.ServicioParametrizar;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.servicio.ServicioUsuario;
import com.ec.untilitario.MailerClassSistema;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author gato
 */
public class RegistroUsuarioExt {

    @Wire
    Window windowIdUsuario;
    ServicioUsuario servicioUsuario = new ServicioUsuario();
    private Usuario usuarioSistema = new Usuario();
    private String tipoUSuario = "2";
    private String accion = "create";

    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
//    UserCredential credential = new UserCredential();
//    private String amRuc = "";
//    private Tipoambiente amb = new Tipoambiente();
    ServicioParametrizar servicioParametrizar = new ServicioParametrizar();
//    private Boolean readOnly = true;

    @AfterCompose
    public void afterCompose(@ExecutionArgParam("usuario") Usuario usuarioSistema, @ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        if (usuarioSistema != null) {
            this.usuarioSistema = usuarioSistema;
            tipoUSuario = this.usuarioSistema.getUsuNivel().toString();
            accion = "update";

        } else {
            this.usuarioSistema = new Usuario();
            accion = "create";

        }
    }

    public RegistroUsuarioExt() {

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
    @NotifyChange("usuarioSistema")
    public void guardar() {
        if (usuarioSistema != null && !usuarioSistema.getUsuNombre().equals("")
                    && !usuarioSistema.getUsuLogin().equals("")
                    && !tipoUSuario.equals("")) {
            usuarioSistema.setUsuNivel(Integer.valueOf(tipoUSuario));
            /*verifica si tiene tipo ambiente*/

            if (usuarioSistema.getUsuWhatsapp() == null) {
                Clients.showNotification("Ingrese un numero de contacto..!!",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                return;
            }
            if (usuarioSistema.getUsuRuc().length() != 13) {
                Clients.showNotification("Ingrese un RUC valido..!!",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                return;
            }

            Usuario usuariovalida = servicioUsuario.FindUsuarioPorNombre(usuarioSistema.getUsuLogin());
            if (usuariovalida != null) {
                Clients.showNotification("El nombre de usuario ya se encuentra en uso..!!",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                return;
            }
            usuarioSistema.setUsuFechaRegistro(new Date());
            Date fecha = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(fecha);
            c.add(Calendar.DATE, 30);
            usuarioSistema.setUsuFechaPago(c.getTime());
            usuarioSistema.setUsuIlimitado(Boolean.TRUE);
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
            // verifica si existe sino lo crea
            Tipoambiente tipoAmbienteRecup = servicioTipoAmbiente.findALlTipoambientePorUsuario(usuarioSistema);

            if (tipoAmbienteRecup == null) {
                // PRUEBAS
                Tipoambiente tipoambiente = new Tipoambiente();
                tipoambiente.setAmDirBaseArchivos("//DOCUMENTOSRI");
                tipoambiente.setAmCodigo("1");
                tipoambiente.setAmDescripcion("PRUEBAS");
                tipoambiente.setAmEstado(Boolean.TRUE);
                tipoambiente.setAmIdEmpresa(1);
                tipoambiente.setAmUsuariosri("PRUEBA");
                tipoambiente.setAmUrlsri("celcer.sri.gob.ec");

                tipoambiente.setAmDirReportes("REPORTES");
                tipoambiente.setAmGenerados("GENERADOS");
                tipoambiente.setAmDirXml("XML");
                tipoambiente.setAmFirmados("FIRMADOS");
                tipoambiente.setAmTrasmitidos("TRASMITIDOS");
                tipoambiente.setAmDevueltos("DEVUELTOS");
                tipoambiente.setAmFolderFirma("FIRMA");
                tipoambiente.setAmAutorizados("AUTORIZADOS");
                tipoambiente.setAmNoAutorizados("NOAUTORIZADOS");
                tipoambiente.setAmTipoEmision("1");
                tipoambiente.setAmEnviocliente("ENVIARCLIENTE");
                tipoambiente.setAmRuc(usuarioSistema.getUsuRuc());
                tipoambiente.setAmNombreComercial(usuarioSistema.getUsuNombre());
                tipoambiente.setAmRazonSocial(usuarioSistema.getUsuNombre());
                tipoambiente.setAmDireccionMatriz("");
                tipoambiente.setAmDireccionSucursal("");
                tipoambiente.setAmEstab("001");
                tipoambiente.setAmPtoemi("001");

                tipoambiente.setAmPort("587");
                tipoambiente.setAmProtocol("smtp");
                tipoambiente.setAmUsuarioSmpt("recibos@facturado.ec");
                tipoambiente.setAmPassword("Lampara&Luz$");
                tipoambiente.setAmHost("smtp.office365.com");
                tipoambiente.setLlevarContabilidad("NO");
                tipoambiente.setAmMicroEmp(Boolean.FALSE);
                tipoambiente.setAmAgeRet(Boolean.FALSE);
                tipoambiente.setAmContrEsp(Boolean.FALSE);
                tipoambiente.setAmExp(Boolean.FALSE);
                tipoambiente.setIdUsuario(usuarioSistema);
                tipoambiente.setAmUnidadDisco("/");
                tipoambiente.setAmGrabaIce(Boolean.FALSE);
                tipoambiente.setAmValorIce(BigDecimal.ZERO);
                tipoambiente.setAmCodigoIce("0");
                tipoambiente.setAmComprobanteImprime("factura.jasper");
                servicioTipoAmbiente.crear(tipoambiente);

                // PRODUCCION
                Tipoambiente tipoambienteProd = new Tipoambiente();
                tipoambienteProd.setAmUnidadDisco("/");
                tipoambienteProd.setAmDirBaseArchivos("//DOCUMENTOSRI");
                tipoambienteProd.setAmCodigo("2");
                tipoambienteProd.setAmDescripcion("PRODUCCION");
                tipoambienteProd.setAmEstado(Boolean.FALSE);
                tipoambienteProd.setAmIdEmpresa(1);
                tipoambienteProd.setAmUsuariosri("PRODUCCION");
                tipoambienteProd.setAmUrlsri("cel.sri.gob.ec");
                tipoambienteProd.setAmFolderFirma("FIRMA");
                tipoambienteProd.setAmDirReportes("REPORTES");
                tipoambienteProd.setAmGenerados("GENERADOS");
                tipoambienteProd.setAmDirXml("XML");
                tipoambienteProd.setAmFirmados("FIRMADOS");
                tipoambienteProd.setAmTrasmitidos("TRASMITIDOS");
                tipoambienteProd.setAmDevueltos("DEVUELTOS");
                tipoambienteProd.setAmAutorizados("AUTORIZADOS");
                tipoambienteProd.setAmNoAutorizados("NOAUTORIZADOS");
                tipoambienteProd.setAmTipoEmision("1");
                tipoambienteProd.setAmEnviocliente("ENVIARCLIENTE");
                tipoambienteProd.setAmRuc(usuarioSistema.getUsuRuc());
                tipoambienteProd.setAmNombreComercial(usuarioSistema.getUsuNombre());
                tipoambienteProd.setAmRazonSocial(usuarioSistema.getUsuNombre());
                tipoambienteProd.setAmEstab("001");
                tipoambienteProd.setAmPtoemi("001");
                tipoambienteProd.setAmDireccionMatriz("");
                tipoambienteProd.setAmDireccionSucursal("");
                tipoambienteProd.setLlevarContabilidad("NO");
                tipoambienteProd.setAmPort("587");
                tipoambienteProd.setAmProtocol("smtp");
                tipoambienteProd.setAmUsuarioSmpt("recibos@facturado.ec");
                tipoambienteProd.setAmPassword("Lampara&Luz$");
                tipoambienteProd.setAmHost("smtp.office365.com");

                tipoambienteProd.setAmMicroEmp(Boolean.FALSE);
                tipoambienteProd.setAmAgeRet(Boolean.FALSE);
                tipoambienteProd.setAmContrEsp(Boolean.FALSE);
                tipoambienteProd.setAmExp(Boolean.FALSE);
                tipoambienteProd.setIdUsuario(usuarioSistema);
                tipoambienteProd.setAmGrabaIce(Boolean.FALSE);
                tipoambienteProd.setAmValorIce(BigDecimal.ZERO);
                tipoambienteProd.setAmCodigoIce("0");
                tipoambienteProd.setAmComprobanteImprime("factura.jasper");

                servicioTipoAmbiente.crear(tipoambienteProd);

                
            }

//            usuarioSistema = new Usuario();
            try {
                tipoAmbienteRecup = servicioTipoAmbiente.findALlTipoambientePorUsuario(usuarioSistema);
                MailerClassSistema mail = new MailerClassSistema();
                mail.sendMailRecuperarPassword(usuarioSistema.getUsuCorreo(), "Cuenta creada", usuarioSistema.getUsuLogin(), usuarioSistema.getUsuPassword(), tipoAmbienteRecup);
                Clients.showNotification("Los accesos se enviaron al correo electrónico",
                            Clients.NOTIFICATION_TYPE_INFO, null, "end_center", 2000, true);
            } catch (RemoteException ex) {
                Clients.showNotification("Ocurrio un error al recuperar su password",
                            Clients.NOTIFICATION_TYPE_ERROR, null, "end_center", 2000, true);
                Logger.getLogger(RecuperarClave.class.getName()).log(Level.SEVERE, null, ex);
            }
            windowIdUsuario.detach();

        } else {
            Messagebox.show("Verifique la informacion ingresada", "Atención", Messagebox.OK, Messagebox.ERROR);
        }
    }

}
