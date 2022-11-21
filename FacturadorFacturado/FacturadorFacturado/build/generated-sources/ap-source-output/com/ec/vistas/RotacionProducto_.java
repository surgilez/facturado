package com.ec.vistas;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-21T00:00:57")
@StaticMetamodel(RotacionProducto.class)
public class RotacionProducto_ { 

    public static volatile SingularAttribute<RotacionProducto, BigDecimal> cantidadVenta;
    public static volatile SingularAttribute<RotacionProducto, String> prodNombre;
    public static volatile SingularAttribute<RotacionProducto, Date> facFecha;
    public static volatile SingularAttribute<RotacionProducto, Integer> codTipoambiente;
    public static volatile SingularAttribute<RotacionProducto, Integer> idProducto;
    public static volatile SingularAttribute<RotacionProducto, BigInteger> idRotacion;
    public static volatile SingularAttribute<RotacionProducto, BigDecimal> valorVentaProducto;

}