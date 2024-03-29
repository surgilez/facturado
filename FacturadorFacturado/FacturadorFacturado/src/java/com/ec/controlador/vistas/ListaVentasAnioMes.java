/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.controlador.vistas;

import com.ec.entidad.Factura;
import com.ec.entidad.Tipoambiente;
import com.ec.seguridad.EnumSesion;
import com.ec.seguridad.UserCredential;
import com.ec.servicio.ServicioAcumuladoVentas;
import com.ec.servicio.ServicioTipoAmbiente;
import com.ec.untilitario.ArchivoUtils;
import com.ec.vistas.Acumuladoaniomes;
import com.ec.vistas.Acumuladopordia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.activation.MimetypesFileTypeMap;
import javax.mail.internet.ParseException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Filedownload;

/**
 *
 * @author gato
 */
public class ListaVentasAnioMes {

    ServicioAcumuladoVentas servicioAcumuladoVentas = new ServicioAcumuladoVentas();

    private Date fechainicio = new Date();
    private Date fechafin = new Date();
    private List<Acumuladoaniomes> listaAcumuladoaniomeses = new ArrayList<Acumuladoaniomes>();
    /*DIARIA*/
    private Date fechainicioDiaria = new Date();
    private Date fechafinDiaria = new Date();

    private List<Acumuladopordia> listaAcumuladopordias = new ArrayList<Acumuladopordia>();
    
       UserCredential credential = new UserCredential();
    private Tipoambiente amb = new Tipoambiente();
    private String amRuc = "";
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    public ListaVentasAnioMes() {

           

        Session sess = Sessions.getCurrent();
        credential = (UserCredential) sess.getAttribute(EnumSesion.userCredential.getNombre());
//        amRuc = credential.getUsuarioSistema().getUsuRuc();
        amb = servicioTipoAmbiente.findALlTipoambientePorUsuario(credential.getUsuarioSistema());

        
        Calendar calendar = Calendar.getInstance(); //obtiene la fecha de hoy 
        calendar.add(Calendar.MONTH, -6); //el -3 indica que se le restaran 3 dias 
        fechainicio = calendar.getTime();
        //fechainicio.setMonth(-6);
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -15); //el -3 indica que se le restaran 3 dias 
        fechainicioDiaria = calendar.getTime();
        //fechainicioDiaria.setDate(-7);
        consultaVentasAnioMes();
        consultaVentasDiarias();
    }

    @Command
    @NotifyChange({"listaAcumuladopordias", "fechainicioDiaria", "fechafinDiaria"})
    public void buscarDiaria() {

        consultaVentasDiarias();

    }

    @Command
    @NotifyChange({"listaAcumuladoaniomeses", "fechainicio", "fechafin"})
    public void buscarAnioMes() {

        consultaVentasAnioMes();

    }

    private void consultaVentasAnioMes() {
        listaAcumuladoaniomeses = servicioAcumuladoVentas.findAcumuladoventasAnioMes(fechainicio, fechafin,amb);
    }

    private void consultaVentasDiarias() {
        listaAcumuladopordias = servicioAcumuladoVentas.findAcumuladoventasdiaria(fechainicioDiaria, fechafinDiaria, amb);
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public List<Acumuladoaniomes> getListaAcumuladoaniomeses() {
        return listaAcumuladoaniomeses;
    }

    public void setListaAcumuladoaniomeses(List<Acumuladoaniomes> listaAcumuladoaniomeses) {
        this.listaAcumuladoaniomeses = listaAcumuladoaniomeses;
    }

    public Date getFechainicioDiaria() {
        return fechainicioDiaria;
    }

    public void setFechainicioDiaria(Date fechainicioDiaria) {
        this.fechainicioDiaria = fechainicioDiaria;
    }

    public Date getFechafinDiaria() {
        return fechafinDiaria;
    }

    public void setFechafinDiaria(Date fechafinDiaria) {
        this.fechafinDiaria = fechafinDiaria;
    }

    public List<Acumuladopordia> getListaAcumuladopordias() {
        return listaAcumuladopordias;
    }

    public void setListaAcumuladopordias(List<Acumuladopordia> listaAcumuladopordias) {
        this.listaAcumuladopordias = listaAcumuladopordias;
    }

    //exportar informacion por dia
    @Command
    public void exportExcelDiario() throws Exception {
        try {
            File dosfile = new File(exportarExcelDiario());
            if (dosfile.exists()) {
                FileInputStream inputStream = new FileInputStream(dosfile);
                Filedownload.save(inputStream, new MimetypesFileTypeMap().getContentType(dosfile), dosfile.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL DESCARGAR EL ARCHIVO" + e.getMessage());
        }
    }

    private String exportarExcelDiario() throws FileNotFoundException, IOException, ParseException {
        String directorioReportes = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes");

        Date date = new Date();
        SimpleDateFormat fhora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sm = new SimpleDateFormat("yyy-MM-dd");
        String strDate = sm.format(date);

        String pathSalida = directorioReportes + File.separator + "AcumuladoDiario.xls";
        System.out.println("Direccion del reporte acumulado diario " + pathSalida);
        try {
            int j = 0;
            File archivoXLS = new File(pathSalida);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet s = wb.createSheet("Diario");

            HSSFFont fuente = wb.createFont();
            fuente.setBoldweight((short) 700);
            HSSFCellStyle estiloCelda = wb.createCellStyle();
            //   estiloCelda.setWrapText(true);
            //  estiloCelda.setAlignment((short) 2);
            estiloCelda.setFont(fuente);

            HSSFCellStyle estiloCeldaInterna = wb.createCellStyle();
            estiloCeldaInterna.setWrapText(true);
            estiloCeldaInterna.setAlignment((short) 5);
            estiloCeldaInterna.setFont(fuente);

            HSSFCellStyle estiloCelda1 = wb.createCellStyle();
            estiloCelda1.setWrapText(true);
            estiloCelda1.setFont(fuente);

            HSSFRow r = null;

            HSSFCell c = null;
            r = s.createRow(0);

            HSSFCell chfe = r.createCell(j++);
            chfe.setCellValue(new HSSFRichTextString("Total con factura"));
            chfe.setCellStyle(estiloCelda);

            HSSFCell chfe1 = r.createCell(j++);
            chfe1.setCellValue(new HSSFRichTextString("Total con Nota Venta"));
            chfe1.setCellStyle(estiloCelda);

            HSSFCell chfe11 = r.createCell(j++);
            chfe11.setCellValue(new HSSFRichTextString("Total"));
            chfe11.setCellStyle(estiloCelda);

            HSSFCell ch1 = r.createCell(j++);
            ch1.setCellValue(new HSSFRichTextString("Fecha"));
            ch1.setCellStyle(estiloCelda);

            int rownum = 1;
            int i = 0;
            BigDecimal totalConFactura = BigDecimal.ZERO;
            BigDecimal totalNotaVenta = BigDecimal.ZERO;
            BigDecimal total = BigDecimal.ZERO;
            BigDecimal Fecha = BigDecimal.ZERO;

            for (Acumuladopordia item : listaAcumuladopordias) {
                i = 0;

                r = s.createRow(rownum);

                HSSFCell cf = r.createCell(i++);
                cf.setCellValue(new HSSFRichTextString(ArchivoUtils.redondearDecimales(item.getFacTotal(), 2).toString()));
                totalConFactura = totalConFactura.add(ArchivoUtils.redondearDecimales(item.getFacTotal(), 2));
                HSSFCell cf1 = r.createCell(i++);
                cf1.setCellValue(new HSSFRichTextString(ArchivoUtils.redondearDecimales(item.getTotalntv(), 2).toString()));
                totalNotaVenta = totalNotaVenta.add(ArchivoUtils.redondearDecimales(item.getTotalntv(), 2));
                HSSFCell cf11 = r.createCell(i++);
                cf11.setCellValue(new HSSFRichTextString(ArchivoUtils.redondearDecimales(item.getTotalacumulado(), 2).toString()));
                total = total.add(ArchivoUtils.redondearDecimales(item.getTotalacumulado(), 2));
                HSSFCell c0 = r.createCell(i++);
                c0.setCellValue(new HSSFRichTextString(sm.format(item.getFacFecha())));

                /*autemta la siguiente fila*/
                rownum += 1;

            }

            j = 0;
            r = s.createRow(rownum);
            HSSFCell chfeF1 = r.createCell(j++);
            chfeF1.setCellValue(new HSSFRichTextString(totalConFactura.toString()));
            chfeF1.setCellStyle(estiloCelda);

            HSSFCell chfeF2 = r.createCell(j++);
            chfeF2.setCellValue(new HSSFRichTextString(totalNotaVenta.toString()));
            chfeF2.setCellStyle(estiloCelda);

            HSSFCell chfeF3 = r.createCell(j++);
            chfeF3.setCellValue(new HSSFRichTextString(total.toString()));
            chfeF3.setCellStyle(estiloCelda);

            HSSFCell chF4 = r.createCell(j++);
            chF4.setCellValue(new HSSFRichTextString(""));
            chF4.setCellStyle(estiloCelda);

            for (int k = 0; k <= listaAcumuladopordias.size(); k++) {
                s.autoSizeColumn(k);
            }
            wb.write(archivo);
            archivo.close();

        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }
        return pathSalida;

    }

    //exportar informacion por mes
    @Command
    public void exportExcelMes() throws Exception {
        try {
            File dosfile = new File(exportarExcelMes());
            if (dosfile.exists()) {
                FileInputStream inputStream = new FileInputStream(dosfile);
                Filedownload.save(inputStream, new MimetypesFileTypeMap().getContentType(dosfile), dosfile.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR AL DESCARGAR EL ARCHIVO" + e.getMessage());
        }
    }

    private String exportarExcelMes() throws FileNotFoundException, IOException, ParseException {
        String directorioReportes = Executions.getCurrent().getDesktop().getWebApp().getRealPath("/reportes");

        Date date = new Date();
        SimpleDateFormat fhora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sm = new SimpleDateFormat("yyy-MM-dd");
        String strDate = sm.format(date);

        String pathSalida = directorioReportes + File.separator + "AcumuladoMes.xls";
        System.out.println("Direccion del reporte acumulado diario " + pathSalida);
        try {
            int j = 0;
            File archivoXLS = new File(pathSalida);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }
            archivoXLS.createNewFile();
            FileOutputStream archivo = new FileOutputStream(archivoXLS);
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet s = wb.createSheet("Mensual");

            HSSFFont fuente = wb.createFont();
            fuente.setBoldweight((short) 700);
            HSSFCellStyle estiloCelda = wb.createCellStyle();
            // estiloCelda.setWrapText(true);
            // estiloCelda.setAlignment((short) 2);
            estiloCelda.setFont(fuente);

            HSSFCellStyle estiloCeldaInterna = wb.createCellStyle();
            estiloCeldaInterna.setWrapText(true);
            estiloCeldaInterna.setAlignment((short) 5);
            estiloCeldaInterna.setFont(fuente);

            HSSFCellStyle estiloCelda1 = wb.createCellStyle();
            estiloCelda1.setWrapText(true);
            estiloCelda1.setFont(fuente);

            HSSFRow r = null;

            HSSFCell c = null;
            r = s.createRow(0);

            HSSFCell chfe = r.createCell(j++);
            chfe.setCellValue(new HSSFRichTextString("Total con factura"));
            chfe.setCellStyle(estiloCelda);

            HSSFCell chfe1 = r.createCell(j++);
            chfe1.setCellValue(new HSSFRichTextString("Total con Nota Venta"));
            chfe1.setCellStyle(estiloCelda);

            HSSFCell chfe11 = r.createCell(j++);
            chfe11.setCellValue(new HSSFRichTextString("Total"));
            chfe11.setCellStyle(estiloCelda);

            HSSFCell ch1 = r.createCell(j++);
            ch1.setCellValue(new HSSFRichTextString("Mes"));
            ch1.setCellStyle(estiloCelda);

            HSSFCell ch111 = r.createCell(j++);
            ch111.setCellValue(new HSSFRichTextString("Año"));
            ch111.setCellStyle(estiloCelda);

            int rownum = 1;
            int i = 0;
            BigDecimal totalConFactura = BigDecimal.ZERO;
            BigDecimal totalNotaVenta = BigDecimal.ZERO;
            BigDecimal total = BigDecimal.ZERO;
            BigDecimal Fecha = BigDecimal.ZERO;

            for (Acumuladoaniomes item : listaAcumuladoaniomeses) {
                i = 0;

                r = s.createRow(rownum);

                HSSFCell cf = r.createCell(i++);
                cf.setCellValue(new HSSFRichTextString(ArchivoUtils.redondearDecimales(item.getFacTotal(), 2).toString()));
                totalConFactura = totalConFactura.add(ArchivoUtils.redondearDecimales(item.getFacTotal(), 2));

                HSSFCell cf1 = r.createCell(i++);
                cf1.setCellValue(new HSSFRichTextString(ArchivoUtils.redondearDecimales(item.getTotalntv(), 2).toString()));
                totalNotaVenta = totalNotaVenta.add(ArchivoUtils.redondearDecimales(item.getTotalntv(), 2));

                HSSFCell cf11 = r.createCell(i++);
                cf11.setCellValue(new HSSFRichTextString(ArchivoUtils.redondearDecimales(item.getTotalacumulado(), 2).toString()));
                total = total.add(ArchivoUtils.redondearDecimales(item.getTotalacumulado(), 2));

                HSSFCell c0 = r.createCell(i++);
                c0.setCellValue(new HSSFRichTextString(String.valueOf(item.getMes().intValue())));

                HSSFCell c00 = r.createCell(i++);
                c00.setCellValue(new HSSFRichTextString(String.valueOf(item.getAnio().intValue())));

                /*autemta la siguiente fila*/
                rownum += 1;

            }

            j = 0;
            r = s.createRow(rownum);
            HSSFCell chfeF1 = r.createCell(j++);
            chfeF1.setCellValue(new HSSFRichTextString(totalConFactura.toString()));
            // chfeF1.setCellStyle(estiloCelda);

            HSSFCell chfeF2 = r.createCell(j++);
            chfeF2.setCellValue(new HSSFRichTextString(totalNotaVenta.toString()));
            chfeF2.setCellStyle(estiloCelda);

            HSSFCell chfeF3 = r.createCell(j++);
            chfeF3.setCellValue(new HSSFRichTextString(total.toString()));
            chfeF3.setCellStyle(estiloCelda);

            HSSFCell chF4 = r.createCell(j++);
            chF4.setCellValue(new HSSFRichTextString(""));
            chF4.setCellStyle(estiloCelda);

            HSSFCell chF5 = r.createCell(j++);
            chF5.setCellValue(new HSSFRichTextString(""));
            chF5.setCellStyle(estiloCelda);

            for (int k = 0; k <= listaAcumuladoaniomeses.size(); k++) {
                s.autoSizeColumn(k);
            }
            wb.write(archivo);
            archivo.close();

        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }
        return pathSalida;

    }

}
