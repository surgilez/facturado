/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.untilitario;

import com.ec.entidad.Tipoambiente;
import com.ec.servicio.ServicioTipoAmbiente;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MailerClassSistema {

    private Tipoambiente amb = new Tipoambiente();
    ServicioTipoAmbiente servicioTipoAmbiente = new ServicioTipoAmbiente();

    /**
     * Recupera el nombre del catálogo descrito en la enumeración
     *
     * @param categoria nombre del parametroa a buscar
     * @return
     */
    public String getConfiguracionCorreo(String categoria) {
//        Set<BeCatalogo> dato = ofertaServicio.getCatalogo1(categoria);
//        if (dato.iterator().hasNext()) {
//            return dato.iterator().next().getNbCatalogo();
//        }
        return null;
    }

    /**
     * Método que envía al mail las credenciales de acceso al sistema
     *
     * @param address Dirección de correo electronico
     * @param mensaje Contenido del mensaje
     * @return
     * @throws java.rmi.RemoteException
     */
   

    class SmtpAuthenticator extends Authenticator {

        public SmtpAuthenticator() {

            super();
        }

        @Override
        public PasswordAuthentication getPasswordAuthentication() {
//            amb = servicioTipoAmbiente.FindALlTipoambiente();
//            String username = amb.getAmUsuarioSmpt().trim();
//            String password = amb.getAmPassword().trim();
            String username = "no-reply@sutributacion.com";
            String password = "Food4Ducks&cats$2";
            return new PasswordAuthentication(username, password);

        }
    }

   
    /*MAIL RECUPERA CONTRASEÑA*/
    public boolean sendMailRecuperarPassword(String address,
                String asuntoInf, String usuarioRecup,
                String passwordRecup, Tipoambiente ambiente)
                throws java.rmi.RemoteException {

        try {
//                        String usuarioSmpt = "no-reply@sutributacion.com";
//            String password = "Food4Ducks&cats$2";

            amb = ambiente;

//              String host = "mail.deckxel.com";
//            String port = "26";
//            String protocol = "smtp";
//            String usuarioSmpt = "defact@deckxel.com";
//            String password = "Dereckandre02!";
            String asunto = asuntoInf;
            String host = "smtp.office365.com";
            String port = "587";
            String protocol = "smtp";
            String usuarioSmpt = "no-reply@sutributacion.com";
            String password = "Food4Ducks&cats$2";
//            String asunto = asuntoInf;
//            String host = amb.getAmHost();
//            String port = amb.getAmPort();
//            String protocol = amb.getAmProtocol();
//            String usuarioSmpt = amb.getAmUsuarioSmpt().trim();
//            String password = amb.getAmPassword().trim();

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
            String nickFrom = MimeUtility.encodeText("SUTRIBUTACION");
//            String nickTo = MimeUtility.encodeText(amb.getAmNombreComercial());
            Address addressfrom = new InternetAddress(usuarioSmpt, nickFrom);

            m.setFrom(addressfrom);

            BodyPart texto = new MimeBodyPart();
            String HTMLENVIO = "<body style=\"color: #666; font-size: 14px; font-family: 'Open Sans',Helvetica,Arial,sans-serif;\">\n"
                        + "<div class=\"box-content\" style=\"width: 80%; margin: 20px auto; max-width: 800px; min-width: 600px;\">\n"
                        + "    <div class=\"header-tip\" style=\"font-size: 10px;\n"
                        + "                                   color: #010e07;\n"
                        + "                                   text-align: right;\n"
                        + "                                   padding-right: 25px;\n"
                        + "                                   padding-bottom: 10px;\">\n"
                        + "      SISTEMA DE FACTURACION ELECTRONICA SU TRIBUTACION\n"
                        + "    </div>\n"
                        + "    <div class=\"info-top\" style=\"padding: 15px 25px;\n"
                        + "                                 border-top-left-radius: 10px;\n"
                        + "                                 border-top-right-radius: 10px;\n"
                        + "                                 background: #007ff7;\n"
                        + "                                 color: #fff;\n"
                        + "                                 overflow: hidden;\n"
                        + "                                 line-height: 32px;\">\n"
                        + "        <div style=\"color:#00000;font-size:18px\"><strong>\n"
                        + "		 USUARIO FACTURADO : " + amb.getAmNombreComercial().toUpperCase() + "</strong></div>\n"
                        + "		<div style=\"color:#00000;font-size:11px\"><strong>\n"
                        + "		SISTEMA DE FACTURACION ELECTRONICA SU TRIBUTACION  </strong></div>\n"
                        + "    </div>\n"
                        + "    <div class=\"info-wrap\" style=\"border-bottom-left-radius: 10px;\n"
                        + "                                  border-bottom-right-radius: 10px;\n"
                        + "                                  border:1px solid #ddd;\n"
                        + "                                  overflow: hidden;\n"
                        + "                                  padding: 15px 15px 20px;\">\n"
                        + "        <div class=\"tips\" style=\"padding:15px;\">\n"
                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">Estimado cliente,</p>\n"
                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">" + amb.getAmRazonSocial() + "</p>\n"
                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Su acceso a la plataforma ha sido generado correctamente </p>\n"
                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Usuario:"
                        + "                 <strong style=\"color:#010e07\"> " + usuarioRecup + "</strong></p>\n"
                        + "			<p style=\" list-style: 160%; margin: 10px 0;\">Password:"
                        + "                 <strong style=\"color:#010e07\"> " + passwordRecup + "</strong></p>\n"
                        //                        + "            <p style=\" list-style: 160%; margin: 10px 0;\">Sus archivos PDF y XML se enviaron de forma adjunta, por favor reviselos</p>\n"
                        + "        </div>\n"
                        + "        <div class=\"time\" style=\"text-align: right; color: #999; padding: 0 15px 15px;\">"
                        + "<strong style=\"color:#010e07\"></strong> </div>\n"
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
                        + "			  <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:10px\n"
                        + "				align-items: center;display: flex;justify-content: center;\">\n"
                        + "			  <td style=\" font-size:9px\">Copyright © 2022 SU TRIBUTACION</td>\n"
                        + "\n"
                        + "			 </tr>\n"
                        + "			 <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:10px\n"
                        + "				align-items: center;display: flex;justify-content: center;\">\n"
                        + "			  <td style=\" font-size:9px\">SU TRIBUTACION</td>\n"
                        + "\n"
                        + "			 </tr>\n"
                        + "\n"
                        + "			  <tr style=\" background: #fafafa; color: #333; border-bottom: 1px solid #eee;;font-size:10px\n"
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
            Logger.getLogger(MailerClassSistema.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    

}
