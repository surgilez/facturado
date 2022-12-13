package com.ec.entidad;

import com.ec.entidad.Factura;
import com.ec.entidad.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-13T14:57:23")
@StaticMetamodel(DetalleFactura.class)
public class DetalleFactura_ { 

    public static volatile SingularAttribute<DetalleFactura, Integer> idDetalle;
    public static volatile SingularAttribute<DetalleFactura, String> tipodir;
    public static volatile SingularAttribute<DetalleFactura, String> numero;
    public static volatile SingularAttribute<DetalleFactura, String> codigoCantonMatriculacion;
    public static volatile SingularAttribute<DetalleFactura, String> provincia;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detTotaldescuento;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detCantidad;
    public static volatile SingularAttribute<DetalleFactura, String> detCamvcpn;
    public static volatile SingularAttribute<DetalleFactura, String> numerotel;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detValorIce;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detSubtotaldescuento;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detSubtotaldescuentoporcantidad;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detTarifa;
    public static volatile SingularAttribute<DetalleFactura, String> detCodTipoVenta;
    public static volatile SingularAttribute<DetalleFactura, String> detTipoVenta;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detTotal;
    public static volatile SingularAttribute<DetalleFactura, String> detAtributo;
    public static volatile SingularAttribute<DetalleFactura, String> calle;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detIva;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detSubtotal;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detTotalconiva;
    public static volatile SingularAttribute<DetalleFactura, String> detCodIva;
    public static volatile SingularAttribute<DetalleFactura, String> tipoIdentificacionPropietario;
    public static volatile SingularAttribute<DetalleFactura, String> interseccion;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detPordescuento;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detValdescuento;
    public static volatile SingularAttribute<DetalleFactura, String> detDescripcion;
    public static volatile SingularAttribute<DetalleFactura, Factura> idFactura;
    public static volatile SingularAttribute<DetalleFactura, String> detCodPorcentaje;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detCantpordescuento;
    public static volatile SingularAttribute<DetalleFactura, String> tipotel;
    public static volatile SingularAttribute<DetalleFactura, Producto> idProducto;
    public static volatile SingularAttribute<DetalleFactura, BigDecimal> detTotaldescuentoiva;
    public static volatile SingularAttribute<DetalleFactura, String> detSerialvin;

}