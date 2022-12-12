package com.ec.entidad;

import com.ec.entidad.Factura;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-12-12T22:12:10")
@StaticMetamodel(DetallePago.class)
public class DetallePago_ { 

    public static volatile SingularAttribute<DetallePago, BigDecimal> detpTotal;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpSubtotal;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpMulta;
    public static volatile SingularAttribute<DetallePago, Integer> idDetallePago;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpAbono;
    public static volatile SingularAttribute<DetallePago, Factura> idFactura;
    public static volatile SingularAttribute<DetallePago, Date> detpFechaPago;
    public static volatile SingularAttribute<DetallePago, Integer> detpNumPago;
    public static volatile SingularAttribute<DetallePago, Date> detpFechaCobro;
    public static volatile SingularAttribute<DetallePago, BigDecimal> detpSaldo;

}