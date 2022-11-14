/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.untilitario;

import com.ec.entidad.Tipoambiente;
import com.ec.servicio.ServicioTipoAmbiente;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.BodyPart;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeUtility;

/**
 * Clase que permite el envio de e-mails utilizando el API javamail.
 *
 */
public class MailerClass {

    private Tipoambiente amb = new Tipoambiente();
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    public String getConfiguracionCorreo(String categoria) {

        return null;
    }

    class SmtpAuthenticator extends Authenticator {

        public SmtpAuthenticator() {

            super();
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
//            amb = servicioTipoAmbiente.FindALlTipoambiente();
            String username = amb.getAmUsuarioSmpt().trim();
            String password = amb.getAmPassword().trim();
            return new PasswordAuthentication(username, password);

        }
    }

    //envio de mail simple
//    
//      m.setRecipients(Message.RecipientType.TO,
//                    InternetAddress.parse(address));
    public boolean sendMailSimple(String address,
                String[] attachFiles, String asuntoInf, String acceso,
                String numeroDocumento, BigDecimal valorTotal, String cliente, Tipoambiente ambiente)
                throws java.rmi.RemoteException {

        try {

            amb = ambiente;

//            String asunto = asuntoInf;
//              String host = "mail.deckxel.com";
//            String port = "26";
//            String protocol = "smtp";
//            String usuarioSmpt = "defact@deckxel.com";
//            String password = "Dereckandre02!";
            String asunto = asuntoInf;
            String host = amb.getAmHost();
            String port = amb.getAmPort();
            String protocol = amb.getAmProtocol();
            String usuarioSmpt = amb.getAmUsuarioSmpt().trim();
            String password = amb.getAmPassword().trim();

            // Propiedades de la conexión
            // Get system properties
            Properties properties = System.getProperties();

            // Setup mail server
            properties.setProperty("mail.smtp.host", host);
            properties.setProperty("mail.smtp.user", usuarioSmpt);
            properties.setProperty("mail.smtp.password", password);
            properties.setProperty("mail.smtp.port", port);
            properties.setProperty("mail.smtp.starttls.enable", "true");
            properties.setProperty("mail.smtp.auth", "true");
            properties.setProperty("mail.debug", "false");
            // Setup Port
            properties.put("mail.smtp.ssl.trust", host);
            SmtpAuthenticator auth = new SmtpAuthenticator();
            // Get the default Session object.
            Session session = Session.getInstance(properties, auth);
            MimeMessage m = new MimeMessage(session);
            String nickFrom = MimeUtility.encodeText(amb.getAmNombreComercial());
//            String nickTo = MimeUtility.encodeText(amb.getAmNombreComercial());
            Address addressfrom = new InternetAddress(usuarioSmpt, nickFrom);

            m.setFrom(addressfrom);

            BodyPart texto = new MimeBodyPart();
             String HTMLENVIO3 ="";
            String HTMLENVIO = "<body style=\"color: #666; font-size: 14px; font-family: 'Open Sans',Helvetica,Arial,sans-serif;\">\n"
                        + "<div class=\"box-content\" style=\"width: 80%; margin: 20px auto; max-width: 800px; min-width: 600px;\">\n"
                        + "    <div class=\"header-tip\" style=\"font-size: 10px;\n"
                        + "                                   color: #010e07;\n"
                        + "                                   text-align: right;\n"
                        + "                                   padding-right: 25px;\n"
                        + "                                   padding-bottom: 10px;\">\n"
                        + "      SISTEMA DE FACTURACION ELECTRONICA FACTURADO\n"
                        + "    </div>\n"
                        + "    <div class=\"info-top\" style=\"padding: 15px 25px;\n"
                        + "                                 border-top-left-radius: 10px;\n"
                        + "                                 border-top-right-radius: 10px;\n"
                        + "                                 background: #007ff7;\n"
                        + "                                 color: #fff;\n"
                        + "                                 overflow: hidden;\n"
                        + "                                 line-height: 32px;\">\n"
                        + "        <div style=\"color:#00000;font-size:18px\"><strong>\n"
                        + "		 DOCUMENTO ELETRONICO DE: " + amb.getAmNombreComercial().toUpperCase() + "</strong></div>\n"
                        + "		<div style=\"color:#00000;font-size:11px\"><strong>\n"
                        + "		SISTEMA DE FACTURACION ELECTRONICA  </strong></div>\n"
                        + "    </div>\n"
                        + "    <div class=\"info-wrap\" style=\"border-bottom-left-radius: 10px;\n"
                        + "                                  border-bottom-right-radius: 10px;\n"
                        + "                                  border:1px solid #ddd;\n"
                        + "                                  overflow: hidden;\n"
                        + "                                  padding: 15px 15px 20px;\">\n"
                        + "        <div class=\"tips\" style=\"padding:15px;\">\n"
                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">Estimado cliente,</p>\n"
                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">" + cliente + "</p>\n"
                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Su documento electronico se ha generado correctamente</p>\n"
                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Numero de documento:"
                        + "                 <strong style=\"color:#010e07\"> " + numeroDocumento + "</strong></p>\n"
                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Clave de acceso:"
                        + "                 <strong style=\"color:#010e07\"> " + acceso + "</strong></p>\n"
                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">Sus archivos PDF y XML se enviaron de forma adjunta, por favor reviselos</p>\n"
                        + "        </div>\n"
                        + "        <div class=\"time\" style=\"text-align: right; color: #999; padding: 0 15px 15px;\">Valor total:"
                        + "<strong style=\"color:#010e07\"> $" + ArchivoUtils.redondearDecimales(valorTotal, 2) + "</strong> </div>\n"
                        + "        <br>\n"
                        + "        <table class=\"list\" style=\"width: 100%; border-collapse: collapse; border-top:1px solid #eee\">\n"
                        + "            <thead>\n"
                        + "            <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee\">\n"
                        + "                Si tienes alguna consulta con respecto a esta informacion no dudes en comunicarte con nosotros, "
                        + "caso contrario no es necesario responder a este correo electronico.\n"
                        + "            </tr>\n"
                        + "            </thead>\n"
                        + "            <tbody>\n"
                        + "	\n"
                        + "			  <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:7px\n"
                        + "				align-items: center;display: flex;justify-content: center;\">\n"
                        + "			  <td style=\" font-size:9px\">Copyright © 2022 FACTURADO</td>\n"
                        + "\n"
                        + "			 </tr>\n"
                        + "			 <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:7px\n"
                        + "				align-items: center;display: flex;justify-content: center;\">\n"
                        + "			  <td style=\" font-size:9px\">FACTURADO</td>\n"
                        + "\n"
                        + "			 </tr>\n"
                        + "\n"
                        + "			  <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:7px\n"
                        + "				align-items: center;display: flex;justify-content: center;\">\n"
                        + "			  <td style=\" font-size:9px\">QUITO - ECUADOR</td>\n"
                        + "\n"
                        + "			 </tr>\n"
                        + "\n"
                        + "            </tbody>\n"
                        + "        </table>\n"
                        + "    </div>\n"
                        + "</div>\n"
                        + "</body>\n"
                        + "";

            texto.setContent(HTMLENVIO, "text/html");

            MimeMultipart multiParte = new MimeMultipart();
            // inicio adjunto
            if (attachFiles != null && attachFiles.length > 0) {
                for (String filePath : attachFiles) {
                    MimeBodyPart attachPartDoc = new MimeBodyPart();
                    try {
                        if (!filePath.equals("")) {
                            attachPartDoc.attachFile(filePath);
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    multiParte.addBodyPart(attachPartDoc);
                }
            }
            m.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(address));
            multiParte.addBodyPart(texto);

//            m.setRecipients(Message.RecipientType.TO, addresTto);
//            m.setRecipients(Message.RecipientType.BCC, from);
            m.setSubject(asunto);
            m.setSentDate(new java.util.Date());
//             m.setContent(dirDatos, "text/plain");
            m.setContent(multiParte);

            Transport t = session.getTransport(protocol);
//             t.connect();
            t.connect(host, usuarioSmpt, password);
            t.send(m);
            t.close();
            return true;
        } catch (javax.mail.MessagingException e) {
            System.out.println("error" + e);
            e.printStackTrace();

            return false;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MailerClass.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


}
