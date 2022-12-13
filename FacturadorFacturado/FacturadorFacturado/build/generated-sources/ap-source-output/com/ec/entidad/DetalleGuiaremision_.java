package com.ec.entidad;

import com.ec.entidad.Guiaremision;
import com.ec.entidad.Producto;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-13T14:57:23")
@StaticMetamodel(DetalleGuiaremision.class)
public class DetalleGuiaremision_ { 

    public static volatile SingularAttribute<DetalleGuiaremision, Integer> idDetalleGuiaremision;
    public static volatile SingularAttribute<DetalleGuiaremision, String> detTipoVenta;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detTotal;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detIva;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detSubtotal;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detTotalconiva;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detPordescuento;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detTotaldescuento;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detValdescuento;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detCantidad;
    public static volatile SingularAttribute<DetalleGuiaremision, String> detDescripcion;
    public static volatile SingularAttribute<DetalleGuiaremision, Guiaremision> idGuiaremision;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detSubtotaldescuento;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detSubtotaldescuentoporcantidad;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detCantpordescuento;
    public static volatile SingularAttribute<DetalleGuiaremision, Producto> idProducto;
    public static volatile SingularAttribute<DetalleGuiaremision, BigDecimal> detTotaldescuentoiva;
    public static volatile SingularAttribute<DetalleGuiaremision, String> detCodTipoVenta;

}