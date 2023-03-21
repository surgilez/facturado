package com.ec.entidad;

import com.ec.entidad.DetalleKardex;
import com.ec.entidad.EstadoFacturas;
import com.ec.entidad.Proveedores;
import com.ec.entidad.Tipoambiente;
import com.ec.entidad.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-03-21T21:43:14")
@StaticMetamodel(CabeceraCompra.class)
public class CabeceraCompra_ { 

    public static volatile SingularAttribute<CabeceraCompra, String> cabNumFactura;
    public static volatile SingularAttribute<CabeceraCompra, BigDecimal> cabIva;
    public static volatile SingularAttribute<CabeceraCompra, String> cab_ruc_proveedor;
    public static volatile SingularAttribute<CabeceraCompra, Usuario> idUsuario;
    public static volatile SingularAttribute<CabeceraCompra, BigDecimal> cabSubTotal;
    public static volatile CollectionAttribute<CabeceraCompra, DetalleKardex> detalleKardexCollection;
    public static volatile SingularAttribute<CabeceraCompra, String> cabDescripcion;
    public static volatile SingularAttribute<CabeceraCompra, String> cabRetencionAutori;
    public static volatile SingularAttribute<CabeceraCompra, Date> cabFecha;
    public static volatile SingularAttribute<CabeceraCompra, BigDecimal> cabSubTotalCero;
    public static volatile SingularAttribute<CabeceraCompra, String> cabHomologado;
    public static volatile SingularAttribute<CabeceraCompra, Integer> idCabecera;
    public static volatile SingularAttribute<CabeceraCompra, Proveedores> idProveedor;
    public static volatile SingularAttribute<CabeceraCompra, String> cabPuntoEmi;
    public static volatile SingularAttribute<CabeceraCompra, Boolean> cabTraeSri;
    public static volatile SingularAttribute<CabeceraCompra, Integer> idTipoIdentificacionCompra;
    public static volatile SingularAttribute<CabeceraCompra, String> drcCodigoSustento;
    public static volatile SingularAttribute<CabeceraCompra, EstadoFacturas> estIdEstado;
    public static volatile SingularAttribute<CabeceraCompra, EstadoFacturas> idEstado;
    public static volatile SingularAttribute<CabeceraCompra, String> cabProveedor;
    public static volatile SingularAttribute<CabeceraCompra, Date> cabFechaEmision;
    public static volatile SingularAttribute<CabeceraCompra, String> cabEstablecimiento;
    public static volatile SingularAttribute<CabeceraCompra, Usuario> usuIdUsuario;
    public static volatile SingularAttribute<CabeceraCompra, Tipoambiente> codTipoambiente;
    public static volatile SingularAttribute<CabeceraCompra, String> cabEstado;
    public static volatile SingularAttribute<CabeceraCompra, BigDecimal> cabTotal;
    public static volatile SingularAttribute<CabeceraCompra, String> cabClaveAcceso;
    public static volatile SingularAttribute<CabeceraCompra, String> cabAutorizacion;

}