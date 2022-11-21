package com.ec.entidad;

import com.ec.entidad.CabeceraCompra;
import com.ec.entidad.Factura;
import com.ec.entidad.Kardex;
import com.ec.entidad.Tipokardex;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T15:42:09")
@StaticMetamodel(DetalleKardex.class)
public class DetalleKardex_ { 

    public static volatile SingularAttribute<DetalleKardex, Integer> idDetalleKardex;
    public static volatile SingularAttribute<DetalleKardex, Kardex> idKardex;
    public static volatile SingularAttribute<DetalleKardex, Boolean> detkKardexmanual;
    public static volatile SingularAttribute<DetalleKardex, Date> detkFechakardex;
    public static volatile SingularAttribute<DetalleKardex, String> detkUnidadOrigen;
    public static volatile SingularAttribute<DetalleKardex, Integer> detkTipokardex;
    public static volatile SingularAttribute<DetalleKardex, Date> detkFechacreacion;
    public static volatile SingularAttribute<DetalleKardex, BigDecimal> detkIngresoCantidadSinTransformar;
    public static volatile SingularAttribute<DetalleKardex, BigDecimal> detkCantidad;
    public static volatile SingularAttribute<DetalleKardex, Integer> idVenta;
    public static volatile SingularAttribute<DetalleKardex, String> detkDetalles;
    public static volatile SingularAttribute<DetalleKardex, Integer> idIngreso;
    public static volatile SingularAttribute<DetalleKardex, String> detkUnidadFin;
    public static volatile SingularAttribute<DetalleKardex, CabeceraCompra> idCompra;
    public static volatile SingularAttribute<DetalleKardex, Factura> idFactura;
    public static volatile SingularAttribute<DetalleKardex, Tipokardex> idTipokardex;

}