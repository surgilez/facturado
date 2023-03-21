package com.ec.entidad.sri;

import com.ec.entidad.EstadoFacturas;
import com.ec.entidad.Proveedores;
import com.ec.entidad.Usuario;
import com.ec.entidad.sri.CategoriaCompras;
import com.ec.entidad.sri.DetalleCompraSri;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-21T21:43:14")
@StaticMetamodel(CabeceraCompraSri.class)
public class CabeceraCompraSri_ { 

    public static volatile SingularAttribute<CabeceraCompraSri, String> cabNumFactura;
    public static volatile SingularAttribute<CabeceraCompraSri, BigDecimal> cabIva;
    public static volatile SingularAttribute<CabeceraCompraSri, Usuario> idUsuario;
    public static volatile SingularAttribute<CabeceraCompraSri, BigDecimal> cabSubTotal;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabDescripcion;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabRetencionAutori;
    public static volatile SingularAttribute<CabeceraCompraSri, Date> cabFecha;
    public static volatile SingularAttribute<CabeceraCompraSri, Integer> idCabeceraSri;
    public static volatile SingularAttribute<CabeceraCompraSri, BigDecimal> cabSubTotalCero;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabHomologado;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabRucProveedor;
    public static volatile SingularAttribute<CabeceraCompraSri, Proveedores> idProveedor;
    public static volatile SingularAttribute<CabeceraCompraSri, String> categoriaFactura;
    public static volatile SingularAttribute<CabeceraCompraSri, Boolean> cabTraeSri;
    public static volatile SingularAttribute<CabeceraCompraSri, Integer> idTipoIdentificacionCompra;
    public static volatile SingularAttribute<CabeceraCompraSri, String> drcCodigoSustento;
    public static volatile SingularAttribute<CabeceraCompraSri, EstadoFacturas> estIdEstado;
    public static volatile SingularAttribute<CabeceraCompraSri, CategoriaCompras> idCategoriaCompras;
    public static volatile SingularAttribute<CabeceraCompraSri, EstadoFacturas> idEstado;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabProveedor;
    public static volatile CollectionAttribute<CabeceraCompraSri, DetalleCompraSri> detalleCompraSriCollection;
    public static volatile SingularAttribute<CabeceraCompraSri, Date> cabFechaEmision;
    public static volatile SingularAttribute<CabeceraCompraSri, Usuario> usuIdUsuario;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabCasillero;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabEstado;
    public static volatile SingularAttribute<CabeceraCompraSri, BigDecimal> cabTotal;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabClaveAcceso;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabAutorizacion;
    public static volatile SingularAttribute<CabeceraCompraSri, String> cabXmlSri;

}