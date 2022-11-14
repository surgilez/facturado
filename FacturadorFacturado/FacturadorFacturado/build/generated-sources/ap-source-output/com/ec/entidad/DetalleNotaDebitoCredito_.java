package com.ec.entidad;

import com.ec.entidad.NotaCreditoDebito;
import com.ec.entidad.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-11T17:28:01")
@StaticMetamodel(DetalleNotaDebitoCredito.class)
public class DetalleNotaDebitoCredito_ { 

    public static volatile SingularAttribute<DetalleNotaDebitoCredito, String> detTipoVenta;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detTotal;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detIva;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detSubtotal;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detTotalconiva;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detPordescuento;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detTotaldescuento;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detValdescuento;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detCantidad;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, String> detDescripcion;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detSubtotaldescuento;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detSubtotaldescuentoporcantidad;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detCantpordescuento;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, Integer> idDetalleNota;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, NotaCreditoDebito> idNota;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, Producto> idProducto;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, BigDecimal> detTotaldescuentoiva;
    public static volatile SingularAttribute<DetalleNotaDebitoCredito, String> detCodTipoVenta;

}