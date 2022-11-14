/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador;

import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.HelperPersistencia;
import com.ec.servicio.ServicioHistorialDeclaraciones;

import com.ec.servicio.ServicioTipoAmbiente;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import com.ec.entidad.HistorialDeclaraciones;
import com.ec.untilitario.ArchivoUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;

/**
 *
 * @author gato
 */
public class ListaHistorialDeclaraciones {

    ServicioHistorialDeclaraciones servicioHistorialDeclaraciones = new ServicioHistorialDeclaraciones();
    private List<HistorialDeclaraciones> listaDatos = new ArrayList<HistorialDeclaraciones>();
    //reporte
    AMedia fileContent = null;
    Connection con = null;
    private String buscar = "";
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();
    private String amRuc = "";
    UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private static String PATH_BASE = "";

    public ListaHistorialDeclaraciones() {
   
        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());
        
        //OBTIENE LAS RUTAS DE ACCESO A LOS DIRECTORIOS DE LA TABLA TIPOAMBIENTE
        PATH_BASE = amb.getAmDirBaseArchivos() + File.separator
                    + amb.getAmDirXml();
        consultarHistorial();
    }

    private void consultarHistorial() {
        listaDatos = servicioHistorialDeclaraciones.findByTipoAmbiente(amb);
    }

    public void reporteGeneral(Integer numeroFactura) throws JRException, IOException, NamingException, SQLException {
        EntityManager emf = HelperPersistencia.getEMF();
        try {

            emf.getTransaction().begin();
            con = emf.unwrap(Connection.class);
            String reportFile = Executions.getCurrent().getDesktop().getWebApp()
                        .getRealPath("/reportes");
            String reportPath = "";

            reportPath = reportFile + File.separator + "ordentrabajo.jasper";

            Map<String, Object> parametros = new HashMap<String, Object>();

            //  parametros.put("codUsuario", String.valueOf(credentialLog.getAdUsuario().getCodigoUsuario()));
            parametros.put("numfactura", numeroFactura);

            if (con != null) {
                System.out.println("Conexión Realizada Correctamenteeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            }
            FileInputStream is = null;
            is = new FileInputStream(reportPath);

            byte[] buf = JasperRunManager.runReportToPdf(is, parametros, con);
            InputStream mediais = new ByteArrayInputStream(buf);
            AMedia amedia = new AMedia("Reporte", "pdf", "application/pdf", mediais);
            fileContent = amedia;
            final HashMap<String, AMedia> map = new HashMap<String, AMedia>();
//para pasar al visor
            map.put("pdf", fileContent);
            org.zkoss.zul.Window window = (org.zkoss.zul.Window) Executions.createComponents(
                        "/venta/contenedorReporte.zul", null, map);
            window.doModal();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR EL PRESENTAR EL REPORTE " + e.getMessage());
        } catch (JRException e) {
            System.out.println("ERROR EL PRESENTAR EL REPORTE " + e.getMessage());
        } finally {
            if (emf != null) {
                emf.getTransaction().commit();
            }

        }

    }

    public List<HistorialDeclaraciones> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<HistorialDeclaraciones> listaDatos) {
        this.listaDatos = listaDatos;
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
