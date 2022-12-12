package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.CierreCaja;
import com.ec.entidad.Factura;
import com.ec.entidad.OrdenTrabajo;
import com.ec.entidad.Parroquia;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.sri.CabeceraCompraSri;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:01:37")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Boolean> usuDriveActivo;
    public static volatile SingularAttribute<Usuario, String> usuCorreo;
    public static volatile SingularAttribute<Usuario, String> usuActividad;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile SingularAttribute<Usuario, String> usuPagina;
    public static volatile SingularAttribute<Usuario, String> usuDrivePlaca;
    public static volatile SingularAttribute<Usuario, Boolean> usuDriveDisponible;
    public static volatile SingularAttribute<Usuario, Boolean> usuIlimitado;
    public static volatile CollectionAttribute<Usuario, Factura> facturaCollection;
    public static volatile SingularAttribute<Usuario, String> usuNombre;
    public static volatile SingularAttribute<Usuario, String> usuLongNegocio;
    public static volatile SingularAttribute<Usuario, Boolean> usuEsDrive;
    public static volatile SingularAttribute<Usuario, Integer> usuNivel;
    public static volatile SingularAttribute<Usuario, Date> usuFechaRegistro;
    public static volatile SingularAttribute<Usuario, Date> usuFechaPago;
    public static volatile SingularAttribute<Usuario, String> usuDriveColor;
    public static volatile SingularAttribute<Usuario, String> usuServlet;
    public static volatile SingularAttribute<Usuario, String> usuRuc;
    public static volatile SingularAttribute<Usuario, Integer> usuNumDocumentos;
    public static volatile SingularAttribute<Usuario, Date> usuFechaRegMov;
    public static volatile CollectionAttribute<Usuario, CabeceraCompra> cabeceraCompraCollection;
    public static volatile SingularAttribute<Usuario, Integer> usuTotalContratado;
    public static volatile SingularAttribute<Usuario, String> usuDescripcionNegocio;
    public static volatile CollectionAttribute<Usuario, OrdenTrabajo> ordenTrabajoCollection;
    public static volatile CollectionAttribute<Usuario, CierreCaja> cierreCajaCollection;
    public static volatile SingularAttribute<Usuario, Date> usuFechaCaduca;
    public static volatile SingularAttribute<Usuario, Boolean> usuActivaMovil;
    public static volatile SingularAttribute<Usuario, String> usuFotografia;
    public static volatile CollectionAttribute<Usuario, CabeceraCompraSri> cabeceraCompraSriCollection;
    public static volatile SingularAttribute<Usuario, Parroquia> idParroquia;
    public static volatile SingularAttribute<Usuario, String> usuLogin;
    public static volatile SingularAttribute<Usuario, Character> usuFoto;
    public static volatile SingularAttribute<Usuario, String> usuLatNegocio;
    public static volatile SingularAttribute<Usuario, String> usuTipoUsuario;
    public static volatile SingularAttribute<Usuario, String> usuFacebook;
    public static volatile SingularAttribute<Usuario, String> usuPassword;
    public static volatile SingularAttribute<Usuario, Integer> usuNumeroFotos;
    public static volatile SingularAttribute<Usuario, String> usuWhatsapp;
    public static volatile CollectionAttribute<Usuario, Tipoambiente> tipoambienteCollection;

}